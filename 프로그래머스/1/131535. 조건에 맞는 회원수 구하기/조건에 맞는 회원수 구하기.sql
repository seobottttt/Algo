SELECT count(*) as users
from USER_INFO
where age >=20 and age < 30 and to_char(joined,'yyyy') = '2021'