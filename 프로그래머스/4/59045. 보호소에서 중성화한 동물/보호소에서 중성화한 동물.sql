SELECT A.ANIMAL_ID, A.animal_type, A.name
from ANIMAL_INS A, ANIMAL_OUTS B
where A.animal_id = B.animal_id and a.SEX_UPON_INTAKE != B.SEX_UPON_OUTCOME
order by 1