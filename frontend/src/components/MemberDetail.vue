<template>
  <div class="flex items-center justify-center min-h-screen w-full bg-gray-100">
    <div
      class="a4-paper w-[210mm] h-[297mm] p-10 bg-white shadow-lg rounded-lg flex flex-col items-center"
    >
      <div class="w-full text-center border-b pb-4 mb-4">
        <input
          v-if="isEditing"
          v-model="editableMember.username"
          class="text-3xl font-bold border px-2"
        />
        <h1 v-else class="text-3xl font-bold">{{ member.username }}</h1>

        <input
          v-if="isEditing"
          v-model="editableMember.job_title"
          class="text-lg text-gray-600 border px-2"
          placeholder="직무 정보 없음"
        />
        <p v-else class="text-lg text-gray-600">{{ member.job_title || '직무 정보 없음' }}</p>
      </div>

      <div>
        <img
          :src="member.profile_img"
          alt="Profile Image"
          class="image-size rounded-full shadow-md"
        />
        <div v-if="isEditing">
          <input
            type="file"
            ref="fileInput"
            @change="handleFileChange"
            accept="image/*"
            style="display: none"
          />
          <input type="button" value="사진 선택" @click="triggerFileInput" />
        </div>
        <button v-if="!isEditing" @click="enableEditMode">사진 수정</button>
      </div>

      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">기본정보</h2>
        <p>
          <strong>☎ 휴대폰 : </strong>
          <input v-if="isEditing" v-model="editableMember.phone" class="border px-2" />
          <span v-else>{{ member.phone }}</span>
        </p>
        <p>
          <strong>✉ 이메일 : </strong>
          <input v-if="isEditing" v-model="editableMember.email" class="border px-2" />
          <span v-else>{{ member.email }}</span>
        </p>
        <p>
          <strong>📅 생년월일 : </strong>
          <input v-if="isEditing" v-model="editableMember.birthday" class="border px-2" />
          <span v-else>{{ member.birthday }}</span>
        </p>
        <p><strong>📆 입사일 : </strong> {{ member.created_at }}</p>
      </div>

      <div>
        <input v-if="!isEditing" type="button" value="정보 수정" @click="enableEditMode()" />
        <input v-if="isEditing" type="button" value="정보 저장" @click="saveChanges()" />
        <input v-if="isEditing" type="button" value="저장 취소" @click="cancelEdit()" />
      </div>

      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">경력</h2>
        <div class="experience-table-container">
          <el-table
            v-if="member.experiences && member.experiences.length > 0"
            border
            :data="member.experiences"
            style="width: 100%"
          >
            <el-table-column prop="company" label="회사명"></el-table-column>
            <el-table-column prop="experience_year" label="근속년수"></el-table-column>
          </el-table>
          <p v-else>신입</p>
        </div>
      </div>

      <div class="mt-6 border-t pt-4 text-left w-full max-w-md text-sm">
        <h2 class="text-xl font-semibold mb-2">학력</h2>
        <div class="education-table-container">
          <el-table
            v-if="member.educations && member.educations.length > 0"
            border
            :data="member.educations"
            style="width: 100%"
          >
            <el-table-column prop="school" label="학교명"></el-table-column>
            <el-table-column prop="remark" label="비고"></el-table-column>
            <el-table-column prop="education_year" label="졸업년도"></el-table-column>
          </el-table>
          <p v-else>해당 없음</p>
        </div>
      </div>

      <div>
        <input type="button" value="회원 삭제" @click="deleteMemberMode()" />
      </div>
    </div>
  </div>
</template>

<script>
import { useMemberStore } from '@/stores/SelectMemberStore.js'
import { updateMember, deleteMember } from '@/api.js'
import { computed, ref } from 'vue'
import { useRouter } from 'vue-router'

export default {
  setup() {
    const error = ''
    const memberStore = useMemberStore()
    const member = computed(() => memberStore.member)
    const isEditing = ref(false)
    const editableMember = ref({ ...memberStore.member })
    const fileInput = ref(null)
    const router = useRouter()
    const enableEditMode = () => {
      isEditing.value = true
      editableMember.value = { ...memberStore.member }
    }

    // 파일 입력창 열기
    const triggerFileInput = () => {
      fileInput.value.click()
    }

    // 파일 선택 시 이미지 변경
    const handleFileChange = (event) => {
      const file = event.target.files[0]
      if (file) {
        const reader = new FileReader()
        reader.onload = (e) => {
          editableMember.value.profile_img = e.target.result // 미리 보기
          member.value.profile_img = e.target.result
        }
        reader.readAsDataURL(file)

        // 서버에 업로드
        // 1. 변경 안내 메시지
        // 2. 서버 연결, 데이터 전송
      }
    }

    const saveChanges = async () => {
      try {
        await updateMember(editableMember.value) // API 요청
        Object.assign(memberStore.member, editableMember.value) // 상태 업데이트
        isEditing.value = false
      } catch (error) {
        this.error = error
      }
    }

    const deleteMemberMode = async () => {
      try {
        await deleteMember(memberStore.member.id) // API 요청
        isEditing.value = false
        router.push('/memberMenagement')
      } catch (error) {
        this.error = error
      }
    }

    const cancelEdit = () => {
      isEditing.value = false
    }

    return {
      error,
      member,
      editableMember,
      isEditing,
      enableEditMode,
      saveChanges,
      cancelEdit,
      deleteMemberMode,
      fileInput,
      triggerFileInput,
      handleFileChange,
    }
  },
}
</script>

<style scoped>
/* A4 용지 크기를 유지하며 화면 중앙에 배치 */
.flex {
  display: flex;
  justify-content: center; /* 가로 중앙 */
  align-items: center; /* 세로 중앙 */
  min-height: 100vh; /* 화면 전체 높이 */
}

.a4-paper {
  width: 210mm; /* A4 용지 너비 */
  height: auto; /* 높이를 자동으로 설정 */
  padding: 20mm; /* 여백 */
  background-color: white;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
}

/* 이미지 크기 */
.image-size {
  width: 150px;
  height: 150px;
  object-fit: cover;
  margin-top: 20px;
}

/* 버튼 및 폼 스타일 */
input[type='button'] {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
  font-size: 14px;
}

input[type='button']:hover {
  background-color: #0056b3;
}

input[type='text'],
input[type='email'],
input[type='date'],
input[type='tel'] {
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #ddd;
}

h2 {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
}

/* 경력 및 학력 테이블 컨테이너 스타일 */
.experience-table-container,
.education-table-container {
  max-height: 300px; /* 테이블 최대 높이 */
  overflow-y: auto; /* 스크롤 생기도록 설정 */
}

/* 테이블 스타일 */
.el-table {
  width: 100%;
  margin-top: 20px;
}

::v-deep(.el-table__cell) {
  text-align: center !important;
}
</style>
