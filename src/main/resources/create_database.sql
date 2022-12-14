drop database if exists tintro;
create database tintro;
use tintro;

create table user (
	id bigint auto_increment primary key,
    phone varchar(255),
    password varchar(255),
    name varchar(255),
    date varchar(255),
    type int,
    quequan varchar(255),
    cmnd varchar(255),
    currentapart bigint
);

create table apartment (
	id bigint auto_increment primary key,
    tp varchar(255),
    quan varchar(255),
    phuong varchar(255),
    duong varchar(255),
    quequan varchar(255),
    dientich float,
    price float,
    wifi boolean,
    wc boolean,
    pet boolean,
    tudo boolean,
    kitchen boolean,
    ac boolean,
    fridge boolean,
    washing boolean,
    number int,
    max_number int,
    title varchar(255),
    name_owner varchar(255),
    phone varchar(255),
    descript varchar(255),
    password varchar(255),
    owner bigint
);

create table apartment_application (
	id bigint auto_increment primary key,
    user_id bigint,
    apartment_id bigint
);

create table car(
    id bigint auto_increment primary key,
    name varchar(255),
    status boolean,
    veri boolean,
    user_id bigint
);

create table service_application (
	id bigint auto_increment primary key,
    apartment_id bigint,
    type varchar(255),
    day1 varchar(255),
    day2 varchar(255),
    car_id bigint,
    user_id bigint
);

create table bill(
    id bigint auto_increment primary key,
    bienlai bigint,
    content_one varchar(255),
    price_one bigint,
    service_one varchar(255),
    price_service bigint,
    user_id bigint,
    date varchar(255),
    status boolean
);

insert into user(phone,password,name,date,type,quequan,cmnd,currentapart)
values ("1111","1111","Le thanh nam","08/07/2001",1,"TPHCM","12/31 Tp HCM",1),
    ("2222","2222","Nguyen qua nam","08/07/2001",2,"TPHCM","12/31 Tp HCM",null),
    ("3333","2222","Nguyen cong chi","08/07/2001",1,"TPHCM","12/31 Tp HCM",null);

insert into apartment(tp,quan,phuong,duong,quequan,dientich,price,wifi,wc,pet,tudo,kitchen,ac,fridge,washing,number,max_number,title,name_owner,phone,descript,password,owner)
values ("TPHCM","12","Chi linh","Au Co","Lac Hong",2000,2000000,1,1,0,0,1,1,0,0,2,4,"Sweet home","Nguyen qua nam","2222","Greater home","44448888",2);

insert into apartment_application(user_id,apartment_id)
values (3,1);

insert into car(name,status,veri,user_id)
values ("AD-07-12",1,1,1);

insert into service_application(apartment_id,type,day1,day2,car_id,user_id)
values (1,"Đăng ký wifi","12/12/2022","12/1/2023",null,1),
    (1,"Đăng ký giữ xe","12/12/2022","12/1/2023",1,1),
    (1,"Đăng ký dọn phòng","12/12/2022",null,null,1);


alter table user
add constraint fk_user_apart foreign key (currentapart) references apartment(id);

alter table apartment
add constraint fk_owner_apartment foreign key (owner) references user(id);

alter table apartment_application
add constraint fk_apartment_application_user foreign key (user_id) references user(id);

alter table apartment_application
add constraint fk_apartment_application_apart foreign key (apartment_id) references apartment(id);

alter table car
add constraint fk_car_owner foreign key (user_id) references user(id);

alter table service_application
add constraint fk_1 foreign key (user_id) references user(id);

alter table service_application
add constraint fk_2 foreign key (apartment_id) references apartment(id);

alter table service_application
add constraint fk_service_application_car foreign key (car_id) references car(id);

alter table bill
add constraint fk_bill foreign key (user_id) references user(id);

