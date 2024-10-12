PremierLeagueScoresApp

Description
PremierLeagueScoresApp is a web application providing live scores from the English Premier League. The project is developed using Java and utilizes the Spring Framework for backend logic. The frontend is built with HTML, CSS, and JavaScript, and the database is powered by MySQL.

The application offers:
Live standings and score tables – updated in real-time through REST API requests to an external live score service.
Dedicated team pages for each Premier League club, featuring sections with details on titles, fan base, and team history.
User profile page and a fan communication page, where fans can chat with each other, managed by a separate project.

Technologies:
Java 11
Spring Framework (Spring Boot, Spring MVC, Spring Data JPA)
MySQL database
JavaScript for frontend interactivity
HTML5 and CSS3 for page design and layout
REST API integration for real-time data
Internationalization (i18n) support for multi-language functionality on the homepage

Features:
Homepage: Standings table and live match scores that automatically update using REST API polling.
Team Pages: Each page includes information about the team's titles, history, and fanbase.
User Profile and Communication: Users can create profiles and communicate with each other via a chat page. The chat functionality is handled through a separate project.
Chat Project Integration: The application communicates with a separate chat project – PremierLeagueScoresApp-Chat via REST API requests. You can find more information about the project here: https://github.com/RosenTodorov2006/PremierLeagueScoresApp-Chat

Internationalization (i18n):
The application supports multiple languages on the homepage, utilizing Spring Internationalization (i18n) for easy switching between different languages.
