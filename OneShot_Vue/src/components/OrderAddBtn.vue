<template>
	<v-btn variant="tonal" class="mb-2 mr-2" @click.prevent="click">주문 추가</v-btn>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { useRouter } from "vue-router";

const router = useRouter();
const click = () => {
  router.push({ name: "order-menu" });
};

</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
