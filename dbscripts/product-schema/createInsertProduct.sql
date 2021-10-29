DROP SEQUENCE IF EXISTS cs_product."product_seq";
DROP TABLE IF EXISTS cs_product."product";
DROP SCHEMA IF EXISTS cs_product;

CREATE SCHEMA cs_product;

CREATE SEQUENCE cs_product.product_seq
  START WITH     1
  INCREMENT BY   1;
 
CREATE TABLE cs_product."product"(
  ID   INT                NOT NULL,
  NAME VARCHAR(20)       NOT NULL,
  DESCRIPTION VARCHAR(100) NOT NULL,
  SIZE  VARCHAR(10) NOT NULL,
  PRICE  VARCHAR(10)  NOT NULL,
  CREATE_DATE DATE,
  PRIMARY KEY (ID)
);

INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Cortado','DESC_CORTADO_O1', 'SMALL','3.50',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Latte','DESC_LATTE_01', 'SMALL','4.00',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Latte','DESC_LATTE_02', 'LARGE','4.75',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Capuccino','DESC_CAPPUCCINO_01', 'SMALL','4.25',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Cappuccino','DESC_CAPPUCCINO_02', 'LARGE','5.00',current_timestamp ); 
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Flat White','DESC_FW_01', 'SMALL','4.50',current_timestamp ); 
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Americano','DESC_AMERICANO_01', 'SMALL','3.25',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Americano','DESC_AMERICANO_02', 'LARGE','4.00',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Espresso','DESC_ESPRESSO_01', 'SINGLE','3.00',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Espresso','DESC_ESPRESSO_02', 'DOUBLE','5.00',current_timestamp );
 INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Ice Latte','DESC_ICE_LATTE_01', 'SMALL','4.00',current_timestamp );
 INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Ice Latte','DESC_ICE_LATTE_02', 'LARGE','4.75',current_timestamp );
 INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Cold Brew','DESC_COLD_BREW_O1', 'SMALL','3.75',current_timestamp );
 INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Cold Brew','DESC_COLD_BREW_O2', 'LARGE','4.50',current_timestamp );
 INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Hot Chocolate','DESC_HOT_COCO_01', 'SMALL','2.50',current_timestamp );
INSERT INTO cs_product."product" (ID, NAME, DESCRIPTION, SIZE, PRICE, CREATE_DATE) VALUES
  (nextval('cs_product.product_seq'), 'Hot Chocolate','DESC_HOT_COCO_02', 'LARGE','3.25',current_timestamp );  
 

SET default_tablespace = '';
SET client_encoding = 'UTF8';
