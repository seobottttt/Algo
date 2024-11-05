-- 코드를 입력하세요

select price_group, count(*) as PRODUCTS
from (
SELECT case when trunc(price/10000) = 0 then '0'
else concat(trunc((PRICE/10000),0),'0000') end as price_group
FROM PRODUCT   
)
group by price_group
order by 1

