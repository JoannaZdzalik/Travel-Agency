CREATE TABLE guides(
   id bigserial PRIMARY key,
   name VARCHAR (50) NOT NULL
);
CREATE TABLE destinations(
   id bigserial PRIMARY key,
   name VARCHAR (255) NOT NULL
);
CREATE TABLE clients(
   id bigserial PRIMARY key,
   name VARCHAR (30) NOT NULL,
	surname VARCHAR (50) NOT NULL,
	passport_nr VARCHAR (20) UNIQUE NOT NULL
);
CREATE TABLE trips(
   id bigserial PRIMARY key,
	id_destination bigint,
	departure_date date NOT NULL,
	return_date date NOT NULL,
	suggested_price decimal(19,2) NOT NULL,
	id_guide bigint,
	foreign key (id_destination) references destinations (id) ON DELETE CASCADE,
	foreign key (id_guide) references guides (id) ON DELETE CASCADE
);
CREATE TABLE reservations(
id bigserial PRIMARY key,
   id_client bigint,
   id_trip bigint,
   actual_price decimal (19,2) NOT NULL,
   foreign key (id_client) references clients (id) ON DELETE CASCADE,
   foreign key (id_trip) references trips (id) ON DELETE CASCADE,
   unique (id_client, id_trip)
);
