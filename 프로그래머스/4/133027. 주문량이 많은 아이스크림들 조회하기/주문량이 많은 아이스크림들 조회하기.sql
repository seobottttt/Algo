select flavor
from (
select A.flavor, A.total_order + B.total_order as total_order
from (select sum(total_order) as total_order, flavor
from FIRST_HALF
group by flavor) A,
(select sum(total_order) as total_order, flavor
from july
group by flavor) B
where A.flavor = B.flavor
order by A.total_order + B.total_order desc
)
where rownum <=3
    