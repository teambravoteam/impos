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

INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('101', '민트초코라떼', '3000', '커피', '11');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('201', '민트초코쿠키', '5000', '쿠키', '22');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('301', '민트초코케이크', '8000', '케이크', '33');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('102', '헤이즐넛아이스아메리카노', '2500', '커피', '1');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('202', '헤이즐넛쿠키', '4500', '쿠키', '2');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('302', '얼그레이케이크', '10000', '케이크', '33');
INSERT INTO Sale (saCode, saName, saPrice, saCategory, saCount) VALUES ('303', '카푸치노케이크', '13000', '케이크', '3');

UPDATE Sale SET saCategory='cake' WHERE saCategory='케이크';

SELECT * FROM Sale WHERE MONTH(regDate) = '6';

DROP TABLE Sale;