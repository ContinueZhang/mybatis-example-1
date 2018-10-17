DROP SEQUENCE IF EXISTS seq_user CASCADE;
CREATE SEQUENCE seq_user;
DROP TABLE IF EXISTS t_user CASCADE;
CREATE TABLE t_user (
  id                   INTEGER      NOT NULL  DEFAULT NEXTVAL('seq_user'),
  name                 VARCHAR(500) ,
  password             VARCHAR(500) ,
  email                VARCHAR(500) ,
  profile              TEXT,
  time                 TIMESTAMP(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);


DROP SEQUENCE IF EXISTS seq_role CASCADE;
CREATE SEQUENCE seq_role;
DROP TABLE IF EXISTS t_role CASCADE;
CREATE TABLE t_role (
  id                   INTEGER      NOT NULL  DEFAULT NEXTVAL('seq_role'),
  user_id              INTEGER ,
  name                 VARCHAR(500) ,
  effective_sign       INTEGER  , --有效标志
  time                 TIMESTAMP(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
CREATE INDEX ON t_role (user_id);


DROP SEQUENCE IF EXISTS seq_authority CASCADE;
CREATE SEQUENCE seq_authority;
DROP TABLE IF EXISTS t_authority CASCADE;
CREATE TABLE t_authority (
  id                   INTEGER      NOT NULL  DEFAULT NEXTVAL('seq_authority'),
  name                 VARCHAR(500) ,
  url                  varchar(500) ,
  time                 TIMESTAMP(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS seq_user_role CASCADE;
CREATE SEQUENCE seq_user_role;
DROP TABLE IF EXISTS t_user_role CASCADE;
CREATE TABLE t_user_role (
  id                   INTEGER      NOT NULL  DEFAULT NEXTVAL('seq_user_role'),
  user_id              INTEGER,
  role_id              INTEGER,
  time                 TIMESTAMP(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
CREATE INDEX ON t_user_role (user_id);
CREATE INDEX ON t_user_role (role_id);


DROP SEQUENCE IF EXISTS seq_role_authority CASCADE;
CREATE SEQUENCE seq_role_authority;
DROP TABLE IF EXISTS t_role_authority CASCADE;
CREATE TABLE t_role_authority (
  id                   INTEGER      NOT NULL  DEFAULT NEXTVAL('seq_role_authority'),
  role_id              INTEGER ,
  authority_id         INTEGER ,
  time                 TIMESTAMP(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
CREATE INDEX ON t_role_authority (role_id);
CREATE INDEX ON t_role_authority (authority_id);




