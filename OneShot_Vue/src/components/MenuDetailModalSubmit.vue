<template>
	<div class="input-group mb-3">
		<input
			type="text"
			class="form-control"
			placeholder="주문하실 분의 이름을 입력해 주세요"
			aria-label="Recipient's username"
			aria-describedby="button-addon2"
			v-model="name"
		/>
		<button
			class="btn btn-outline-secondary"
			type="button"
			id="button-addon2"
			@click.prevent="order"
		>
			Submit
		</button>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { ref, defineProps } from "vue";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const URL = useUrlStore();
const menuStore = useMenuStore();
const name = ref("");

defineProps({
	menuDetailId: Number,
});

const order = () => {
	console.log(menuStore.menuDetail);
	axios
		.post(URL.API.ORDER_DETAIL_CREATE, {
			orderId: menuStore.orderId,
			menuDetailId: menuStore.menuDetail.menuDetailId,
			name: name.value,
			amount: menuStore.amount,
		})
		.then((res) => {
			alert("주문 성공");
		})
		.catch((err) => {
			alert("주문 실패");
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
