# Lab4

CREATE TABLE IF NOT EXISTS lab5_product_table (
    id int not null auto_increment,
    prodid char(36) not null UNIQUE,
    title varchar(50) not null UNIQUE,
    cost float not null,
    primary key (id, title)
);
