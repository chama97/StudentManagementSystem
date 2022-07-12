DROP DATABASE IF EXISTS Kade;
CREATE DATABASE IF NOT EXISTS Kade;
USE Kade;

CREATE TABLE Customer(
                         student_id VARCHAR(15) NOT NULL,
                         name VARCHAR(20) NOT NULL,
                         email VARCHAR(20) NOT NULL,
                         contact
                         address TEXT,

                         CONSTRAINT PRIMARY KEY (id)
);
SHOW TABLES;
DESC Customer;

INSERT INTO Item VALUES ('I-001','Computer','100','100000'),
                        ('I-002','Laptop','100','150000'),
                        ('I-003','Tab','200','130000');

SELECT * FROM Item;

CREATE TABLE Item(
        id VARCHAR(15) NOT NULL,
        type VARCHAR(20) NOT NULL,
        qty INT,
        unitPrice DOUBLE NOT NULL,
        CONSTRAINT PRIMARY KEY (id)
);
SHOW TABLES;
DESC Item;

INSERT INTO Item VALUES ('I-001','Computer','100','100000'),
                        ('I-002','Laptop','100','150000'),
                        ('I-003','Tab','200','130000');

SELECT * FROM Item;



