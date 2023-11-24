<template>
	<router-view />
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { useRoute, useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const menuStore = useMenuStore();
const URL = useUrlStore();
const route = useRoute();
const router = useRouter();

axios
	.get(`${URL.API.ORDER}?orderCode=${route.params.orderCode}`)
	.then((res) => {
		menuStore.order = res.data.order;
		menuStore.orderDetails = res.data.orderDetail;
		router.push({ name: "order-result" });
	})
	.catch((err) => {
		if (err.response.status === 500) {
			router.push({ name: "order-error" });
		}
	});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
