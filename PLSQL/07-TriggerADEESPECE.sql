create or replace TRIGGER ADE_ESPECE
AFTER DELETE ON ESPECE
FOR EACH ROW

BEGIN

  DELETE FROM OBSERVER
  WHERE OBSERVER.ENOM=:old.ENOM;

END;