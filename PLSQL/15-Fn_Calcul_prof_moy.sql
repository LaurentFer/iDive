create or replace FUNCTION FN_Calcul_Profondeur_Moy(Participant VARCHAR2)
  RETURN NUMBER IS

  Prof     NUMBER;

  CURSOR TEMPO IS

    SELECT  avg(PPRO)
    FROM    PLONGER
    WHERE   PMAIL=Participant;
  
BEGIN

  OPEN  TEMPO;
  FETCH TEMPO INTO Prof;
  CLOSE TEMPO;

  RETURN Prof;
  
END;