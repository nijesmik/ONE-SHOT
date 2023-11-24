<template>
	<a id="logout" href="" @click.prevent="logout">로그아웃</a>

	<v-snackbar v-model="snackbar" timeout="1500">
		로그아웃 완료!

		<template v-slot:actions>
			<v-btn color="blue" variant="text" @click="snackbar = false">
				Closes
			</v-btn>
		</template>
	</v-snackbar>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, watch } from "vue";

const snackbar = ref(false);
const isLogout = ref(false);

const logout = () => {
	sessionStorage.removeItem("token");
	snackbar.value = true;
	isLogout.value = true;
};

watch(snackbar, (snackbar) => {
	if (!snackbar && isLogout.value) {
		location.reload();
	}
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
