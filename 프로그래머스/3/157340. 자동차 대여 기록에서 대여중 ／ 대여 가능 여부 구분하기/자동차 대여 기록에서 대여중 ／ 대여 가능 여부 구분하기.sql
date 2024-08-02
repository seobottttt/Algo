
SELECT CAR_ID,
max(case when '2022-10-16' between to_char(start_date,'yyyy-mm-dd') and to_char(end_date,'yyyy-mm-dd') then '대여중'
else '대여 가능' end) 
as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by 1 desc
