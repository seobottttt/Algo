-- 코드를 입력하세요
SELECT o.animal_id, o.NAME
from ANIMAL_OUTS o
left join ANIMAL_ins i
on o.animal_id = i.animal_id
where i.animal_id is null
order by o.animal_id

