-- 코드를 입력하세요
select *
from food_product
where price = (select MAX(price) from food_product)