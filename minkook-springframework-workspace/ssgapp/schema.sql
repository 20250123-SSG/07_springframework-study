
-- root 계정에서 실행 
create database springdb;
grant all privileges on springdb.* to '수업용계정'@'%';

-- 수업용 계정에서 실행 
use springdb;

create table tbl_user(
    user_no int primary key auto_increment,
    user_id varchar(20) not null unique,
    user_pwd varchar(255) not null,
    user_name varchar(100) not null,
    email varchar(100),
    gender char(1) check (gender in ('M', 'F')),
    phone varchar(13),
    address varchar(255),
    profile_url varchar(500),
    signup_date datetime default now(),
    modify_date datetime default now(),
    role char(1) default 'U' check(role in ('U', 'R', 'A')) -- U:일반회원, R:탈퇴회원, A:관리자
);

create table tbl_board(
    board_no int primary key auto_increment,
    board_title varchar(100) not null,
    board_writer int not null,
    board_content varchar(2000) not null,
    read_count int default 0,
    regist_date datetime default now(),
    modify_date datetime default now(), 
    status char(1) default 'Y' check(status in ('Y', 'N')), -- Y:게시, N:미게시(삭제)
    foreign key(board_writer) references tbl_user(user_no) on delete cascade
);

create table tbl_attachment(
    file_no int primary key auto_increment,
    file_path varchar(255),
    filesystem_name varchar(255),
    original_name varchar(255),
    upload_date datetime default now(),
    ref_board_no int,
    foreign key(ref_board_no) references tbl_board(board_no)
);

create table tbl_reply(
    reply_no int primary key auto_increment,
    reply_content varchar(500) not null,
    reply_writer int not null,
    ref_board_no int not null,
    regist_date datetime default now(),
    status char(1) default 'Y' check(status in ('Y', 'N')),
    foreign key(reply_writer) references tbl_user(user_no) on delete cascade,
    foreign key(ref_board_no) references tbl_board(board_no) on delete cascade
);

