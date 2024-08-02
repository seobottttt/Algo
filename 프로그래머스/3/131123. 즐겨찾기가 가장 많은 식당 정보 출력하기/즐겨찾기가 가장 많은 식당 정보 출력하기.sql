-- 코드를 입력하세요
-- select food_type, rest_id, rest_name, favorites
-- from REST_INFO
select r2.food_type, r2.rest_id, r2.rest_name, r2.favorites
from (SELECT FOOD_TYPE, max(FAVORITES) as mf
from REST_INFO 
group by food_type) r1, rest_info r2
where r1.food_type = r2.food_type and r1.mf = r2.favorites
order by 1 desc
