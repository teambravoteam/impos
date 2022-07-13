CREATE TABLE Manager (
   mid			BIGINT				PRIMARY KEY AUTO_INCREMENT,
   name      	VARCHAR(16)      	NOT NULL,
   userId      	VARCHAR(16)      	NOT NULL,
   passwd   	VARCHAR(20)      	NOT NULL,
   area      	VARCHAR(30)      	NOT NULL
) AUTO_INCREMENT = 1;

SELECT * FROM Manager;