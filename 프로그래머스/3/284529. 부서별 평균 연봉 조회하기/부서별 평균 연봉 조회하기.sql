-- 코드를 작성해주세요
select d.DEPT_ID, DEPT_NAME_EN, round(avg(SAL), 0) AVG_SAL
from HR_DEPARTMENT d inner join HR_EMPLOYEES e
on d.DEPT_ID = e.DEPT_ID
group by d.DEPT_ID
order by AVG_SAL desc
