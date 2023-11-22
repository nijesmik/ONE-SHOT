<template>
	<v-img src="/src/assets/coffee.jpg"></v-img>
	<router-link :to="{ name: 'login' }" class="btn btn-outline-primary btn-lg"
		>로그인</router-link
	>
	<router-link :to="{ name: 'signup' }" class="btn btn-outline-primary btn-lg"
		>회원가입</router-link
	>
	<router-link
		:to="{ name: 'order-brand' }"
		class="btn btn-outline-secondary btn-lg"
		>비회원 주문</router-link
	>
	<v-btn size="x-large" variant="plain" class="w-15">시작하기</v-btn>
</template>
<!-- --------------------------------------------------------------- -->
<script setup></script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
