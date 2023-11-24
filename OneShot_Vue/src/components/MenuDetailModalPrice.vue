<template>
	<v-card-text>
		<div class="d-flex justify-space-between align-center">
			<span class="subheading">주문 금액</span>
			<span class="price">{{ price }}원</span>
		</div>
	</v-card-text>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useMenuStore } from "@/stores/menu";
import { computed } from "vue";

const menuStore = useMenuStore();

const price = computed(() => {
	return menuStore.menuDetail.price * menuStore.amount;
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.price {
	font-size: 1.3rem;
}
</style>
