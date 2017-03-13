USE `temp`;

insert into ROLES (ROLE_NAME) values ('USER');
insert into ROLES (ROLE_NAME) values ('ADMIN');

insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('System_Programmer', 'sysprog', '$2a$11$NKNItd8V/02afxJVGhFouefDE3R8YttZ0moUAA0.Grwu.keU7qE32');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('Admin', 'admin', '$2a$11$iXOUawTHBNAswdVWdHF9EuveOseXTB88egGfzBb.9Y.T.96ipQrte');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('QwertyUser', 'qwerty', '$2a$11$mYwze2v1YQgcj7kwvXLkOOWgwqwMwimWVaCloEzA0ibfLLEYcgxXm');

insert into SESSIONS (SESSION_USER_ID, FILES_QUANTITY, FILES_SORT, FILES_ASCEND, USER_LOCALE) values ('1', '10', 'id', 1, "en");
insert into SESSIONS (SESSION_USER_ID, FILES_QUANTITY, FILES_SORT, FILES_ASCEND, USER_LOCALE) values ('2', '10', 'id', 1, "ru");
insert into SESSIONS (SESSION_USER_ID, FILES_QUANTITY, FILES_SORT, FILES_ASCEND, USER_LOCALE) values ('3', '10', 'id', 1, "ru");


insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('1', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('2', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('3', '1');

insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_ballons.png', 'png', 'Ballons', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_bouquet.png', 'png', 'Flowers bouquet', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_cake.png', 'png', 'A cake is a lie!', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_chrome.png', 'png', 'Chrome browser', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_clock.png', 'png', 'Clock', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_cloud.png', 'png', 'Cloud', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_cross.png', 'png', 'God in his heaven, all right with the world!', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_firefox.png', 'png', 'Furryfox browser', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_folder.png', 'png', 'Folder', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_folder_1.png', 'png', 'Folder', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_gift.png', 'png', 'Gift', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_gift_1.png', 'png', 'Gift', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_gift_2.png', 'png', 'Gift', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_heart.png', 'png', 'Heart', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_home.png', 'png', 'Home', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_human.png', 'png', 'Human', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_ie.png', 'png', 'Internet Explo#5@!^...', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_mail.png', 'png', 'Mail', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_mail_1.png', 'png', 'Mail', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_maxthon.png', 'png', 'WhatIsIt?', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_netscape.png', 'png', 'Netscape browser', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_newfile.png', 'png', 'New file', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_next.png', 'png', 'Next', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_ok.png', 'png', 'Mkay...', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_opera.png', 'png', 'Opera browser', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_photo.png', 'png', 'Photo', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_plus.png', 'png', 'Plus', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_previous.png', 'png', 'Previous', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_rings.png', 'png', 'Jail cuffs', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_rose.png', 'png', 'Rose', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_safari.png', 'png', 'Safari browser', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_search.png', 'png', 'Search', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_settings.png', 'png', 'Settings', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_success.png', 'png', 'Success', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_talk.png', 'png', 'Talk', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_trash.png', 'png', 'Trash', '1', 1, 1);
insert into FILES (FILE_NAME, FILE_EXTENSION, FILE_ALT, FILE_AUTHOR, FILE_PUBLIC, FILE_NOT_DELETABLE) values ('innerResources/pic_volume.png', 'png', 'Volume', '1', 1, 1);

insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA) values ('database.label', 'ru', 'Хуйня');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA) values ('database.label', 'en', 'Hooynya');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.emptyField', 'ru', 'Поле не должно быть пустым', 'Форма логина - проверка на пустое поле');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.outOfBounds', 'ru', 'Количество символов логина должно быть от 6 до 32', 'Форма логина - проверка на логин');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.passOutOfBounds', 'ru', 'Количество символов пароля должно быть от 8 до 32', 'Форма логина - проверка на пароль');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.loginError', 'ru', 'Логин/пароль не найден', 'Форма логина - проверка на несовпадение данных с БД');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.alreadyExist', 'ru', 'Такой пользователь уже существует', 'Форма создания пользователя - проверка на занятость логина');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.passwordConfirmFalse', 'ru', 'Поля пароль и подтверждение пароля не совпадают', 'Форма создания пользователя - проверка на совпадение двух паролей');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractAccessDecisionManager.accessDenied', 'ru', 'Вход запрещён', 'Spring Message - 403 (Access denied)');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractUserDetailsAuthenticationProvider.onlySupports', 'ru', 'Only UsernamePasswordAuthenticationToken is supported', 'Special Spring Error Message');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractUserDetailsAuthenticationProvider.badCredentials', 'ru', 'Login or password is incorrect', 'Ошибка логина/пароля');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.uploadbutton', 'ru', 'Загрузить файл', 'кнопка загрузки файла');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.choosefilebutton', 'ru', 'Выбрать файл', 'кнопка выбора файла');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.uploadfilemessage', 'ru', 'Выберите файл на жёстком диске и нажмите кнопку загрузить', 'сообщение в меню загрузки');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.filenotchoosed', 'ru', 'Файл не выбран', 'сообщение в открывающимся окне');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.filenamelabel', 'ru', 'Пожалуйста, проименуйте файл для быстрого поиска', 'сообщение в лейбе имени файла');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filespage.filepubliclabel', 'ru', 'Открытый доступ всем?  ', 'сообщение в лейбе открытого доступа файла');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.searchbutton', 'ru', 'Искать', 'список файлов, название кнопки поиска');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.sortfilenamebutton', 'ru', 'Название', 'список файлов, название заголовка');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.sorttypebutton', 'ru', 'Тип', 'список файлов, название заголовка');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.sortuploaddatebutton', 'ru', 'Создан', 'список файлов, название заголовка');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.sortauthorbutton', 'ru', 'Автор', 'список файлов, название заголовка');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.changefilesquantity', 'ru', 'Показать', 'список файлов, название заголовка смены количества файлов');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.searchlabel', 'ru', 'Введите название или часть названия файла', 'лейба поиска файлов');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.searchformbutton', 'ru', 'Искать', 'кнопка поиска файлов');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('filessearchpage.returnbutton', 'ru', 'Вернуться назад', 'кнопка возвращения на страницу поиска файлов');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.firstbutton', 'ru', 'Первая', 'название первой страницы в списке страниц');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.lastbutton', 'ru', 'Последняя', 'название последней страницы в списке страниц');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('fileslistpage.uploadbutton', 'ru', 'Загрузить', 'название кнопки загрузки в списке кнопок');

