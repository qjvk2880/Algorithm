SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I
LEFT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID 
WHERE O.DATETIME < I.DATETIME
ORDER BY I.DATETIME ASC;