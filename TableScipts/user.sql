create database freight_transport_region_user;

use freight_transport_region_user;

drop table if exists ftr_user;

create table ftr_user(
    user_id BigInt primary key,
    first_name varchar(30),
    last_name varchar(30),
    email_id varchar(30),
    mobile_number BigInt,
    password varchar(30),
    nationality varchar(30),
    passport_number varchar(30),
    permanent_address varchar(200),
    office_address varchar(200),
    personal_identification_number BigInt
);

insert into `freight_transport_region_user`.`ftr_user` (`user_id`,`first_name`,`last_name`,`email_id`,`mobile_number`,`password`,`nationality`,`passport_number`,`permanent_address`,`office_address`,`personal_identification_number`) values('10001', 'Annie', 'Thomas', 'anniethomas@gmail.com', '9090987890', 'anniethomas!12', 'Indian', 'A7878765', '195/12, Cross, Lalbagh Road, K S Garden, Bangalore', '16 Gandhibazaarmnrd, basavangudi, b-, Basavanagudi, Bangalore.', '676767898765');
insert into `freight_transport_region_user`.`ftr_user` (`user_id`,`first_name`,`last_name`,`email_id`,`mobile_number`,`password`,`nationality`,`passport_number`,`permanent_address`,`office_address`,`personal_identification_number`) values('10002', 'Mike', 'Hillyer', 'mikehillyer@yahoo.com', '9090456789', 'mikehillyer@12', 'Indian', 'H3489098', '261/67, Angappa Naick St, Parrys, Chennai', '260 Mint Street, Periamet, Chennai.', '345678902345');
insert into `freight_transport_region_user`.`ftr_user` (`user_id`,`first_name`,`last_name`,`email_id`,`mobile_number`,`password`,`nationality`,`passport_number`,`permanent_address`,`office_address`,`personal_identification_number`) values('10003', 'Jon', 'Stephens', 'jonstephens@gmail.com', '8767890654', 'jonstephens!12', 'Singapore', 'U7643289', 'Chao Chu Kang Crescent, Singapore', '1 SENGKANG SQUARE, #02-18 545078, Singapore.', '676767854323');
insert into `freight_transport_region_user`.`ftr_user` (`user_id`,`first_name`,`last_name`,`email_id`,`mobile_number`,`password`,`nationality`,`passport_number`,`permanent_address`,`office_address`,`personal_identification_number`) values('10004', 'Andrew', 'Fuller', 'andrewfuller@gmail.com', '7878787878', 'andrewfuller@12', 'Canada', 'F6829384', '955 Eglinton Avenue, Toronto, Canada', '3910 Wascana Parkway, Regina, Canada.', '676767898765');
insert into `freight_transport_region_user`.`ftr_user` (`user_id`,`first_name`,`last_name`,`email_id`,`mobile_number`,`password`,`nationality`,`passport_number`,`permanent_address`,`office_address`,`personal_identification_number`) values('10005', 'Nancy', 'Davolio', 'nancydavolio@gmail.com', '9879879876', 'nancydavolio#123', 'Australia', 'Z7967876', '45 Faulkner Street, BOOROLONG, New South Wales, Australia.','88 Maintongoon Road, MOE SOUTH, Victoria, Australia', '898909876543');

-- *************************************************************************************

Create database freight_transport_region_login;

use freight_transport_region_login;

drop table if exists ftr_login;

create table ftr_login(
    user_name varchar(30) primary key,
    password varchar(30)
);

insert into `freight_transport_region_login`.`ftr_login` (`user_name`,`password`) values("anniethomas@gmail.com", "anniethomas!12");
insert into `freight_transport_region_login`.`ftr_login` (`user_name`,`password`) values("mikehillyer@yahoo.com", "mikehillyer@12");
insert into `freight_transport_region_login`.`ftr_login` (`user_name`,`password`) values("jonstephens@gmail.com", "jonstephens!12");
insert into `freight_transport_region_login`.`ftr_login` (`user_name`,`password`) values("andrewfuller@gmail.com", "andrewfuller@12");
insert into `freight_transport_region_login`.`ftr_login` (`user_name`,`password`) values("nancydavolio@gmail.com", "nancydavolio#123" );
