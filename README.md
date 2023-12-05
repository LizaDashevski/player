# Player API
Microservice that expose REST API for getting and listing players
Spring Boot microservice with spring data and postgres. 
The application is deployed with docker compose.

## What this repo does
Load the players data from CSV file into postgres DB


## Try it out
Build the app by running:
```bash
mvn clean install -DskipTests
```
note: due to lack of time my tests fail. I didn't have time to fix the issue.

* To run mvn install with the tests we need to have postgres running.
```bash
docker compose up postgres -d
mvn clean install
docker compose down
```

Start the app by running:
```bash
docker compose up --build -d
```
This will build a docker container with the player app jar and start the container
It will also start a postgres DB container

You should be able to interact with the app using the curl command
e.g.
### list all players
```bash
curl  http://localhost:8080/api/players
```

### Get player by PlayerID
```bash
curl  http://localhost:8080/api/players/hassoge01
```

### Troubleshooting
To view the player app logs execute:
```bash
docker logs player-app-1
```


## Things I would do differently:
1. add more test cases
2. add logging
3. learn more about best practises with Spring boot, spring data and context
4. add input validation and a better exception handling
5. improve the list method:
   a. add filter functionality 
   b. add pagenation
6. complete CRUD
7. I had a mismatch of java versions, mvn java version was 11 and the project used 17.
I got "Java: Error: Release version 17 not supported". This took a lot of time figuring out.
In the end I reinstalled java and reconfigured my JAVA_HOME.
