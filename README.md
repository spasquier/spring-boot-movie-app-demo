# Demo Movie App

## Getting Started

### Requirements
- Install OpenJDK 8 (java 1.8), you can download it here: https://developers.redhat.com/products/openjdk/download
- Install Docker Desktop for Mac or Windows or Docker Engine for Linux: https://docs.docker.com/engine/install/

### Build the App
1. Copy the file "database/src/main/resources/application.properties.example" to
   "database/src/main/resources/application.properties"

If you are going to use Docker to run the app on your local environment, then you don't need to modify the file.

If you are planning to run the app on your host machine, then change the Postgres configuration properties, so the  app
can use your local Postgres installation. Also, you will need to import the database in "docker/init.sql"

2. Open your console and change your working directory to this project.

3. Generate the JAR file for the Docker deployment executing the following command:

```bash
mvnw package
```

### Start the Docker Container
Once the app has been built, you can set up a development environment with Docker to review the app. You can start this
app container and all its dependencies with the following command:

```bash
docker-compose up --build
```

Wait until the console shows that the REST API container is ready, it should show something like this:

```text
TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
MovieApp         : Started MovieApp in 1.973 seconds (JVM running for 2.548)
```

When the app is ready to receive requests you can access it from the following URL:

http://localhost:8080

## Browsing the Database
This project includes a PGAdmin4 Docker container, so you can easily browse the Database container:

http://localhost:8081

The default user is `admin@localhost` and the default password is `postgres`.

Once you are inside PGAdmin4 you can add a new `Server` to connect to the `db` Docker container and easily browse the
database, these would be the connection details:

```text
Connection Tab
Host name/address: db
Port: 5432
Maintenance Database: postgres
Username: postgres
Password: postgres
```

## Developing

### Changing the initial database dump

If you want to make any changes to the "docker/init.sql", you need to recreate the Postgres container. Execute the
following command to recreate the Postgres container and init the database again:

```bash
docker-compose up --build --force-recreate
```
