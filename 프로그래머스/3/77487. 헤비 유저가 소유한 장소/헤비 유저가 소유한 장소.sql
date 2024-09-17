with A as (
  select HOST_ID
    from PLACES
    group by HOST_ID
having count(*) >= 2
)

-- 코드를 입력하세요
SELECT ID, NAME, A.HOST_ID
from PLACES inner join A
on PLACES.HOST_ID = A.HOST_ID

order by ID