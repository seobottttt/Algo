SELECT b.CATEGORY, sum(bs.sales) as TOTAL_SALES
from book b, BOOK_SALES bs
where b.BOOK_ID = bs.BOOK_ID and to_char(bs.SALES_DATE,'yyyy-mm')='2022-01'
group by CATEGORY
order by 1