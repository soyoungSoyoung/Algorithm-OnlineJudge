-- 코드를 작성해주세요
select count(*) as FISH_COUNT, month(TIME) as MONTH
from FISH_INFO 
group by month(TIME)
having count(*) > 0
order by month(TIME)