import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080', // Spring Boot 서버 주소
  timeout: 5000, // 요청 제한 시간
})

export default api
