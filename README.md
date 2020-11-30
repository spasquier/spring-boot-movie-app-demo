# Demo Movie App

## Getting Started

### Build the App
First open your bash console (if you are using Windows I recommend installing Git Bash) and change your working
directory to this project. For example if the path to the root of this project is "C:\Users\me\Documents\movie-app":

```bash
cd /c/Users/me/Documents/movie-app
```

To build the app and generate a JAR file for deployments, execute the following command:

```bash
mvnw package
```

### Start the Docker Containers
Once the app has been built you can set up a development environment with Docker to check the app.
You can start this app container and all its dependencies with the following command:

```bash
docker-compose up
```

Wait until the console shows that the REST API container is ready, it should show something like this:

```text
o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
com.movie.app.demo.MovieApp              : Started MovieApp in 1.973 seconds (JVM running for 2.548)
```

When the app is ready to receive requests you can access it from the following URL:

http://localhost:8080

## Browsing the Database
To explore the database you can use the PGAdmin4 container included in the Docker environment from the following URL:

http://localhost:8081

The default web user is `admin@localhost` and the default password is `postgres`

Once you're inside PGAdmin4 you can create a new connection to the Docker db container with the following details:

```text
Host: db
Port: 5432
User: postgres
Pass: postgres
```

After connecting you will be able to browse al the tables and data that this app is using.
