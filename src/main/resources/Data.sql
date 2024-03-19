CREATE SCHEMA IF NOT EXISTS TURISTGUIDE;

USE TURISTGUIDE;

DROP TABLE IF EXISTS TURISTGUIDE.Attractions;
DROP TABLE IF EXISTS TURISTGUIDE.Cities;

CREATE TABLE TURISTGUIDE.Attractions (
                               attractionID int NOT NULL AUTO_INCREMENT,
                               attractionName varchar(30),
                               attractionDescription varchar(250),
                               cityId int,
                               ticketPrice int,
                               PRIMARY KEY (attractionID)
);

INSERT INTO TURISTGUIDE.Attractions (attractionName, attractionDescription, cityId, ticketPrice) VALUES
                                ('Tivoli_H2', 'Forlystelsespark i København_H2', 1, 200),
                                ('SMK_H2', 'Statens musen for kunst_H2', 1, 49),
                                ('Tivoli Friheden_H2', 'Forlystelsespark i Århus_H2', 2, 300),
                                ('Rundetårn_H2', ' Et rundt tårn_H2', 1, 249);

CREATE TABLE TURISTGUIDE.Cities (
                                    cityID int NOT NULL AUTO_INCREMENT,
                                    cityName varchar(50),
                                    PRIMARY KEY(cityID)
    );

INSERT INTO TURISTGUIDE.Cities (cityName) VALUES
    ('København'),
    ('Århus'),
    ('Odense');
