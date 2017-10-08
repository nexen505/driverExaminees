CREATE SEQUENCE id_certificate_seq;

CREATE SEQUENCE id_inspection_seq;

CREATE SEQUENCE id_license_of_driver_seq;

CREATE SEQUENCE id_owner_seq;

CREATE SEQUENCE id_school_seq;

CREATE SEQUENCE id_transport_seq;

CREATE SEQUENCE name_categories_seq;

CREATE SEQUENCE type_exam_seq;

CREATE SEQUENCE type_transport_seq;

CREATE TABLE exdr_categories
(
  name_categories VARCHAR(255) NOT NULL
    CONSTRAINT exdr_categories_pkey
    PRIMARY KEY,
  activity_flag   BOOLEAN
);

CREATE TABLE exdr_certificate
(
  id_certificate       INTEGER      NOT NULL
    CONSTRAINT exdr_certificate_pkey
    PRIMARY KEY,
  name_categories      VARCHAR(255) NOT NULL
    CONSTRAINT fkddad9ed9c42749b8
    REFERENCES exdr_categories,
  id_license_of_driver INTEGER,
  id_school            INTEGER      NOT NULL
);

CREATE TABLE exdr_exams
(
  id_exam        SERIAL       NOT NULL
    CONSTRAINT exdr_exams_pkey
    PRIMARY KEY,
  exam_date      DATE,
  is_passed      BOOLEAN,
  id_certificate INTEGER
    CONSTRAINT fkab6d42f621ae1c86
    REFERENCES exdr_certificate,
  type_exam      VARCHAR(255) NOT NULL
);

CREATE TABLE exdr_inspection
(
  id_inspection      INTEGER NOT NULL
    CONSTRAINT exdr_inspection_pkey
    PRIMARY KEY,
  address_inspection VARCHAR(255),
  name_inspection    VARCHAR(255)
);

CREATE TABLE exdr_license_of_driver
(
  id_license_of_driver INTEGER NOT NULL
    CONSTRAINT exdr_license_of_driver_pkey
    PRIMARY KEY,
  date_of_issue        DATE,
  id_inspection        INTEGER NOT NULL
    CONSTRAINT fkbd0e5cd44711c6b6
    REFERENCES exdr_inspection,
  id_owner             INTEGER
);

ALTER TABLE exdr_certificate
  ADD CONSTRAINT fkddad9ed94793426a
FOREIGN KEY (id_license_of_driver) REFERENCES exdr_license_of_driver;

CREATE TABLE exdr_owner
(
  id_owner      INTEGER NOT NULL
    CONSTRAINT exdr_owner_pkey
    PRIMARY KEY,
  date_of_birth DATE,
  name          VARCHAR(255),
  patronymic    VARCHAR(255),
  surname       VARCHAR(255)
);

ALTER TABLE exdr_license_of_driver
  ADD CONSTRAINT fkbd0e5cd45d430d7e
FOREIGN KEY (id_owner) REFERENCES exdr_owner;

CREATE TABLE exdr_school
(
  id_school      INTEGER      NOT NULL
    CONSTRAINT exdr_school_pkey
    PRIMARY KEY,
  address_school VARCHAR(255) NOT NULL,
  name_school    VARCHAR(255) NOT NULL,
  phone_number   INTEGER      NOT NULL
);

ALTER TABLE exdr_certificate
  ADD CONSTRAINT fkddad9ed96fdb0036
FOREIGN KEY (id_school) REFERENCES exdr_school;

CREATE TABLE exdr_transport
(
  id_transport    INTEGER      NOT NULL
    CONSTRAINT exdr_transport_pkey
    PRIMARY KEY,
  brand_transport VARCHAR(255),
  name_transport  VARCHAR(255),
  year_of_issue   INTEGER,
  id_owner        INTEGER
    CONSTRAINT fk1f2bbceb5d430d7e
    REFERENCES exdr_owner,
  type_transport  VARCHAR(255) NOT NULL
);

CREATE TABLE exdr_type_exams
(
  type_exam           VARCHAR(255) NOT NULL
    CONSTRAINT exdr_type_exams_pkey
    PRIMARY KEY,
  number_of_mistakes  INTEGER,
  number_of_questions INTEGER
);

ALTER TABLE exdr_exams
  ADD CONSTRAINT fkab6d42f68ab06227
FOREIGN KEY (type_exam) REFERENCES exdr_type_exams;

CREATE TABLE exdr_type_of_vehicle
(
  type_transport  VARCHAR(255) NOT NULL
    CONSTRAINT exdr_type_of_vehicle_pkey
    PRIMARY KEY,
  maximum_weight  REAL,
  minimum_weight  REAL,
  name_categories VARCHAR(255) NOT NULL
    CONSTRAINT fkf111472bc42749b8
    REFERENCES exdr_categories
);

ALTER TABLE exdr_transport
  ADD CONSTRAINT fk1f2bbcebb3a0a4db
FOREIGN KEY (type_transport) REFERENCES exdr_type_of_vehicle;

