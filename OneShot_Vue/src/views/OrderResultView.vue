<template>
	<v-container>
		<v-card max-width="600" class="mx-auto p-3 mt-3">
			<span class="title">주문 내역</span>
			<v-list lines="two" v-for="orderDetail in menuStore.orderDetails">
				<Result :order-detail="orderDetail" />
			</v-list>
		</v-card>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useMenuStore } from "@/stores/menu";
import Result from "@/components/Result.vue";

const menuStore = useMenuStore();
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.list {
	width: auto;
	margin: 0 auto;
}

.title {
	font-size: 2.5rem;
	font-weight: 500;
}
</style>
