-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-05 02:37:36.743

-- tables
-- Table: macchina_user
CREATE TABLE macchina_user (
    user_id serial  NOT NULL,
    username varchar(200)  NOT NULL,
    passwordd varchar(200)  NOT NULL,
    named varchar(200)  NOT NULL,
    lastnames varchar(200)  NOT NULL,
    email varchar(400)  NOT NULL,
    phone int  NOT NULL,
    dni varchar(200)  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_user_pk PRIMARY KEY (user_id)
);

-- Table: macchine_group_rol
CREATE TABLE macchina_group_rol (
    group_role_id serial  NOT NULL,
    group_id int  NOT NULL,
    rol_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_group_rol_pk PRIMARY KEY (group_role_id)
);

-- Table: macchine_order
CREATE TABLE macchina_order (
    order_id serial  NOT NULL,
    customer_name varchar(200)  NOT NULL,
    customer_address varchar(200)  NOT NULL,
    customer_dni varchar(200)  NOT NULL,
    customer_order_date timestamp  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_order_pk PRIMARY KEY (order_id)
);

-- Table: macchine_order_detail
CREATE TABLE macchina_order_detail (
    order_datail_id serial  NOT NULL,
    order_id int  NOT NULL,
    vehicle_id int  NOT NULL,
    product_name varchar(400)  NOT NULL,
    unit_price decimal(15,5)  NOT NULL,
    qtty decimal(8,4)  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_order_detail_pk PRIMARY KEY (order_datail_id)
);

-- Table: macchine_rol
CREATE TABLE macchina_rol (
    rol_id serial  NOT NULL,
    status boolean  NOT NULL,
    named varchar(200)  NOT NULL,
    description varchar(400)  NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchine_rol_pk PRIMARY KEY (rol_id)
);

-- Table: macchine_user_group
CREATE TABLE macchina_user_group (
    user_group_id serial  NOT NULL,
    user_id int  NOT NULL,
    group_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_user_group_pk PRIMARY KEY (user_group_id)
);

-- Table: macchine_vehicles
CREATE TABLE macchina_vehicles (
    user_id int  NOT NULL,
    vehicle_id int  NOT NULL,
    brand varchar(200)  NOT NULL,
    model varchar(200)  NOT NULL,
    license_plate varchar(50)  NOT NULL,
    model_year int  NOT NULL,
    color int  NOT NULL,
    description varchar(400)  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_vehicles_pk PRIMARY KEY (vehicle_id)
);

-- Table: maccine_group
CREATE TABLE macchina_group (
    group_id serial  NOT NULL,
    named varchar(200)  NOT NULL,
    description varchar(400)  NULL,
    status boolean  NOT NULL,
    tx_username varchar(200)  NOT NULL,
    tx_host varchar(200)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT macchina_group_pk PRIMARY KEY (group_id)
);

-- foreign keys
-- Reference: macchine_group_rol_macchine_rol (table: macchine_group_rol)
ALTER TABLE macchina_group_rol ADD CONSTRAINT macchina_group_rol_macchina_rol
    FOREIGN KEY (rol_id)
    REFERENCES macchina_rol (rol_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_group_rol_maccine_group (table: macchine_group_rol)
ALTER TABLE macchina_group_rol ADD CONSTRAINT macchina_group_rol_macchina_group
    FOREIGN KEY (group_id)
    REFERENCES macchina_group (group_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_order_detail_macchine_order (table: macchine_order_detail)
ALTER TABLE macchina_order_detail ADD CONSTRAINT macchina_order_detail_macchina_order
    FOREIGN KEY (order_id)
    REFERENCES macchina_order (order_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_order_detail_macchine_vehicles (table: macchine_order_detail)
ALTER TABLE macchina_order_detail ADD CONSTRAINT macchina_order_detail_macchina_vehicles
    FOREIGN KEY (vehicle_id)
    REFERENCES macchina_vehicles (vehicle_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_user_group_macchina_user (table: macchine_user_group)
ALTER TABLE macchina_user_group ADD CONSTRAINT macchina_user_group_macchina_user
    FOREIGN KEY (user_id)
    REFERENCES macchina_user (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_user_group_maccine_group (table: macchine_user_group)
ALTER TABLE macchina_user_group ADD CONSTRAINT macchina_user_group_maccine_group
    FOREIGN KEY (group_id)
    REFERENCES macchina_group (group_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: macchine_vehicles_macchina_user (table: macchine_vehicles)
ALTER TABLE macchina_vehicles ADD CONSTRAINT macchina_vehicles_macchina_user
    FOREIGN KEY (user_id)
    REFERENCES macchina_user (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- End of file.

