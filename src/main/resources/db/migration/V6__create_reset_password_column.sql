set schema 'public';
ALTER TABLE accounts ADD COLUMN reset_password_token varchar(64);
