-- 일자를 구하고 카운트를 구함
-- 7일 이상인 애들만 출력함

-- select car_id, to_char(duration,'FM999.0') as AVERAGE_DURATION
-- from(
-- select car_id, round(sum(end_date - start_date)/count(*),1) as duration
-- from car_rental_company_rental_history
-- group by car_id
-- having round(sum(end_date - start_date)/count(*),1) >=7
-- order by 2 desc, 1 desc)

select car_id, to_char(AVERAGE_DURATION,'FM999.0') as AVERAGE_DURATION
from (
select car_id, round(avg(end_date-start_date+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having round(avg(end_date-start_date+1),1) >= 7
order by 2 desc, 1 desc
    )