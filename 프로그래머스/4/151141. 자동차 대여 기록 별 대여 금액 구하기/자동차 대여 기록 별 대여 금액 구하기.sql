-- 코드를 입력하세요


-- SELECT C.car_id, C.car_type, C.daily_fee, H.END_DATE-H.START_DATE+1 as during, H.HISTORY_ID
-- from  CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
-- where H.car_id = C.car_id and C.car_type = '트럭'

-- select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
-- 5 8 15


select A.HISTORY_ID, 
case when A.during < 7 then A.during * A.daily_fee
when A.during between 7 and 29 then A.during * (A.daily_fee * 0.95)
when A.during between 30 and 89 then A.during * (A.daily_fee * 0.92)
else A.during * (A.daily_fee * 0.85)
end as FEE
from (SELECT C.car_id, C.car_type, C.daily_fee, H.END_DATE-H.START_DATE+1 as during, H.HISTORY_ID
from  CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
where H.car_id = C.car_id and C.car_type = '트럭') A
order by 2 desc, 1 desc

-- SELECT C.car_id, C.car_type, C.daily_fee, H.END_DATE-H.START_DATE+1 as during, H.HISTORY_ID
-- from  CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
-- where H.car_id = C.car_id and C.car_type = '트럭'


