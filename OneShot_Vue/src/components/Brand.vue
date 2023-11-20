<template>
	<div class="box">
		<img :src="brand.logo" :alt="brand.brandName" />
	</div>
	<div>{{ brand.brandName }}</div>
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

.box {
	width: 100%;
	max-height: 250px;
}

div {
	margin: 2%;
}
</style>
