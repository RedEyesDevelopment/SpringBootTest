DROP DATABASE IF EXISTS `temp`;
CREATE DATABASE `temp` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `temp`;

DROP TABLE IF EXISTS `USERS`;
CREATE TABLE USERS (
    USER_ID BIGINT NOT NULL AUTO_INCREMENT,
    FULL_NAME VARCHAR(60) NOT NULL,
    USER_NAME VARCHAR(20) NOT NULL,
    PSWD VARCHAR(180) NOT NULL,
    US_CREATED TIMESTAMP NOT NULL DEFAULT NOW(),
    US_VIEWED_COUNT BIGINT NOT NULL DEFAULT 0,
    USER_ENABLED BIT NOT NULL DEFAULT 1,
    UNIQUE UNIQUE_USER_ID (USER_ID),
    UNIQUE UNIQUE_FULL_NAME (FULL_NAME),
    UNIQUE UNIQUE_USER_NAME (USER_NAME),
    PRIMARY KEY (USER_ID)
    );

DROP TABLE IF EXISTS `ROLES`;
CREATE TABLE ROLES (
    ROLE_ID INT NOT NULL AUTO_INCREMENT,
    ROLE_NAME VARCHAR(20) NOT NULL,
    UNIQUE UNIQUE_ROLE_ID (ROLE_ID),
    PRIMARY KEY (ROLE_ID)
    );

DROP TABLE IF EXISTS `USER_ROLES`;
CREATE TABLE USER_ROLES (
    UR_USER_ID BIGINT NOT NULL,
    UR_ROLE_ID INT NOT NULL,
    UR_CREATED TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE UNIQUE_USER_ROLES (UR_USER_ID, UR_ROLE_ID),
    FOREIGN KEY(UR_USER_ID) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
    FOREIGN KEY(UR_ROLE_ID) REFERENCES ROLES(ROLE_ID) ON DELETE CASCADE
    );

DROP TABLE IF EXISTS `INTERNATIONAL_MESSAGES`;
CREATE TABLE INTERNATIONAL_MESSAGES (
    INTERNATIONAL_MESSAGES_ID BIGINT NOT NULL AUTO_INCREMENT,
    IM_COMMENT VARCHAR(255),
    IM_CODE VARCHAR(80) NOT NULL,
    IM_LOCALE VARCHAR(15) NOT NULL,
    IM_DATA TEXT NOT NULL,
    UNIQUE UNIQUE_INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE),
    PRIMARY KEY (INTERNATIONAL_MESSAGES_ID)
);

DROP TABLE IF EXISTS `FILES`;
CREATE TABLE FILES (
    FILE_ID INT NOT NULL AUTO_INCREMENT,
    FILE_NAME VARCHAR(150) NOT NULL,
    FILE_EXTENSION VARCHAR(10),
    FILE_ALT VARCHAR(150) NOT NULL,
    FILE_UPLOADED TIMESTAMP NOT NULL DEFAULT NOW(),
    FILE_AUTHOR BIGINT NOT NULL,
    FILE_PUBLIC BIT NOT NULL DEFAULT 1,
    FILE_NOT_DELETABLE BIT NOT NULL DEFAULT 0,
    FOREIGN KEY(FILE_AUTHOR) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
    UNIQUE UQ_FILES_1 (FILE_ID),
    PRIMARY KEY (FILE_ID)
);

DROP TABLE IF EXISTS `SESSIONS`;
CREATE TABLE SESSIONS (
    SESSION_ID BIGINT NOT NULL AUTO_INCREMENT,
    SESSION_USER_ID BIGINT NOT NULL,
    FILES_QUANTITY INT NOT NULL,
    FILES_SORT VARCHAR(50) NOT NULL,
    FILES_ASCEND BIT NOT NULL DEFAULT 1,
    USER_LOCALE VARCHAR(6) NOT NULL,
    UNIQUE UQ_SESSIONS_1 (SESSION_ID, SESSION_USER_ID),
    PRIMARY KEY (SESSION_ID)
);

DROP TABLE IF EXISTS `NEWS`;
CREATE TABLE NEWS (
    NEWS_ID BIGINT NOT NULL AUTO_INCREMENT,
    NEWS_NAME VARCHAR(255) NOT NULL,
    NEWS_IMAGE INT,
    NEWS_DESCR VARCHAR(255) NOT NULL,
    NEWS_DATA TEXT NOT NULL,
    NEWS_AUTHOR BIGINT NOT NULL,
    NEWS_POSTED TIMESTAMP NOT NULL DEFAULT NOW(),
    NEWS_ENABLED BIT NOT NULL DEFAULT 0,
    FOREIGN KEY(NEWS_AUTHOR) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
    FOREIGN KEY(NEWS_IMAGE) REFERENCES FILES(FILE_ID) ON DELETE CASCADE,
    UNIQUE UNIQUE_NEWS (NEWS_ID),
    PRIMARY KEY (NEWS_ID)
);

DROP TABLE IF EXISTS `TAGS`;
CREATE TABLE TAGS (
    TAG_ID INT NOT NULL AUTO_INCREMENT,
    TAG_DATA VARCHAR(255) NOT NULL,
    UNIQUE UNIQUE_TAGS (TAG_ID, TAG_DATA),
    PRIMARY KEY (TAG_ID)
);

DROP TABLE IF EXISTS `NEWS_TAGS_MAG`;
CREATE TABLE NEWS_TAGS_MAG (
    NEWS_TAG_MAG_ID BIGINT NOT NULL AUTO_INCREMENT,
    TN_NEWS_ID BIGINT NOT NULL,
    TN_TAG_ID INT NOT NULL,
    UNIQUE UNIQUE_NEWS_TAGS_MAG (NEWS_TAG_MAG_ID, TN_NEWS_ID, TN_TAG_ID),
    PRIMARY KEY (NEWS_TAG_MAG_ID),
    KEY (TN_TAG_ID),
    KEY (TN_NEWS_ID),
    CONSTRAINT FK_TAGMAG_TAGS_1 FOREIGN KEY (TN_TAG_ID) REFERENCES TAGS (TAG_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_TAGMAG_NEWS_1 FOREIGN KEY (TN_NEWS_ID) REFERENCES NEWS (NEWS_ID) ON DELETE CASCADE ON UPDATE CASCADE
);