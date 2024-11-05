-- 코드를 입력하세요
SELECT name ,count(name) as count
from ANIMAL_INS
group by name
having count(name)>1 and name is not null
order by 1

