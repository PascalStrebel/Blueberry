delete from todo;
insert into todo (id, name, description) values (1, 'test', 'test test test');
insert into todo (id, name, description) values (2, 'test 2', 'test test test2');

delete from person;
insert into person (dtype, birthdate, entry_date, first_name, gender, name, nationality) values ('child', 'test', 'test test test');
commit;