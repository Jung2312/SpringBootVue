import { defineStore } from 'pinia'
import api from '@/api' // Axios 인스턴스

export const useMemberListStore = defineStore('members', {
  state: () => ({
    members: [],
    isLoading: false,
    error: null,
    selectMember: null,
  }),
  actions: {
    async fetchMembers() {
      this.isLoading = true
      this.error = null

      try {
        const response = await api.get('/allMember')
        this.members = response.data.list
      } catch (error) {
        this.error = '회원 목록을 불러오는 데 실패했습니다.'
      } finally {
        this.isLoading = false
      }
    },
  },
})
