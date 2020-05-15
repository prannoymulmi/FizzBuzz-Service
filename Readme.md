# FizzBuzz Service
 This is a simple service which shows the simple service from the Kata catalog. 
 
 The rules of this application is very straight forward, which are as follows:
 
 * Application expects an number, from which the corresponding results are derived. 
 * All numbers greater than 0 are valid.
 * All numbers divisible by 3 return the value Fizz.
 * All numbers divisible by 5 return the value Buzz.
 * All numbers divisible by 3 and 5 return the value FizzBuzz.
 * All numbers not divisible by 3 and 5 return the input number.
 
 ### Running the Application
 There are various ways to run the application locally, either by using your preferred IDE, i.e. IntellJ, Eclipse or by using
 the command line. Below you can find a snippet of how one can run the application using the CMD.
 
   ```
   # You need to have Maven installed for it 
    mvn spring-boot:run
```
 
 ### Swagger
 When the application is started the post request can be sent using the swagger ui present in the application itself. 
 [Swagger UI local link](http://localhost:9012/swagger-ui.html). It is important that the application to be started before to use
 swagger. A Screenshot of the Swagger UI can be seen below.
  
 ![Swagger UI for the Rest API](./swagger.PNG)