SELECT book_id, to_char(PUBLISHED_DATE,'yyyy-mm-dd') as PUBLISHED_DATE
from book
where category = '인문' and to_char(PUBLISHED_DATE,'yyyy') = '2021'
order by PUBLISHED_DATE