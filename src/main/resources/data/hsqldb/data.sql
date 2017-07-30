INSERT INTO Pet (name,photoUrl,status) VALUES ('Dog','http://r.ddmcdn.com/s_f/o_1/cx_633/cy_0/cw_1725/ch_1725/w_720/APL/uploads/2014/11/too-cute-doggone-it-video-playlist.jpg','available');
INSERT INTO Pet (name,photoUrl,status) VALUES ('Cat','http://www.readersdigest.ca/wp-content/uploads/2011/01/4-ways-cheer-up-depressed-cat.jpg','available');
INSERT INTO Pet (name,photoUrl,status) VALUES ('Rabbit','https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/JumpingRabbit.JPG/220px-JumpingRabbit.JPG','available');
INSERT INTO Pet (name,photoUrl,status) VALUES ('Piglet','https://14twdi75fc14jykd-zippykid.netdna-ssl.com/wp-content/uploads/2013/10/piglet.jpg','available');


INSERT INTO users (username,email,password,enabled) VALUES ('user','n@gmail.com','$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK',true);
INSERT INTO users (username,email,password,enabled) VALUES ('neel','n@gmail.com','$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK',true);


INSERT INTO user_roles (userid, role)
VALUES (001, 'ROLE_USER');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_roles (userid, role)
VALUES (002, 'ROLE_USER');