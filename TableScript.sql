-- ************************************************************************************

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
select * from ftr_user;
-- *************************************************************************************
Create database freight_transport_region_terminals;
use freight_transport_region_terminals;
drop table if exists ftr_terminals;
create table ftr_terminals(
    terminal_id varchar(20) primary key,
    terminal_name varchar(100),
    country varchar(30),
    item_type varchar(100),
    terminal_description varchar(200),
    capacity BigInt,
    available_capacity BigInt,
    status varchar(200),
    harborLocation varchar(30),
    country varchar(30)
);
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`, `harborLocation`, `country`) values("T1","Kakinada","India","Computer Hardware","T1-Computer Hardware","30000","10000","Available", "Chennai Port", "India");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T2","Hazira","India","Oil Container","T2-Oil Container","40000","10000","NotAvailable", "Paradip Port", "India");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T3","Klang","Singapore","Wood","T3-Wood","85000","78000","Available","Jurong", "Singapore");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T4","Saint John","Canada","Motorcycles","T4-Motorcycles","85000","73000","Available","Port Hawkesbury", "Canada");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capaci
ty`,`status`,`harborLocation`, `country`) values("T5","Brisbane","Australia","Electronics","T5-Electronics","50000","12000","NotAvailable","Sydney Harbor", "Australia");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T6","Haldia","India","Computer Hardware","T6-Computer Hardware","37500","19000","NotAvailable","Visakhapatnam Port", "India");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T7","Tanjung","Singapore","Oil Container","T7-Oil Container","89000","50000","Available","Tanjong Pagar", "Singapore");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T8","Busan","South Korea","Wood","T8-Wood","24900","9900","NotAvailable", "Busan Port", "South Korea");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminal_name`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T9","Montreal","Canada","Motorcycles","T9-Motorcycles","87000","24000","NotAvailable","Halifax", "Canada");
insert into `freight_transport_region_terminals`.`ftr_terminals` (`terminal_id`,`terminalName`,`country`,`item_type`,`terminal_description`,`capacity`,`available_capacity`,`status`,`harborLocation`, `country`) values("T10","Fremantle","Australia","Electronics","T10-Electronics","94700","20000","Available","Sydney Harbor", "Australia");
select * from ftr_terminals;
-- **********************************************************************************
Create database freight_transport_region_vehicles;
use freight_transport_region_vehicles;
drop table if exists ftr_vehicles;
create table ftr_vehicles(
    vehicle_number varchar(20) primary key,
    vehicle_name varchar(50),
    max_lifting_capacity BigInt,
    retire_date Date,
    vehicle_status varchar(30),
    harborLocation varchar(30),
    country varchar(30)
);
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("UE7890","Tower crane","19.8","2030-12-20","InProgress", "Chennai Port", "India");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("WK7876","Fireplace crane","7100","2022-01-21","InProgress", "Paradip Port", "India");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("DG8986","Double treadwheel crane","2.5","2025-03-22","InProgress","Jurong", "Singapore");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("VQ7890","Crawler crane","250","2030-12-23","InProgress","Port Hawkesbury", "Canada");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("BH2343","Aerial crane","1000","2022-01-21","InProgress","Sydney Harbor", "Australia");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("NM1012","Fireplace crane","2.5","2025-03-22","InActive","Visakhapatnam Port", "India");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("SD3456","Double treadwheel crane","3","2030-12-26","Active","Tanjong Pagar", "Singapore");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("CT7867","Crawler crane","550","2024-05-27","InActive", "Busan Port", "South Korea");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("ER5849","Deck crane","40","2032-09-28","Active","Halifax", "Canada");
insert into `freight_transport_region_vehicles`.`ftr_vehicles` (`vehicle_number`,`vehicle_name`,`max_lifting_capacity`,`retire_date`,`vehicle_status`,`harborLocation`, `country`) values("KY8876","Tower crane","19.8","2030-06-29","InActive","Sydney Harbor", "Australia");
select * from ftr_vehicles;
-- ************************************************************************************
create database freight_transport_region_workitems;
use freight_transport_region_workitems;
drop table if exists ftr_workitems;
create table ftr_workitems(
workitem_id varchar(20) primary key,
    user_id BigInt,
    item_name varchar(200),
    item_type varchar(200),
    item_description varchar(200),
    message_to_recipient varchar(200),
    quantity varchar(100),
    source_country varchar(30),
    destination_country varchar(30),
    originHarborLocation varchar(30),
    selected_harbor_location varchar(200),
    shipping_date Date,
    amount BigInt
);
insert into `freight_transport_region_workitems`.`ftr_workitems` (`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values ("J2012","10001", "UPS", "Computer Hardware", "Luminous Inverter battery", "Please confirm once received.", "7500", "India", "Singapore", "Tanjong Pagar", "2020-08-12", "119992500");
insert into `freight_transport_region_workitems`.`ftr_workitems` (`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values ('J2013','10002', 'Aviation Turbine Fuel', 'Oil Container', 'Fuel for Jet', 'Please confirm once received.', '9200 litre', 'Singapore', 'Malaysia', 'Johor Port', '2020-08-24', '207368');
insert into `freight_transport_region_workitems`.`ftr_workitems` (`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values ('J2014','10003', 'Round pole milling machine', 'Wood', 'EMTEX 20mm Drilling and Milling Machine DM20', 'Please confirm once received.', '1500', 'India', 'Australia', 'Sydney Harbor', '2020-10-17', '195000000');
insert into `freight_transport_region_workitems`.`ftr_workitems` (`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values ('J2015','10004', 'Honda Dio', 'Motorcycles', 'Honda', 'Please confirm once received.', '1331', 'India', 'Canada', 'Port Hawkesbury', '2020-11-04', '84300216');
insert into `freight_transport_region_workitems`.`ftr_workitems` (`workitem_id`,`user_id`,`item_name`,`item_type`,`item_description`,`message_to_recipient`,`quantity`,`source_country`,`destination_country`,`selected_harbor_location`,`shipping_date`,`amount`) values ('J2016','10005', 'Washing Machine', 'Electronics', 'Whirlpool 6.5 Kg Fully-Automatic Top Load', 'Please confirm once received.', '3000','India', 'Singapore', 'Jurong', '2020-11-09', '40470000');
select * from ftr_workitems;
-- *********************************************************************************
drop table if exists ftr_workitem_terminal;
create table ftr_workitem_terminal(
    workitem_id varchar(10) primary key,
    terminal_id varchar(10)
);
insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`) values('J2012','T1');
insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`) values('J2013','T2');
insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`) values('J2016','T5');
insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`) values('J2014','T7');
insert into `freight_transport_region_workitems`.`ftr_workitem_terminal` (`workitem_id`, `terminal_id`) values('J2015','T9');
select * from ftr_workitem_terminal;
-- *************************************************************************************
drop table if exists ftr_vehicle_workItem;
create table ftr_vehicle_workItem(
    workitem_id varchar(20) primary key,
    vehicle_number varchar(20),
    driver_id varchar(20),
    assigned_workitem_status varchar(20)
);
insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem` (`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`) values('J2012','UE7890','D111','InProgress');
insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem` (`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`) values('J2013','WK7876','D112','InProgress');
insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem` (`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`) values('J2014','DG8986','D113','Completed');
insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem` (`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`) values('J2015','VQ7890','D114','InProgress');
insert into `freight_transport_region_workitems`.`ftr_vehicle_workitem` (`workitem_id`,`vehicle_number`,`driver_id`,`assigned_workitem_status`) values('J2016','BH2343','D115','Completed');
select * from ftr_vehicle_workitem;
-- *************************************************************************************
drop table if exists ftr_harbor;
create table ftr_harbor(
    country varchar(30) primary key,
    available_harbor_locations varchar(200)
);
insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`) values('Singapore', 'Tanjong Pagar, Jurong');
insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`) values('Malaysia', 'Johor Port, Puteri, Telaga Harbor, Marina, Penang');
insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`) values('Australia', 'Sydney Harbor');
insert into `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`) values('Canada', 'Port Hawkesbury, Halifax');
INSERT INTO `freight_transport_region_workitems`.`ftr_harbor` (`country`, `available_harbor_locations`) VALUES ('France', 'Old Port Of Marseille, Grand Port Maritime of Dunkirk');
select * from ftr_harbor;
commit;
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
select * from ftr_login;
-- *************************************************************************************