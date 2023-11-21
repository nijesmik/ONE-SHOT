<template>
	<ShareUrl :url="shareUrl" />

	<div class="type mb-3">
		<button
			class="btn btn-outline-info btn-sm"
			v-for="type in menuTypes"
			@click.prevent="clickType(type)"
		>
			{{ type }}
		</button>
	</div>

	<div class="list">
		<div v-for="menu in computedMenus" class="item mb-3">
			<Menu :menu="menu" />
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";
import axios from "axios";
import Menu from "@/components/Menu.vue";
import ShareUrl from "@/components/ShareUrl.vue";
import MenuDetailModal from "../components/MenuDetailModal.vue";

const URL = useUrlStore();
const menuStore = useMenuStore();
const route = useRoute();
const router = useRouter();
const orderCode = route.params.orderCode;

const shareUrl = ref(`${URL.DOMAIN}/order/${orderCode}`);
const order = ref({});
const orderDetails = ref([]);
const menuTypes = ref([]);
const menus = ref([]);

const clickType = (type) => {
	menuStore.type = type;
};
const computedMenus = computed(() => {
	return menus.value.filter((menu) => menu.type === menuStore.type);
});

axios
	.get(`${URL.API.ORDER}?orderCode=${orderCode}`)
	.then((res) => {
		order.value = res.data.order;
		orderDetails.value = res.data.orderDetail;
		axios.get(`${URL.API.MENU}?brandId=${order.value.brandId}`).then((res) => {
			menuTypes.value = res.data.menuType;
			menus.value = res.data.menuList;
			menuStore.type = menuTypes.value[0];
		});
	})
	.catch((err) => {
		if (err.response.status === 500) {
			alert("잘못된 URL입니다.");
			router.push({ name: "home" });
		}
	});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.type {
	display: flex;
	flex-wrap: wrap;
}
</style>
