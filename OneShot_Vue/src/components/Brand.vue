<template>
	<v-col cols="2">
		<v-card hover link>
			<v-img :src="brand.logo" aspect-ratio="1" contain></v-img>
			<v-card-title>{{ brand.brandName }}</v-card-title>
		</v-card>
	</v-col>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps } from "vue";

defineProps({
	brand: Object,
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
