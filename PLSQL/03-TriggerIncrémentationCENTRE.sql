CREATE TRIGGER Incr_CENTRE
BEFORE INSERT ON CENTRE
FOR EACH ROW

BEGIN

    SELECT Seq_Centre.nextval into :NEW.IDCENTRE FROM dual;

END;