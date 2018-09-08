-- user 表数据

INSERT INTO crm.user (id, name, password, position, sex, username) VALUES (1, 'zs', '1234', '高管', '1', '123');
INSERT INTO crm.user (id, name, password, position, sex, username) VALUES (3, 'zs', '1234', '高管', '2', '1234');

-- role 数据
INSERT INTO crm.role (id, permission, name) VALUES (2, 1, 'ROOT');

-- user_roles 表
INSERT INTO crm.user_roles (ur_user_id, ur_role_id) VALUES (3, 2);
