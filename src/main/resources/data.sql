
INSERT INTO USER(USER_ID,USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,EMAIL) VALUES(1,'check24','$2a$10$i000/ZJSTZuX5h4hwZXyYO0DJmTNlnQhuyTnoI6ZIGaOT/qsIOOSO','Check','24','sample@check24.com');

INSERT INTO ROLE(ID,NAME) VALUES(1,'ROLE_USER');

INSERT INTO USER_ROLES(USER_ID,ROLE_ID) VALUES(1,1);

INSERT INTO FILM(FILM_ID,NAME,YEAR_OF_RELEASE,DURATION_IN_MINS) VALUES(1,'Film 1','2019','120');
INSERT INTO FILM(FILM_ID,NAME,YEAR_OF_RELEASE,DURATION_IN_MINS) VALUES(2,'Film 2','2000','120');
INSERT INTO FILM(FILM_ID,NAME,YEAR_OF_RELEASE,DURATION_IN_MINS) VALUES(3,'Film 3','2010','180');
INSERT INTO FILM(FILM_ID,NAME,YEAR_OF_RELEASE,DURATION_IN_MINS) VALUES(4,'Film 4','2009','60');
INSERT INTO FILM(FILM_ID,NAME,YEAR_OF_RELEASE,DURATION_IN_MINS) VALUES(5,'Film 5','2010','150');


INSERT INTO RATING(ID,RATING,FILM_ID,USER_ID) VALUES(1,5,1,1);
INSERT INTO RATING(ID,RATING,FILM_ID,USER_ID) VALUES(2,4,2,1);
INSERT INTO RATING(ID,RATING,FILM_ID,USER_ID) VALUES(3,2,3,1);