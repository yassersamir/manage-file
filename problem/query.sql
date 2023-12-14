select u.user_id , u.username , td.training_id , td.training_date , count(u.user_id)
from user u inner join training_details td on u.user_id = td.user_id
group by u.user_id , u.username , td.training_id , td.training_date
having count(u.user_id) > 1
order by td.training_date desc;