<template>
	<v-text-field :model-value="shareUrl" label="URL" variant="outlined" readonly>
		<template v-slot:append-inner>
			<v-btn color="primary" variant="tonal" @click="clipboard"> Copy </v-btn>

			<v-snackbar v-model="snackbar" timeout="2000">
				복사 완료!

				<template v-slot:actions>
					<v-btn color="blue" variant="text" @click="snackbar = false">
						Close
					</v-btn>
				</template>
			</v-snackbar>
		</template>
	</v-text-field>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useUrlStore } from "@/stores/url";
import { useRoute } from "vue-router";

const route = useRoute();
const URL = useUrlStore();
const shareUrl = ref(`${URL.DOMAIN}/order/${route.params.orderCode}`);
const snackbar = ref(false);
const clipboard = () => {
	navigator.clipboard.writeText(shareUrl.value).then(() => {
		snackbar.value = true;
	});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
