select m.name, count(*) as quality from meet as m left join user_meet um on m.id = um.meet_id
join user_meet_status ums on um.id = ums.id_user_meet
where id_status = 1
group by m.name;

select  m.name from meet as m left join user_meet um on m.id = um.meet_id
where user_id is null;


