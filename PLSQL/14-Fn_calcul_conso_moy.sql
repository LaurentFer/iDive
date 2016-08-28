create or replace FUNCTION FN_Calcul_Conso_Moy(Participant VARCHAR2)
  RETURN NUMBER IS

  Conso     NUMBER;

  CURSOR TEMPO IS
    SELECT avg(ConsoPl) FROM
    (SELECT ((((PCB*PPD)-(PCB*PPA))/((PPRO/10)+1))/PDUR) AS ConsoPL
    FROM    PLONGER
    WHERE   PMAIL=Participant);
  
BEGIN

  OPEN  TEMPO;
  FETCH TEMPO INTO Conso;
  CLOSE TEMPO;

  RETURN Conso;
  
END;