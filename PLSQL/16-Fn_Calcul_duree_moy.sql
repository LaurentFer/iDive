create or replace FUNCTION FN_Calcul_Duree_Moy(Participant VARCHAR2)
  RETURN NUMBER IS

  duree     NUMBER;

  CURSOR TEMPO IS

    SELECT  avg(PDUR)
    FROM    PLONGER
    WHERE   PMAIL=Participant;
  
BEGIN

  OPEN  TEMPO;
  FETCH TEMPO INTO duree;
  CLOSE TEMPO;

  RETURN duree;
  
END;