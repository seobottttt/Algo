SELECT b.INGREDIENT_TYPE, sum(a.TOTAL_ORDER) as total_order
from FIRST_HALF a, ICECREAM_INFO b
where a.flavor = b.flavor
group by b.INGREDIENT_TYPE
order by 2 asc
