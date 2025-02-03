<template>
  <h2>{{ member.email }}</h2>
  <h2>{{ member.username }}</h2>
</template>

<script>
import { useMemberStore } from '@/stores/SelectMemberStore.js'
import { computed } from 'vue'

export default {
  setup() {
    const memberStore = useMemberStore()
    // Pinia의 상태를 computed로 감싸서 반응형 유지
    const member = computed(() => memberStore.member)

    return {
      member,
    }
  },
}
</script>
