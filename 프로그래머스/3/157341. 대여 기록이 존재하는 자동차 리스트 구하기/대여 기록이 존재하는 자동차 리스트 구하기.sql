SELECT distinct C.CAR_ID
from CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
where C.CAR_ID = H.CAR_ID and to_char(H.START_DATE,'mm') = '10' and C.car_type = '세단'
order by 1 desc
