-- 코드를 입력하세요
SELECT o.animal_id, o.ANIMAL_TYPE, o.NAME
from ANIMAL_INS i
join animal_outs o
on i.ANIMAL_ID = o.ANIMAL_ID
where i.SEX_UPON_INTAKE != o.SEX_UPON_OUTCOME
order by o.animal_id 