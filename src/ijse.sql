DROP DATABASE IF EXISTS ijse;
CREATE DATABASE IF NOT EXISTS ijse;
USE ijse;

CREATE TABLE Student(
                         student_id VARCHAR(45) NOT NULL,
                         student_name VARCHAR(45) NOT NULL,
                         email TEXT,
                         contact VARCHAR(20) NOT NULL,
                         address TEXT,
                         nic VARCHAR(45) NOT NULL,
                         CONSTRAINT PRIMARY KEY (student_id)
);
SHOW TABLES;
DESC Student;

INSERT INTO Student VALUES ('S-001','Saman','saman@gmail','0771234567','Horana','123456234V'),
                        ('S-002','Kamal','kamal@gmail','0782345678','Panadura','234456234V'),
                        ('S-003','Amal','amal@gmail','0751234567','Colombo','567456234V');

SELECT * FROM Student;

CREATE TABLE Teacher(
                        teacher_id VARCHAR(45) NOT NULL,
                        name VARCHAR(45) NOT NULL,
                        nic VARCHAR(45) NOT NULL,
                        contact VARCHAR(45) NOT NULL,
                        address TEXT,
                        CONSTRAINT PRIMARY KEY (teacher_id)
);
SHOW TABLES;
DESC Teacher;

INSERT INTO Teacher VALUES ('T-001','Ranajith','567456234V','0761234567','Horana'),
                           ('T-002','Chamara','734456234V','0772345678','Galle'),
                           ('T-003','Nandasena','867456234V','0781234567','Colombo');

SELECT * FROM Teacher;


