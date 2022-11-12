create database collegequera;

create table collegequera.user(
	userid int AUTO_INCREMENT,
	username varchar(100) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	password varchar(20) NOT NULL,
	type varchar(20) NOT NULL,
	branch varchar(20) NOT NULL,	
	PRIMARY KEY(userid)
);

create table collegequera.question(
	qusid int AUTO_INCREMENT,
	qus varchar(500) NOT NULL,
	qusdate date NOT NULL,
	student int,
	FOREIGN KEY(student) REFERENCES collegequera.user(userid),
	PRIMARY KEY(qusid)
);

create table collegequera.answer(
	ansid int AUTO_INCREMENT,
	ans varchar(1000) NOT NULL,
	ansdate date NOT NULL,
	question int,
	faculty int,
	FOREIGN KEY(question) REFERENCES collegequera.question(qusid),
	FOREIGN KEY(faculty) REFERENCES collegequera.user(userid),
	PRIMARY KEY(ansid)
);








