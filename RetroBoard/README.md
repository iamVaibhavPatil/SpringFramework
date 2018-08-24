# Retro Board
Retro board project is the basic web application built using Spring Boot, Spring Web, Security and H2 in memory DB 
to demonstrate the basic application on ideas board for a team.

## Feature

- **Login**  
It has login feature which is protected using default Spring Security intercepter page.  

![Alt text](https://github.com/vaibhavpatilai/SpringFramework/blob/master/RetroBoard/login.JPG?raw=true "Login to Application")

- **Dashboard**  
Dashboard is basically shows all the ideas from different users and we can also post ideas which can be seen by other users.

![Alt text](https://github.com/vaibhavpatilai/SpringFramework/blob/master/RetroBoard/comment.JPG?raw=true "Dashboard")

### Running Application

1. Download or clone the repo

2. Run below cmd

```
mvn clean install
java -jar target/RetroBoard-0.0.1-SNAPSHOT.jar
```

OR Running using Spring Boot

```
mvn clean spring-boot:run
```

We can also check the entries in database after running application and adding some data.

![Alt text](https://github.com/vaibhavpatilai/SpringFramework/blob/master/RetroBoard/db.JPG?raw=true "H2 DB")