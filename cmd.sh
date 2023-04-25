psql -U root

#or

psql -U root -l

###

psql -U root -d <database>

###

\l

###

\c root

###

\dt

###

CREATE TABLE accounts (
	user_id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP
);

####

https://www.postgresqltutorial.com/postgresql-tutorial/postgresql-create-table/

### insert multiple data row

INSERT INTO
    accounts (user_id, username)
VALUES
    (1,'Google'),
    (2,'Yahoo'),
    (3,'Bing');