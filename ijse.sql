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

CREATE TABLE Subject(
                        subject_id VARCHAR(45) NOT NULL,
                        subject_name VARCHAR(45) NOT NULL,
                        credit DOUBLE ,
                        teacher_id VARCHAR(45),
                        CONSTRAINT PRIMARY KEY (subject_id),
                        CONSTRAINT FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Subject;

INSERT INTO Subject VALUES ('S-001','JDBC','100000','T-001'),
                           ('S-002','OOP','200000','T-002');
SELECT * FROM Subject;


CREATE TABLE Course(
                        course_id VARCHAR(45) NOT NULL,
                        course_name VARCHAR(45) NOT NULL,
                        cost DOUBLE ,
                        duration VARCHAR(45),
                        subject_id VARCHAR(45),
                        CONSTRAINT PRIMARY KEY (course_id),
                        CONSTRAINT FOREIGN KEY (subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Course;

INSERT INTO Course VALUES ('C-001','ComputerScience','100000','4years','S-001'),
                          ('C-002','SF','200000','4years','S-002');
SELECT * FROM Course;


CREATE TABLE Intake(
                       intake_id VARCHAR(45) NOT NULL,
                       start_date DATE,
                       intakecol VARCHAR(45),
                       description VARCHAR(45),
                       course_id VARCHAR(45),
                       CONSTRAINT PRIMARY KEY (intake_id),
                       CONSTRAINT FOREIGN KEY (course_id) REFERENCES Course(course_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Intake;

INSERT INTO Intake VALUES ('I-001','2022-7-12','abcd','started','C-001'),
                          ('I-002','2022-7-13','abcd','started','C-002');
SELECT * FROM Intake;


CREATE TABLE Registration(
                       registration_id VARCHAR(45) NOT NULL,
                       reg_date DATE,
                       student_id VARCHAR(45),
                       intake_id VARCHAR(45),
                       CONSTRAINT PRIMARY KEY (registration_id , intake_id),
                       CONSTRAINT FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
                       CONSTRAINT FOREIGN KEY (intake_id) REFERENCES Intake(intake_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Registration;

INSERT INTO Registration VALUES ('R-001','2022-7-12','S-001','I-001'),
                                ('R-002','2022-7-16','S-001','I-002');
SELECT * FROM Registration;


CREATE TABLE Payment(
                       payment_id VARCHAR(45) NOT NULL,
                       date DATE,
                       cost DOUBLE ,
                       registration_id VARCHAR(45),
                       CONSTRAINT PRIMARY KEY (payment_id),
                       CONSTRAINT FOREIGN KEY (registration_id) REFERENCES Registration(registration_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES;
DESC Payment;

INSERT INTO Payment VALUES ('P-001','2022-7-12','10000.0','R-001'),
                           ('P-002','2022-7-20','20000.0','R-002');
SELECT * FROM Payment;



