select * from movie_app.user;
/
select * from movie_app.cart;
/
select * from movie_app.movie_dtls ;
update movie_app.user set name="Tinnnee" where id = 1;
commit;
/
CREATE TABLE movie_app.movie_dtls (
movieid INT NOT NULL AUTO_INCREMENT,
moviename VARCHAR(45) NULL,
director VARCHAR(45) NULL,
price DOUBLE NULL,
movieCategory VARCHAR(45) NULL,
status VARCHAR(45) NULL,
photo VARCHAR(45) NULL,
PRIMARY KEY (movieid));
/
CREATE TABLE movie_app.user (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45),
    email varchar(45),
    usercol varchar(45),
    phno varchar(45),
    password varchar(45),
    address varchar(45),
    landmark varchar(45),
    city varchar(45),
    state varchar(45),
    PRIMARY KEY (id));
/
CREATE TABLE movie_app.cart (

cartid INT NOT NULL AUTO_INCREMENT,

movieid INT NULL,

userid INT NULL,

bookName VARCHAR(45) NULL,

director VARCHAR(45) NULL,

price DOUBLE NULL,

total_price DOUBLE NULL,

PRIMARY KEY (cartid));
