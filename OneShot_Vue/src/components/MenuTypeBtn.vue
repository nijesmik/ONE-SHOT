<template>
	<button class="btn btn-outline-info btn-sm" @click.prevent="clickType(type)">
		{{ type }}
	</button>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps } from 'vue';
import { useMenuStore } from "@/stores/menu";

const menuStore = useMenuStore();

defineProps({
  type: String,
})

const clickType = (type) => {
	menuStore.type = type;
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
