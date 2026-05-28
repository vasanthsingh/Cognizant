CREATE DATABASE digital_nurture_db;
USE digital_nurture_db;

-- 1. Create Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

-- 2. Create Events Table
CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled') NOT NULL,
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

-- 3. Create Sessions Table
CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 4. Create Registrations Table
CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 5. Create Feedback Table
CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 6. Create Resources Table
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Insert Users
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

-- Insert Events
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

-- Insert Sessions
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

-- Insert Registrations
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

-- Insert Feedback
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

-- Insert Resources
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

-- 1.Finding Upcoming Events
SELECT u.full_name, e.title, e.city, e.start_date 
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON e.event_id = r.event_id
WHERE e.status = 'upcoming' AND e.city = u.city
ORDER BY e.start_date;

-- 2 
SELECT e.event_id, e.title, AVG(f.rating) AS avg_rating
FROM Events AS e
JOIN Feedback AS f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 2
ORDER BY avg_rating DESC, e.event_id ASC;

-- 3
SELECT user_id, full_name, email
FROM Users
WHERE user_id NOT IN (
    SELECT DISTINCT user_id 
    FROM Registrations 
    WHERE registration_date >= DATE_SUB('2025-06-20', INTERVAL 90 DAY)
)
ORDER BY user_id ASC;

-- 4
SELECT event_id,count(*) as peak_session_count
from Sessions
where (time(start_time) >= '10:00:00' AND time(end_time) <= '12:00:00') 
group by event_id
order by event_id asc;

-- 5
select city,count(*) as total_registrations
from users
where(select distinct user_id from registrations)
group by city
order by total_registrations desc,city asc;

-- 6
select e.event_id,e.title,
	sum(case when r.resource_type = 'pdf' then 1 else 0 end) as pdf_count,
	sum(case when r.resource_type = 'image' then 1 else 0 end) as image_count,
	sum(case when r.resource_type = 'link' then 1 else 0 end) as link_count
from events as e
left join resources as r
on e.event_id = r.event_id
group by e.events_id,e.title
order by event_id asc;

-- 7
select u.full_name,e.title as event_name,f.rating,f.comments
from users as u
join feedback as f
on f.user_id = u.user_id
join events as e
on e.event_id = f.event_id
where f.rating < 3
order by f.rating asc;

-- 8
select e.event_id,e.title,count(s.session_id) as session_count
from events as e
left join sessions as s
on e.event_id = s.event_id
where status = "upcoming"
group by e.event_id,e.title
order by session_count desc;

-- 9
select u.user_id,u.full_name as organizer_name,e.status,count(e.event_id) as event_count
from users as u
join events as e
on u.user_id = e.organizer_id
group by u.user_id,u.full_name,e.status
order by organizer_name;

-- 10
select distinct e.event_id,e.title
from events as e
join registrations as r
on e.event_id = r.event_id
where e.event_id not in (
select event_id from feedback
)order by e.event_id asc;
    
-- 11
select registration_date,count(user_id) as new_users
from users 
where registration_date >= date_sub('2025-06-20',INTERVAL 7 day)
group by registration_date
order by registration_date desc;

-- 12
select event_id,count(session_id) as session_count
from sessions
group by event_id
having count(session_id) = (
    select Max(cnt) from
    (select count(session_id) as cnt
    from sessions
    group by event_id
    ) as subquery
)

-- 13
select e.city,round(avg(f.rating),2) as avg_feedback_rating
from events as e
join feedback as f
on e.event_id = f.event_id
group by e.city
order by avg_feedback_rating desc,e.city;

-- 14
select e.event_id,e.title,COUNT(registration_id) as registration_count
from events as e
left join Registrations as r
on e.event_id = r.event_id
group by e.event_id,e.title
order by registration_count desc,e.event_id asc
limit 3;

-- 15
select e1.event_id,e1.session_id as session_id_1,e1.title as session_title_1,e2.session_id as session_id_2,e2.title as session_title_2
from sessions as e1
join sessions as e2
on e1.event_id = e2.event_id
and e1.session_id_1 < e2.session_id_2
where e1.start_time < e2.end_time and e1.end_time > e2.start_time
order by event_id asc;



-- 16
select u.user_id,u.full_name,u.registration_date
from users as u
where registration_date >= date_sub('2025-06-20',interval 30 day)
and u.user_id not in(select user_id from registrations)
order by user_id asc;

-- 17
select speaker_name ,count(session_id) as session_count
from sessions 
group by speaker_name
having session_count > 1
order by session_count desc,speaker_name asc;

--18
select e.event_id,e.title 
from events as e
where event_id not in(select event_id from resources)
order by e.event_id asc;

--19 
select e.event_id,e.title,count(select registration_id from registrations where e.event_id = event_id) as total_registrations,round(select avg(rating) from feedback where event_id = e.event_id,2) as avg_feedback_rating
from events as e
where e.status = 'completed'
order by e.event_id asc;

-- 20
select u.user_id,u.full_name,ifnull((select count(registration_id) from registrations where user_id = u.user_id),0) as events_registered,
ifnull((select count(feedback_id) from feedback where user_id = u.user_id),0)
from users as u
order by u.user_id asc;

--21 
select u.user_id,u.full_name,count(f.feedback_id) as feedback_count
from users as u
join feedback as f
on u.user_id = f.user_id
group by u.user_id,u.full_name
order by feedback_count desc
limit 5;

-- 22
select r.user_id,r.event_id,count(registration_id) as registration_count
from registrations as r
group by r.event_id,r.user_id
having registration_count > 1
order by r.user_id asc;

--23
select date_format(registration_date,"%Y-%m") as registration_month,count(registration_id) as month_registration_count
from registrations
group by date_format(registration_date,"%Y-%M")
order by registration_month asc;

-- 24
select e.event_id,e.title,round(avg(timestampdiff(MINUTE,start_time,end_time)),2) as  avg_session_duration_minutes
from events as e
join sessions as s
on e.event_id = s.event_id
group by e.event_id,e.title
order by avg_session_duration_minutes desc,e.event_id ASC;

-- 25
select e.event_id,e.title
from events as e
where event_id NOT IN(select event_id from sessions)
order by e.event_id
