with A as (
  select max(SIZE_OF_COLONY) big, year(DIFFERENTIATION_DATE) yearbig
    from ECOLI_DATA 
    group by year(DIFFERENTIATION_DATE)
)
-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) YEAR, (big - SIZE_OF_COLONY) YEAR_DEV, ID
from ECOLI_DATA inner join A
on year(DIFFERENTIATION_DATE) = yearbig

order by YEAR, YEAR_DEV