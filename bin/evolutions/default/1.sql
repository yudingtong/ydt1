# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  wxid                          varchar(255) not null,
  name                          varchar(255),
  type                          integer not null,
  tel                           varchar(255),
  regdate                       datetime(6) not null,
  constraint pk_admin primary key (wxid)
);

create table analyst_member (
  id                            bigint auto_increment not null,
  stock_code                    varchar(255),
  industry_code                 varchar(255),
  trade_logic                   varchar(255),
  trade_direction               integer not null,
  trade_position                double not null,
  trade_price                   double not null,
  user_id                       integer not null,
  memo1                         varchar(255),
  memo2                         varchar(255),
  memo3                         varchar(255),
  memo4                         varchar(255),
  trade_day                     datetime(6) not null,
  constraint pk_analyst_member primary key (id)
);

create table avatar (
  id                            integer auto_increment not null,
  user_id                       bigint,
  content_type                  varchar(255),
  data                          longblob,
  constraint uq_avatar_user_id unique (user_id),
  constraint pk_avatar primary key (id)
);

create table book (
  resid                         varchar(255) not null,
  bookid                        varchar(255),
  wxid                          varchar(255),
  name                          varchar(255),
  tel                           varchar(255),
  title                         varchar(255),
  des                           varchar(255),
  attendee                      varchar(255),
  maillist                      varchar(255),
  status                        integer not null,
  bookdate                      datetime(6) not null,
  starttime                     datetime(6) not null,
  endtime                       datetime(6) not null,
  booktime                      datetime(6) not null,
  chektime                      datetime(6) not null,
  constraint pk_book primary key (resid)
);

create table comment (
  id                            integer auto_increment not null,
  disid                         integer not null,
  commid                        integer not null,
  userid                        integer not null,
  content                       varchar(255),
  isreturn                      integer not null,
  memo                          varchar(255),
  createtime                    datetime(6) not null,
  constraint pk_comment primary key (id)
);

create table company (
  id                            bigint auto_increment not null,
  comid                         varchar(255),
  name                          varchar(255),
  wxid                          varchar(255),
  addshort                      varchar(255),
  addlong                       varchar(255),
  lat                           float not null,
  ing                           float not null,
  tel                           varchar(255),
  status                        integer not null,
  createtime                    datetime(6) not null,
  checktime                     datetime(6) not null,
  modifytime                    datetime(6) not null,
  constraint pk_company primary key (id)
);

create table computer (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime(6),
  discontinued                  datetime(6),
  company_id                    bigint,
  constraint pk_computer primary key (id)
);

create table daily_position (
  id                            bigint auto_increment not null,
  stock_code                    varchar(255),
  industry_code                 varchar(255),
  share_position                double not null,
  memo1                         varchar(255),
  memo2                         varchar(255),
  memo3                         varchar(255),
  memo4                         varchar(255),
  market_date                   datetime(6) not null,
  constraint pk_daily_position primary key (id)
);

create table discuss (
  id                            integer auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  userid                        integer not null,
  memo                          varchar(255),
  createtime                    datetime(6) not null,
  constraint pk_discuss primary key (id)
);

create table favor (
  id                            integer auto_increment not null,
  disid                         integer not null,
  userid                        integer not null,
  memo                          varchar(255),
  createtime                    datetime(6) not null,
  constraint pk_favor primary key (id)
);

create table news (
  id                            integer auto_increment not null,
  title                         varchar(255),
  url                           varchar(255),
  classify                      varchar(255),
  time                          varchar(255),
  constraint pk_news primary key (id)
);

create table role (
  id                            integer auto_increment not null,
  name                          varchar(255),
  constraint pk_role primary key (id)
);

create table stock (
  id                            bigint auto_increment not null,
  code                          varchar(255),
  name                          varchar(255),
  simple_name                   varchar(255),
  constraint pk_stock primary key (id)
);

create table transaction_records (
  id                            bigint auto_increment not null,
  analyst_name                  varchar(255),
  industry_code                 varchar(255),
  user_id                       integer not null,
  phone                         varchar(255),
  memo1                         varchar(255),
  memo2                         varchar(255),
  memo3                         varchar(255),
  memo4                         varchar(255),
  in_date                       datetime(6) not null,
  out_date                      datetime(6) not null,
  constraint pk_transaction_records primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  mobile                        bigint not null,
  level                         integer not null,
  gender                        integer not null,
  email                         varchar(255),
  op_style_a                    varchar(255),
  op_style_b                    varchar(255),
  total_profit                  varchar(255),
  department                    varchar(255),
  analyst_cid                   varchar(255),
  analyst_desc                  varchar(255),
  beiyong1                      varchar(255),
  stock_order                   varchar(255),
  image_url                     varchar(255),
  language                      varchar(255),
  province                      varchar(255),
  city                          varchar(255),
  country                       varchar(255),
  user_id                       integer not null,
  name                          varchar(255),
  password                      varchar(255),
  update_time                   datetime(6),
  mid                           varchar(255),
  role_id                       integer,
  create_time                   datetime(6) not null,
  constraint pk_user primary key (id)
);

create table user_stock_r (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  stock_id                      bigint,
  put_price                     double,
  memo                          varchar(255),
  memo1                         varchar(255),
  stockname                     varchar(255),
  create_time                   datetime(6) not null,
  constraint pk_user_stock_r primary key (id)
);

alter table avatar add constraint fk_avatar_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table computer add constraint fk_computer_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_id on computer (company_id);

alter table user add constraint fk_user_role_id foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_role_id on user (role_id);

alter table user_stock_r add constraint fk_user_stock_r_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_user_stock_r_user_id on user_stock_r (user_id);

alter table user_stock_r add constraint fk_user_stock_r_stock_id foreign key (stock_id) references stock (id) on delete restrict on update restrict;
create index ix_user_stock_r_stock_id on user_stock_r (stock_id);


# --- !Downs

alter table avatar drop foreign key fk_avatar_user_id;

alter table computer drop foreign key fk_computer_company_id;
drop index ix_computer_company_id on computer;

alter table user drop foreign key fk_user_role_id;
drop index ix_user_role_id on user;

alter table user_stock_r drop foreign key fk_user_stock_r_user_id;
drop index ix_user_stock_r_user_id on user_stock_r;

alter table user_stock_r drop foreign key fk_user_stock_r_stock_id;
drop index ix_user_stock_r_stock_id on user_stock_r;

drop table if exists admin;

drop table if exists analyst_member;

drop table if exists avatar;

drop table if exists book;

drop table if exists comment;

drop table if exists company;

drop table if exists computer;

drop table if exists daily_position;

drop table if exists discuss;

drop table if exists favor;

drop table if exists news;

drop table if exists role;

drop table if exists stock;

drop table if exists transaction_records;

drop table if exists user;

drop table if exists user_stock_r;

