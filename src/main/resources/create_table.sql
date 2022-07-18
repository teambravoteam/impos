--product
CREATE TABLE Coffee (
	pid			    BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	proCode		  VARCHAR(20)	NOT NULL,
	proName		  VARCHAR(20)	NOT NULL,
	proPrice	  DOUBLE		  NOT NULL,
	proCategory VARCHAR(20)	NOT NULL,
	proImage VARCHAR(40)
) AUTO_INCREMENT = 1;

--imgName VARCHAR(20)

SELECT * FROM Coffee;
DROP TABLE Coffee;

CREATE TABLE Cookie (
	pid		    	BIGINT	  	PRIMARY KEY AUTO_INCREMENT,
	proCode	  	VARCHAR(20)	NOT NULL,
	proName	  	VARCHAR(20)	NOT NULL,
	proPrice  	DOUBLE		  NOT NULL,
	proCategory VARCHAR(20) NOT NULL,
	proImage VARCHAR(40)
) AUTO_INCREMENT = 101;

SELECT * FROM Cookie;
DROP TABLE Cookie;

CREATE TABLE Cake (
	pid		    	BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	proCode	  	VARCHAR(20)	NOT NULL,
	proName	  	VARCHAR(20)	NOT NULL,
	proPrice  	DOUBLE	  	NOT NULL,
	proCategory VARCHAR(20) NOT NULL,
	proImage VARCHAR(40)
) AUTO_INCREMENT = 201;

SELECT * FROM Cake;
DROP TABLE Cake;

--stock
CREATE TABLE CookieStock (
	sid				BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	scode		    VARCHAR(20)	  NOT NULL,
	scategory		VARCHAR(20)	  NOT NULL,
	stock       	INT           DEFAULT 0
) AUTO_INCREMENT = 101;

SELECT * FROM CookieStock;
DROP TABLE CookieStock;

CREATE TABLE CakeStock (
	sid				BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	scode		    VARCHAR(20)	  NOT NULL,
	scategory		VARCHAR(20)	  NOT NULL,
	stock       	INT           DEFAULT 0
) AUTO_INCREMENT = 201;

SELECT * FROM CakeStock;
DROP TABLE CakeStock;

--material
CREATE TABLE Material (
	mid            BIGINT       PRIMARY KEY AUTO_INCREMENT,
	materialName   VARCHAR(20)  NOT NULL,
	materialVolume DOUBLE       NOT NULL
) AUTO_INCREMENT = 1;

SELECT * FROM Material;
DROP TABLE Material;

INSERT INTO Material (materialName, materialVolume) VALUES("원두", 100);
INSERT INTO Material (materialName, materialVolume) VALUES("우유", 50);

--manager
CREATE TABLE Manager (
   mid			BIGINT				PRIMARY KEY AUTO_INCREMENT,
   name     VARCHAR(16)   NOT NULL,
   userId   VARCHAR(16)   NOT NULL,
   passwd   VARCHAR(20)   NOT NULL,
   area     VARCHAR(30)   NOT NULL
) AUTO_INCREMENT = 1;

SELECT * FROM Manager;
DROP TABLE Manager;

--sale
CREATE TABLE Sale (
	saId		  BIGINT		  PRIMARY KEY AUTO_INCREMENT,
	saCode		  VARCHAR(20)	  NOT NULL,
	saName 	      VARCHAR(20)	  NOT NULL,
	saPrice	      DOUBLE		  NOT NULL,
	saCategory    VARCHAR(20)	  NOT NULL,
  	saCount       INT             NOT NULL,
	regDate		  TIMESTAMP	  	  NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1;

SELECT * FROM Sale;
DROP TABLE Sale;