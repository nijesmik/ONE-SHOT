<template>
	<v-alert
		type="error"
		v-model="alertBox"
		variant="tonal"
		closable
		close-label="Close Alert"
		title="잘못된 URL입니다."
		class="mt-10 alert"
	>
		우측 닫기 버튼을 누르면 홈화면으로 이동합니다.
	</v-alert>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref, watch } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();
const alertBox = ref(true);

watch(alertBox, (isOpen) => {
	if (!isOpen) {
		router.push({ name: "home" });
	}
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.alert {
	margin: 0 auto;
	width: 50%;
}

@media screen and (max-width: 930px) {
	.alert {
		width: 80%;
	}
}
</style>
