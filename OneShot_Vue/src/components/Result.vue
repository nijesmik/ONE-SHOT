<template>
	<v-list-item
		:title="orderDetail.name"
		:subtitle="content"
		:prepend-avatar="orderDetail.img"
	></v-list-item>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps, ref } from "vue";

const props = defineProps({
	orderDetail: Object,
});
const content = ref(
	`${props.orderDetail.menuName} / ${props.orderDetail.temperature} / ${props.orderDetail.sizeName} / ${props.orderDetail.amount}잔`
);
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
