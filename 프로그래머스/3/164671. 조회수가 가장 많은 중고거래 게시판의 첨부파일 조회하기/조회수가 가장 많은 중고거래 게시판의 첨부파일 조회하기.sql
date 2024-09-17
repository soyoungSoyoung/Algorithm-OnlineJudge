with A as (
   select BOARD_ID
    from USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
)

-- 코드를 입력하세요
SELECT concat("/home/grep/src/", USED_GOODS_BOARD.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
from USED_GOODS_BOARD inner join A 
on A.BOARD_ID = USED_GOODS_BOARD.BOARD_ID
inner join USED_GOODS_FILE
on A.BOARD_ID = USED_GOODS_FILE.BOARD_ID
order by FILE_ID desc