<template>
	<div class="input-group mb-3 url">
		<input
			type="text"
			class="form-control"
			:placeholder="shareUrl"
			aria-label="Recipient's username"
			aria-describedby="button-addon2"
		/>
		<button
			@click.prevent="clipboard"
			class="btn btn-outline-secondary"
			type="button"
			id="button-addon2"
		>
			Copy
		</button>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const menuStore = useMenuStore();
const URL = useUrlStore();
const shareUrl = ref(`${URL.DOMAIN}/order/${menuStore.orderCode}`);

const clipboard = () => {
	navigator.clipboard.writeText(props.url).then(() => {
		alert("URL이 복사되었습니다.");
	});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
