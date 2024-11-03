-- 코드를 입력하세요
select code as CATEGORY,count(*) as PRODUCTS
from(
SELECT substr(PRODUCT_CODE,1,2) as code
from PRODUCT)
group by code
order by 1 
