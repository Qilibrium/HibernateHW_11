INSERT INTO client (name) VALUES
     ('Svitlana Noskova'),
     ('Dmitro Kovalchuk'),
    ('Oksana Tkachuk'),
    ('Pavlo Zibrov'),
    ('Sergiy Bondarchuk'),
    ('Ivan Kovalchuk'),
    ('Valeriia Shablii'),
   ('Victor Gritsuk'),
   ('Oleksandr Lemishh'),
    ('Oleksandr Shapko');

INSERT INTO planet (id, name) VALUES
     ('MARS', 'Mars'),
    ('MER', 'Mercury'),
     ('EAR', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
  ('2021-08-16', 1, 'MARS', 'MER'),
    ('2021-08-21', 2, 'MER', 'MARS'),
    ('2021-09-01', 3, 'EAR', 'JUP'),
    ('2021-10-03', 4, 'JUP', 'EAR'),
    ('2021-11-10', 5, 'JUP', 'SAT'),
    ('2021-12-15', 6, 'SAT', 'JUP'),
('2021-01-20', 7, 'EAR', 'MARS'),
    ('2021-02-23', 8, 'MARS', 'EAR'),
    ('2021-03-25', 9, 'MER', 'EAR'),
('2021-05-02', 10, 'EAR', 'SAT');
