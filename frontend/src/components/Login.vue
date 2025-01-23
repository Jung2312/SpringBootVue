<template>
  <div class="login-container">
    <div class="login-card">
      <form @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="email">아이디</label>
          <input id="email" type="email" v-model="email" />
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
import axios from 'axios'

export default {
  data() {
    return {
      password: '',
      email: '',
    }
  },
  methods: {
    async handleLogin() {
      this.$router.push('/board')
      if (this.email === null || this.email === '') {
        alert('아이디를 입력하세요.')
        return
      }
      if (this.password === null || this.password === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      try {
        // Spring Boot 로그인 API 호출
        const response = await axios.post('/login', {
          email: this.email,
          password: this.password,
        })

        // API 응답 처리
        if (response.status === 200) {
          // 로그인 성공 시 게시판 화면으로 이동
          this.$router.push('/board')
        } else {
          alert('로그인에 실패했습니다. 다시 시도해주세요.')
        }
      } catch (error) {
        console.error(error)
        alert('로그인 중 오류가 발생했습니다. 다시 시도해주세요.')
      }
    },
  },
}
</script>

<style scoped>
/* 전체 컨테이너 스타일 */
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f4f4f9;
}

/* 카드 스타일 */
.login-card {
  width: 100%;
  max-width: 400px;
  padding: 30px;
  background: #ffffff;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* 입력 폼 그룹 스타일 */
.form-group {
  margin-bottom: 20px;
}

/* 라벨 스타일 */
.form-group label {
  display: block;
  margin-bottom: 8px;
  font-size: 14px;
  font-weight: bold;
  color: #333;
}

/* 입력 필드 스타일 */
.form-group input {
  width: 100%;
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  transition: border-color 0.3s;
}

.form-group input:focus {
  border-color: #007bff;
  outline: none;
  box-shadow: 0 0 4px rgba(0, 123, 255, 0.2);
}

/* 버튼 스타일 */
.btn {
  width: 100%;
  padding: 12px;
  font-size: 16px;
  font-weight: bold;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #0056b3;
}

/* 하단 링크 스타일 */
p {
  text-align: center;
  margin-top: 15px;
  font-size: 14px;
  color: #666;
}

p a {
  color: #007bff;
  text-decoration: none;
  font-weight: bold;
}

p a:hover {
  text-decoration: underline;
}
</style>
