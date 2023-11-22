<template>
	<v-chip-group
		v-model="typeSelection"
		selected-class="text-deep-purple-accent-4"
		mandatory
	>
		<template v-for="menuType in types">
			<v-chip>{{ menuType }}</v-chip>
		</template>
	</v-chip-group>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps, ref, watch } from "vue";
import { useMenuStore } from "@/stores/menu";

const typeSelection = ref(0);
const menuStore = useMenuStore();

const props = defineProps({
	types: Array,
});

watch(typeSelection, (idx) => {
	menuStore.type = props.types[idx];
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
