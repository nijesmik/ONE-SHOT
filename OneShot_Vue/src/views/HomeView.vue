<template>

<router-link :to="{name : 'login'}" class="btn btn-outline-primary btn-lg">로그인</router-link>
<router-link :to="{name : 'signup'}" class="btn btn-outline-primary btn-lg">회원가입</router-link>
<router-link :to="{ name: 'order-brand' }" class="btn btn-outline-secondary btn-lg">비회원 주문</router-link>

</template>
<!-- --------------------------------------------------------------- -->
<script setup>



</script>
<!-- --------------------------------------------------------------- -->
<style scoped>
* {
  margin: 1%;
}


</style>