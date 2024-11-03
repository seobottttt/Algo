-- 코드를 입력하세요

select user_id, nickname, city||' '||street_address1||' '||street_address2 as 전체주소, 
substr(TLNO,1,3)||'-'||substr(TLNO,4,4)||'-'||substr(TLNO,8,4) as 전화번호
from USED_GOODS_USER
where user_id in (
select WRITER_ID from
(SELECT count(*) as cnt, WRITER_ID
from USED_GOODS_BOARD
group by WRITER_ID)
where cnt >= 3
)
order by 1 desc