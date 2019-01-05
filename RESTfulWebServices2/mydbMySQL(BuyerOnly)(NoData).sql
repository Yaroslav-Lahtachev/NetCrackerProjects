
CREATE TABLE `mydb`.`buyers` (
  `id_buyer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `region` VARCHAR(45) NULL,
  `sale` DOUBLE NULL,
  PRIMARY KEY (`id_buyer`))

----------------
insert into mydb.buyers (id_buyer, name, region, sale)
values (1,'buyer1','someRegion1',1);

insert into mydb.buyers (id_buyer, name, region, sale)
values (2,'buyer2','someRegion2',2);

insert into mydb.buyers (id_buyer, name, region, sale)
values (3,'buyer3','someRegion3',3);

insert into mydb.buyers (id_buyer, name, region, sale)
values (4,'buyer4','someRegion4',4);

insert into mydb.buyers (id_buyer, name, region, sale)
values (5,'buyer5','someRegion5',5);