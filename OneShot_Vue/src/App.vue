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
	display: flex;
	flex-direction: column;
	align-items: center;
}

.select {
	padding: 1%;
	border: 1px solid black;
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 30%;
	max-width: 250px;
}

.list {
	width: 95%;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}
</style>
