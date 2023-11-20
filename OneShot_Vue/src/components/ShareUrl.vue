<template>
	<div class="input-group mb-3 url">
		<input
			type="text"
			class="form-control"
			:placeholder="url"
			aria-label="Recipient's username"
			aria-describedby="button-addon2"
		/>
		<button class="btn btn-outline-secondary" type="button" id="button-addon2">
			Copy
		</button>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps } from "vue";

defineProps({
	url: String,
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
