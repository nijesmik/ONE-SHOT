<template>
	<v-container>
		<ShareUrl />
		<MenuTypeBtn :types="menuTypes" />
		<v-row>
			<template v-for="menu in computedMenus">
				<v-col :cols="cols">
					<Menu :menu="menu" />
				</v-col>
			</template>
		</v-row>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, computed, watch } from "vue";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";
import axios from "axios";
import Menu from "@/components/Menu.vue";
import ShareUrl from "@/components/ShareUrl.vue";
import MenuTypeBtn from "@/components/MenuTypeBtn.vue";

const URL = useUrlStore();
const menuStore = useMenuStore();

const calcCols = () => {
	if (window.innerWidth < 600) {
		return 4;
	}
	return 2;
};
const cols = ref(calcCols());

const menuTypes = ref([]);
const menus = ref([]);

const computedMenus = computed(() => {
	if (menuStore.type === "ALL") {
		return menus.value;
	}
	return menus.value.filter((menu) => menu.type === menuStore.type);
});

const getMenus = () => {
	axios
		.get(`${URL.API.MENU}?brandId=${menuStore.order.brandId}`)
		.then((res) => {
			menuTypes.value = ["ALL", ...res.data.menuType];
			menus.value = res.data.menuList;
			menuStore.type = menuTypes.value[0];
		});
};

getMenus();

watch(
	() => menuStore.order,
	() => {
		getMenus();
	}
);
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
