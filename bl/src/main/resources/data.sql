delete from blueberry.child_observation;
delete from blueberry.person;
delete from blueberry.observation;

INSERT INTO blueberry.person (dtype, id, birthdate, entry_date, first_name, gender, name, nationality) VALUES ('child', 1, '2023-02-01', '2023-02-01', 'Ich', 1, 'Nicht', 'CH');

INSERT INTO blueberry.observation (id, category, expected_at_months, text) VALUES (1, 'Movement', 36, 'Can ride a tricycle');
INSERT INTO blueberry.observation (id, category, expected_at_months, text) VALUES (2, 'Movement', 36, 'Can jump off with both legs');
INSERT INTO blueberry.observation (id, category, expected_at_months, text) VALUES (3, 'Coordination', 36, 'Can thread large beads onto a string');

INSERT INTO blueberry.child_observation (child_id, observation_id, comment, created_at, points) VALUES (1, 1, 'Completed', '2023-02-07 13:08:36.000000', 2);

commit;