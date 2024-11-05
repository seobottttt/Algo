-- 코드를 입력하세요


-- SELECT LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <=24;


select A.HOUR , nvl(B.count,0) as count
from
(SELECT LEVEL-1 AS HOUR FROM DUAL CONNECT BY LEVEL <=24) A left join
(select to_number(to_char(datetime,'hh24')) as h, count(*) as count
from animal_outs
group by to_number(to_char(datetime,'hh24'))) B
on A.hour = b.h
order by 1


