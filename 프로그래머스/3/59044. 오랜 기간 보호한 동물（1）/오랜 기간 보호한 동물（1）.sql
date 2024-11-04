-- 코드를 입력하세요\
-- 1. 아직 입양 못간 동물
-- 2. 가장 오래 있었던 동물 3마리
-- 3. 이름과 보호 시작일
-- 정렬 : 보호시작일 asc




select name, datetime
from (
    select * 
from ANIMAL_INS 
where ANIMAL_ID not in (
SELECT ANIMAL_ID
from ANIMAL_OUTS
) order by datetime asc
)
where rownum <= 3