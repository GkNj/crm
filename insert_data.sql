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

//product表

INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (1, '联想Z5', 1, '台', 1399, 0, 0.4);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (2, '荣耀8X', 9, '台', 1999, 0, 0.32);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (3, 'oppoR17', 8, '台', 3499, 0, -0.26);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (4, '华为nova3i', 8, '台', 1999, 0, 0.2);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (5, '华为Mate10', 4, '台', 3299, 0, 0.12);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (6, '华为P20', 1, '台', 3388, 0, -0.17);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (7, '小米 红米Note', 6, '台', 1099, 0, -0.16);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (8, 'iPhone8', 5, '台', 4768, 0, 0.3);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (9, 'iPhoneXS 512G', 2, '台', 12700, 0, -0.1);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (10, 'iPhoneXS 128G', 1, '台', 9599, 0, 0.21);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (11, 'iPhoneXS 256G', 13, '台', 10999, 0, 0.1);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (12, '公司卡', 14, '套', 10000, 0, -0.5);

//dictionary
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (1, '国家', '国家', 0, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (2, '客户等级', '客户等级', 0, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (3, '服务类型', '服务类型', 0, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (4, '用户类型', '用户类型', 0, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (5, '销售经理', '销售经理', 4, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (6, '高管', '高管', 4, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (7, '客户经理', '客户经理', 4, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (8, '系统管理员', '系统管理员', 4, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (9, '普通客户', '普通客户', 2, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (10, '重点开发客户', '重点开发客户', 2, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (11, '大客户', '大客户', 2, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (12, '合作伙伴', '合作伙伴', 2, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (13, '战略合作伙伴', '战略合作伙伴', 2, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (14, '客户满意度', '客户满意度', 0, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (15, '', '1', 14, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (16, '', '2', 14, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (17, '', '3', 14, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (18, '', '4', 14, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (19, '', '5', 14, 0);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (20, '咨询', '咨询', 3, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (21, '建议', '建议', 3, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (22, '投诉', '投诉', 3, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (23, '中国', '中国', 1, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (24, '美国', '美国', 1, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (25, '北京市', '北京市', 23, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (26, '四川省', '四川省', 23, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (27, '山西省', '山西省', 23, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (28, '朝阳区', '朝阳区', 25, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (29, '海淀区', '海淀区', 25, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (30, '昌平区', '昌平区', 25, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (31, '成都市', '成都市', 26, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (32, '乐山市', '乐山市', 26, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (33, '太原市', '太原市', 27, 1);
INSERT INTO crm.dictionary (id, type_key, type_value, p_id, editable) VALUES (34, '晋城市', '晋城市', 27, 1);

//stock

INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (1, '联想Z5', 1, '台', 1399, 0, 0.4);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (2, '荣耀8X', 9, '台', 1999, 0, 0.32);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (3, 'oppoR17', 8, '台', 3499, 0, -0.26);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (4, '华为nova3i', 8, '台', 1999, 0, 0.2);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (5, '华为Mate10', 4, '台', 3299, 0, 0.12);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (6, '华为P20', 1, '台', 3388, 0, -0.17);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (7, '小米 红米Note', 6, '台', 1099, 0, -0.16);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (8, 'iPhone8', 5, '台', 4768, 0, 0.3);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (9, 'iPhoneXS 512G', 2, '台', 12700, 0, -0.1);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (10, 'iPhoneXS 128G', 1, '台', 9599, 0, 0.21);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (11, 'iPhoneXS 256G', 13, '台', 10999, 0, 0.1);
INSERT INTO crm.product (p_id, p_name, p_num, p_unit, p_price, o_id, fluctuation) VALUES (12, '公司卡', 14, '套', 10000, 0, -0.5);

//stock
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (1, '联想Z5', '本部总仓', '3-16', 521, '销量火爆，急需补货');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (2, '联想Z5', '华北商场', '2-90', 520, '急需补货');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (3, '联想Z5', '西南商场', '4-65', 1314, '急需补货');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (4, 'oppoR17', '本部总仓', '1-84', 232, '');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (5, 'oppoR17', '华北商场', '1-72', 256, '');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (6, 'oppoR17', '西南商场', '4-93', 436, '');
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (7, '荣耀8X', '本部总仓', '3-41', 568, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (8, '荣耀8X', '华北商场', '4-59', 321, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (9, '荣耀8X', '西南商场', '8-93', 242, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (10, 'iPhoneXS 512G', '华北商场', '2-69', 356, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (11, 'iPhoneXS 512G', '西南商场', '6-57', 235, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (12, 'iPhoneXS 128G', '本部总仓', '7-34', 558, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (13, 'iPhoneXS 256G', '西南商场', '1-09', 124, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (14, '华为P20', '华北商场', '8-49', 235, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (15, '华为P20', '西南商场', '9-24', 589, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (16, '公司卡', '本部总仓', '2-45', 223, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (17, '公司卡', '华北商场', '4-56', 246, null);
INSERT INTO crm.stock (s_id, s_name, s_address, s_position, s_num, s_note) VALUES (18, '公司卡', '西南商场', '6-78', 468, null);