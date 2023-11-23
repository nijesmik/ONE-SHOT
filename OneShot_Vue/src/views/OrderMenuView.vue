<template>
	<v-container v-if="!errorState">
		<ShareUrl />
		<MenuTypeBtn :types="menuTypes" />
		<v-row>
			<template v-for="menu in computedMenus">
				<v-col :cols="cols">
					<Menu :menu="menu" />
				</v-col>
			</template>
		</v-row>
	</v-container>

	<!-- alert -->
	<div>
		<v-alert
			type="error"
			v-model="errorState"
			variant="tonal"
			closable
			close-label="Close Alert"
			title="잘못된 URL입니다."
			class="mt-10 alert"
		>
			우측 닫기 버튼을 누르면 홈화면으로 이동합니다.
		</v-alert>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, computed, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";
import axios from "axios";
import Menu from "@/components/Menu.vue";
import ShareUrl from "@/components/ShareUrl.vue";
import MenuTypeBtn from "@/components/MenuTypeBtn.vue";

const URL = useUrlStore();
const menuStore = useMenuStore();
const route = useRoute();
const router = useRouter();
menuStore.orderCode = route.params.orderCode;

const calcCols = () => {
	if (window.innerWidth < 600) {
		return 4;
	}
	return 2;
};
const cols = ref(calcCols());

const order = ref({});
const orderDetails = ref([]);
const menuTypes = ref([]);
const menus = ref([]);
const errorState = ref(false);

watch(errorState, (state) => {
	if (!state) {
		router.push({ name: "home" });
	}
});

const computedMenus = computed(() => {
	if (menuStore.type === "ALL") {
		return menus.value;
	}
	return menus.value.filter((menu) => menu.type === menuStore.type);
});

const test = (details, id) => {
	const name = localStorage.getItem(`oneshot-order-${id}`);
	if (name === null) {
		return false;
	}
	return details.filter((detail) => detail.name === name).length > 0;
};

axios
	.get(`${URL.API.ORDER}?orderCode=${menuStore.orderCode}`)
	.then((res) => {
		order.value = res.data.order;
		menuStore.orderId = order.value.orderId;
		orderDetails.value = res.data.orderDetail;
		if (test(orderDetails.value, menuStore.orderId)) {
			router.push({ name: "order-result", params: { orderCode: menuStore.orderCode } });
		} else {
			axios
				.get(`${URL.API.MENU}?brandId=${order.value.brandId}`)
				.then((res) => {
					menuTypes.value = ["ALL", ...res.data.menuType];
					menus.value = res.data.menuList;
					menuStore.type = menuTypes.value[0];
				});
		}
	})
	.catch((err) => {
		if (err.response.status === 500) {
			errorState.value = true;
		}
	});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.alert {
	margin: 0 auto;
	width: 50%;
}

@media screen and (max-width: 900px) {
	.alert {
		width: 80%;
	}
}
</style>
