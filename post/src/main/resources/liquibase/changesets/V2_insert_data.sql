insert into users (id, name, username, password)
values ('1ce9d212-e7c1-4c8b-a779-fcab112f11b8', 'Kirill Davletshin', 'kirichka27@gmail.com', '123456'),
       ('d3f4f7cd-fbcd-40fb-9767-4c73daf11f1d', 'Mike Smith', 'mikesmith@yahoo.com', '123456');

insert into users_roles (user_id, role)
values ('1ce9d212-e7c1-4c8b-a779-fcab112f11b8', 'ROLE_ADMIN'),
       ('1ce9d212-e7c1-4c8b-a779-fcab112f11b8', 'ROLE_USER'),
       ('d3f4f7cd-fbcd-40fb-9767-4c73daf11f1d', 'ROLE_USER');