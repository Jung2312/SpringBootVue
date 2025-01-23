import { defineStore } from 'pinia'
import api from '@/api' // Axios 인스턴스

export const useMemberStore = defineStore('member', {
  state: () => ({
    members: [],
    isLoading: false,
    error: null,
    selectMember: null,
  }),
  actions: {
    async fetchMembers() {
      console.log('fetchMembers 실행') // 실행 여부 확인
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

    async fetchMemberById(id) {
      const cachedMember = this.members.find((member) => member.id === id)
      if (cachedMember) {
        this.selectedMember = cachedMember
      } else {
        const response = await api.get(`/member?email=${email}`)
        this.selectedMember = response.data
      }
    },
  },
})
