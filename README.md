# KeksagrammSpringMVC

База данных PosrgreSQL

```SQL
CREATE TABLE IF NOT EXISTS app_user
(
    id        SERIAL PRIMARY KEY,
    user_name VARCHAR(128) NOT NULL,
    avatar    VARCHAR(255),
    f_name    VARCHAR(128) NOT NULL,
    l_name    VARCHAR(128) NOT NULL,
    e_mail    VARCHAR(128) NOT NULL
);
CREATE TABLE IF NOT EXISTS app_post
(
    id        SERIAL PRIMARY KEY,
    user_id   BIGINT REFERENCES app_user (id),
    post_head VARCHAR(128) NOT NULL,
    post_text VARCHAR(1024),
    post_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS app_photo
(
    id        SERIAL PRIMARY KEY,
    url       VARCHAR(255),
    user_id   BIGINT REFERENCES app_user (id),
    load_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS app_user_photos
(
    id        SERIAL PRIMARY KEY,
    photos_id BIGINT REFERENCES app_photo (id),
    user_id   BIGINT REFERENCES app_user (id)
);
CREATE TABLE IF NOT EXISTS app_user_posts
(
    id        SERIAL PRIMARY KEY,
    posts_id BIGINT REFERENCES app_post (id),
    user_id   BIGINT REFERENCES app_user (id)
);
INSERT INTO app_user (user_name, avatar, f_name, l_name, e_mail)
VALUES ('HermanVFX', DEFAULT, 'Herman', 'Makhiyanov', 'hermanvfx@outlook.com'),
       ('Natashechka', 'avatar_woman_default.png', 'Natali', 'Shumakova', 'natashechka2000@outlook.com');

INSERT INTO app_post (user_id, post_head, post_text)
VALUES (1,
        'The standard Lorem Ipsum passage, used since the 1500s',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
       (1,
        '1914 translation by H. Rackham',
        DEFAULT);
INSERT INTO app_photo (url, user_id)
VALUES ('photo_0001.jpg', 1),
       ('photo_0002.jpg', 1),
       ('photo_0003.jpg', 1),
       ('photo_0004.jpg', 1),
       ('photo_0005.jpg', 1),
       ('photo_0006.jpg', 1),
       ('photo_0007.jpg', 1),
       ('photo_0008.jpg', 1),
       ('photo_0009.jpg', 1),
       ('photo_0010.jpg', 2),
       ('photo_0011.jpg', 2),
       ('photo_0012.jpg', 2),
       ('photo_0013.jpg', 2),
       ('photo_0014.jpg', 2),
       ('photo_0015.jpg', 2),
       ('photo_0016.jpg', 2),
       ('photo_0017.jpg', 2),
       ('photo_0018.jpg', 2),
       ('photo_0019.jpg', 2),
       ('photo_0020.jpg', 2);
INSERT INTO app_user_photos (photos_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 2),
       (11, 2),
       (12, 2),
       (13, 2),
       (14, 2),
       (15, 2),
       (16, 2),
       (17, 2),
       (18, 2),
       (19, 2);
INSERT INTO app_user_posts (posts_id, user_id)
VALUES (1, 1),
       (2, 1);
```
