<template>
  <div class="management-container">
    <h1 class="management-title">회원 관리</h1>

    <el-table
      class="management-table"
      v-if="memberList.length > 0"
      border
      :data="memberList"
      @row-click="rowClick"
    >
      <el-table-column prop="email" label="아이디"></el-table-column>
      <el-table-column prop="username" label="이름"></el-table-column>
    </el-table>
    <p v-else>데이터를 불러오는 중...</p>
    <!-- 데이터 없을 때 메시지 표시 -->

    <div class="pagination">
      <button class="page-btn">이전</button>
      <button class="page-btn">1</button>
      <button class="page-btn">2</button>
      <button class="page-btn">3</button>
      <button class="page-btn">다음</button>
    </div>
  </div>
</template>

<script>
import { useMemberListStore } from '@/stores/MemberStore.js'
import { useMemberStore } from '@/stores/SelectMemberStore.js'
import { computed, onMounted } from 'vue'
import { useRouter } from 'vue-router'

export default {
  name: 'MemberList',
  setup() {
    const membersStore = useMemberListStore()
    const router = useRouter()

    // Pinia의 상태를 computed로 감싸서 반응형 유지
    const memberList = computed(() => membersStore.members)

    onMounted(async () => {
      await membersStore.fetchMembers()
    })

    const rowClick = (row) => {
      console.log(row.email)
      const MemberStore = useMemberStore()
      MemberStore.selectMember = row.email
      MemberStore.fetchMember()

      router.push('/member')
    }

    return {
      memberList,
      rowClick,
    }
  },
}
</script>

<style scoped>
/* 게시판 컨테이너 */
.management-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  margin-top: 40px;
}

/* 제목 스타일 */
.management-title {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

/* 글쓰기 버튼 */
.management-actions {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
}

.new-register-btn {
  background-color: #007bff;
  color: #fff;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s;
}

.new-register-btn:hover {
  background-color: #0056b3;
}

/* 게시판 테이블 */
.management-table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.management-table th,
.management-table td {
  text-align: left;
  padding: 10px;
  border: 1px solid #ddd;
}

.management-table th {
  background-color: #f1f1f1;
  font-weight: bold;
}

.management-table tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}

.management-table tbody tr:hover {
  background-color: #f1f1f1;
}

/* 페이지네이션 */
.pagination {
  display: flex;
  justify-content: center;
  gap: 5px;
}

.page-btn {
  padding: 8px 12px;
  border: 1px solid #ddd;
  background-color: #fff;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  transition:
    background-color 0.3s,
    color 0.3s;
}

.page-btn:hover {
  background-color: #007bff;
  color: #fff;
}
</style>
