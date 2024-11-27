SELECT CAR_ID, CASE WHEN CAR_ID IN (SELECT CAR_ID
                                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                    WHERE DATE_FORMAT(START_DATE, '%Y-%m-%d') <= '2022-10-16' 
                                    AND DATE_FORMAT(END_DATE, '%Y-%m-%d') >= '2022-10-16')
                                THEN '대여중'
                                ELSE '대여 가능'
                                END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;


 

















