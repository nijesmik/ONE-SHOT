<template>
	<div class="ratio ratio-1x1">
		<img :src="brand.logo" :alt="brand.brandName" />
	</div>
	<h5 class="brand-name">{{ brand.brandName }}</h5>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps } from "vue";

defineProps({
	brand: Object,
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
img {
	width: 100%;
	height: 100%;
	object-fit: contain;
}

.brand-name {
  margin-top: 10%;
  margin-bottom: 0;
}
</style>
