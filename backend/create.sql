create table tb_category (id int8 generated by default as identity, description varchar(255), name varchar(255), primary key (id));
create table tb_investment (id int8 generated by default as identity, active varchar(255), purchase date, quota int4, value float8, fk_id_category int8, primary key (id));
alter table if exists tb_investment add constraint FK740ulo68u1p7bvktpn37m7n0c foreign key (fk_id_category) references tb_category;
