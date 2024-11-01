-- 코드를 입력하세요
-- 생산일자가 22년 5월인 식품 중에,
-- 식품 ID, 식품 이름, 총매출 조회
-- 총매출 price * amount

-- 생산일자 22년 5월 식품 ID 리스트

select P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * O.amount) as TOTAL_SALES
from FOOD_PRODUCT P, 
(SELECT PRODUCT_ID, SUM(AMOUNT) as amount
from FOOD_ORDER
where to_char(PRODUCE_DATE,'YYYYMM') = '202205'
group by PRODUCT_ID) O
where P.PRODUCT_ID = O.PRODUCT_ID
order by 3 desc, 1 asc


