<template>
	<v-container>
		<div class="title"></div>
		<v-card
			class="mx-auto pa-12 pb-8"
			elevation="8"
			max-width="448"
			rounded="lg"
		>
			<div class="text-subtitle-1 text-medium-emphasis">Account</div>

			<v-text-field
				density="compact"
				placeholder="Email address"
				prepend-inner-icon="mdi-email-outline"
				variant="outlined"
				v-model="email"
			></v-text-field>

			<div
				class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between"
			>
				Password
			</div>

			<v-text-field
				:append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
				:type="visible ? 'text' : 'password'"
				density="compact"
				placeholder="Enter your password"
				prepend-inner-icon="mdi-lock-outline"
				variant="outlined"
				@click:append-inner="visible = !visible"
				v-model="password"
			></v-text-field>

			<v-btn
				block
				class="mb-8 mt-8"
				color="blue"
				size="large"
				variant="tonal"
				@click.prevent="login(email, password)"
			>
				Log In
			</v-btn>

			<v-card-text class="text-center">
				<router-link
					:to="{ name: 'signup' }"
					class="text-blue text-decoration-none"
					rel="noopener noreferrer"
				>
					Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
				</router-link>
			</v-card-text>
		</v-card>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import axios from "axios";
import { ref } from "vue";
import { useUrlStore } from "@/stores/url";
import { useRouter } from "vue-router";

const URL = useUrlStore();
const email = ref("");
const password = ref("");
const router = useRouter();

const visible = ref(false);

const login = (email, password) => {
	axios
		.post(URL.API.LOGIN, {
			email: email,
			password: password,
		})
		.then((res) => {
			alert("로그인 성공");
			console.log(res.data);
			localStorage.setItem("token", res.data.userId);
			router.push({ name: "home" });
		})
		.catch((err) => {
			alert("로그인 실패");
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.title {
	margin-top: 10%;
}
</style>
