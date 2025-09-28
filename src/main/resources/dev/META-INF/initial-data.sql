insert into tab_proprietario (codigo, nome, telefone) values (1, 'Fernando Martins', '99 9 1111 1111');
insert into tab_proprietario (codigo, nome, telefone) values (2, 'Isabela Santos', '99 9 2222 2222');
insert into tab_proprietario (codigo, nome, telefone) values (3, 'Ulisses Silva', '99 9 3333 3333');

insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('AAA','1111', 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL', sysdate(), 1);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('BBB','2222', 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA', sysdate(), 2);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('CCC', '3333', 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(), 3);
insert into tab_veiculo (placa, cidade, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('DDD', '4444', 'Ford', 'Ka', 2018, 2019, 27000, 'BICOMBUSTIVEL', sysdate(), 1);