# Getting Started

Minimalist web server.

## Features

### Release 0.0.1

- serve static content

## Options

`static.resources`

resource path to the folder that you want to serve. Note: path must end with `/`

## Build

```
set PATH=C:\a\software\apache-maven-3.5.0\bin;C:\Program Files\Java\jdk1.8.0_131\bin;%PATH%
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
mvn clean package
```

## Run

```bash
SET PATH=C:\Program Files\Java\jre1.8.0_181;%PATH%
java "-Dstatic.resources=file:C:/path/to/folder/" -jar .\target\simple-http-server-${project.version}.jar
```