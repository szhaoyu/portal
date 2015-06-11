/*
CREATE TABLE T_USERS (
 id 			INT auto_increment,
 username		VARCHAR(24) PRIMARY KEY,
 truename		VARCHAR(32) not null,
 mphone			VARCHAR(24) not null,
 email			VARCHAR(32)	not null,
 bornday		DATE,
 password		VARCHAR(24)	not null,
 
 enabled 		INT default 1,
 
 create_by		VARCHAR(24),
 create_time	DATETIME,
 modify_by		VARCHAR(24),
 modify_time	DATETIME
);

CREATE TABLE T_USER_ROLES (
 id 			INT auto_increment,
 username		VARCHAR(24),
 role			VARCHAR(16)
);

insert into T_USERS( username, truename, mphone, email, password, create_time ) values ( 'admin', '', '', '', password('1q2w3e'), sysdate() );
insert into T_USER_ROLES( username, role) values ('admin', 'ROLE_ADMIN');
*/
CREATE TABLE T_USER(
	id    		bigint auto_increment primary key,
	email 		varchar(48) not null,
	password_hash varchar(64) not null,
	role 		  varchar(16) not null
);

INSERT INTO T_USER (email, password_hash, role) VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN');

commit;
