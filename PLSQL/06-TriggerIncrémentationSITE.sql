CREATE TRIGGER Incr_Site 
BEFORE INSERT ON SITE
FOR EACH ROW

BEGIN

    SELECT Seq_Site.nextval into :NEW.IDSITE FROM dual;

END;