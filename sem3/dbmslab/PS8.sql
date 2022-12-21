create sequence id
start with 0
increment by 1
minvalue 0;
create table Sailors (id int primary key, name varchar(20), rating int,
constraint c check (rating >= 6 and rating <= 10), age int);
insert into Sailors values (id.nextval,'Jack Sparrow', 10, 40);
insert into Sailors values (id.nextval,'Will Turner', 6, 26);
insert into Sailors values (id.nextval,'Horatio', 7, 24);
insert into Sailors values (id.nextval,'Gibbs', 9, 51);
insert into Sailors values (id.nextval,'Davey Jones', 10, 42);
insert into Sailors values (id.nextval,'Julius',9, 25);
select * from sailors;

create sequence bid
start with 100
increment by 1;
create table Boat(bid int primary key, Bname varchar(20), colour varchar(20));
insert into Boat values (bid.nextval,'Black Pearl', 'black');
insert into Boat values (bid.nextval,'Queen Annes Revenge', 'red');
insert into Boat values (bid.nextval,'Blackbeards Delight', 'black');
insert into Boat values (bid.nextval,'Redbeards Delight', 'red');
insert into Boat values (bid.nextval,'Oceans Dagger', 'blue');
insert into Boat values (bid.nextval,'Marine', 'blue');
insert into Boat values (bid.nextval,'Interlake', 'red');
select * from Boat;

create table Reserves(sid int, bid int, day date, primary key (sid,bid,day), foreign key(sid) references Sailors(id), foreign key(bid) references Boat(bid));
insert into Reserves (sid, bid, day) values (2, 101, '11-FEB-16');
insert into Reserves (sid, bid, day) values (6, 107, '10-JUN-16');
insert into Reserves (sid, bid, day) values (1, 101, '10-OCT-16');
insert into Reserves (sid, bid, day) values (1, 101, '10-OCT-17');
insert into Reserves (sid, bid, day) values (1, 102, '10-OCT-17');
insert into Reserves (sid, bid, day) values (1, 101, '10-JUL-17');
insert into Reserves (sid, bid, day) values (2, 102, '11-SEP-17');
insert into Reserves (sid, bid, day) values (2, 102, '7-NOV-17');
insert into Reserves (sid, bid, day) values (3, 101, '7-NOV-17');
insert into Reserves (sid, bid, day) values (3, 102, '7-AUG-17');
insert into Reserves (sid, bid, day) values (4, 103, '19-SEP-17');
insert into Reserves (sid, bid, day) values (6, 104, '19-SEP-17');
select * from Reserves;

--1
select count(colour) as BlackBoat from Boat where colour in 'black';
--2
select sid from reserves r join boat b on b.bid= r.bid where b.colour in ('red','green');

--3
SELECT name,age from sailors where age = (select min(age) from sailors);
select * from (select name,age from sailors order by age) WHERE rownum=1;

--4
select s.* from sailors s INNER JOIN Reserves r on s.id = r.sid  where r.bid = 101;

--5
select name from sailors where id != all(select sid from reserves);

--6
select b.colour from boat b join reserves r on b.bid = r.bid join sailors s on s.id = r.sid WHERE s.name = 'Horatio';

--7
select count(colour) from reserves r join boat b on r.bid = b.bid join sailors s on s.id = r.sid where s.rating = 10 and b.colour = 'red'; 

--8
select * from(select b.bid from boat b join reserves r on b.bid = r.bid where extract(year from r.day) = 2017 and b.colour = 'red' order by b.bid) where rownum = 1; 

--9
select id from sailors where rating = (select max(rating) from sailors);

--12
select DISTINCT s.id from sailors s join reserves r on r.sid = s.id join boat b on b.bid = r.bid where b.colour = 'red';

--14
select bid from(select bid,count(bid) as "c" from reserves group by bid order by "c" desc) where rownum=1;

--15
select id from sailors where rating > (select rating from sailors where name = 'Gibbs');

--16
select sid from reserves where id !=3 and bid = (select bid from reserves where sid = 3);

--17
select id, name from sailors where id != all(select sid from reserves);

--22
select sid from reserves group by sid having count(*) >=1;
 