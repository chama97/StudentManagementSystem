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

INSERT INTO Subject VALUES ('S-001','JDBC','100000','T-001');
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

INSERT INTO Course VALUES ('C-001','ComputerScience','100000','4years','S-001');
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

INSERT INTO Intake VALUES ('I-001','2022-7-12','abcd','started','C-001');
SELECT * FROM Intake;



