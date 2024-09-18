-- 코드를 작성해주세요
-- ITEM_TREE 에서 PARENT_ITEM_ID가 ITEM_INFO 의 id가 되면 가능
-- 즉, 레뿌뜨 조인 했을 때 null의 향연인 애는 업글 불가
select ITEM_INFO.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO left join ITEM_TREE 
on ITEM_INFO.ITEM_ID = ITEM_TREE.PARENT_ITEM_ID
where ITEM_TREE.PARENT_ITEM_ID is null
order by ITEM_INFO.ITEM_ID desc