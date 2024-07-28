-- 코드를 입력하세요
-- 2022년 8월 부터 10월까지
-- 총 대여 횟수가 5회 이상인 자동차

-- 해당 월별
-- 자동차 별
-- 대여 횟수
-- SELECT car_id
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- where to_char(START_DATE,'yyyy-mm') between '2022-08' and '2022-11'
-- group by car_id
-- having count(car_id) > 4


SELECT to_number(to_char(start_date,'mm')) as month, car_id, count(car_id) as records 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where to_char(START_DATE,'yyyy-mm') between '2022-08' and '2022-11'
and car_id in (
SELECT car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where to_char(START_DATE,'yyyy-mm') between '2022-08' and '2022-11'
group by car_id
having count(car_id) > 4)
group by to_number(to_char(start_date,'mm')), car_id
order by 1, 2 desc






