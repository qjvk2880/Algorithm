-- 코드를 입력하세요
# SELECT USER_ID, NICKNAME, TOTAL_SALES
# FROM USED_GOODS_USER 
# WHERE USER_ID IN (SELECT WRITER_ID
#                   FROM USED_GOODS_BOARD
#                   GROUP BY WRITER_ID HAVING SUM(PRICE) > 700000
#                   WHERE STATUS = 'SALE')
# ORDER BY 

# SELECT u.USER_ID, u.NICKNAME, SUM(b.PRICE) AS TOTAL_SALES
# FROM USED_GOODS_USER AS u
# INNER JOIN USED_GOODS_BOARD AS b ON u.USER_ID = b.WRITER_ID
# WHERE b.STATUS = 'DONE'
# GROUP BY u.USER_ID HAVING SUM(b.PRICE) >= 700000
# ORDER BY TOTAL_SALES ASC

SELECT U.USER_ID, U.NICKNAME, SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS B
LEFT JOIN USED_GOODS_USER AS U ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS = 'DONE'
GROUP BY B.WRITER_ID HAVING SUM(B.PRICE) >= 700000
ORDER BY SUM(B.PRICE) ASC;