-- 코드를 입력하세요
-- SELECT APNT_NO, PT_NAME, PT_NO, MCDP_CD, DR_NAME, APNT_YMD

-- appointment pt_no 환자, mddr_id 의사
-- select * from appointment
-- where MCDP_CD = 'CS' and APNT_CNCL_YN='N' and to_char(APNT_YMD,'yyyymmdd') = '20220413'

select APNT_NO, PT_NAME, PT_NO, MCDP_CD, DR_NAME, APNT_YMD
from (
select A.*, B.DR_NAME from (
select A.*, B.PT_NAME from (select * from appointment
where MCDP_CD = 'CS' and APNT_CNCL_YN='N' and to_char(APNT_YMD,'yyyymmdd') = '20220413') A,
PATIENT B
where A.pt_no= B.pt_no) A,
DOCTOR B
where A.mddr_id = B.DR_ID
)
order by 6 asc