<template>
  <div class="board-container">
    <h1 class="board-title">공지사항</h1>
    <div class="board-actions">
      <button class="btn new-post-btn">글쓰기</button>
    </div>
    <table class="board-table">
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
      </thead>
      <tbody>
        <!-- 예시 데이터 -->
        <tr>
          <td>1</td>
          <td>게시판 제목 1</td>
          <td>홍길동</td>
          <td>2025-01-23</td>
          <td>123</td>
        </tr>
        <tr>
          <td>2</td>
          <td>게시판 제목 2</td>
          <td>김철수</td>
          <td>2025-01-22</td>
          <td>87</td>
        </tr>
        <tr>
          <td>3</td>
          <td>게시판 제목 3</td>
          <td>이영희</td>
          <td>2025-01-21</td>
          <td>45</td>
        </tr>
        <!-- 실제 데이터는 v-for로 반복 렌더링 -->
      </tbody>
    </table>
    <div class="pagination">
      <button class="page-btn">이전</button>
      <button class="page-btn">1</button>
      <button class="page-btn">2</button>
      <button class="page-btn">3</button>
      <button class="page-btn">다음</button>
    </div>
  </div>
</template>

<style scoped>
/* 게시판 컨테이너 */
.board-container {
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
.board-title {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

/* 글쓰기 버튼 */
.board-actions {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 10px;
}

.new-post-btn {
  background-color: #007bff;
  color: #fff;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s;
}

.new-post-btn:hover {
  background-color: #0056b3;
}

/* 게시판 테이블 */
.board-table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.board-table th,
.board-table td {
  text-align: left;
  padding: 10px;
  border: 1px solid #ddd;
}

.board-table th {
  background-color: #f1f1f1;
  font-weight: bold;
}

.board-table tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}

.board-table tbody tr:hover {
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
