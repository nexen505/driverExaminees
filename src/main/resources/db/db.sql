--CREATE DATABASE database_auto_inspection;
--CREATE USER user WITH password '1';
--GRANT ALL ON DATABASE database_auto_inspection TO user;

DROP TABLE IF EXISTS type_exams CASCADE;
DROP TABLE IF EXISTS exams CASCADE;
DROP TABLE IF EXISTS school CASCADE;
DROP TABLE IF EXISTS inspection CASCADE;
DROP TABLE IF EXISTS owner CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS type_of_vehicle CASCADE;
DROP TABLE IF EXISTS transport CASCADE;
DROP TABLE IF EXISTS license_of_driver CASCADE;
DROP TABLE IF EXISTS certificate CASCADE;

--1
CREATE TABLE exdr_type_exams (
  type_exam           VARCHAR(20),
  number_of_mistakes  INTEGER NOT NULL,
  number_of_questions INTEGER NOT NULL
);
ALTER TABLE exdr_type_exams
  ADD PRIMARY KEY (type_exam);

--2
CREATE TABLE exdr_exams (
  id_exam        SERIAL      NOT NULL,
  type_exam      VARCHAR(20) NOT NULL,
  id_certificate INTEGER     NOT NULL,
  exam_date      DATE        NOT NULL,
  is_passed      BOOLEAN     NOT NULL
);
ALTER TABLE exdr_exams
  ADD PRIMARY KEY (id_exam);
ALTER TABLE exdr_exams
  ADD FOREIGN KEY (type_exam) REFERENCES exdr_type_exams (type_exam);

--3
CREATE TABLE exdr_school (
  id_school      SERIAL      NOT NULL,
  name_school    VARCHAR(20) NOT NULL,
  address_school VARCHAR(20) NOT NULL,
  phone_number   INTEGER     NOT NULL
);
ALTER TABLE exdr_school
  ADD PRIMARY KEY (id_school);

--4
CREATE TABLE exdr_inspection (
  id_inspection      SERIAL      NOT NULL,
  name_inspection    VARCHAR(20) NOT NULL,
  address_inspection VARCHAR(20) NOT NULL
);
ALTER TABLE exdr_inspection
  ADD PRIMARY KEY (id_inspection);

--5
CREATE TABLE exdr_owner (
  id_owner      SERIAL      NOT NULL,
  name          VARCHAR(30) NOT NULL,
  patronymic    VARCHAR(30) NOT NULL,
  surname       VARCHAR(30) NOT NULL,
  date_of_birth DATE        NOT NULL
);
ALTER TABLE exdr_owner
  ADD PRIMARY KEY (id_owner);

--6
CREATE TABLE exdr_categories (
  name_categories VARCHAR(20) NOT NULL,
  activity_flag   BOOLEAN
);
ALTER TABLE exdr_categories
  ADD PRIMARY KEY (name_categories);

--7
CREATE TABLE exdr_type_of_vehicle (
  type_transport  VARCHAR(20) NOT NULL,
  minimum_weight  REAL        NOT NULL,
  maximum_weight  REAL        NOT NULL,
  name_categories VARCHAR(20) NOT NULL
);
ALTER TABLE exdr_type_of_vehicle
  ADD PRIMARY KEY (type_transport);
ALTER TABLE exdr_type_of_vehicle
  ADD FOREIGN KEY (name_categories) REFERENCES exdr_categories (name_categories);

--8
CREATE TABLE exdr_transport (
  id_transport    SERIAL      NOT NULL,
  name_transport  VARCHAR(30) NOT NULL,
  brand_transport VARCHAR(20) NOT NULL,
  year_of_issue   INTEGER     NOT NULL,
  type_transport  VARCHAR(20) NOT NULL,
  id_owner        INTEGER     NOT NULL
);
ALTER TABLE exdr_transport
  ADD PRIMARY KEY (id_transport);
ALTER TABLE exdr_transport
  ADD FOREIGN KEY (id_owner) REFERENCES exdr_owner (id_owner);
ALTER TABLE exdr_transport
  ADD FOREIGN KEY (type_transport) REFERENCES exdr_type_of_vehicle (type_transport);

--9
CREATE TABLE exdr_license_of_driver (
  id_license_of_driver SERIAL      NOT NULL,
  date_of_issue        DATE        NOT NULL,
  institution_address  VARCHAR(70) NOT NULL,
  id_owner             INTEGER     NOT NULL,
  name_categories      VARCHAR(20) NOT NULL,
  id_inspection        INTEGER     NOT NULL
);
ALTER TABLE exdr_license_of_driver
  ADD PRIMARY KEY (id_license_of_driver);
ALTER TABLE exdr_license_of_driver
  ADD FOREIGN KEY (id_owner) REFERENCES exdr_owner (id_owner);
ALTER TABLE exdr_license_of_driver
  ADD FOREIGN KEY (name_categories) REFERENCES exdr_categories (name_categories);
ALTER TABLE exdr_license_of_driver
  ADD FOREIGN KEY (id_inspection) REFERENCES exdr_inspection (id_inspection);

--10
CREATE TABLE exdr_certificate (
  id_certificate       SERIAL      NOT NULL,
  id_school            INTEGER     NOT NULL,
  name_categories      VARCHAR(20) NOT NULL,
  id_license_of_driver INTEGER     NOT NULL
);
ALTER TABLE exdr_certificate
  ADD PRIMARY KEY (id_certificate);
ALTER TABLE exdr_certificate
  ADD FOREIGN KEY (id_school) REFERENCES exdr_school (id_school);
ALTER TABLE exdr_certificate
  ADD FOREIGN KEY (name_categories) REFERENCES exdr_categories (name_categories);
ALTER TABLE exdr_certificate
  ADD FOREIGN KEY (id_license_of_driver) REFERENCES exdr_license_of_driver (id_license_of_driver);
ALTER TABLE exdr_exams
  ADD FOREIGN KEY (id_certificate) REFERENCES exdr_certificate (id_certificate);



