-- Gram Panchayat Member (gpm) Table:

mysql>  create table gpm(
    -> gid INT PRIMARY KEY AUTO_INCREMENT,
    -> gname VARCHAR(25) NOT NULL,
    -> email_id VARCHAR(50) NOT NULL,
    -> password VARCHAR(12) NOT NULL,
    -> district VARCHAR(30),
    -> state VARCHAR(30),
    -> contact VARCHAR(10) );
 
 
 -- Employee Table:
 
 CREATE TABLE employee ( 
 		eid int PRIMARY KEY, 
 		ename varchar(20) NOT NULL, 
 		email VARCHAR(50) UNIQUE NOT NULL, 
 		working_day int DEFAULT 0, 
 		dob date NOT NULL, 
 		gid int DEFAULT NULL, 
 		pid int DEFAULT NULL,
 		FOREGIN KEY (pid) REFERENCES project (pid),
 		FOREIGN KEY (gid) REFERENCES gpm (gid) );
 
 
 -- Project Table;
 
 CREATE TABLE PROJECT ( 
 		pid int PRIMARY KEY, 
 		pname varchar(20) NOT NULL, 
 		pcost double default 0.00,
 		pduration int default 0,
 		eid int default null,
 		gid int default null,
 		foregin key (gid) references gpm (gid),
 		foregin key (eid) references employee (eid) );
 		
 
 