-- 코드를 입력하세요

-- 1. 22년 1월 book_sales
SELECT a.author_id, a.author_name, b.category, sum (bs.sales * b.price) as TOTAL_SALES
from BOOK b, AUTHOR a, BOOK_SALES bs
where bs.BOOK_ID = b.BOOK_ID and a.AUTHOR_ID = b.AUTHOR_ID
and to_char(bs.SALES_DATE,'yyyy-mm')='2022-01'
group by a.author_id, a.author_name ,b.category
order by 1, 3 desc

