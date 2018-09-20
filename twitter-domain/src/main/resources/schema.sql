drop table if exists Member;
drop table if exists Tweet;

create table Member (
  memberId bigint not null auto_increment,
  id char(16) not null,
  password char(128) not null,
  displayName char(32) not null,
  email varchar(64) not null,
  createdAt timestamp not null default now(),
  primary key (memberId)
);

create table Tweet (
  tweetId bigint not null auto_increment,
  content varchar(280) not null,
  memberId bigint not null,
  createdAt timestamp not null default now(),
  primary key (tweetId),
  foreign key (memberId) references Member(memberId)
);
