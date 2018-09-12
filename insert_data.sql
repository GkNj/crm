-- user 表数据

INSERT INTO crm.user (id, name, password, position, sex, username) VALUES (79, '123', '$2a$10$yVsPxxB3QEZYnoHlK83ojuL2ic0kzkp.jCwpqwedpyhrO6Kl5OzsO', 'ROOT', '女', '1713010101');
INSERT INTO crm.user (id, name, password, position, sex, username) VALUES (32, 'Root', '$2a$10$1Mh01qeGRtBSHX0ERnRspOipzy4FFT0z.fPkG2ogIQwTGXnIL1bHu', 'ROOT', '男', 'root');
-- role 数据
INSERT INTO crm.role (id, name, introduction) VALUES (1, 'ROOT', '超级管理员');
INSERT INTO crm.role (id, name, introduction) VALUES (2, 'ADMIN', '系统管理');
INSERT INTO crm.role (id, name, introduction) VALUES (3, 'AM', '客户经理');
INSERT INTO crm.role (id, name, introduction) VALUES (4, 'SA', '销售主管');
INSERT INTO crm.role (id, name, introduction) VALUES (5, 'SM', '高管');
INSERT INTO crm.role (id, name, introduction) VALUES (0, 'NULL', '为止职位');

-- user_role 表
INSERT INTO crm.user_role (id, ur_role_id, ur_user_id) VALUES (80, 1, 79);
INSERT INTO crm.user_role (id, ur_role_id, ur_user_id) VALUES (1, 1, 32);