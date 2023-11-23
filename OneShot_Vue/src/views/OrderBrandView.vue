<template>
	<v-container>
		<div class="title">주문하실 브랜드를 선택해주세요</div>
		<v-row>
			<template v-for="brand in brands">
				<Brand :brand="brand" />
			</template>
		</v-row>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import axios from "axios";
import Brand from "@/components/Brand.vue";
import { useUrlStore } from "@/stores/url";

const URL = useUrlStore();
const brands = ref([]);

axios.get(URL.API.BRAND).then((res) => {
	brands.value = res.data;
});
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.title {
	font-size: 2.5rem;
	font-weight: bold;
	margin: 2rem 0 2rem 0;
}

@media screen and (max-width: 600px) {
	.title {
		font-size: 1.7rem;
	}
}
</style>
