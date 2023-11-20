<template>
	<div class="list">
		<div
			v-for="brand in brands"
			class="brand select"
			@click="selectBrand(brand)"
		>
			<Brand :brand="brand" />
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import Brand from "@/components/Brand.vue";
const GET_BRANDS_API = "http://localhost:8080/api/brand";
const ORDER_API = "http://localhost:8080/api/order/create";

const brands = ref([]);
const router = useRouter();

axios.get(GET_BRANDS_API).then((res) => {
	brands.value = res.data;
});

const selectBrand = (brand) => {
	const isConfirmed = confirm("주문하시겠습니까?");
	if (isConfirmed) {
		axios.post(`${ORDER_API}?brandId=${brand.brandId}`).then((res) => {
			router.push({ name: "order-menu", params: { orderCode: res.data } });
		});
	}
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
