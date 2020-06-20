# restaurant

Requirements:
1. 2 Rest Services, one simulating restaurant and another simulating delivery person
2. When delivery service is started it tells restaurant service its host and port
3. Post api to place an order
4. Get api to get status of the order
5. Post api to update status of the order
6. Post api to assign order to delivery person
7. Get api to get current status of delivery person

Overview:
This is restaurant service written as a spring boot project. It handles data about restaurant products and customer orders.
'SampleData' class is provided to manage all data in memory. Data is categorised with two entities namely 'OrderDetails' and 'ProductDetails'.

Project Structure:
src/main/java/com/restaurant--
1. Controller-contains all rest apis specifications
2. Service-service layer contains all logics for the apis
3. Dao-dao layer communicates with database for fetching or updating database
4. Models-contain database entities and other entities
5. Request-contains request entities
6. Response-contains api response entities
7. Commons-contains 'SampleData' and 'Constants'
8. Validators-contains code for validations.

Solution:
(requrement1). This is restaurant service written as a spring boot project.
(requirement2). An api is provided by restaurant service (find in 'AdminController') to delivery service for registering delivery service's current host and port. Whenever delivery service is started it can hit this api to tell its current host and port.
(requirement3). Find api in 'RestaurantController' with Post mapping 'restaurant/order/place'.
(requirement4). Find api in 'RestaurantController' with Get mapping 'restaurant/order/status'.
(requirement5). Find api in 'RestaurantController' with Post mapping 'restaurant/order/status'.

Notes:
This project is a spring boot project which is designed for production readiness in future but currently maintaining all states in memory while it has already been integrated with mysql database.
This project demonstrates my coding styles and project structures 
Authorisation and security has not been added to apis as it was not in requirements.
