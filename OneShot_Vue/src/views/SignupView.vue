<template>
  <form class="row g-3">
  <h2>Sign up</h2>
  <br/>
  <div class="mb-3">
    <label for="email" class="form-label">Email address</label>
    <input type="email" class="form-control form-control-lg" id="email" aria-describedby="emailHelp" v-model="email">
  </div>
  <div class="mb-3 col-md-6">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control form-control-lg" id="password" v-model="password">
  </div>
  <div class="mb-3 col-md-6">
    <label for="password2" class="form-label">Password 확인</label>
    <input type="password" class="form-control form-control-lg" id="password2" v-model="password2">
  </div>
  <div class="mb-3">
    <label for="nickname" class="form-label">Nickname</label>
    <input type="text" class="form-control form-control-lg" id="nickname" v-model="nickname">
  </div>
  <button type="submit" class="btn btn-primary btn-lg" @click.prevent="signup">Submit</button>
</form>


</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import {ref} from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import { useUrlStore } from "@/stores/url";

const router = useRouter();
const URL = useUrlStore();
const email = ref("");
const password = ref("");
const password2 = ref("");
const nickname = ref("");

const signup = () => {
  if (password.value !== password2.value) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }
  axios.post(URL.API.SIGNUP, {
    email: email.value,
    password: password.value,
    nickname: nickname.value,
  }).then((res)=>{
    if (res.data === 1) {
      alert("회원가입 성공");
      router.push({name: "login"});
    }
  }).catch((err) => {
    alert("회원가입 실패");
    console.log(err);
  });

}


</script>
<!-- --------------------------------------------------------------- -->
<style scoped>

form {
  width: 90%;
  max-width: 900px;
}

</style>