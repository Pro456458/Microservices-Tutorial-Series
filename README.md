# Microservices Tutorial -Project

# Project Directory 

6 API
HotelService -mySQL
UserService -PostgresSQL
RatingService -MongoDB
API Gatway
Services Registry
Config Server


****************How to starts the aplication and test ************

1) Start the Application Services Registory
END Point URL : http://localhost:8761/

2) Start The Application API Gatway

3) Start rest of three microservices Hotel,User,rating in any order
 END Point URL Registred with Eureka: http://desktop-2lvds24:8081/userServices/users

http://localhost:8081/userServices/users


-----------------------------------------------------------
http://localhost:8082/ratingServices/ratings
http://desktop-2lvds24:8082/ratingServices/ratings
-----------------------------------------------------------
http://localhost:8083/hotelService/hotels
http://desktop-2lvds24:8083/hotelService/hotels
-----------------------------------------------------------



DB detail
MongoDB
url: mongodb://localhost:27017
db: microservices