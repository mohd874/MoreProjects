/*
Created		2/6/2006
Modified		3/18/2006
Project		
Model		
Company		
Author		
Version		
Database		mySQL 4.0 
*/




drop table IF EXISTS sysuser;
drop table IF EXISTS shops;
drop table IF EXISTS services;
drop table IF EXISTS service_schedule;
drop table IF EXISTS rooms;
drop table IF EXISTS reservation_history;
drop table IF EXISTS facilities;
drop table IF EXISTS events;
drop table IF EXISTS event_schedule;
drop table IF EXISTS employees;
drop table IF EXISTS Customers;
drop table IF EXISTS customer_reservation;




Create table customer_reservation (
	reservation_id Int NOT NULL,
	arrival_date Date NOT NULL,
	depart_date Date NOT NULL,
	flight_number Varchar(5),
	confirmation Char(1),
	note Varchar(255),
	credit_card_no Int NOT NULL,
	credit_card_type Varchar(20) NOT NULL,
	credit_card_exp_month Int NOT NULL,
	credit_card_exp_year Int NOT NULL,
	customer_id Int NOT NULL,
	room_id Int NOT NULL,
 Primary Key (reservation_id),
 Index IX_Relationship1 (customer_id),
 Foreign Key (customer_id) references Customers (customer_id) on delete no action on update no action,
 Index IX_Relationship13 (room_id),
 Foreign Key (room_id) references rooms (room_id) on delete no action on update no action
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table Customers (
	customer_id Int NOT NULL,
	title Char(20) NOT NULL,
	fax Int,
	e_mail Varchar(50) NOT NULL,
 Primary Key (customer_id)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table employees (
	employee_id Int NOT NULL,
	job_title Varchar(20) NOT NULL,
	marital_status Char(20) NOT NULL,
	gender Char(20) NOT NULL,
	years_of_exp Varchar(50) NOT NULL,
	service_no Int NOT NULL,
 Primary Key (employee_id),
 Index IX_Relationship18 (service_no),
 Foreign Key (service_no) references services (service_no) on delete no action on update no action
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table event_schedule (
	appointment_no Int NOT NULL,
	date_from Date NOT NULL,
	date_to Date NOT NULL,
	comment Varchar(255),
	total_price Int,
	description Varchar(255),
	customer_id Int NOT NULL,
	facility_no Int NOT NULL,
	event_id Int NOT NULL,
 Primary Key (appointment_no),
 Index IX_Relationship10 (customer_id),
 Foreign Key (customer_id) references Customers (customer_id) on delete no action on update no action,
 Index IX_Relationship11 (facility_no),
 Foreign Key (facility_no) references facilities (facility_no) on delete no action on update no action,
 Index IX_Relationship20 (event_id),
 Foreign Key (event_id) references events (event_id) on delete no action on update no action
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table events (
	event_id Int NOT NULL,
	event_type Varchar(15) NOT NULL,
	event_desc Varchar(255) NOT NULL,
	event_price Int NOT NULL,
 Primary Key (event_id)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table facilities (
	facility_no Int NOT NULL,
	facility_type Varchar(20) NOT NULL,
	facility_desc Char(255) NOT NULL,
 Primary Key (facility_no)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table reservation_history (
	reservation_id Int NOT NULL,
	arrival_date Date NOT NULL,
	depart_date Date NOT NULL,
	flight_number Varchar(5),
	confirmation Char(1),
	note Varchar(255),
	credit_card_no Int NOT NULL,
	credit_card_type Varchar(20) NOT NULL,
	credit_card_exp_month Int NOT NULL,
	credit_card_exp_year Int NOT NULL,
	customer_id Int NOT NULL,
	room_id Int NOT NULL,
 Primary Key (reservation_id)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table rooms (
	room_id Int NOT NULL,
	room_number Varchar(7) NOT NULL,
	room_type Varchar(15) NOT NULL,
	room_price Int,
	room_view Varchar(20),
 Primary Key (room_id)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table service_schedule (
	order_id Int NOT NULL,
	date Date NOT NULL,
	time Time NOT NULL,
	description Varchar(255),
	job_done Char(20),
	reservation_id Int NOT NULL,
	employee_id Int NOT NULL,
	service_no Int NOT NULL,
 Primary Key (order_id),
 Index IX_Relationship15 (reservation_id),
 Foreign Key (reservation_id) references customer_reservation (reservation_id) on delete no action on update no action,
 Index IX_Relationship19 (employee_id),
 Foreign Key (employee_id) references employees (employee_id) on delete no action on update no action,
 Index IX_Relationship21 (service_no),
 Foreign Key (service_no) references services (service_no) on delete no action on update no action
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table services (
	service_no Int NOT NULL,
	service_type Varchar(20) NOT NULL,
	service_desc Varchar(255) NOT NULL,
 Primary Key (service_no)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table shops (
	shop_no Int NOT NULL,
	shop_name Varchar(20) NOT NULL,
	shop_pic Varchar(50),
	descr Varchar(255),
	url Varchar(50),
 Primary Key (shop_no)
) TYPE = MyISAM
ROW_FORMAT = Default;

Create table sysuser (
	user_id Int NOT NULL,
	user_name Varchar(20) NOT NULL,
	password Varchar(20) NOT NULL,
	name Varchar(20) NOT NULL,
	surname Varchar(20) NOT NULL,
	phone_number Int,
	mobile_number Int NOT NULL,
	address Varchar(100) NOT NULL,
	passport_number Varchar(20) NOT NULL,
	p_o_box Varchar(7),
	nationality Varchar(20) NOT NULL,
 Primary Key (user_id)
) TYPE = MyISAM
ROW_FORMAT = Default;









