import { defineStore } from 'pinia'
import api from '@/api' // Axios 인스턴스

export const useMemberStore = defineStore('member', {
  state: () => ({
    member: [],
    isLoading: false,
    error: null,
    selectMember: null,
  }),
  actions: {
    async fetchMember() {
      console.log('fetchMember 실행') // 실행 여부 확인
      this.isLoading = true
      this.error = null

      try {
        const response = await api.get(`/getMember?email=${this.selectMember}`)
        this.member = response.data
      } catch (error) {
        this.error = '회원을 불러오는 데 실패했습니다.'
      } finally {
        this.isLoading = false
      }
    },
  },
})
