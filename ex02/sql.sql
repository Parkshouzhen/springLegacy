create sequence seq_board;

create table tbl_board(
bno number(10, 0),
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regDate date default sysdate,
updteDate date default sysdate
);

select * from TBL_BOARD;

alter table tbl_board add constraint pk_board
primary key(bno);

insert into TBL_BOARD values(seq_board.nextval, '첫게시물', '우왕 처음이다!!', '박소분', sysdate, sysdate);
insert into TBL_BOARD values(seq_board.nextval, '두번째게시물', '우왕 두번째다!!', '박소분', sysdate, sysdate);

drop table tbl_board;