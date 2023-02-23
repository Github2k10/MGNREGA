-- Gram Panchayat Member (gpm) Table:

 create table gpm( 
 		gid int primary key, 
 		gname varchar(25) not null, 
 		email_id varchar(50) unique not null, 
 		password varchar(12) not null );
 
 
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
 		
 
 