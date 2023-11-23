<template>
	<v-card-text>
		<v-text-field
			:rules="rules"
			label="Name"
			variant="outlined"
			v-model="name"
			class="mb-3"
		></v-text-field>
		<v-btn color="primary" block @click.prevent="order">order</v-btn>
	</v-card-text>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { useRouter, useRoute } from "vue-router";
import { ref, defineProps } from "vue";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const URL = useUrlStore();
const menuStore = useMenuStore();
const name = ref("");
const router = useRouter();
const route = useRoute();

const rules = ref([
	(v) => !!v || "Required.",
	(v) => (v && v.length <= 10) || "Name must be less than 10 characters.",
]);

defineProps({
	menuDetailId: Number,
});

const order = () => {
	if (name.value.length < 1) {
		alert("이름을 입력해주세요.");
		return;
	}
	axios
		.post(URL.API.ORDER_DETAIL_CREATE, {
			orderId: menuStore.orderId,
			menuDetailId: menuStore.menuDetail.menuDetailId,
			name: name.value,
			amount: menuStore.amount,
		})
		.then((res) => {
			localStorage.setItem(`oneshot-order-${menuStore.orderId}`, name.value);
			router.push({
				name: "order-result",
				params: { orderCode: route.params.orderCode },
			});
		})
		.catch((err) => {
			alert("주문 실패");
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
