# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id                            bigint auto_increment not null,
  wxid                          varchar(255),
  name                          varchar(255),
  type                          integer not null,
  tel                           varchar(255),
  regdate                       datetime(6) not null,
  constraint pk_admin primary key (id)
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
  bookid                        varchar(255) not null,
  resid                         bigint,
  comid                         varchar(255),
  bookdate                      datetime(6),
  starttime                     varchar(255),
  endtime                       varchar(255),
  wxid                          varchar(255),
  name                          varchar(255),
  tel                           varchar(255),
  title                         varchar(255),
  des                           varchar(255),
  attendee                      varchar(255),
  maillist                      varchar(255),
  status                        integer not null,
  booktime                      datetime(6) not null,
  chektime                      datetime(6) not null,
  constraint pk_book primary key (bookid)
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
  comid                         varchar(255) not null,
  name                          varchar(255),
  wxid                          varchar(255),
  addshort                      varchar(255),
  addlong                       varchar(255),
  lat                           float not null,
  ing                           float not null,
  tel                           varchar(255),
  admintel                      varchar(255),
  adminname                     varchar(255),
  admin_id                      varchar(255),
  status                        integer not null,
  createtime                    datetime(6) not null,
  checktime                     datetime(6) not null,
  modifytime                    datetime(6) not null,
  constraint pk_company primary key (comid)
);

create table computer (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime(6),
  discontinued                  datetime(6),
  company_comid                 varchar(255),
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

create table node (
  id                            integer auto_increment not null,
  avatar_large                  varchar(255),
  name                          varchar(255),
  avatar_normal                 varchar(255),
  title                         varchar(255),
  url                           varchar(255),
  topics                        integer not null,
  footer                        varchar(255),
  header                        varchar(255),
  title_alternative             varchar(255),
  avatar_mini                   varchar(255),
  stars                         integer not null,
  root                          tinyint(1) default 0,
  parent_node_name              varchar(255),
  memo                          varchar(255),
  createtime                    datetime(6) not null,
  constraint pk_node primary key (id)
);

create table post (
  id                            integer auto_increment not null,
  node                          integer,
  member                        bigint,
  last_reply_by                 varchar(255),
  title                         varchar(255),
  url                           varchar(255),
  content                       varchar(255),
  content_rendered              varchar(255),
  replies                       integer not null,
  memo                          varchar(255),
  last_touched                  datetime(6) not null,
  created                       datetime(6) not null,
  last_modified                 datetime(6) not null,
  constraint pk_post primary key (id)
);

create table price (
  id                            bigint auto_increment not null,
  pricedate                     date,
  code                          varchar(255),
  name                          varchar(255),
  price                         double not null,
  price1                        double not null,
  price2                        double not null,
  des                           varchar(255),
  bak1                          varchar(255),
  bak2                          varchar(255),
  createdate                    datetime(6) not null,
  constraint pk_price primary key (id)
);

create table res (
  id                            bigint auto_increment not null,
  type                          integer not null,
  resid                         varchar(255),
  comid                         varchar(255),
  size                          integer not null,
  status                        integer not null,
  name                          varchar(255),
  projector                     tinyint(1) default 0,
  camera                        tinyint(1) default 0,
  validdate                     varchar(255),
  des                           varchar(255),
  starttime                     varchar(255),
  endtime                       varchar(255),
  modifytime                    datetime(6),
  d11                           varchar(255),
  d12                           varchar(255),
  d13                           varchar(255),
  d2                            integer not null,
  d3                            double not null,
  createtime                    datetime(6) not null,
  constraint pk_res primary key (id)
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

create table user1 (
  id                            bigint auto_increment not null,
  wxid                          varchar(255),
  name                          varchar(255),
  type                          integer not null,
  tel                           varchar(255),
  com                           varchar(255),
  userinfo                      varchar(255),
  bint1                         integer not null,
  bint2                         integer not null,
  b1                            varchar(255),
  b2                            varchar(255),
  avatar_large                  varchar(255),
  avatar_mini                   varchar(255),
  location                      varchar(255),
  website                       varchar(255),
  avatar_normal                 varchar(255),
  bio                           varchar(255),
  btc                           varchar(255),
  url                           varchar(255),
  regdate                       datetime(6) not null,
  constraint uq_user1_wxid unique (wxid),
  constraint pk_user1 primary key (id)
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

alter table book add constraint fk_book_resid foreign key (resid) references res (id) on delete restrict on update restrict;
create index ix_book_resid on book (resid);

alter table book add constraint fk_book_comid foreign key (comid) references company (comid) on delete restrict on update restrict;
create index ix_book_comid on book (comid);

alter table computer add constraint fk_computer_company_comid foreign key (company_comid) references company (comid) on delete restrict on update restrict;
create index ix_computer_company_comid on computer (company_comid);

alter table post add constraint fk_post_node foreign key (node) references node (id) on delete restrict on update restrict;
create index ix_post_node on post (node);

alter table post add constraint fk_post_member foreign key (member) references user1 (id) on delete restrict on update restrict;
create index ix_post_member on post (member);

alter table res add constraint fk_res_comid foreign key (comid) references company (comid) on delete restrict on update restrict;
create index ix_res_comid on res (comid);

alter table user add constraint fk_user_role_id foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_role_id on user (role_id);

alter table user_stock_r add constraint fk_user_stock_r_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_user_stock_r_user_id on user_stock_r (user_id);

alter table user_stock_r add constraint fk_user_stock_r_stock_id foreign key (stock_id) references stock (id) on delete restrict on update restrict;
create index ix_user_stock_r_stock_id on user_stock_r (stock_id);


# --- !Downs

alter table avatar drop foreign key fk_avatar_user_id;

alter table book drop foreign key fk_book_resid;
drop index ix_book_resid on book;

alter table book drop foreign key fk_book_comid;
drop index ix_book_comid on book;

alter table computer drop foreign key fk_computer_company_comid;
drop index ix_computer_company_comid on computer;

alter table post drop foreign key fk_post_node;
drop index ix_post_node on post;

alter table post drop foreign key fk_post_member;
drop index ix_post_member on post;

alter table res drop foreign key fk_res_comid;
drop index ix_res_comid on res;

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

drop table if exists node;

drop table if exists post;

drop table if exists price;

drop table if exists res;

drop table if exists role;

drop table if exists stock;

drop table if exists transaction_records;

drop table if exists user;

drop table if exists user1;

drop table if exists user_stock_r;

