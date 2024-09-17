-- 코드를 입력하세요
SELECT USED_GOODS_USER.USER_ID, NICKNAME, 
    concat(CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2) 전체주소, 
    concat(left(TLNO,3),"-",substring(TLNO,4,4),"-",right(TLNO,4)) 전화번호
from USED_GOODS_USER inner join USED_GOODS_BOARD
on USED_GOODS_USER.USER_ID = USED_GOODS_BOARD.WRITER_ID
group by USED_GOODS_USER.USER_ID
having count(*) >= 3
order by USED_GOODS_USER.USER_ID desc