<template>
	<v-container>
		<v-list lines="two" v-for="orderDetail in orderDetails">
			<Result :order-detail="orderDetail" />
		</v-list>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";
import { useRoute } from "vue-router";
import { ref } from "vue";
import Result from "@/components/Result.vue";

const URL = useUrlStore();
const menuStore = useMenuStore();
const route = useRoute();
const order = ref({});
const orderDetails = ref([]);

axios
	.get(`${URL.API.ORDER}?orderCode=${route.params.orderCode}`)
	.then((res) => {
		order.value = res.data.order;
		menuStore.orderId = order.value.orderId;
		orderDetails.value = res.data.orderDetail;
		console.log(orderDetails.value);
	});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
