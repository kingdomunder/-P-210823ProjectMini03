DROP TABLE student cascade constraint;
DROP TABLE attendance cascade constraint;
DROP TABLE study cascade constraint;
DROP SEQUENCE student_idx;
DROP SEQUENCE study_idx;

CREATE TABLE student (
	student_id  NUMBER(10)  PRIMARY KEY,
	student_name VARCHAR2(20) NOT NULL,
	address VARCHAR2(50) NOT NULL,
	major VARCHAR2(20) NOT NULL,
	study_id NUMBER(10)	
);
CREATE TABLE attendance (
	student_id NUMBER(10)  PRIMARY KEY,
	present NUMBER(10),
	late NUMBER(10),
	absent NUMBER(10)
);
CREATE TABLE study (
	study_id NUMBER(10)  PRIMARY KEY,
	study_name VARCHAR2(50) NOT NULL,
	topic VARCHAR2(100) NOT NULL,
	leader_id NUMBER(10) NOT NULL,
	meeting_date VARCHAR2(8) NOT NULL
);

ALTER TABLE attendance ADD FOREIGN KEY (student_id) REFERENCES student (student_id);
ALTER TABLE student ADD FOREIGN KEY (study_id) REFERENCES study (study_id) ON DELETE SET NULL;
ALTER TABLE study ADD FOREIGN KEY (leader_id) REFERENCES student (student_id) ON DELETE SET NULL;

CREATE SEQUENCE student_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
CREATE SEQUENCE study_idx START WITH 1 INCREMENT BY 1 MAXVALUE 10000000 CYCLE NOCACHE;
