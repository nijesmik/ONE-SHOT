<template>
	<div>
		<v-card hover link>
			<v-img :src="menu.img" aspect-ratio="1" cover></v-img>
			<v-card-title>{{ menu.menuName }}</v-card-title>
			<v-card-text>{{ menu.defaultPrice }}원</v-card-text>
		</v-card>

		<v-dialog v-model="dialog" activator="parent" width="auto">
			<v-card :width="width">
				<MenuDetailModal :menu="menu" />
				<v-card-actions>
					<v-btn color="red" block @click="dialog = false">Close</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useMenuStore } from "@/stores/menu";
import { defineProps, ref, watch } from "vue";
import MenuDetailModal from "./MenuDetailModal.vue";

const calcWidth = () => {
	if (window.innerWidth < 500) {
		return window.innerWidth * 0.9;
	}
	return 450;
};
const width = ref(calcWidth());

const menuStore = useMenuStore();

const props = defineProps({
	menu: Object,
});

const dialog = ref(false);

watch(dialog, (dialog) => {
	if (!dialog) {
		menuStore.menuDetail = {};
		menuStore.temperature = "";
		menuStore.size = "";
		menuStore.amount = 1;
	}
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
