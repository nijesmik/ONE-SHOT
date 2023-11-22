<template>
	<v-img :src="menu.img"></v-img>
	<br />
	<v-card-title>{{ menu.menuName }}</v-card-title>
	<v-card-text>
		<span class="subheading">Select temperature</span>

		<v-chip-group
			v-model="temperatureSelection"
			selected-class="text-deep-purple-accent-4"
			mandatory
		>
			<template v-for="temperature in temperatures">
				<v-chip>{{ temperature }}</v-chip>
			</template>
		</v-chip-group>
	</v-card-text>

	<v-card-text>
		<span class="subheading">Select size</span>

		<v-chip-group
			v-model="sizeSelection"
			selected-class="text-deep-purple-accent-4"
			mandatory
		>
			<template v-for="size in sizes">
				<v-chip>{{ size }}</v-chip>
			</template>
		</v-chip-group>
	</v-card-text>
	<MenuDetailModalAmount />
	<MenuDetailModalSubmit />
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { useMenuStore } from "@/stores/menu";
import { useUrlStore } from "@/stores/url";
import { ref, defineProps, watch } from "vue";
import MenuDetailModalAmount from "@/components/MenuDetailModalAmount.vue";
import MenuDetailModalSubmit from "@/components/MenuDetailModalSubmit.vue";

const props = defineProps({
	menu: Object,
});

const menuStore = useMenuStore();
const URL = useUrlStore();
const menuDetails = ref([]);
const temperatures = ref([]);
const sizes = ref([]);
const temperatureSelection = ref(0);
const sizeSelection = ref(0);
const setMenuDetail = () => {
	menuStore.menuDetail = menuDetails.value.filter(
		(detail) =>
			detail.temperature === menuStore.temperature &&
			detail.sizeName === menuStore.size
	)[0];
};

axios.get(`${URL.API.MENU_DETAIL}?menuId=${props.menu.menuId}`).then((res) => {
	menuDetails.value = res.data;
	temperatures.value = [
		...new Set(menuDetails.value.map((detail) => detail.temperature)),
	];
	menuStore.temperature = temperatures.value[0];
	sizes.value = [
		...new Set(menuDetails.value.map((detail) => detail.sizeName)),
	];
	sizes.value.forEach((size, idx, _) => {
		if (size === props.menu.defaultSizeName) {
			sizeSelection.value = idx;
		}
	});
	menuStore.size = sizes.value[sizeSelection.value];
	setMenuDetail();
});

watch(temperatureSelection, (idx) => {
	menuStore.temperature = temperatures.value[idx];
	setMenuDetail();
});

watch(sizeSelection, (idx) => {
	menuStore.size = sizes.value[idx];
	setMenuDetail();
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
