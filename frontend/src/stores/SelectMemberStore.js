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
      this.isLoading = true
      this.error = null

      try {
        const response = await api.get(`/getMember?email=${this.selectMember}`)
        this.member = response.data.memberInfo
      } catch (error) {
        this.error = '회원을 불러오는 데 실패했습니다.'
      } finally {
        this.isLoading = false
      }
    },
  },
})
