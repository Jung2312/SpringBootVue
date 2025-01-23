<template>
  <h2>{{ member.email }}</h2>
</template>

<script>
import { useMemberStore } from '@/stores/MemberStore.js'
import { computed, onMounted } from 'vue'

export default {
  setup() {
    const route = useRoute()

    const memberStore = useMemberStore()

    // 유저 ID로 상세 정보 가져오기
    onMounted(() => {
      const memberEmail = route.params.email
      memberStore.fetchMemberById(memberEmail)
    })

    return {
      member: memberStore.selectedMember,
    }
  },
}
</script>
