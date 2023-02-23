-- Gram Panchayat Member (gpm) Table:

 create table gpm( 
 		gid int primary key, 
 		gname varchar(25) not null, 
 		email_id varchar(50) unique not null, 
 		password varchar(12) not null );
 
 
 -- Employee Table:
 
 CREATE TABLE employee ( 
 		pid int PRIMARY KEY, 
 		pname varchar(20) NOT NULL, 
 		email VARCHAR(50) UNIQUE NOT NULL, 
 		working_day int DEFAULT 0, 
 		dob date NOT NULL, 
 		gid int DEFAULT NULL, 
 		FOREIGN KEY (gid) REFERENCES gpm (gid) );
 
 
 -- Project Table;
 
 