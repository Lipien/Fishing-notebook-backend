### Fishing-notebook
Backend of an application that combines fishing weather status dashboard and fishing registry for chosen river sections:
- connects automatically (time interval set on one hour) to meteorogical APIs: IMGW (rivers water levels) and Accuweather (current weather data from chosen stations)
- stores the data in MySQL database
- shares the weather & hydro information through "hydro-and-weather-controller" endpoint
(Swagger screenshot): https://1drv.ms/u/s!Alk4lPJiK05Jg-EV-XTDBiymSLz8kQ
- offers write & read fishing register functionality through "fishing-registry" enpoints

### Techical information and system requirements
- Java8
- Spring Boot 2.1.5.RELEASE
- Lombok 1.18.8
- Gradle 4.10.2
- MySQL 8.0.14
- Swagger 2.9.2

### Launching the project
Runs at port 8080 (http)

### Endpoints documentation
Available through SwaggerUI: http://localhost:8080/swagger-ui.html

## Application frontend
https://github.com/Lipien/Fishing-notebook-frontend
