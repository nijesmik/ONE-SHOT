<template>
	<div class="menu" @click.prevent="clickMenu">
		<div class="image">
			<img :src="menu.img" :alt="menu.menuName" />
		</div>
		<div>{{ menu.menuName }}</div>
		<div>{{ menu.price }}원</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useMenuStore } from "@/stores/menu";
import { defineProps } from "vue";

const menuStore = useMenuStore();

const props = defineProps({
	menu: Object,
});

const clickMenu = () => {
	menuStore.id = props.menu.menuId;
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
img {
	width: 100%;
	border-radius: var(--bs-border-radius-sm);
}

div {
	margin: 2% 0;
}
</style>
