INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `last_name`, `login`, `email`, `password`) VALUES ('1', '1', '1990-01-01 01:00:00','1990-01-01 01:00:00', 'Joe', 'Bar', 'joe.bar', 'joe.bar@comics.be', 'test');
INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `last_name`, `login`, `email`, `password`) VALUES ('2', '1', '1959-10-29 01:00:00','1959-10-29 01:00:00', 'Astérix', 'Le gaulois', 'asterix', 'asterix@comics.fr', 'test');
INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `last_name`, `login`, `email`, `password`) VALUES ('3', '1', '1957-02-28 01:00:00','1957-02-28 01:00:00', 'Gaston', 'Lagaffe', 'gaston', 'gaston@comics.be', 'test');
INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `login`, `email`, `password`) VALUES ('4', '1', '1938-03-21 01:00:00','1938-03-21 01:00:00', 'Spirou', 'spirou', '', 'test');
INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `last_name`, `login`, `email`, `password`) VALUES ('5', '1', '1948-10-28 01:00:00','1948-10-28 01:00:00', 'Philip', 'Mortimer', 'mortimer', 'philip.mortimer@comics.be', 'test');
INSERT INTO `tutorial`.`users` (`id`, `active`, `created`, `updated`, `first_name`, `login`, `email`, `password`) VALUES ('6', '1', '1929-01-01 01:00:00','1929-01-01 01:00:00', 'Tintin', 'tintin', 'tintin@comics.be', 'test');

INSERT INTO `tutorial`.`groups` (`id`, `active`, `created`, `updated`, `name`, `description`) VALUES ('1', '1', '2014-01-01 01:00:00','2014-01-01 01:00:00', 'Simple user', 'Application default user');
INSERT INTO `tutorial`.`groups` (`id`, `active`, `created`, `updated`, `name`, `description`) VALUES ('2', '1', '2014-01-01 01:00:00','2014-01-01 01:00:00', 'Administrator', 'Application\'s administrator');

INSERT INTO `tutorial`.`permissions` (`id`, `active`, `created`, `updated`, `name`, `description`) VALUES ('1', '1', '2014-01-01 01:00:00','2014-01-01 01:00:00', 'Administration', 'Application\'s administration');
INSERT INTO `tutorial`.`permissions` (`id`, `active`, `created`, `updated`, `name`, `description`) VALUES ('2', '1', '2014-01-01 01:00:00','2014-01-01 01:00:00', 'User profile', 'This allow the current user to change its profile settings: address, email, password, ... ');

INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('1', '1');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('2', '1');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('3', '1');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('4', '1');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('5', '1');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('5', '2');
INSERT INTO `tutorial`.`users_groups` (`user_id`, `group_id`) VALUES ('6', '1');

INSERT INTO `tutorial`.`groups_permissions` (`group_id`, `permission_id`) VALUES ('1', '2');
INSERT INTO `tutorial`.`groups_permissions` (`group_id`, `permission_id`) VALUES ('2', '1');
