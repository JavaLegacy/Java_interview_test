DROP TABLE CIDADES;

CREATE TABLE CIDADES 
(CODIGO_CIDADE INT PRIMARY KEY,
LATITUDE DECIMAL(10,6),
LONGITUDE DECIMAL(10,6)
);

-- Sao Paulo -23.547778 -46.635833
insert into CIDADES values(1,-23.547778,-46.635833);
-- Mogi das Cruzes 23.522778, -46.187778
insert into CIDADES values(2,23.522778,-46.187778);
-- Guaruhos -23.462778, -46.532778
insert into CIDADES values(3,-23.462778,-46.532778);
-- Taboao da Serra -23.601944, -46.752778
insert into CIDADES values(4,-23.601944,-46.752778);
-- Mairipora -23.318889, -46.586944
insert into CIDADES values(5,-23.318889,-46.586944);
-- Osasco -23.532778, -46.799444
insert into CIDADES values(6,-23.532778,-46.799444);
-- Carapicuiba -23.519167, -46.835833
insert into CIDADES values(7,-23.519167,-46.835833);
-- Jandira -23.527778, -46.902778
insert into CIDADES values(8,-23.527778,-46.902778);
-- Diadema -23.686111, -46.610556
insert into CIDADES values(9,-23.686111,-46.610556);
-- Cotia -23.604167, -46.919444
insert into CIDADES values(10,-23.604167,-46.919444);

select * from CIDADES;

