-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, sum(b.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD b, USED_GOODS_USER u
where b.WRITER_ID = u.USER_ID and b.STATUS = 'DONE'
group by u.USER_ID, u.NICKNAME
having sum(b.PRICE) >= 700000
order by 3 