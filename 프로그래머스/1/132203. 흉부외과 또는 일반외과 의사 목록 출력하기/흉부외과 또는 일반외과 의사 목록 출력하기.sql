-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, to_char(HIRE_YMD,'yyyy-mm-dd') as HIRE_YMD
from doctor
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by 4 desc, 1 asc;