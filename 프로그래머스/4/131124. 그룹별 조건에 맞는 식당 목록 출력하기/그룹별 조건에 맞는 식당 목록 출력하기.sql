-- 코드를 입력하세요

-- 리뷰를 가장 많이 작성한 회원 찾기
-- select member_id
-- from(
-- SELECT count(*) as cnt, member_id
-- from REST_REVIEW
-- group by member_id
-- order by 1 desc
-- )
-- where cnt = (select cnt from(
-- SELECT count(*) as cnt, member_id
-- from REST_REVIEW
-- group by member_id
-- order by 1 desc
-- ) where rownum = 1)

select M.MEMBER_NAME, R.REVIEW_TEXT, to_char(R.REVIEW_DATE,'yyyy-mm-dd') as REVIEW_DATE
from REST_REVIEW R, MEMBER_PROFILE M
where R.MEMBER_ID IN (select member_id
from(
SELECT count(*) as cnt, member_id
from REST_REVIEW
group by member_id
order by 1 desc
)
where cnt = (select cnt from(
SELECT count(*) as cnt, member_id
from REST_REVIEW
group by member_id
order by 1 desc
) where rownum = 1))
and M.MEMBER_ID = R.MEMBER_ID
order by 3 asc, 2 asc