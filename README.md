# Micro-Services-SmartSchool (Academic Project)
### Getting Started with Micro Service Architecture :
In this application we have a total of 9 microServices :
| MicroService | Description |
| ------------ | ----------- |
| Api-Gateway  | API management tool that sits between a client and a collection of backend services|
| Eureka-Server-MS | This micro service is Our discovery Server  |
| User-management-MS | This micro service is designed to manage users and implement Authentication and Authorisation |
| Node-Server-MS | This micro service is designed to manage classes |
| Event-Server-MS | This micro service is designed to manage all the School events | 
| Reclamation-Server-MS | This micro service is designed to manage all the reclamations |
| Forum-Server-MS | This micro service is designed to manage all the School Forums | 
| Club-Server-MS | This micro service is designed to manage all the School Clubs | 
| Course-Server-MS | This micro service is designed to manage all the School Courses | 

### MSs & their PORTS
| MicroService | local PORT |
| ------------ | ----------- |
| Api-Gateway | 8051 |
| Eureka-Server | 8761 |
| User-MS | 8060 |
| Course-MS | 9090 |
| Node-MS | 5000 |
| Reclamation-MS | 8040 |
| Forum-MS | 8080 |
| Event-MS | 8090 |
| Club-MS | 9000 |

### how to run this application :
1- download the code of this repo 
2- install all the dependencies 
3- run `maven clean install` to all the micro services 
4- go to the root folder then run `docker compose up`
