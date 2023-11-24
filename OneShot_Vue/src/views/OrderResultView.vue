<template>
	<v-container v-if="menuStore.order.orderId > 0">
		<div class="url">
			<ShareUrl />
		</div>
		<v-card max-width="600" class="mx-auto list">
			<v-row class="justify-space-between">
				<v-col class="v-col-auto">

					<div class="title">주문 내역</div>
					<div class="ml-1 total">총 {{ total.amount }}잔 / {{ total.price }}원</div>
				</v-col>
				<v-col class="v-col-auto d-flex align-end" v-if="isService">
					<OrderAddBtn />
					<OrderCompleteBtn v-if="isManager"/>
				</v-col>
			</v-row>
			<v-list lines="two" v-for="orderDetail in menuStore.orderDetails">
				<Result :order-detail="orderDetail" />
			</v-list>
		</v-card>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, computed } from "vue";
import { useMenuStore } from "@/stores/menu";
import Result from "@/components/Result.vue";
import ShareUrl from "@/components/ShareUrl.vue";
import OrderAddBtn from "@/components/OrderAddBtn.vue";
import OrderCompleteBtn from "@/components/OrderCompleteBtn.vue";

const menuStore = useMenuStore();
const total = computed(() => {
	let price = 0;
	let amount = 0;
	menuStore.orderDetails.forEach((orderDetail) => {
		price += orderDetail.unitPrice * orderDetail.amount;
		amount += orderDetail.amount;
	});
	return {price:price, amount:amount};
});

const isManager = computed(() => {
	const userId = sessionStorage.getItem("token");
	const orderUserId = menuStore.order.userId;
	if (userId == orderUserId) {
		return true;
	}
})
const isService = computed(() => (menuStore.order.service == 0));
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

.total {
	font-size: 1.1rem;
}
</style>
