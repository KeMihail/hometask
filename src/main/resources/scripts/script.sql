CREATE TABLE `Auditorium` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`numberOfSeats` int,
	`created` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100),
	`basePrice` double,
	`rating` varchar(100),
	`auditorium_id` int,
	`created` TIMESTAMP NOT NULL,
	`modified` TIMESTAMP,
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
	`user_id` int,
	`created` TIMESTAMP,
	`modified` TIMESTAMP,
	PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
	`id` int NOT NULL AUTO_INCREMENT,
	`firstName` varchar(200),
	`lastName` varchar(200),
	`email` varchar(200),
	`created` TIMESTAMP,
	`modified` TIMESTAMP,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Event` ADD CONSTRAINT `Event_fk0` FOREIGN KEY (`auditorium_id`) REFERENCES `Auditorium`(`id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk0` FOREIGN KEY (`event_id`) REFERENCES `Event`(`id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk1` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);
