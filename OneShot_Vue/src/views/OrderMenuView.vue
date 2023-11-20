<template>
	<ShareUrl :url="share_url" />

	<div class="type mb-3">
		<button
			class="btn btn-outline-info btn-sm"
			v-for="type in menuTypes"
			@click.prevent="selectType(type)"
		>
			{{ type }}
		</button>
	</div>

	<div class="list">
		<div
			v-for="menu in computedMenus"
			class="menu select mb-3"
			@click="selectMenu(menu)"
		>
			<Menu :menu="menu" />
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import axios from "axios";
import Menu from "@/components/Menu.vue";
import ShareUrl from "@/components/ShareUrl.vue";

const URL = useUrlStore();
const route = useRoute();
const router = useRouter();
const orderCode = route.params.orderCode;

const share_url = ref(`${URL.DOMAIN}/order/${orderCode}`);
const order = ref({});
const orderDetails = ref([]);
const menuTypes = ref([]);
const menus = ref([]);

const typeSelected = ref("");
const selectType = (type) => {
	typeSelected.value = type;
};
const computedMenus = computed(() => {
	return menus.value.filter((menu) => menu.type === typeSelected.value);
});

axios
	.get(`${URL.API.ORDER}?orderCode=${orderCode}`)
	.then((res) => {
		order.value = res.data.order;
		orderDetails.value = res.data.orderDetail;
		axios.get(`${URL.API.MENU}?brandId=${order.value.brandId}`).then((res) => {
			menuTypes.value = res.data.menuType;
			menus.value = res.data.menuList;
			typeSelected.value = menuTypes.value[0];
		});
	})
	.catch((err) => {
		if (err.response.status === 500) {
			alert("잘못된 URL입니다.");
			router.push({ name: "home" });
		}
	});

const selectMenu = (menu) => {
	alert("TODO : 사이즈, ice/hot 선택 모달 띄우기");
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.type {
	display: flex;
	flex-wrap: wrap;
}
</style>
