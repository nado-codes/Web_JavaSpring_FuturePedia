CREATE DATABASE Futurepedia;
USE Futurepedia;

/* Create tables */

/* ARTICLES */
CREATE TABLE Articles (
	Id int not null primary key AUTO_INCREMENT,
    Name varchar(64) not null,
    Content text not null,
	DateAdded datetime not null DEFAULT NOW(),
	LastModified timestamp not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
DELIMITER //
CREATE PROCEDURE GetArticles()
BEGIN
	SELECT Id, Name, Content, DateAdded, LastModified FROM Articles;
END //
DELIMITER //
CREATE PROCEDURE GetArticleById(IN in_id int)
BEGIN
	SELECT Id, Name, Content, DateAdded, LastModified FROM Articles WHERE Id=in_id;
END //
CREATE PROCEDURE GetArticleByName(IN in_name varchar(64))
BEGIN
	SELECT Id, Name, Content, DateAdded, LastModified FROM Articles WHERE Name=in_name;
END //
CREATE PROCEDURE AddArticle(
	IN in_name varchar(64),
    IN in_content text
)
BEGIN
	INSERT INTO Articles (Name, Content)
    VALUES(in_name,in_content);
END //
CREATE PROCEDURE UpdateArticle(
    IN in_id int,
	IN in_name varchar(64),
    IN in_content text,
    IN in_lastmodified timestamp
)
BEGIN
	UPDATE Articles SET name=in_name, content=in_content WHERE id=in_id AND lastmodified=in_lastmodified;
    SELECT ROW_COUNT();
END //
/* Add example article */
INSERT INTO Articles (Name,Content) values ("HelloArticle","HelloWorld");
	
/* ROLLBACK
DROP DATABASE Futurepedia
*/
