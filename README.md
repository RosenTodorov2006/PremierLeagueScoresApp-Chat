PremierLeagueScoresApp-Chat

Description: 
PremierLeagueScoresApp-Chat is the chat service designed specifically for the main application PremierLeagueScoresApp: https://github.com/RosenTodorov2006/PremierLeagueScoresApp. It allows fans of the English Premier League to communicate with each other in real time. The chat service communicates with the main application via REST API requests, enabling seamless integration between the two projects.

Key features include:
Real-time communication for users of the PremierLeagueScoresApp.
Automatic deletion of chat history every 24 hours to maintain optimal performance.
Profanity filter that checks and blocks forbidden words in messages to ensure a respectful environment.

Technologies:
Java 11
Spring Framework (Spring Boot, Spring MVC, Spring Data JPA)
REST API communication with PremierLeagueScoresApp
MySQL database for temporary message storage
Message filtering to block profanity and inappropriate language

Features:
REST API Communication: The chat service communicates with the main application PremierLeagueScoresApp via REST API. This ensures real-time message transfer between users while maintaining the integrity and performance of both systems.
Automatic Chat Deletion: To optimize the performance and prevent unnecessary data storage, all chat messages are automatically deleted every 24 hours.
Profanity Filter: The chat system includes a profanity filter that scans messages and blocks any forbidden words, creating a safe and respectful space for users.
