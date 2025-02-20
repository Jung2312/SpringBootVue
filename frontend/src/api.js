import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080', // Spring Boot 서버 주소
  timeout: 5000, // 요청 제한 시간
})

export const updateMember = async (updatedData) => {
  try {
    const response = await api.put('/updateMember', updatedData)
    return response.data
  } catch (error) {
    console.error('Error updating member:', error)
    throw error
  }
}

export const deleteMember = async (id) => {
  try {
    const response = await api.delete(`/deleteMember?id=${id}`)
    return response.data
  } catch (error) {
    console.error('Error delete member:', error)
    throw error
  }
}

export default api
