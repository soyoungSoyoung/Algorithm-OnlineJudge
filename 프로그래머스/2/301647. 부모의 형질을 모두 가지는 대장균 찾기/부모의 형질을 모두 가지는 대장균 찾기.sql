-- 코드를 작성해주세요
select me.ID, me.GENOTYPE, paren.GENOTYPE PARENT_GENOTYPE
from ECOLI_DATA me inner join ECOLI_DATA paren
on me.PARENT_ID = paren.ID
where me.GENOTYPE & paren.GENOTYPE = paren.GENOTYPE
order by ID