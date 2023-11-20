<template>
	<div class="image">
		<img :src="menu.img" :alt="menu.menuName" />
	</div>
	<div>{{ menu.menuName }}</div>
	<div>{{ menu.price }}원</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps } from "vue";

defineProps({
	menu: Object,
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
img {
	width: 100%;
	border-radius: 50%;
}

div {
  margin: 2% 0;
}
</style>
