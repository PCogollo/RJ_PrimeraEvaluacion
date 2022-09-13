CREATE DATABASE myBase;
use myBase; 

create table Player (
	PersonID int, 
    Name varchar(255), 
    Score int, 
    Level int
);

insert into Player(PersonID, Name, Score, Level) values (0, "Dan", 10, 20);
insert into Player(PersonID, Name, Score, level) values (1, "Pam", 15, 25);
UPDATE Player
SET Name = 1, Score = 10
WHERE PersonID = 1;
select * from Player;

create table Persons(
	ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255), 
    Age int,
    Nationality varchar(255),
);

alter table Persons
DROP PRIMARY KEY;
INSERT INTO Persons (ID, LastName, FirstName, Age, Nationality) VALUES (5, 'Lau2', 'Jorgen2', 51, 'Danish2');
INSERT INTO Persons (ID, LastName, FirstName, Age, Nationality) VALUES (3, 'Jezza', 'Bernardo', 23, 'Brazilian');
select * from Persons;


