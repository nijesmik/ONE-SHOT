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

			<!-- password2 -->
			<div
				class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between"
			>
				Password 확인
			</div>
			<v-text-field
				:append-inner-icon="visible2 ? 'mdi-eye-off' : 'mdi-eye'"
				:type="visible2 ? 'text' : 'password'"
				density="compact"
				placeholder="Enter your password"
				prepend-inner-icon="mdi-lock-outline"
				variant="outlined"
				@click:append-inner="visible2 = !visible2"
				v-model="password2"
			></v-text-field>

			<div
				class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between"
			>
				Nickname
			</div>
			<v-text-field
				density="compact"
				placeholder="Enter your nickname"
				variant="outlined"
				v-model="nickname"
			></v-text-field>
			<div>
				<v-btn
					block
					class="mb-8 mt-8"
					color="blue"
					size="large"
					variant="tonal"
					@click.prevent="signup"
				>
					Submit
				</v-btn>
				<v-dialog v-model="dialog" activator="parent" width="auto">
					<v-card>
						<v-card-text> {{ modalText }} </v-card-text>
						<v-card-actions>
							<v-spacer></v-spacer>
							<v-btn
								color="primary-darken-1"
								variant="text"
								@click.prevent="closeModal"
							>
								확인
							</v-btn>
						</v-card-actions>
					</v-card>
				</v-dialog>
			</div>
		</v-card>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import { useUrlStore } from "@/stores/url";

const router = useRouter();
const URL = useUrlStore();
const email = ref("");
const password = ref("");
const password2 = ref("");
const nickname = ref("");

const visible = ref(false);
const visible2 = ref(false);

const dialog = ref(false);
const modalText = ref("");

const success = ref(false);
const closeModal = () => {
	if (success.value) {
		router.push({ name: "login" });
	}
};

const signup = () => {
	if (password.value.length <= 0) {
		modalText.value = "비밀번호를 입력해주세요.";
		return;
	}
	if (password.value !== password2.value) {
		modalText.value = "비밀번호가 일치하지 않습니다.";
		return;
	}
	if (nickname.value === "" || nickname.value === null) {
		modalText.value = "닉네임을 입력해주세요.";
		return;
	}
	axios
		.post(URL.API.SIGNUP, {
			email: email.value,
			password: password.value,
			nickname: nickname.value,
		})
		.then((res) => {
			if (res.data === 1) {
				success.value = true;
				modalText.value = "회원가입 완료!";
			}
		})
		.catch((err) => {
			modalText.value = "회원가입 실패";
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
form {
	width: 90%;
	max-width: 900px;
}

.title {
	margin-top: 10%;
}
</style>
