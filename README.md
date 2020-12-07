# Demo Movie App

## Getting Started

### Requirements
- Install OpenJDK 8 (java 1.8) or higher: https://developers.redhat.com/products/openjdk/download
- Install PostgresSQL 9.5 or higher: https://www.postgresql.org/download/
- Install Docker Desktop for Mac or Windows or Docker Engine for Linux: https://docs.docker.com/engine/install/

### Build the App
1. Copy the file "database/src/main/resources/application.properties.example" to
   "database/src/main/resources/application.properties".

2. Change the default values in the property file to the ones of your local PostgresSQL database, also import the dump
   included in "docker/init.sql".

```text
# Database Properties
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/postgres}
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD:postgres}
```

3. Open your console and change your working directory to this project.

4. Generate the JAR file for the Docker deployment executing the following Maven command
   (this repo includes Maven wrapper so, you don't have to install it):

```bash
./mvnw package
```

If you are using Windows console, the previous command would be invalid, instead use this following:

```shell
mvnw package
```

### Start the Docker Container
After building the app, you can start all the Docker containers to review it with the following command:

```bash
docker-compose up --build
```

Wait until the console shows that the REST API container is ready, it should show something like this:

```text
TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
MovieApp         : Started MovieApp in 1.973 seconds (JVM running for 2.548)
```

When the app is ready, you can access it from the following URL:

http://localhost:8080/api/v1/movies

## Browsing the Database with PGAdmin4
This project includes a PGAdmin4 Docker container in case you don't have PGAdmin4 on your local machine, access it from:

http://localhost:8081/

The default user is `admin@localhost` and the default password is `postgres`.

Once you are inside PGAdmin4 you can add a new `Server` to connect to the `db` Docker container, these are the
connection details:

```text
Connection Tab
Host name/address: db
Port: 5432
Maintenance Database: postgres
Username: postgres
Password: postgres
```

## Development

### Changing the initial database dump

If you want to make any changes to the "docker/init.sql" and apply the changes on the Docker container you already
started, you need to recreate the `db` container. Execute the following command to recreate the all this project
containers and init the database again:

```bash
docker-compose down
docker-compose up --build --force-recreate
```

## Testing the API

You can import the Postman collection in "docs/postman_collection.json". You need to set the variable `BASE_URL` in
your Postman Environment.

You can use the Login endpoint to get a JWT, you must copy the value on the header `Authorization` (this is the JWT)
and put it on Postman Authorization tab, select the type "Bearer Token" before pasting the JWT.
