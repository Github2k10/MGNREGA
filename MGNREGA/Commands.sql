-- Gram Panchayat Member (gpm) Table:

mysql> create table gpm(
    -> gid int primary key AUTO_INCREMENT,
    -> gname varchar(25) not null,
    -> email_id varchar(50) unique not null,
    -> password varchar(12) not null,
    -> district varchar(30),
    -> state varchar(30) );
 
 
 -- Employee Table:
 
 CREATE TABLE employee ( 
 		eid int PRIMARY KEY, 
 		ename varchar(20) NOT NULL, 
 		email VARCHAR(50) UNIQUE NOT NULL,
 		contact varchar(10) unique not null,
 		dob date NOT NULL, 
 		joining_date date,
 		wages double default 0.00,
 		epid int DEFAULT NULL,
 		FOREGIN KEY (pid) REFERENCES project (pid);
 
 
 -- Project Table;
 
 mysql> create table project(
    -> pid int primary key AUTO_INCREMENT,
    -> pname varchar(25) not null,
    -> pcost double default 0.00,
    -> pduration int default null,
    -> gpmid int default null,
    -> foreign key (gpmid) references gpm (gid) );
 		
 
 mysql> create table gpm(
    -> gid int primary key auto_increment,
    -> gname varchar(25) not null,
    -> email_id varchar(50) unique not null,
    -> password varchar(12) not null,
    -> district varchar(30),
    -> state varchar(30) );
Query OK, 0 rows affected (0.03 sec)

mysql> create table project(
    -> pid int primary key auto_increment,
    -> pname varchar(25) not null,
    -> pcost double default 0.00,
    -> pduration int default null,
    -> gpmid int default null,
    -> foreign key (gpmid) references gpm (gid) ON DELETE SET NULL ON UPDATE SET NULL );
Query OK, 0 rows affected (0.03 sec)

mysql> create table employee(
    -> eid int primary key auto_increment,
    -> ename varchar(25) not null,
    -> email varchar(50) unique not null,
    -> contact varchar(10) not null,
    -> dob date not null,
    -> joining_date date,
    -> wages double default 0.00,
    -> epid int default null,
    -> foreign key (epid) references project (pid) ON DELETE SET NULL ON UPDATE SET NULL );
Query OK, 0 rows affected (0.04 sec)