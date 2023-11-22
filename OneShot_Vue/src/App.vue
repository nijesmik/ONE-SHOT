<template>
	<v-container>
		<router-view />
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup></script>
<!-- --------------------------------------------------------------- -->
<style>

.item {
	padding: 2%;
	border: 1px solid #dee2e6;
	border-radius: var(--bs-border-radius-sm);
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 30%;
	max-width: 250px;
}

.list {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}
</style>
