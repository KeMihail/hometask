CREATE TABLE `Auditorium` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`numberOfSeats` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`basePrice` double,
	`rating_id` int,
	`auditorium_id` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `EventRating` (
	`id` int NOT NULL AUTO_INCREMENT,
	`rating` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Ticket` (
	`id` int NOT NULL AUTO_INCREMENT,
	`seat` int,
	`event_id` int,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
	`id` int NOT NULL AUTO_INCREMENT,
	`firstName` varchar(200),
	`lastName` varchar(200),
	`email` varchar(200),
	PRIMARY KEY (`id`)
);

ALTER TABLE `Event` ADD CONSTRAINT `Event_fk0` FOREIGN KEY (`rating_id`) REFERENCES `EventRating`(`id`);

ALTER TABLE `Event` ADD CONSTRAINT `Event_fk1` FOREIGN KEY (`auditorium_id`) REFERENCES `Auditorium`(`id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk0` FOREIGN KEY (`event_id`) REFERENCES `Event`(`id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk1` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
