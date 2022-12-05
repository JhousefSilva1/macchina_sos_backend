-- insertar datos en tabla macchine_user, con passwordd hasheada
INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('JhousefSilva','878e7wqe47878dqc8787q','Jhousef','Silva','jhousef_silva@gmail.com','65578478','45641654',true,'JhousefSilva','127.0.0.1',now());

INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('CamilaPerez','878e7wqe47878dqc8787q','Camila','Perez','camila_perez@gmail.com','65578478','45641654',true,'CamilaPerez','127.0.0.1',now());

INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('JuanDiaz','878e7wqe47878dqc8787q','Juan','Diaz','juan_diaz@gmail.com','65578478','45641654',true,'JuanDiaz','127.0.0.1',now());

INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('MariaGomez','878e7wqe47878dqc8787q','Maria','Gomez','maria_gomez@gmail.com','65578478','45641654',true,'MariaPerez','127.0.0.1',now());

INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('JorgeSerrano','878e7wqe47878dqc8787q','Jorge','Serrano','jorge_Serrano','65578478','45641654',true,'JorgeSerrano','127.0.0.1',now());

INSERT INTO macchina_user (username, passwordd, named, lastnames, email, phone, dni, status, tx_username, tx_host, tx_date)
VALUES ('StephaniAntelo','878e7wqe47878dqc8787q','Stephani','Antelo','stephani_antelo@gmail.com','65578478','45641654',true,'StephaniAntelo','127.0.0.1',now());


-- insertar datos para los grupos

INSERT INTO macchina_group (named, description, status, tx_username, tx_host, tx_date)
VALUES ('Administrador','Grupo de administradores',true,'JhousefSilva','127.0.0.1',now());

INSERT INTO macchina_group (named, description, status, tx_username, tx_host, tx_date)
VALUES ('Cliente','Grupo de clientes',true,'JhousefSilvaz','127.0.0.1',now());

INSERT INTO macchina_group (named, description, status, tx_username, tx_host, tx_date)
VALUES ('Mecanico','Grupo de mecanicos',true,'JhousefSilva','127.0.0.1',now());



-- insertar datos para los roles

INSERT INTO macchina_rol (named, description, status, tx_username, tx_host, tx_date)
VALUES ('CREAR_ORDEN', null, true, 'JhousefSilva', '127.0.0.1)', now());

INSERT INTO macchina_rol (named, description, status, tx_username, tx_host, tx_date)
VALUES ('LERR_ORDEN', null, true, 'JhousefSilva', '127.0.0.1)', now());

INSERT INTO macchina_rol (named, description, status, tx_username, tx_host, tx_date)
VALUES ('CREAR_USUARIO', null, true, 'JhousefSilva', '127.0.0.1)', now());

-- ASGINAR ROLES A GRUPOS

--ROLES DE ADMINISTRADOR
INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (1, 1, true, 'JhousefSilva', '127.0.0.1', now());

INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (1, 2, true, 'JhousefSilva', '127.0.0.1', now());

INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (1, 3, true, 'JhousefSilva', '127.0.0.1', now());

--ROLES DE CLIENTE
INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (2, 1, true, 'JhousefSilva', '127.0.0.1', now());

INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (2, 2, true, 'JhousefSilva', '127.0.0.1', now());

--ROLES DE MECANICO

INSERT INTO macchina_group_rol (group_id, rol_id, status, tx_username, tx_host, tx_date)
VALUES (3, 2, true, 'JhousefSilva', '127.0.0.1', now());

--AGREGAR USUARIOS A LOS GRUPOS

INSERT INTO macchina_user_group (user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (1, 1, true, 'JhousefSilva', '127.0.0.1', now());

INSERT INTO macchina_user_group (user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (2, 2, true, 'CamilaPerez', '127.0.0.1', now());

INSERT INTO macchina_user_group (user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (3, 2, true, 'JuanDiaz', '127.0.0.1', now());

SELECT mac.named,mac.description
    FROM
        macchina_user usr
            LEFT JOIN  macchina_user_group mug on usr.user_id = mug.user_id
            LEFT JOIN  macchina_group mg on mug.group_id = mg.group_id
            LEFT JOIN  macchina_group_rol mgr on mg.group_id = mgr.group_id
            LEFT JOIN  macchina_rol mac on mgr.rol_id = mac.rol_id
WHERE
        usr.username = 'JhousefSilva';



