-- Datos de prueba para la tabla macchine_user

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Jose', '8392748932yd2h23y892y8rur238ru230', true, 'admin', '127.0.0.1',now());

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Maria', '2r23r3223yd2h23y892y8rur238ru230', true, 'admin', '127.0.0.1', now());

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Pedro', '2r23r3223yd2h23y892y8rur238ru230', true, 'admin', '127.0.0.1', now());

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Juan', '2r23r3223yd2h23y892y8rur238ru230', true, 'admin', '127.0.0.1', now());

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Luis', '2r23r3223yd2h23y892y8rur238ru230', true, 'admin', '127.0.0.1', now());

INSERT INTO  macchina_user ( username, passwrod, status, tx_username, tx_host, tx_date)
VALUES ( 'Jose', '8392748932yd2h23ydd892y8rur238ru230', true, 'admin', '127.0.0.1',now());

-- insertar datos para los grupo

INSERT INTO  maccine_group (name, description, status, tx_username, tx_host, tx_date)
VALUES ('Administrador', 'Grupo de administrador', true, 'admin', '127.0.0.1', now());

INSERT INTO  maccine_group (name, description, status, tx_username, tx_host, tx_date)
VALUES ('Mecanicos', 'Grupo de mecanicos', true, 'admin', '127.0.0.1', now());

INSERT INTO  maccine_group (name, description, status, tx_username, tx_host, tx_date)
VALUES ('Conductores', 'Grupo de conductores', true, 'admin', '127.0.0.1', now());

INSERT INTO  maccine_group (name, description, status, tx_username, tx_host, tx_date)
VALUES ('Clientes', 'Grupo de Clientes', true, 'admin', '127.0.0.1', now());


-- insertar datos para los roles

INSERT INTO  macchine_rol (name, description, status, tx_username, tx_host, tx_date)
VALUES ('CREAR_ORDEN', null, true, 'admin', '127.0.0.1', now());

INSERT INTO  macchine_rol (name, description, status, tx_username, tx_host, tx_date)
VALUES ('LEER_ORDEN', null, true, 'admin', '127.0.0.1', now());

INSERT INTO  macchine_rol (name, description, status, tx_username, tx_host, tx_date)
VALUES ('CREAR_USUARIO', null, true, 'admin', '127.0.0.1', now());

 --ASIGNAR ROLES A GRUPOS
INSERT INTO macchine_group_rol (group_id,rol_id,status, tx_username, tx_host, tx_date)
VALUES (1,1,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_group_rol (group_id,rol_id,status, tx_username, tx_host, tx_date)
VALUES (4,1,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_group_rol (group_id,rol_id,status, tx_username, tx_host, tx_date)
VALUES (2,2,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_group_rol (group_id,rol_id,status, tx_username, tx_host, tx_date)
VALUES (3,2,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_group_rol (group_id,rol_id,status, tx_username, tx_host, tx_date)
VALUES (4,3,true, 'admin', '127.0.0.1', now());


-- ASIGBAR USUARIOS A GRUPOS

INSERT INTO macchine_user_group (user_id,group_id,status, tx_username, tx_host, tx_date)
VALUES (1,1,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_user_group (user_id,group_id,status, tx_username, tx_host, tx_date)
VALUES (2,2,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_user_group (user_id,group_id,status, tx_username, tx_host, tx_date)
VALUES (3,3,true, 'admin', '127.0.0.1', now());

INSERT INTO macchine_user_group (user_id,group_id,status, tx_username, tx_host, tx_date)
VALUES (4,4,true, 'admin', '127.0.0.1', now());


--PROBAMOS LA CONSULTA

SELECT mr.name, mr.description
    FROM
           macchina_user usr
                LEFT JOIN macchine_user_group mug on usr.user_id = mug.user_id
                LEFT JOIN maccine_group mg on mug.group_id = mg.group_id
                LEFT JOIN macchine_group_rol mgr on mg.group_id = mgr.group_id
                LEFT JOIN macchine_rol mr on mgr.rol_id = mr.rol_id
WHERE
    usr.username = 'Jose';