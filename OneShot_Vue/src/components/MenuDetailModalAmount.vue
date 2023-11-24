<template>
	<v-card-text>
		<span class="subheading">수량</span>
		<v-row class="align-center mt-n1 mb-n1">
			<v-col cols="auto">
				<v-btn
					icon="mdi-minus"
					size="x-small"
					@click.prevent="amountDown"
				></v-btn>
			</v-col>
			<v-col cols="auto">{{ menuStore.amount }}</v-col>

			<v-col cols="auto">
				<v-btn
					icon="mdi-plus"
					size="x-small"
					@click.prevent="menuStore.amount++"
				></v-btn>
			</v-col>
		</v-row>
	</v-card-text>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useMenuStore } from "@/stores/menu";

const menuStore = useMenuStore();

const amountDown = () => {
	if (menuStore.amount > 1) {
		menuStore.amount--;
	}
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
