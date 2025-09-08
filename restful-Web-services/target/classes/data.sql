insert into user_details(id,name,birth_date) values (101,'Rushi', current_date()),(102,'Shreyash', current_date()),
 (103,'Trisha', current_date());

 insert into post(id,user_id,description) values (111,101, 'Java'),(112,101, 'CPP'),(113,101, 'React'),(114,101, 'Javascript');