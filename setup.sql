create sequence venue_id_seq;
create table venue (
	id bigint primary key default nextval('venue_id_seq'),
	name varchar(255) not null unique,
	category varchar(40),
	url varchar(2000),
	date_added timestamp,
	excerpt varchar(255),
	thumbnail_url varchar(2000),
	latitude decimal(9, 7),
	longitude decimal(10, 7),
	address varchar(255),
	phone varchar(20),
	twitter varchar(15),
	stars_beer decimal(2, 1),
	stars_atmosphere decimal(2, 1),
	stars_amenities decimal(2, 1),
	stars_value decimal(2, 1)
);
alter sequence venue_id_seq owned by venue.id;
create sequence tag_id_seq;
create table tag (
	id bigint primary key default nextval('tag_id_seq'),
	name varchar(255) unique not null
);
alter sequence tag_id_seq owned by tag.id;
create table venue_tag (
	venue_id bigint not null,
	tag_id bigint not null,
	foreign key (venue_id) references venue(id),
	foreign key (tag_id) references tag(id),
	primary key (venue_id, tag_id)
);