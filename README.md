# Spring Boot Rest
This project provides a boilerplate code to start a REST service providing program in couple of seconds.

## Set Up
In order to run this program you need to have Java(1.7 or above) and Maven (2 or above) installed on your system. Hence set up your workplace by installing both.    
  - Import a HTML file and watch it magically convert to Markdown
  - Drag and drop images (requires your Dropbox account be linked)

## Clone
Once you install the necessary softwares you can clone this project very easily using the following command.
   
     cd <your_working_directory> 
     git clone https://github.com/tharsans/spring-boot-rest.git

## Start
You can start application using follwing commands

    cd spring-boot-rest
    mvn spring-boot:run
    
If application started without any issues, then you may notice a message as "Started Application in x seconds" in the console. 
    
## Test
Now that the application is running, you can test it. You can use any REST client you wish. The following examples use the tool curl.

### 1. Add user
    $ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "Robin", "age": 15 }' 'http://localhost:8090/users/'
    
This will create a new user called "Robin" and you should get a following response.

    {"code":0,"message":"User Robin has been created successfully"}
    
#### 1.1 Invalid age
If invalid data is entered then it will throw an error.

    $ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "Robin", "age": 150 }' 'http://localhost:8090/users/'
    
 If age is entered above 100, then it will throw an exception as below.

    {"exception":"asia.embla.exception.InvalidDataException", "message":"The given age is not valid"}
    
#### 1.2 Invalid name
If name is not provided, different error message will be thrown. 

    $ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "", "age": 100 }' 'http://localhost:8090/users/'

    {"exception":"asia.embla.exception.InvalidDataException", "message":"Name is not provided"}
    
### 2. Get user
You can get a user by giving user id as parameter 
    $ curl 'http://localhost:8090/users/1'
    
You will receive following error message. 

    {"code":0,"message":"OK","data":{"id":1,"name":"Robin","age":15}}
    
#### 2.1 Invalid id
If you enter an invalid id, you will get an error message as below.
   
    $ curl 'http://localhost:8090/users/100' 
    
    {"exception":"asia.embla.exception.ItemNotFoundException","message":"The user does not exists"}
    
### 3. Update user 
In the same way a user can be updated  

    $ curl -X PUT --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "id" : 1, "name": "Robert", "age": 100 }' 'http://localhost:8090/users/'
    
If update does not contain any validation or any others, then user will get updated and you will get following message.

    {"code":0,"message":"User Robert has been updated successfully"}
    
If a user does not exists you will receive an "The user does not exists" message.

### 4. Delete user
An existing user can be deleted using following command

    curl -X DELETE 'http://localhost:8090/users/1'
    
    {"code":0,"message":"User Robert has been deleted successfully"}
    
### 5.List of users
Before we execute list of users, lets, add some more users using add command as shown above. Once you add users, execute below command to get list of users

    $ curl http://localhost:8090/users/
    
You will receive an success status code, message and set of users as shown below.

    {"code":0,"
    message":"OK",
    "data":[{"id":1,"name":"Robin","age":15},
            {"id":2,"name":"Russel","age":25},
            {"id":3,"name":"Richard","age":35}]
            
