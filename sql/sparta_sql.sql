show databases; 
use sparta;
show tables;
select * from users;

-- food_orders : 음식 주문 정보 테이블
-- payments : 결제 정보 테이블
-- customers : 고객 정보 테이블

-- 03. SELECT FROM
select * from food_orders;                     


-- 04. 원하는 컬럼만 조회, 별명은 "" 사용 
select restaurant_name as "음식점", addr address from food_orders;
SELECT order_id AS ord_no, price AS "가격", quantity AS "수량" from food_orders;
SELECT name "이름", email "e-mail" FROM customers;


-- 05. WHERE절 필터링
SELECT * FROM customers WHERE age = 21;
SELECT * FROM customers WHERE gender = 'male';

SELECT * FROM food_orders WHERE cuisine_type = 'Korean';

SELECT * FROM payments WHERE pay_type = 'card';


-- 06. 필터링 여러 표현
SELECT * FROM customers WHERE age >= 21;
SELECT * FROM customers WHERE gender <> 'male';
-- 06. between, in, like
SELECT * FROM customers WHERE age BETWEEN 21 AND 23;
SELECT * FROM customers WHERE age IN (21, 25, 27);
SELECT * FROM customers WHERE name IN ("윤주아", "정현준");
SELECT * FROM customers WHERE name LIKE "김%";
-- 실습
SELECT * FROM food_orders WHERE price < 15000;
SELECT * FROM food_orders WHERE price BETWEEN 20000 AND 30000;
SELECT * FROM food_orders WHERE restaurant_name LIKE 'B%';


-- 07. 여러가지 필터링 조건 AND, OR, NOT
SELECT * FROM customers WHERE age >= 21 AND gender = 'male';
-- 실습
SELECT * FROM food_orders WHERE cuisine_type = 'Korean' AND price >= 30000;
SELECT * FROM payments WHERE pay_type = 'card' OR vat <= 0.2;


-- 08. 에러메세지 
-- 테이블명 오류 -> doesn't exist
-- 필드명 오류 -> Unknown column 
-- 필터링 조건 중 ''를 안했을 때 -> Unknown column '' in 'where clause'








-- 2주차 02. 연산, 집계함수
select food_preparation_time,
       delivery_time,
       food_preparation_time + delivery_time as total_time
from food_orders;

select sum(food_preparation_time) total_food_preparation_time,
       avg(delivery_time) avg_delivery_time
from food_orders;

SELECT AVG(age) as '나이' from customers c;

-- count(1), count(*) -> 전체를 조회해줘, distinct 중복제거
select count(1) count_of_orders,
       count(distinct customer_id) count_of_customers
from food_orders;

SELECT count(DISTINCT pay_type) from payments p;

select min(price) min_price,
       max(price) max_price
from food_orders;

SELECT min(quantity) as min_quantity,
	   max(quantity) as max_quantity
from food_orders fo;

-- 2-03. 실습 
-- 어떤 테이블을 사용할지, 어떤 칼럼을 이용할지, 어떤 조건을 지정할지, 어떤 함수를 이용할지
SELECT COUNT(*) from food_orders fo WHERE price * quantity >= 30000;
SELECT avg(price) as avg_price from food_orders fo WHERE cuisine_type ='Korean';

-- 2-04. Group by
select cuisine_type,
       sum(price) sum_of_price
from food_orders
group by cuisine_type;
 
select restaurant_name, max(price) from food_orders fo group by restaurant_name;
SELECT pay_type, max(date) from payments p group by pay_type;

-- 2-05. order by
select cuisine_type,
       sum(price) sum_of_price
from food_orders
group by cuisine_type
order by sum(price);

SELECT restaurant_name, max(price) 
from food_orders group by restaurant_name order by 2 desc;

SELECT * from customers order by name, gender;

-- 2주차 숙제
SELECT cuisine_type, min(price) as min_price, max(price) as max_price 
from food_orders group by 1 order by 2 DESC;








-- 3주차 replace 데이터 내용 바꾸기
select restaurant_name "원래 상점명",
       replace(restaurant_name, 'Blue', 'Pink') "바뀐 상점명"
from food_orders
where restaurant_name like '%Blue Ribbon%';

SELECT addr, REPLACE(addr, '문곡리', '문가리') "바뀐주소"
from food_orders
WHERE addr like '%문곡리%';

-- substr(addr, 1, 2) 특정문자를 뽑아내기 첫번째 문자부터 2글자를 뽑아내줘! substring도 가능
select addr "원래 주소",
       substr(addr, 1, 2) "시도"
from food_orders
where addr like '%서울특별시%';

-- concat 예시
select restaurant_name "원래 이름",
       addr "원래 주소",
       CONCAT(restaurant_name, '-', cuisine_type) "음식타입별 음식점",
       concat('[', substring(addr, 1, 2), '] ', restaurant_name) "바뀐 이름"
from food_orders
where addr like '%서울%';

-- 3-03. 실습
select * from food_orders fo ;

SELECT substr(addr, 1, 2) "지역", cuisine_type, avg(price) "평균금액"
from food_orders where addr like "서울%" group by 1, 2;

SELECT substr(email, 10) "도메인", count(1) "고객수", avg(age) "평균연령" from customers group by 1;

SELECT concat('[', substring(addr, 1, 2), '] ', restaurant_name, '(', cuisine_type, ')') "음식점",
	count(1) "총 주문건수"
from food_orders
group by 1;

-- 3-04. if문 
-- Korean이면 한식 아니면 기타
select restaurant_name,
       cuisine_type "원래 음식 타입",
       if(cuisine_type='Korean', '한식', '기타') "음식 타입"
from food_orders;

-- if문 2
select addr "원래 주소",
       if(addr like '%평택군%', replace(addr, '문곡리', '문가리'), addr) "바뀐 주소"
from food_orders
where addr like '%문곡리%';

-- if문 3
select substring(if(email like '%gmail%', replace(email, 'gmail', '@gmail'), email), 10) "이메일 도메인",
       count(customer_id) "고객 수",
       avg(age) "평균 연령"
from customers
group by 1;


-- 3-05. case when 
select case when cuisine_type="Korean" then '한식'
			when cuisine_type in ('Japanese', 'Chinese') then '아시아'
			else '기타' end as "음식타입",
		cuisine_type
from food_orders;

-- 실습 1 
select order_id,
       price,
       quantity,
       case when quantity=1 then price
            when quantity>=2 then price/quantity end "음식 단가"
from food_orders;

-- 실습 2
select case when (age between 10 and 19) and gender='male' then '10대 남성'
			when (age between 10 and 19) and gender='female' then '10대 여성'
			when (age between 20 and 29) and gender='male' then '20대 남성'
			when (age between 20 and 29) and gender='female' then '20대 여성'
			end "고객 분류",
			name,
			age,
			gender
from customers
where age BETWEEN 10 and 29
order by 1, 2;

-- 
select restaurant_name,
       price/quantity "단가",
       cuisine_type,
       order_id,
       case when (price/quantity <5000) and cuisine_type='Korean' then '한식1'
            when (price/quantity between 5000 and 15000) and cuisine_type='Korean' then '한식2'
            when (price/quantity > 15000) and cuisine_type='Korean' then '한식3'
            when (price/quantity <5000) and cuisine_type in ('Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '아시아식1'
            when (price/quantity between 5000 and 15000) and cuisine_type in ('Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '아시아식2'
            when (price/quantity > 15000) and cuisine_type in ('Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '아시아식3'
            when (price/quantity <5000) and cuisine_type not in ('Korean', 'Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '기타1'
            when (price/quantity between 5000 and 15000) and cuisine_type not in ('Korean', 'Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '기타2'
            when (price/quantity > 15000) and cuisine_type not in ('Korean', 'Japanese', 'Chinese', 'Thai', 'Vietnamese', 'Indian') then '기타3' end "식당 그룹"
from food_orders;

-- 3-06. 지역, 시간에 대한 조건
SELECT case when delivery_time > 30 then price*0.1*if(addr like "%서울%", 1.1, 1)
			when delivery_time BETWEEN 26 and 30 then price*0.05*if(addr like "%서울%", 1.1, 1)
			else 0
			end "수수료",
			restaurant_name,
			order_id,
			price,
			delivery_time,
			addr 
from food_orders;

SELECT case when day_of_the_week='weekday' then 3000*if(quantity>3, 1.2, 1)
			when day_of_the_week='weekend' then 3500*if(quantity>3, 1.2, 1)
			end "배달할증료",
			restaurant_name,
			order_id,
			day_of_the_week,
			quantity
from food_orders;

-- 3-07. 
-- 숫자로 변경
-- cast(if(rating='Not given', '1', rating) as decimal

-- 문자로 변경
-- concat(restaurant_name, '-', cast(order_id as char))

-- 3주차 숙제
SELECT order_id, restaurant_name, day_of_the_week, delivery_time,
	case when (day_of_the_week='Weekday') and delivery_time >= 25 then "Late"
		 when (day_of_the_week='Weekend') and delivery_time >= 30 then "Late"
		 else "On-time"
		 end "지연여부"
from food_orders;










-- 4주차 subquery
SELECT price/quantity 
FROM 
( select price, quantity
from food_orders
) a;

select order_id, restaurant_name, if(over_time>=0, over_time, 0) over_time
from 
(
select order_id, restaurant_name, food_preparation_time-25 over_time
from food_orders
) a;


select order_id, 
	   restaurant_name, 
	   if(food_preparation_time-25 >= 0, food_preparation_time-25, 0) over_time
from food_orders;


-- 4-03. 서브쿼리
select restaurant_name,
       price_per_plate*ratio_of_add "수수료"
from 
	(
	select restaurant_name,
	       case when price_per_plate<5000 then 0.005
	            when price_per_plate between 5000 and 19999 then 0.01
	            when price_per_plate between 20000 and 29999 then 0.02
	            else 0.03 end ratio_of_add,
	       price_per_plate
	from 
		(
		select restaurant_name, avg(price/quantity) price_per_plate
		from food_orders
		group by 1
		) a
	) b;

SELECT restaurant_name,
	   sido,
	   avg_delivery_time,
	   case when avg_delivery_time<=20 then '<=20'
	   		when avg_delivery_time>20 and avg_delivery_time<=30 then '20<x<=30'
	   		else '>30'
	   		END avg_delivery_time_segment
FROM 
	(
	SELECT restaurant_name,
		   substr(addr, 1, 2) sido,
		   avg(delivery_time) avg_delivery_time
	from food_orders
	group by 1, 2
	) a

-- 4-04. 실습
SELECT cuisine_type,
	   total_quantity,
	   count_res,
	   case when count_res>=5 and total_quantity>=30 then 0.005
	   		when count_res>=5 and total_quantity<=30 then 0.008
	   		when count_res <5 and total_quantity>=30 then 0.01
	   		when count_res <5 and total_quantity <30 then 0.02
	   		end rate
FROM (
	SELECT cuisine_type,
		   sum(quantity) total_quantity,
		   count(DISTINCT restaurant_name) count_res
	from food_orders
	group by 1
	) a;


SELECT restaurant_name,
	   sum_quantity,
	   sum_price,
	   case when sum_quantity<=5 then '10%'
	   		when sum_quantity>15 and sum_price>=300000 then '0.5%'
	   		else '1%'
	   		end discount_rate
FROM 
	(
	SELECT restaurant_name,
		   sum(quantity) sum_quantity,
		   sum(price) sum_price
	from food_orders
	group by 1
	) a;

-- 4-05 Join
-- left join은 왼쪽 테이블을 기준으로 합치고 없는 데이터는 NULL
-- inner join은 조건 컬럼을 기준으로 두 테이블 모두 있는 값만 조회
SELECT * from food_orders left join payments on food_orders.order_id=payments.order_id;

select f.order_id,
	   f.customer_id,
	   f.restaurant_name,
	   f.price,
	   c.name,
	   c.age,
	   c.gender
from food_orders f left join customers c on f.customer_id = c.customer_id;

SELECT f.order_id,
	   f.restaurant_name,
	   f.price,
	   p.pay_type,
	   p.vat
FROM food_orders f left join payments p on f.order_id = p.order_id
WHERE cuisine_type='Korean';

SELECT distinct c.name, c.age, c.gender, f.restaurant_name
from customers c left join food_orders f on c.customer_id = f.customer_id
order by 1;

-- 4-07. 실습
-- 다른 테이블의 값을 inner join을 통해 곱해줄 수 있게 만듬
SELECT f.order_id, f.restaurant_name, f.price, p.vat, f.price*p.vat vat2
FROM food_orders f inner join payments p on f.order_id = p.order_id;

-- 
SELECT cuisine_type,
	   sum(price),
	   sum(price*discount_rate) discounted_price
from
	(
	select f.cuisine_type,
		   f.price,
		   c.age,
		   (c.age-50)*0.005 discount_rate
	from food_orders f left join customers c on f.customer_id=c.customer_id
	where c.age>=50
	) a
group by 1
order by 3 desc;

-- 숙제
SELECT f.restaurant_name,
	   case when avg(f.price)>30000 then 'price_group4'
	   		when avg(f.price)>10000 then 'price_group3'
	   		when avg(f.price)>50000 then 'price_group2'
	   		else 'price_group1'
	   		end price_group,
	   	case when avg(age)>=50 then 'age_group4'
	   		 when avg(age)>=40 then 'age_group3'
	   		 when avg(age)>=30 then 'age_group2'
	   		 else 'age_group1'
	   		 end age_group
from food_orders f left join customers c on f.customer_id=c.customer_id
group by f.restaurant_name;










-- 5주차 5-02.
-- 조회한 데이터에 아무 값이 없다면?
-- 없는 값 제외하기, 사용할 수 없는 값은 0으로 간주, null은 값에서 제외 결과값이 다르게 됨 
SELECT restaurant_name,
	   avg(rating) avg_rating,
	   avg(if(rating<>'Not given', rating, null)) avg_rating2
from food_orders
group by 1;

-- where절로 null값 제외
select a.order_id,
       a.customer_id,
       a.restaurant_name,
       a.price,
       b.name,
       b.age,
       b.gender
from food_orders a left join customers b on a.customer_id=b.customer_id
where b.customer_id is not null;

-- null 값의 변경 -> coalesce(age, 대체값)
select a.order_id,
       a.customer_id,
       a.restaurant_name,
       a.price,
       b.name,
       b.age,
       coalesce(b.age, 20) "null 제거",
       b.gender
from food_orders a left join customers b on a.customer_id=b.customer_id
where b.age is null;

-- 5-03. 상식적이지 않은 데이터
SELECT name, age, 
case when age<15 then 15 
	 when age>=80 then 80 
	 else age 
	 end re_age 
from customers;

-- 5-04. pivot table
select f.restaurant_name, substr(p.time, 1, 2) hh, count(1) cnt_order
from food_orders f inner join payments p on f.order_id=p.order_id 
where substr(p.time, 1, 2) BETWEEN 15 and 20
group by 1, 2;


select restaurant_name,
       max(if(hh='15', cnt_order, 0)) "15",
       max(if(hh='16', cnt_order, 0)) "16",
       max(if(hh='17', cnt_order, 0)) "17",
       max(if(hh='18', cnt_order, 0)) "18",
       max(if(hh='19', cnt_order, 0)) "19",
       max(if(hh='20', cnt_order, 0)) "20"
from 
	(
	select a.restaurant_name,
	       substring(b.time, 1, 2) hh,
	       count(1) cnt_order
	from food_orders a inner join payments b on a.order_id=b.order_id
	where substring(b.time, 1, 2) between 15 and 20
	group by 1, 2
	) a
group by 1
order by 7 desc;

SELECT age, 
	   max(if(gender='male', cnt_order, 0)) "male",
	   max(if(gender='female', cnt_order, 0)) "female"
FROM 
(
	SELECT gender,
		   case when age between 10 and 19 then 10
		   		when age BETWEEN 20 and 29 then 20
		   		when age BETWEEN 30 and 39 then 30
		   		when age BETWEEN 40 and 49 then 40
		   		when age BETWEEN 50 and 59 then 50
		   		end age,
		   		count(1) cnt_order
	FROM food_orders f inner join customers c on f.customer_id=c.customer_id
	WHERE age BETWEEN 10 and 59
	group by 1, 2
) a
group by 1
order by 1 desc;


-- 5.05 윈도우 함수, 랭크 구하기
SELECT cuisine_type,
	   restaurant_name,
	   cnt_order,
	   ranking
FROM 
(
	SELECT cuisine_type,
		   restaurant_name,
		   cnt_order,
		   rank() over (partition by cuisine_type order by cnt_order desc) ranking
	FROM 
	(
		select cuisine_type,
			   restaurant_name,
			   count(1) cnt_order
		from food_orders
		group by 1, 2
	) a
) b
WHERE ranking<=3;


SELECT cuisine_type,
	   restaurant_name,
	   cnt_order,
	   sum(cnt_order) over (PARTITION by cuisine_type) sum_cuisine,
	   sum(cnt_order) over (PARTITION by cuisine_type order by cnt_order desc) cum_order
FROM 
(
	SELECT  cuisine_type,
		    restaurant_name,
		    count(1) cnt_order
	FROM food_orders
	group by 1, 2
) a
order by cuisine_type, cnt_order;


-- 5-06. 날짜 형식
select date,
	   date(date) change_date
FROM payments


select date(date) date_type,
       date_format(date(date), '%Y') "년",
       date_format(date(date), '%m') "월",
       date_format(date(date), '%d') "일",
       date_format(date(date), '%w') "요일"
from payments;


SELECT DATE_FORMAT(date(date), '%Y') "년",
	   DATE_FORMAT(date(date), '%m') "월",
	   DATE_FORMAT(date(date), '%y%m') "년월",
	   DATE_FORMAT(date(date), '%d') "일",
	   DATE_FORMAT(date(date), '%W') "요일",
	   count(1) "주문건수"
FROM food_orders f inner join payments p on f.order_id=p.order_id
WHERE DATE_FORMAT(date(date), '%m')='03' 
group by 1, 2, 3
order by 1;




-- 5주차 마무리 1. 음식 타입별, 연령별 주문건수 pivot view 만들기 (연령은 10~59세 사이)
-- food_orders에서 cuisine_type, payments에서 주문건수, customers에서 age 추출
select a.cuisine_type,
       max(if(a.age between 10 and 19, cnt_order, 0)) "10대",
       max(if(a.age between 20 and 29, cnt_order, 0)) "20대",
       max(if(a.age between 30 and 39, cnt_order, 0)) "30대",
       max(if(a.age between 40 and 49, cnt_order, 0)) "40대",
       max(if(a.age between 50 and 59, cnt_order, 0)) "50대"
from 
	(
	select cuisine_type,
		   age,	
	       count(order_id) cnt_order
	from food_orders f inner join customers c on f.customer_id=c.customer_id
	group by f.cuisine_type, age
	) a
group by a.cuisine_type;

 
SELECT * from food_orders fo;
show tables;



