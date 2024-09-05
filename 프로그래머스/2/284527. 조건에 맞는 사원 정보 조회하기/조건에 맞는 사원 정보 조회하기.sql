-- 코드를 작성해주세요
select sum(SCORE) SCORE, emp.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES emp inner join HR_GRADE grade
on emp.EMP_NO = grade.EMP_NO
where YEAR=2022
group by emp.EMP_NO
order by SCORE desc
limit 1