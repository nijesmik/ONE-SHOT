<template>
	<div class="wrapper">
		<router-view />
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup></script>
<!-- --------------------------------------------------------------- -->
<style>
* {
	margin: 0;
	padding: 0;
}

.wrapper {
	width: 90%;
	margin: 5% auto;
	display: flex;
	flex-direction: column;
	align-items: center;
}

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
