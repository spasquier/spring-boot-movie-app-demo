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
MovieApp              : Started MovieApp in 1.973 seconds (JVM running for 2.548)
```

When the app is ready to receive requests you can access it from the following URL:

http://localhost:8080

## Browsing the Database
This project includes a PGAdmin4 Docker container, so you can easily browse the Database container in the following URL:

http://localhost:8081

The default user is `admin@localhost` and the default password is `postgres`.

Once you are inside PGAdmin4 you can add a new `Server` to connect to the `db` Docker container and easily browse the
database, just fill the following fields:

```text
General Tab
Name: db

Connection Tab
Host name/address: db
Port: 5432
Maintenance Database: postgres
Username: postgres
Password: postgres
```

After adding the server you can connect and easily browse all the app tables.
