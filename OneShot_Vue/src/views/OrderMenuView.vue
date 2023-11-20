<template>
	<div class="input-group mb-3 url">
  <input type="text" class="form-control" :placeholder="share_url" aria-label="Recipient's username" aria-describedby="button-addon2">
  <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
</div>

	<div class="list">
		<div v-for="menu in menus" class="menu select" @click="selectMenu(menu)">
			<Menu :menu="menu" />
		</div>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUrlStore } from "@/stores/url";
import axios from "axios";
import Menu from "@/components/Menu.vue";

const URL = useUrlStore();
const route = useRoute();
const router = useRouter();
const orderCode = route.params.orderCode;

const share_url = ref(`${URL.DOMAIN}/order/${orderCode}`);
const order = ref({});
const orderDetails = ref([]);
const menus = ref([]);

axios.get(`${URL.API.ORDER}?orderCode=${orderCode}`).then((res) => {
	order.value = res.data.order;
	orderDetails.value = res.data.orderDetail;
	axios.get(`${URL.API.MENU}?brandId=${order.value.brandId}`).then((res) => {
		menus.value = res.data;
	});
}).catch((err) => {
	if (err.response.status === 500) {
		alert("잘못된 URL입니다.");
		router.push({ name: "home" });
	}
})

const selectMenu = (menu) => {
	alert("TODO : 사이즈, ice/hot 선택 모달 띄우기");
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
.url {
	width: 90%;
}
</style>
