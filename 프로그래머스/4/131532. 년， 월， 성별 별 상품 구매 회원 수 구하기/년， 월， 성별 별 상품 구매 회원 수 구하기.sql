-- -- 코드를 입력하세요
select substr(B.sales_date,1,4) as year,to_number(substr(B.sales_date,5,2)) as month, a.gender, count(*) as users
from USER_INFO A,
(SELECT distinct user_id, to_char(sales_date,'yyyymm') as sales_date from ONLINE_SALE) B
where A.user_id = B.user_id
group by B.sales_date, A.gender
having A.gender is not null
order by 1, 2, 3


