<template>
	<v-container>
		<div class="url">
			<ShareUrl />
		</div>
		<v-card max-width="600" class="mx-auto list">
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
import ShareUrl from "@/components/ShareUrl.vue";

const menuStore = useMenuStore();
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.list {
	padding: 2%;
}

.title {
	font-size: 2.5rem;
	font-weight: 500;
}

.url {
	max-width: 600px;
	margin: 0 auto;
}
</style>
