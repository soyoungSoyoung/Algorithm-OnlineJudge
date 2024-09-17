with A as (
   select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE)=2022 and month(START_DATE) between 8 and 10
    group by CAR_ID
    having count(*) >= 5
)
-- 코드를 입력하세요
SELECT month(START_DATE) MONTH, A.CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY inner join A
on CAR_RENTAL_COMPANY_RENTAL_HISTORY.CAR_ID = A.CAR_ID
where year(START_DATE)=2022 and month(START_DATE) between 8 and 10
group by MONTH, A.CAR_ID
having count(*) > 0
order by MONTH, A.CAR_ID desc