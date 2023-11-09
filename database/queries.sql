CREATE DATABASE GESTION_ETUDIANT_AUTH;
USE GESTION_ETUDIANT_AUTH;

CREATE TABLE etudiant(
    appoge int not null,
    cne varchar(30) not null,
    nom varchar(30) not null,
    prenom varchar(30) not null,
    primary key(appoge,cne)
);