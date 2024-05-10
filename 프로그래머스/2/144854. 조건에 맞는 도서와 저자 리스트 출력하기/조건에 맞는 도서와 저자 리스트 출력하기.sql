-- 코드를 입력하세요
SELECT b.book_id,a.AUTHOR_NAME,date_format(b.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from book b
join author a
on a.AUTHOR_ID = b.AUTHOR_ID
where b.CATEGORY = '경제'
order by b.PUBLISHED_DATE