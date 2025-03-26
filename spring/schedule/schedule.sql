-- 스키마 접속
use schedulemanager;

-- 회원 테이블 생성
CREATE TABLE member (
    member_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '회원 ID',
    member_name VARCHAR(50) NOT NULL UNIQUE COMMENT '회원 이름',
    member_pwd VARCHAR(100) NOT NULL COMMENT '회원 비밀번호'
) COMMENT = '회원 테이블';


-- 일정 테이블 생성
CREATE TABLE schedule (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 ID',
    schedule_content TEXT NOT NULL COMMENT '일정 내용',
    writer VARCHAR(50) NOT NULL COMMENT '작성자',
    schedule_pwd VARCHAR(100) NOT NULL COMMENT '비밀번호',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '작성/수정일',
    CONSTRAINT fk_member FOREIGN KEY (writer) REFERENCES member(member_name)
) COMMENT = '일정 테이블';

-- 테이블 삭제
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS member;

delete from member WHERE member_name='test';
select * from member;

INSERT INTO schedule (schedule_content, writer, schedule_pwd) VALUES ("일정1", "test", "pwd");
INSERT INTO member (member_name, member_pwd) VALUES ("test", "pwd");