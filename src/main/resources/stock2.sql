CREATE TABLE Product (
pId			     BIGINT		      PRIMARY KEY AUTO_INCREMENT,
proCode	    	 VARCHAR(20)	  UNIQUE KEY,
proName 	   	 VARCHAR(20)	  NOT NULL,
proPrice	     DOUBLE		      NOT NULL,
proCategory	 	 VARCHAR(20)	  NOT NULL
) AUTO_INCREMENT = 1;

DROP TABLE Product;

INSERT INTO Product (proCode, proName, proPrice, proCategory) 
VALUES ('111-11-1111', '꼬북칩', 1500, '과자');

SELECT * FROM Product; 

CREATE TABLE Stock (
sid				BIGINT		  PRIMARY KEY AUTO_INCREMENT,
sCode		    VARCHAR(20)	  NOT NULL,
stock       	INT           DEFAULT 0,
CONSTRAINT Product_proCode_FK FOREIGN KEY (sCode) REFERENCES Product(proCode)
) AUTO_INCREMENT = 1;

INSERT INTO Stock (sCode) VALUES ('111-11-1111');

SELECT * FROM Stock;
SELECT * FROM Product p INNER JOIN Stock s ON (p.proCode = s.sCode);

DROP TABLE Stock;

--- 

CREATE TABLE CookieStock (
	sid				BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	scode		    VARCHAR(20)	  NOT NULL,
	scategory		VARCHAR(20)	  NOT NULL,
	stock       	INT           DEFAULT 0
) AUTO_INCREMENT = 101;

CREATE TABLE CakeStock (
	sid				BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	scode		    VARCHAR(20)	  NOT NULL,
	scategory		VARCHAR(20)	  NOT NULL,
	stock       	INT           DEFAULT 0
) AUTO_INCREMENT = 201;

DROP TABLE CookieStock;
DROP TABLE CakeStock;
INSERT INTO CookieStock(scode, scategory) VALUES("111", "cookie");
INSERT INTO CakeStock(scode, scategory) VALUES("111", "cake");

SELECT * FROM CookieStock;
SELECT * FROM CakeStock;

--
CREATE TABLE Coffee (
	pid			    BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	proCode		  VARCHAR(20)	NOT NULL,
	proName		  VARCHAR(20)	NOT NULL,
	proPrice	  DOUBLE		  NOT NULL,
	proCategory VARCHAR(20)	NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE Cookie (
	pid		    	BIGINT	  	PRIMARY KEY AUTO_INCREMENT,
	proCode	  	VARCHAR(20)	NOT NULL,
	proName	  	VARCHAR(20)	NOT NULL,
	proPrice  	DOUBLE		  NOT NULL,
	proCategory VARCHAR(20) NOT NULL
) AUTO_INCREMENT = 101;

CREATE TABLE Cake (
	pid		    	BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	proCode	  	VARCHAR(20)	NOT NULL,
	proName	  	VARCHAR(20)	NOT NULL,
	proPrice  	DOUBLE	  	NOT NULL,
	proCategory VARCHAR(20) NOT NULL
) AUTO_INCREMENT = 201;

SELECT * FROM Coffee;
SELECT * FROM Cookie;
SELECT * FROM Cake;

SELECT b.sid, a.proCategory, a.proCode, a.proName, a.proPrice, b.stock
FROM Cake a INNER JOIN CakeStock b ON (a.proCode = b.scode);

SELECT b.sid, a.proCategory, a.proCode, a.proName, a.proPrice, b.stock
FROM Cake a INNER JOIN CakeStock b  ON (a.proCode = b.scode) WHERE a.proName='초코케이크';

--
CREATE TABLE Manager (
   mid			BIGINT				PRIMARY KEY AUTO_INCREMENT,
   name     VARCHAR(16)   NOT NULL,
   userId   VARCHAR(16)   NOT NULL,
   passwd   VARCHAR(20)   NOT NULL,
   area     VARCHAR(30)   NOT NULL
) AUTO_INCREMENT = 1;

--

CREATE TABLE Material (
	mid            BIGINT       PRIMARY KEY AUTO_INCREMENT,
	materialName   VARCHAR(20)  NOT NULL,
	materialVolume DOUBLE       NOT NULL
) AUTO_INCREMENT = 1;

INSERT INTO Material (materialName, materialVolume) VALUES("원두", 100);
INSERT INTO Material (materialName, materialVolume) VALUES("우유", 50);
SELECT * FROM Material;