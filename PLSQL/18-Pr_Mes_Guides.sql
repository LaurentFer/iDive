create or replace PROCEDURE   "PR_MES_GUIDES" (Participant VARCHAR2)
AS

  Guide     VARCHAR2(50);
  Nombre    NUMERIC;

  CURSOR TEMPO IS
    SELECT PMAIL,count(PMAIL)
    FROM PARTAGER
    WHERE RNOM='Guide de palanquée'
      AND (IDPLON,PPAL) IN (SELECT IDPLON,PPAL FROM PARTAGER WHERE PMAIL=Participant)
    GROUP BY PMAIL
    ORDER BY count(PMAIL) DESC;
  
BEGIN

    OPEN  TEMPO;
    DBMS_OUTPUT.PUT_LINE('Mes Guides :');  
    
    LOOP
      FETCH TEMPO INTO Guide,Nombre;

      DBMS_OUTPUT.PUT_LINE(Guide||' '||Nombre||' fois');
      EXIT WHEN TEMPO%NOTFOUND;
    END LOOP;
    
    CLOSE TEMPO;
    
END;