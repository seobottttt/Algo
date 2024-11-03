-- 코드를 입력하세요




select concat(concat(concat(concat(concat('/home/grep/src/',board_id),'/'),file_id),file_name),file_ext) as FILE_PATH
from USED_GOODS_FILE
where BOARD_ID = (select board_id from (select board_id from USED_GOODS_BOARD order by VIEWS desc) where rownum = 1)
order by file_id desc

