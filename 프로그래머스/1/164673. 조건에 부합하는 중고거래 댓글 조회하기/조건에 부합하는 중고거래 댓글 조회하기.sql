-- SELECT B.TITLE, B.BOARD_ID,R.REPLY_ID, R.WRITER_ID, R.CONTENTS , R.CREATED_DATE
-- from USED_GOODS_BOARD as B and USED_GOODS_REPLY as R

select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, to_char(r.CREATED_DATE,'yyyy-mm-dd') as CREATED_DATE
from USED_GOODS_BOARD b , USED_GOODS_REPLY r
where b.board_id = r.board_id
and to_char(b.CREATED_DATE,'yyyy-mm')='2022-10'
order by r.CREATED_DATE, b.title
