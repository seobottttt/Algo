-- 코드를 입력하세요
SELECT B.BOOK_ID, A.AUTHOR_NAME, to_char(B.PUBLISHED_DATE,'yyyy-mm-dd') as PUBLISHED_DATE
from BOOK B, AUTHOR A
where B.AUTHOR_ID = A.AUTHOR_ID and B.CATEGORY = '경제'
order by 3 asc