-- 코드를 입력하세요

-- 7월 맛별 총 주문량 
-- SELECT FLAVOR,sum(total_order) as TOTAL_ORDER from JULY group by flavor

-- 상반기 맛별 총 주문량
-- select flavor, sum(TOTAL_ORDER) as TOTAL_ORDER from FIRST_HALF group by flavor


select flavor
from(
select A.FLAVOR , (A.TOTAL_ORDER + B.TOTAL_ORDER) as TOTAL_ORDER
from (SELECT FLAVOR,sum(total_order) as TOTAL_ORDER from JULY group by flavor
) A, (select flavor, sum(TOTAL_ORDER) as TOTAL_ORDER from FIRST_HALF group by flavor
) B
where A.FLAVOR = B.FLAVOR
order by 2 desc
)
where rownum <= 3
