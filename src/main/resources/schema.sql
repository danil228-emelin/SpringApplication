create table  if not exists purchase{
    id serial primary key,
    cost numeric check(cost>0) not null,
    name varchar(61) not null
    }