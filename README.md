# Twitter-like Spring Boot Application

This is a simple Twitter-like application developed using Java Spring Boot. It allows users to create, read, update, and delete tweets.

## Features

- Create a new tweet by sending a POST request with the tweet content and user information.
- Retrieve a list of all tweets for a specific user.
- Get a specific tweet by its ID.
- Update the content of a tweet by sending a PUT request with the updated content and tweet ID.
- Delete a tweet by its ID.

## Architecture
<img src="https://github.com/neel0086/twitter_spring_boot/assets/83919508/71470c98-eda4-4da3-8b79-ea2b6b49ec3a"></img>

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven

## Setup and Installation

1. Clone the repository:
git clone <repository-url>


2. Navigate to the project directory:
cd twitter-spring-boot


3. Build the project using Maven:
mvn clean install


4. Run the application:
mvn spring-boot:run



5. The application will be accessible at: `http://localhost:8081`

## API Endpoints

The following API endpoints are available:

- **Create a new tweet:**

- Method: POST
- URL: `/tweets`
- Request Body:
 ```json
 {
   "content": "This is my tweet content",
   "userId": 123
 }
 ```

- **Get tweets for a specific user:**

- Method: GET
- URL: `/1/tweets`

- **Get a specific tweet:**

- Method: GET
- URL: `/tweets/{tweetId}`

- **Update a tweet:**

- Method: PUT
- URL: `/tweets/{tweetId}`
- Request Body:
 ```json
 {
   "content": "Updated tweet content"
 }
 ```

- **Delete a tweet:**

- Method: DELETE
- URL: `/tweets/{tweetId}`

Note: Replace `{userId}` and `{tweetId}` in the URLs with the appropriate user and tweet IDs.

## Database
```
server:
  port: 8081


spring:
  application:
    name: TWITTER-SERVICE
  datasource:
    url: jdbc:mysql://localhost:3306/{collection}
    username: {username}
    password: {password}
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.
