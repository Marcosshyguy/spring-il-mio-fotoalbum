INSERT INTO db_photographer.categories (`type`) VALUES('selfie');
INSERT INTO db_photographer.categories (`type`) VALUES('landscape');
INSERT INTO db_photographer.categories (`type`) VALUES('passport photo');
INSERT INTO db_photographer.categories (`type`) VALUES('wedding');
INSERT INTO db_photographer.categories (`type`) VALUES('graduation');
INSERT INTO db_photographer.categories (`type`) VALUES('artistic');

INSERT INTO db_photographer.pics (description, title, url, visible) VALUES('couple with a sunset', 'marriage', 'https://i.pinimg.com/originals/d9/f6/7f/d9f67f261471c700ea9765f61ddc979e.jpg', 1);
INSERT INTO db_photographer.pics (description, title, url, visible) VALUES('real Java spotted', 'Java', 'https://italy.armymwr.com/application/files/5616/1461/3153/vz_bod_java_coffee_beans_scoop_750x421_mar21.jpg', 1);
INSERT INTO db_photographer.pics (description, title, url, visible) VALUES('', 'Woody\'s selfie', 'https://www.corriere.it/methode_image/2018/05/24/Tecnologia/Foto%20Tecnologia%20-%20Trattate/selfie-woody-toy-story-k6ZF-U43490714368647cI-593x443@Corriere-Web-Sezioni.jpg', 0);

INSERT INTO db_photographer.category_pic (pic_id, category_id) VALUES(2, 1);
INSERT INTO db_photographer.category_pic (pic_id, category_id) VALUES(2, 4);
INSERT INTO db_photographer.category_pic (pic_id, category_id) VALUES(2, 6);
INSERT INTO db_photographer.category_pic (pic_id, category_id) VALUES(3, 1);

INSERT INTO db_photographer.roles (name) VALUES('ADMIN');
INSERT INTO db_photographer.roles (name) VALUES('GUEST');

INSERT INTO db_photographer.users (email, password, username) VALUES('thegmarco@yahoo.it', '{noop}abcd', 'marco');
INSERT INTO db_photographer.users (email, password, username) VALUES('thepmarco@yahoo.it', '{noop}1234', 'ferrari');

INSERT INTO db_photographer.user_role (user_id, role_id) VALUES(1, 1);
INSERT INTO db_photographer.user_role (user_id, role_id) VALUES(2, 2);
















