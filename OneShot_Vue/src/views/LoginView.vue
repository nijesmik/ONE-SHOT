<template>
	<form>
		<h2>Log in</h2>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Email address</label>
			<input
				type="email"
				class="form-control form-control-lg"
				id="exampleInputEmail1"
				aria-describedby="emailHelp"
				v-model="email"
			/>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input
				type="password"
				class="form-control form-control-lg"
				id="exampleInputPassword1"
				v-model="password"
			/>
		</div>
		<button
			type="submit"
			class="btn btn-primary"
			@click.prevent="login(email, password)"
		>
			Submit
		</button>
	</form>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { ref } from "vue";
import { useUrlStore } from "@/stores/url";

const URL = useUrlStore();
const email = ref("");
const password = ref("");

const login = (email, password) => {
	axios
		.post(URL.API.LOGIN, {
			email: email,
			password: password,
		})
		.then((res) => {
			alert("로그인 성공");
			console.log(res.data);
		})
		.catch((err) => {
			alert("로그인 실패");
			console.log(err);
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
form {
	min-width: 50%;
}

button {
	float: right;
}
</style>
