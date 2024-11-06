-- 코드를 입력하세요
select animal_id, name
from(
select A.animal_id as lose, B.animal_id , B.animal_type, B.name
from animal_ins A right join animal_outs B
on A.animal_id = B.animal_id
)
where lose is null
order by 1