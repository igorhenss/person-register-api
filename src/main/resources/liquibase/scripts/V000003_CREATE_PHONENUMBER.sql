CREATE TABLE PHONENUMBER (
  ID_PERSON RAW(36) NOT NULL CONSTRAINT PERSON_PHONENUMBER_FK REFERENCES PERSON_PK,
  PHONENUMBER VARCHAR(40) NOT NULL
) TABLESPACE PERSON_REGISTER_API_DATA