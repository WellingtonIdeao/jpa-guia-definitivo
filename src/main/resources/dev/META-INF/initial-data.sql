insert into tab_proprietario (codigo, nome) values (1, 'Fernando Martins');
insert into tab_proprietario (codigo, nome) values (2, 'Isabela Santos');
insert into tab_proprietario (codigo, nome) values (3, 'Ulisses Silva');

insert into proprietario_telefone (proprietario_codigo, telefone_numero) values (1, '99 9 1111 1111');
insert into proprietario_telefone (proprietario_codigo, telefone_numero) values (2, '99 9 2222 2222');
insert into proprietario_telefone (proprietario_codigo, telefone_numero) values (3, '99 9 3333 3333');

insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('AAA','1111', 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL', sysdate(), 1);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('BBB','2222', 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA', sysdate(), 2);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('CCC', '3333', 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(), 3);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('DDD', '4444', 'Ford', 'Ka', 2018, 2019, 27000, 'BICOMBUSTIVEL', sysdate(), 1);

insert into acessorio (codigo, descricao) values (1, 'Direção hidráulica');
insert into acessorio (codigo, descricao) values (2, 'Alarme');
insert into acessorio (codigo, descricao) values (3, 'Ar condicionado');
insert into acessorio (codigo, descricao) values (4, "Bancos de couro");

insert into veiculo_acessorio (veiculo_placa, veiculo_cidade, acessorio_codigo) values ('AAA', '1111', 1);
insert into veiculo_acessorio (veiculo_placa, veiculo_cidade, acessorio_codigo) values ('AAA', '1111', 2);
insert into veiculo_acessorio (veiculo_placa, veiculo_cidade, acessorio_codigo) values ('AAA', '1111', 3);
insert into veiculo_acessorio (veiculo_placa, veiculo_cidade, acessorio_codigo) values ('AAA', '1111', 4);

insert into cliente (codigo, nome, bloqueado, limite_credito, renda_mensal) values (1,'Mariana Aguilar', false, 10000, 5000);
insert into cliente (codigo, nome, bloqueado, limite_credito, renda_mensal) values (2, 'Douglas Montes', false, 8000, 4500);

insert into funcionario (codigo, nome, cargo, salario) values (3,'Maria das Dores', 'Gerente', 8000);


insert into categoria (codigo, nome) values (1, 'Bebidas');

insert into produto (codigo, categoria_codigo, nome) values (1, 1, 'Água');
insert into produto (codigo, categoria_codigo, nome) values (2, 1, 'Refrigerante');
insert into produto (codigo, categoria_codigo, nome) values (3, 1, 'Cerveja');
