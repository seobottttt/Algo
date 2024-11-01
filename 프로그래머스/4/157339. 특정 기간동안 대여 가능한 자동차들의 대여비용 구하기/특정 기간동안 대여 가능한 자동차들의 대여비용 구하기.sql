
-- 대여 불가능한 차 리스트 뽑는다. 이 리스트에 없는 아이디만 마지막에 뽑으면 된다.
-- SELECT C.CAR_ID
-- from CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
-- where C.CAR_ID = H.CAR_ID 
-- and to_char(H.START_DATE,'YYYYMMDD') <= '20221130' 
-- and to_char(H.END_DATE,'YYYYMMDD') >= '20221101'

-- 할인율 확인 -> 세단 8 , SUV 5
-- select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN

select *
from (
select car_id, car_type,
case when car_type = '세단' then (DAILY_FEE-(DAILY_FEE*0.08))*30
else (DAILY_FEE-(DAILY_FEE*0.05))*30
end as FEE
from CAR_RENTAL_COMPANY_CAR
where car_id not in 
(
SELECT C.CAR_ID
from CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_RENTAL_HISTORY H
where C.CAR_ID = H.CAR_ID 
and to_char(H.START_DATE,'YYYYMMDD') <= '20221130' 
and to_char(H.END_DATE,'YYYYMMDD') >= '20221101'
)
and car_type in ('세단','SUV')
)
where fee between 500000 and 1999999
order by 3 desc, 2 asc, 1 desc;


