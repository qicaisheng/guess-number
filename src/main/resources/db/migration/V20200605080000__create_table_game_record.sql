create table game_record(
  id varchar(64) not null primary key,
  round varchar(64) not null,
  user_guess varchar(7) not null,
  position_correct_number varchar(1) not null,
  value_correct_number varchar(1) not null
);