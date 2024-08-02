SELECT MCDP_CD as "진료과 코드", count(*) as "5월예약건수"
from APPOINTMENT
where to_char(APNT_YMD,'yyyy-mm-dd') between '2022-05-01' and '2022-05-31'
group by mcdp_cd
order by 2, 1

