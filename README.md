# Imaginary Robotic Hoover

A Java/Springboot-based REST API that navigates a imaginary robotic hoover (much like a Roomba) through an equally imaginary room

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql)
- [Maven 3](https://maven.apache.org)
- [IntelliJ IDE](https://www.jetbrains.com/idea/download/#section=windows) or any other Java based IDE
- Install Lombok in your IDE


## Getting Started

1. **Clone the application**

   ```bash
   git clone https://github.com/victor-onu/yotiAssessment.git
   cd yotiAssessment
   ```

2. **Create MySQL database**

   ```bash
   create database yoti in your mysql server, although it will be creted if it does not exist
   ```


3. **Change MySQL username and password as per your MySQL installation**

   + open `src/main/resources/application.yml` file.

   + change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

   There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.yotiassessment.YotiAssessmentApplication` class from your IDE.

   Alternatively you can run the following command

   ```bash
   mvn spring-boot:run
   ```

   The server will start on port 8090.


## Testing the endpoints on Postman

# POST
**Starts the robotic hoover returning the number of patches cleaned and final hoover position - (Use [Request](#Clean Patches Request Sample) below)**

	http://localhost:8090/api/clean-patches


# Clean Patches Request Sample

	{
        "roomSize" : [5, 5],
         "coords" : [1, 2],
         "patches" : [
         [1, 0],
         [2, 2],
         [2, 3]
         ],
         "instructions" : "NNESEESWNWW"
    }
# Clean Patches Success Response Sample	
    {
         "status": "OK",
         "message": "Retrieved response successfully",
         "error": null,
         "timestamp": "15-05-2022 10:15:52",
         "debugMessage": null,
         "subErrors": null,
         "data": {
         "coords": [
         1,
         3
         ],
         "patches": 1
         }

    }




## Built With

- Java
- Springboot
- MySql
- Maven
- Hibernate
- Hypersistence
- GitHub

