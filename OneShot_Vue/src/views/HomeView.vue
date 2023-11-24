<template>
	<div class="background">
		<div id="home-title">ONE-SHOT</div>
		<div class="menu">
			<template v-if="!login">
				<router-link :to="{ name: 'login' }">로그인</router-link>
				<router-link :to="{ name: 'signup' }">회원가입</router-link>
			</template>
			<template v-else>
				<Logout />
				<router-link :to="{ name: 'order-brand' }">주문 하기</router-link>
			</template>
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import Logout from "@/components/Logout.vue";
import { ref } from 'vue';
const islogin = () => {
	if (sessionStorage.getItem("token")) {
		return true;
	}
	return false;
};
const login = ref(islogin());
</script>
<!-- --------------------------------------------------------------- -->
<style>
.background {
	background-image: url("/src/assets/coffee.jpg");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	height: 100vh;
	width: 100vw;
	position: relative;
	overflow: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

#home-title {
	font-size: 11vw;
	font-weight: 900;
	color: white;
}

a {
	margin: 0 1rem;
	font-size: 4vw;
	text-decoration: none;
	color: white;
}

a:hover {
	color: black;
}

@media screen and (min-width: 770px) {
	a {
		font-size: 2.5vw;
	}
}
</style>
