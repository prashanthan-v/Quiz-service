# Quiz Application Microservices
![Architecture of Quiz microservice](https://kambei.dev/assets/img/posts/architecture_step_I.jpg)

Welcome to the Quiz Application Microservices project! This project is aimed at providing quiz functionalities to users through microservices architecture.

## Overview

The project consists of two microservices:

1. **Quiz Service**: This microservice handles user requests for quizzes. It communicates with the Question Service to retrieve questions and evaluate answers.

2. **Question Service**: Responsible for managing questions and evaluating user answers. It communicates with the Quiz Service to provide questions and evaluate answers.

Both microservices are registered with the Eureka Server for service discovery and utilize API Gateway for external communication.

## Architecture

The architecture of the Quiz Application Microservices is as follows:

1. User Request -> Quiz Service -> Question Service (for questions) -> User Selection -> Quiz Service -> Question Service (for evaluation) -> Response


## Technologies Used

- <img align="top" alt="Coding" width="400" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQ-Hu6MkS0D4rqNHlTwD-YHp3HD-i0twnGGgWGG2emMV2Vm5gDqxmKmpk2-b7kqKfHAvk&usqp=CAU"> 
- **Spring Boot**: Framework for building microservices.
- **Eureka Server**: Service registry for registering microservices.
- **API Gateway**: Provides a single entry point to the microservices.
- **OpenFeign**: Used for communication between microservices.
- **JUnit**: Unit testing framework for Java.
- **Mockito**: Mocking framework for unit tests.
- **MockMvc**: Mocking framework for testing Spring MVC applications.
- **AssertJ**: Assertion library for fluent assertions in tests.

## Setup Instructions

1. Clone this repository.
2. Navigate to the root directory of each microservice.
3. Run `./mvnw spring-boot:run` to start each microservice.
4. Ensure Eureka Server and API Gateway are running.
5. Test the endpoints using tools like Postman or curl.

## Unit Testing

Unit tests are implemented in the Question Service using JUnit, Mockito, MockMvc, and AssertJ. 




