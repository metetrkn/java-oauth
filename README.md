# JavaWebDemo

JavaWebDemo is a Spring Boot web application that integrates GitHub OAuth2 authentication and displays a list of pop singers. It also shows the logged-in user's email on a profile page using GitHub's user info API.

## Features

- 🌐 Spring Boot web application with Thymeleaf
- 🔐 OAuth2 GitHub login integration
- 📧 Fetch primary email from GitHub after login
- 🎤 Display a list of POP singers stored in a database
- 👤 View logged-in user's profile with email info

## Technologies Used

- Java 17
- Spring Boot
- Spring Security (OAuth2)
- JPA + H2 (or any other database)
- Thymeleaf (for frontend views)
- GitHub API (for fetching email)

## Endpoints

| Endpoint       | Description                           |
|----------------|---------------------------------------|
| `/`            | Home page showing singers and user    |
| `/profile`     | Profile page showing logged-in email  |
| `/login`       | Redirect to GitHub login              |

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Run the App

```bash
mvn spring-boot:run 
```

### Configuration

- Update your application.yml or application.properties with your GitHub OAuth credentials:

### Project Structure

- controllers/ – Handles web routes

- models/ – JPA entities and repositories

- security/ – OAuth2 configuration and GitHub API client

- templates/ – Thymeleaf templates (home.html, profile.html)

### Author & License

Created by [Mete Turkan](./LICENSE)  
Licensed under the [MIT License](./LICENSE)
