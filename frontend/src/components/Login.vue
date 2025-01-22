<template>
  <div class="login-container">
    <div class="login-card">
      <form @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="id">id</label>
          <input id="id" type="id" v-model="id" />
        </div>
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input id="password" type="password" v-model="password" />
        </div>
        <button type="submit" class="btn">로그인</button>
      </form>
      <p>회원이 아니신가요? <a href="/register">회원가입</a></p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      password: '',
      id: '',
    }
  },
  methods: {
    handleLogin() {
      if (this.id === null || this.id === '') {
        alert('아이디 입력하셈')
        return
      }
      if (this.password === null || this.password === '') {
        alert('비밀번호 입력하셈')
        return
      }
    },
  },
}
</script>
