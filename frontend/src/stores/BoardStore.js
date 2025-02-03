import { defineStore } from 'pinia'
import api from '@/api' // Axios 인스턴스

export const useBoardStore = defineStore('board', {
  state: () => ({
    boards: [],
    isLoading: false,
    error: null,
    selectBoard: null,
  }),
  actions: {
    async fetchBoards() {
      this.isLoading = true
      this.error = null

      try {
        const response = await api.get('/allBoard')
        this.boards = response.data.list
      } catch (error) {
        this.error = '회원 목록을 불러오는 데 실패했습니다.'
      } finally {
        this.isLoading = false
      }
    },
  },
})
