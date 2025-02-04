<template>
  <div class="flex items-center justify-center min-h-screen w-full bg-gray-100">
    <div class="w-[210mm] h-[297mm] p-10 bg-white shadow-lg rounded-lg flex flex-col items-center">
      <!-- 헤더 (이름 및 직무) -->
      <div class="w-full text-center border-b pb-4 mb-4">
        <h1 class="text-3xl font-bold">{{ member.username }}</h1>
        <p class="text-lg text-gray-600">{{ member.job_title || '직무 정보 없음' }}</p>
      </div>

      <!-- 프로필 사진 -->
      <img
        :src="member.profile_img"
        alt="Profile Image"
        class="image-size rounded-full shadow-md"
      />

      <!-- 연락처 섹션 -->
      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">기본정보</h2>
        <p><strong>☎ 휴대폰 : </strong> {{ member.phone }}</p>
        <p><strong>✉ 이메일 : </strong> {{ member.email }}</p>
        <p><strong>📅 생년월일 : </strong> {{ member.birthday }}</p>
        <p><strong>📆 입사일 : </strong> {{ member.created_at }}</p>
      </div>

      <!-- 경력 사항 -->
      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">경력</h2>

        <!-- 경력 데이터가 있을 때 테이블 표시 -->
        <el-table
          v-if="member.experiences && member.experiences.length > 0"
          border
          :data="member.experiences"
          @row-click="rowClick"
        >
          <el-table-column prop="company" label="회사명"></el-table-column>
          <el-table-column prop="experience_year" label="근속년수"></el-table-column>
        </el-table>

        <!-- 경력 데이터가 없을 경우 "신입" 표시 -->
        <p v-else>신입</p>
      </div>

      <!-- 학력 사항 -->
      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">학력</h2>
        <el-table
          v-if="member.educations != null && member.educations.length > 0"
          border
          :data="member.educations"
          @row-click="rowClick"
        >
          <el-table-column prop="school" label="최종학력"></el-table-column>
          <el-table-column prop="remark" label="비고"></el-table-column>
          <el-table-column prop="education_year" label="졸업년도"></el-table-column>
        </el-table>
      </div>
    </div>
  </div>
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
<style scoped>
html,
body {
  height: 100%;
  margin: 0;
}

.image-size {
  width: 150px;
  height: 200px;
  margin-top: 20px;
}
</style>
