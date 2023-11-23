<template>
	<v-col :cols="cols">
		<v-card hover link class="brand">
			<v-img :src="brand.logo" aspect-ratio="1" contain></v-img>
			<div class="brand-name">{{ brand.brandName }}</div>
		</v-card>

		<v-dialog v-model="dialog" activator="parent" width="auto">
			<v-card>
				<v-card-text> {{ brand.brandName }}에서 주문하시겠습니까? </v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn
					color="primary-darken-1"
					variant="text"
					@click.prevent="createOrder(brand)"
					>
					주문
				</v-btn>
				<v-btn color="red-darken-1" variant="text" @click="dialog = false">
					취소
				</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</v-col>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps, ref } from "vue";
import { useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import axios from "axios";

const URL = useUrlStore();
const router = useRouter();

const dialog = ref(false);

const props = defineProps({
	brand: Object,
});

const calcCols = () => {
	if (window.innerWidth < 600) {
		return 4;
	}
	return 3;
};
const cols = ref(calcCols());

const createOrder = (brand) => {
	axios.post(`${URL.API.ORDER_CREATE}?brandId=${brand.brandId}`).then((res) => {
		router.push({ name: "order-menu", params: { orderCode: res.data } });
	});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.brand {
	padding: 6%;
}

.brand-name {
	margin-top: 8%;
	font-size: 1.2rem;
	font-weight: 500;
}
</style>
