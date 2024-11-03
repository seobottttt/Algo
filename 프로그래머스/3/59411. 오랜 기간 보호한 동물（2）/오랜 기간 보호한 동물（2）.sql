-- 코드를 입력하세요
select animal_id, name
from (
select I.animal_id, I.name, O.DATETIME - I.DATETIME as time
from ANIMAL_INS I, ANIMAL_OUTS O
where I.ANIMAL_ID = O.ANIMAL_ID
order by 3 desc
)
where rownum <=2