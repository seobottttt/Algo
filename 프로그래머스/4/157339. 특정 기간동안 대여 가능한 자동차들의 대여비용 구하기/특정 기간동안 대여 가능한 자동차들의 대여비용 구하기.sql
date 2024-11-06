-- '세단' || 'SUV'
-- 2022년 11월 1일부터 30일까지 대여 가능하고
-- 30일간 대여 금액이 50 이상 200미만인 자동차 출력

-- 대여 시작일이 30일 이전이고, 대여 종료일이 1일 이후인 자동차 조회 후 지우기
select * from (

select car_id, car_type,
case when car_type = '세단' then (daily_fee*0.92) * 30
else (daily_fee*0.95) * 30
end as FEE
from (
select car_type ,car_id, daily_fee
from car_rental_company_car 
where car_id not in (
select distinct car_id
from car_rental_company_rental_history
where to_char(start_date,'yyyymmdd') <= '20221130' and to_char(end_date,'yyyymmdd') >= '20221101'
)
and car_type in ('세단','SUV')
)
    )
where fee between 500000 and 1999999
order by 3 desc, 2 asc, 1 desc









