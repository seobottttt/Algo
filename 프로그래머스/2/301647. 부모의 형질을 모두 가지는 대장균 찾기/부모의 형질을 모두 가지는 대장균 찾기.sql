-- 코드를 작성해주세요
select child.ID,child.GENOTYPE,parent.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA child, ECOLI_DATA parent
where child.PARENT_ID = parent.ID
and child.GENOTYPE & parent.GENOTYPE = parent.GENOTYPE
order by 1