Spring Boot Rest

This project provides a boilerplate code to start a REST service providing program in couple of seconds.

Setup
In order to run this program you need to have Java(1.7 or above) and Maven installed on your system. Hence set up your workplace by installing necessary softwares.

Clone
Once you install the necessary softwares you can clone this project very easily using the following command.
cd <your_working_directory>
git clone https://github.com/tharsans/spring-boot-rest.git

Start Application. 
You can start application using follwing commands
cd rest
mvn spring-boot:run

Test the application

Now that the application is running, you can test it. You can use any REST client you wish. The following examples use the tool curl.

List of users
$ curl http://localhost:8090/users/
You will receive an success status code, but with empty set of users as we haven't add any single user.

{"code":0,"message":"OK","data":[]}

Hence we need to add users first

Add user

$ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "Robin", "age": 15 }' 'http://localhost:8090/users/'
             
 This will create a new user called "Robin" and you should get a following response.
 
{"code":0,"message":"User Robin has been created successfully","data":null}
 
 Invalid data
 
 $ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "Robin", "age": 150 }' 'http://localhost:8090/users/'
 
 If invalid data is entered then it will throw an error. If age is entered above 100, then it will throw an exception as below.
 
 {"exception":"asia.embla.exception.InvalidDataException", "message":"The given age is not valid"}
 
 If name is not provided, different error message will be thrown.
 $ curl -X POST --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "name": "", "age": 100 }' 'http://localhost:8090/users/'
 
 {"exception":"asia.embla.exception.InvalidDataException", "message":"Name is not provided"}
 
 Get user
 You can get a user by giving user id as parameter
 $ curl 'http://localhost:8090/users/1'
 
 You will receive following error message.
 {"code":0,"message":"OK","data":{"id":1,"name":"Robin","age":15}}
 
 $ curl 'http://localhost:8090/users/100'
 If you enter an invalid id, you will get an error message as below.
 
 {"exception":"asia.embla.exception.ItemNotFoundException","message":"The user does not exists"}
 
Update user
In the same way a user can be updated
$ curl -X PUT --header "Content-Type:application/json" --header 'Accept: application/json' -d '{ "id" : 1, "name": "Rpbert", "age": 100 }' 'http://localhost:8090/users/'

If update does not contain any validation or any others, then user will get updated and you will get following message.

{"code":0,"message":"User Rober has been updated successfully","data":null}

If a user does not exists you will receive an "The user does not exists" message.

Delete user

An existing user can be deleted using following command

