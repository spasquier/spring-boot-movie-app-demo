# Demo Movie App

## Getting Started

### Requirements
- Install OpenJDK 8 (java 1.8), you can download it here: https://developers.redhat.com/products/openjdk/download
- Install Bash shell to run the Maven wrapper, if you use linux you already have Bash support by default,
  if not, then you need to download a compatible Bash interpreter, for example: https://gitforwindows.org/
- Install Docker Desktop for Mac or Windows or Docker Engine for Linux: https://docs.docker.com/engine/install/

```bash
cd /d/Projects/Demo/movie-app
```

### Build the App
1. Open your Bash shell and change your working directory to this project.

If you are using the Bash shell included in Git for **Windows**, and for example the root of this project is
"D:\Projects\Demo\movie-app", execute the following command:

```bash
cd /d/Projects/Demo/movie-app
```

If you are using **Linux**, change your directory to the path where this project is stored, for example if this
project is in "/home/user/Documents/Projects/Demo/movie-app", execute the following command:

```bash
cd /home/user/Documents/Projects/Demo/movie-app
```

2. To generate a JAR file for deployments, execute the following command:

```bash
mvnw package
```

### Start the Docker Containers
Once the app has been built, you can set up a development environment with Docker to review the app.
You can start this app container and all its dependencies with the following command:

```bash
docker-compose up
```

Wait until the console shows that the REST API container is ready, it should show something like this:

```text
TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
MovieApp         : Started MovieApp in 1.973 seconds (JVM running for 2.548)
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

After adding the server you can connect to it and easily browse all the app tables.
