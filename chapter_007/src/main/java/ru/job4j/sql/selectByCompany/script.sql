select p.name as name from person as p
left join company as c on p.company_id = c.id
where c.id != 5;

select c.name as name, p.name from company as c
left join person p on c.id = p.company_id;

select c.name as name, count(p.name) as quality from company as c
join  person p on c.id = p.company_id
group by c.name order by quality desc limit 1;
