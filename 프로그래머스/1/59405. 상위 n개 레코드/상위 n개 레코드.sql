SELECT name
from (select * from ANIMAL_INS order by datetime)
where rownum = 1;