SELECT PT_NAME, PT_NO, GEND_CD, AGE, nvl(TLNO,'NONE') as tlno
from PATIENT
where age <= 12 and GEND_CD = 'W'
order by age desc, pt_name asc