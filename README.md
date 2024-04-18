# API that converts values ​​between foreign currencies.

 ## API documentation

This project uses ```Java 11```, ```Spring Boot v2.5.5``` and unit tests with ```JUnit 5```. For documentation, ```Swagger``` was used. Logs were captured using the Spring Boot project's standard log framework.

 ## Hands On

1.Before cloning the project, make sure you have previously installed ```Java 11``` and ```Maven```. After that, clone the project and wait for your favorite ```IDE``` to download the necessary artifacts contained in ```pom.xml```.
Once completed, look for the main class ```MoneyapiApplication``` and run it using ```CTRL + SHIFT + F10``` or simply click the run button.

2.Open your favorite requests tool: ```Postman```, ```Insomnia```, or some other and execute the following requests:
- For the HTTP ```POST``` method: choose the currencies you want to convert. One for Base (origin) and one for destination.
- Example 1: From Dollar (USD) to Real (BRL)
        -  Request body:
                    ```{ "userdID":  1,
                         "fromCurrency":  "BRL",
                         "toCurrency":  "USD",
                         "value":  1	}```

<img width="600" alt="Screenshot 2024-04-18 at 00 16 59" src="https://github.com/ClaudioAds/jaya-challange/assets/8331728/252a9bd2-bafb-4629-aa0a-246ee1f2826f">

  

- For the HTTP ```GET``` method: execute the request -> ```localhost:8080/exchange/list?userID=1```. Where the ```userID``` represents the user you used to make and currency conversions.

<img width="250" alt="Screenshot 2024-04-18 at 00 11 07" src="https://github.com/ClaudioAds/jaya-challange/assets/8331728/9efa9d82-51c7-4b3e-92b2-e651030ebd4d">

## Using Heroku

- If you want to make requests to the Currency Conversion API that is in the cloud, using the ```Heroku``` service, simply add the URL = ```https://jaya-challange-6b2e1ee8516a.herokuapp.com``` of the application to your favorite request tool and make operations:
  - For the HTTP ```POST``` method: choose the currencies you want to convert. One for Base (origin) and one for destination.
  - Example 1: From Euro (EUR) to Real (BRL)
        -  Request body:
                    ```{ "userdID":  1,
                         "fromCurrency":  "BRL",
                         "toCurrency":  "USD",
                         "value":  1	}```



<img width="700" alt="Post Heroku" src="https://github.com/ClaudioAds/jaya-challange/assets/8331728/003161b1-a961-4275-bfbb-8f50a88aa7cc">



   - For the HTTP ```GET``` method: execute the request -> ```https://jaya-challange-6b2e1ee8516a.herokuapp.com/exchange/list?userID=1```. Where the ```userID``` represents the user you used to make and currency conversions.


<img width="600" alt="GET Heroku" src="https://github.com/ClaudioAds/jaya-challange/assets/8331728/94d730e2-edb3-44eb-9943-f8793be93b6f">

    
