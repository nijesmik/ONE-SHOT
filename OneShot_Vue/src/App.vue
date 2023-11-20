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
	margin-top: 5%;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.select {
	padding: 2%;
	border: 1px solid #dee2e6;
	border-radius: 0.375rem;
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 30%;
	max-width: 250px;
}

.list {
	width: 90%;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}
</style>
