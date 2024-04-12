"# StayEase" 

## Setup

To run this application locally, follow these steps:

1. Clone this repository:

   ```bash
   git clone https://github.com/ntnmnk/StayEase
   ```

2. Build the application using gradle:
    ```bash
   ./gradlew build clean
   ```

3. Run the application:
    ```bash
    java -jar build/libs/StayEase-0.0.1-SNAPSHOT.jar
    ```
 

## User Endpoints



## User Auth Endpoints
### Public Endpoints
- POST /api/v1/auth/signup - Register a new user (Role can be ADMIN, CUSTOMER, HOTEL_MANAGER), Default Role: CUSTOMER.
    ### Request Body
    ```json
    {
    	  "firstName": "YourFirstName",
  "lastName": "YourLastName",
  "email" : "your-email@example.com",
  "password" : "your-password"

    }
    ```
    ### Request Body
    ```json
    {
    	"firstName": "",
        "lastName": "",
        "email" : "",
        "password" : "1234"
    }
    ```

