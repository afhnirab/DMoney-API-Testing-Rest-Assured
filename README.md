# DMoney-API-Testing-Rest-Assured

## Scenarios
  1. Call login API
  2. Create a new customer and an agent
  3. Search by the customer phone number
  4. Deposit 5000 tk to the Agent from system
  5. Deposit 2000 tk by agent to customer 
  6. Check balance of customer
  7. Check statement by trnxId 
  8. Withdraw 1000 tk by customer and assert expected balance
  9. Send 500 tk to another customer and assert expected balance
  10. Check customer statement
  
## Negative Scenarios
  1. Call login API with invalid credential
  2. Create a new customer and an agent with invalid credentials
  3. Search by the wrong customer phone number
  4. Deposit 9 tk to the Agent from system
  5. Deposit 9 tk by agent to customer 
  6. Check balance of customer with wrong customer phone number
  7. Check statement by incorrect trnxId 
  8. Withdraw 9 tk by customer and assert expected balance
  9. Send 9 tk to another customer and assert expected balance
  10. Check customer statement providing invalid phone number
  
## Technology Used
  1. Rest Assured
  2. TestNG
  3. Common Configuration
  4. Jackson-Databind
  5. Java
  6. Java Faker
  7. Lombok
  8. Allure 
  9. Intellij IDEA
  
## Test Case link: https://docs.google.com/spreadsheets/d/13MnpK4-6EbXfWOnsa0cOj4BzEqpdjgxC/edit?usp=share_link&ouid=103265193281270670621&rtpof=true&sd=true

## ScreenShot
![image](https://user-images.githubusercontent.com/61575633/231577002-4dc0d9ae-eda4-4c93-80d4-72ea20678d87.png)
![image](https://user-images.githubusercontent.com/61575633/231577115-9a46b832-8c22-4115-a043-1471093e7222.png)

# Video
https://user-images.githubusercontent.com/61575633/231577246-afb6b4a9-967e-4a2d-97d9-3a7c4c211a48.mp4


