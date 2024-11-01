-- 코드를 입력하세요
-- INS 보호 시작일 보다 OUTS 입양일이 더 빠른 동물들을 찾아
-- 그 동물의 아이디와 이름 출력

SELECT I.ANIMAL_ID, I.NAME
from ANIMAL_INS I, ANIMAL_OUTS O
where I.ANIMAL_ID = O.ANIMAL_ID
and I.DATETIME > O.DATETIME
order by I.DATETIME asc