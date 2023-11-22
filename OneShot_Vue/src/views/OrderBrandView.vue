<template>
	<v-container>
		<v-row>
			<template v-for="brand in brands">
				<Brand :brand="brand" @click="selectBrand(brand)" />
			</template>
		</v-row>
	</v-container>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import Brand from "@/components/Brand.vue";
import { useUrlStore } from "@/stores/url";

const URL = useUrlStore();
const brands = ref([]);
const router = useRouter();

axios.get(URL.API.BRAND).then((res) => {
	brands.value = res.data;
});

const selectBrand = (brand) => {
	const isConfirmed = confirm(`${brand.brandName}에서 주문하시겠습니까?`);
	if (isConfirmed) {
		axios
			.post(`${URL.API.ORDER_CREATE}?brandId=${brand.brandId}`)
			.then((res) => {
				router.push({ name: "order-menu", params: { orderCode: res.data } });
			});
	}
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
