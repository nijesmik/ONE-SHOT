<template>
	<div class="list">
		<div v-for="menu in menus" class="menu select" @click="selectMenu(menu)">
			<Menu :menu="menu" />
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useRoute } from "vue-router";
import axios from "axios";
import Menu from "@/components/Menu.vue";

const route = useRoute();
const ORDER_API = `http://localhost:8080/api/order?orderCode=${route.params.orderCode}`;
const MENU_API = "http://localhost:8080/api/menu?brandId=";

const order = ref({});
const orderDetails = ref([]);
const menus = ref([]);

axios.get(ORDER_API).then((res) => {
	order.value = res.data.order;
	orderDetails.value = res.data.orderDetail;
	axios.get(`${MENU_API}${order.value.brandId}`).then((res) => {
		menus.value = res.data;
	});
});

const selectMenu = (menu) => {
	alert("TODO : 사이즈, ice/hot 선택 모달 띄우기");
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
