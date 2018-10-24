# unit-converter
Simply Web Application, which can convert various units.

## Technologies:
* Java 8
* Spring Boot 2.0.4
* Hibernate/JPA
* HTML + CSS
* Thymeleaf

## Description:

**If app is running homepage's url is  http://localhost:8080**

There client can choose units which want converted. Cal-Cm and Mil-Km is available so far. After choice client is redirected to appriopriate sub-page and there he can convert values to other.

Every client's query is saved in database and last three are displayed on the client's screen.

### Start app

**IDE**

To start app, you need download this repository and in your IDE import file pom.xml 

Now you need run main method (com.drapala.unitconverter.UnitConverterApplication) in your IDE. It is available in unit-converter/src/main/java/com/drapala/unitconverter/nitConverterApplication.class

**cmd**

To start app in cmd, you need except Java 8, Maven 3 installed.

To run, after download you need into quiz folder use command:

```
mvn clean install
```

Next
```
java -jar target/unit-converter-0.0.1-SNAPSHOT.jar
```

## Database:

All client's query are stored in database.

If app work, database is available in url: http://localhost:8080/h2-console/
