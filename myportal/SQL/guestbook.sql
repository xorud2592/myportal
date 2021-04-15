-- Table
CREATE TABLE guestbook (
	no number primary key,
    name varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    content varchar(255) NOT NULL,
    regdate date DEFAULT sysdate
);

-- PK로 사용할 시퀀스
CREATE SEQUENCE seq_guestbook_no 
    START WITH 1 INCREMENT BY 1 NOCACHE;

-- 테스트 데이터
insert into guestbook (no, name, password, content)
values (seq_guestbook_no.NEXTVAL, '방문자', 'test', '테스트 방명록입니다.');

-- 확인
SELECT no, name, password, content FROM guestbook ORDER BY regdate DESC;
commit;