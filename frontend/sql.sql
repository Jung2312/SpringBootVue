CREATE TABLE MEMBER(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,      -- 사용자 고유 ID
    username VARCHAR(50) NOT NULL UNIQUE,      -- 사용자 이름(고유값)
    password VARCHAR(255) NOT NULL,            -- 비밀번호(암호화 저장)
    email VARCHAR(100) NOT NULL UNIQUE,        -- 이메일
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성 일시
    profile_img VARCHAR(3000) 
    phone VARCHAR(11) not null,
    birthday DATE,
    job_title VARCHAR(50)
); 

CREATE TABLE BOARD (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,      -- 게시글 고유 ID
    title VARCHAR(255) NOT NULL,               -- 게시글 제목
    content TEXT NOT NULL,                     -- 게시글 내용
    author_id BIGINT NOT NULL,                 -- 작성자 ID (user 테이블과 연관)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성 일시
    FOREIGN KEY (author_id) REFERENCES member(id) ON DELETE CASCADE -- 작성자 ID 외래키 설정
);

CREATE TABLE EXPERIENCE(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(255) NOT NULL,
    experience_year BIGINT NOT NULL,
    member_id BIGINT NOT NULL,   
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE 
); 

CREATE TABLE EDUCATION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    school VARCHAR(255) NOT NULL,
    remark VARCHAR(255)NOT NULL,
    member_id BIGINT NOT NULL,   
    education_year BIGINT NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE 
); 
