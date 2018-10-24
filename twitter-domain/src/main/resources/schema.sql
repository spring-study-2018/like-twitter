set mode MYSQL;

drop table if exists Tweet;
drop table if exists Member;

create table Member (
  memberId bigint not null auto_increment,
  id char(16) not null,
  password char(128) not null,
  displayName char(32) not null,
  email varchar(64) not null,
  authority varchar2(12) not null,
  createdAt timestamp not null default now(),
  primary key (memberId)
);

create table Tweet (
  tweetId bigint not null auto_increment,
  content varchar(280) not null,
  memberId bigint not null,
  createdAt timestamp not null default now(),
  primary key (tweetId)
);

alter table Member add constraint UK_MEMBER_ID
  unique key (id);

alter table Tweet add constraint FK_TWEET_MEMBER
  foreign key (memberId)
  references Member;
