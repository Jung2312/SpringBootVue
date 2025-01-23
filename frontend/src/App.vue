<template>
  <v-app>
    <nav>
      <RouterLink to="/login">로그인</RouterLink>
      <!-- <RouterLink to="/register">회원가입</RouterLink> -->
      <RouterLink to="/memberMenagement">회원관리</RouterLink>
    </nav>
    <RouterView />
  </v-app>
</template>

<style scoped>
/* 전체 컨테이너 스타일 */
v-app {
  background-color: #f9f9f9;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

/* 네비게이션 스타일 */
nav {
  display: flex;
  justify-content: flex-end;
  padding: 15px 30px;
  background-color: #007bff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

/* RouterLink 스타일 */
nav a {
  color: #ffffff;
  text-decoration: none;
  font-size: 16px;
  font-weight: bold;
  margin-left: 20px;
  transition: color 0.3s ease;
}

nav a:hover {
  color: #ffdd57;
}

/* RouterView 영역 스타일 */
RouterView {
  flex: 1;
  padding: 20px;
  background-color: #ffffff;
  box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.05);
  border-radius: 8px;
  max-width: 800px;
  margin: 30px auto;
  box-sizing: border-box;
}
</style>
