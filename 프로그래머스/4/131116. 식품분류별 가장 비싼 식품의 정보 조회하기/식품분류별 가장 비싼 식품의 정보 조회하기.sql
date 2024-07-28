-- 코드를 입력하세요


select b.category,b.price as MAX_PRICE, b.product_name
from(
SELECT CATEGORY, max(price) as mp
from FOOD_PRODUCT
where category in ('과자', '국', '김치', '식용유')
group by category) a, FOOD_PRODUCT b
where b.price = a.mp and b.category in ('과자', '국', '김치', '식용유')
order by 2 desc
-- group by a.category, b.product_id


-- SELECT CATEGORY, max(price) as mp
-- from FOOD_PRODUCT
-- where category in ('과자', '국', '김치', '식용유')
-- group by category