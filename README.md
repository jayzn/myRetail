# myRetail
A sample grails application highlighting creation of RESTful web services

Technical Stack:
  Grails 2.4.4
  JDK 1.8
  Embedded H2 In-memory database
(The Data for the application has been bootstrapped.)

Flow:
UrlMappings.groovy - has all the service URL mappings to the Product controller and its actions.
ProductController and its associated ProductService serve up the data from the DB.

API:
1. http://localhost:8080/myRetail/product/{productId} 
  This service returns product details (product information with price) for the given product id
  
  Sample output:
  http://localhost:8080/myRetail/product/2
  {
   "id":2,
   "sku":"IOL123",
   "name":"Optimus Prime",
   "category":"toys",
   "price":13.37,
   "last_updated":"2016-05-12"
}
  
2. http://localhost:8080/myRetail/productList/
  This service returns a list of all product details from the database
  
  Sample output:
  http://localhost:8080/myRetail/productList/
  [
   {
      "id":1,
      "sku":"AEX143",
      "name":"Stroller",
      "category":"baby",
      "price":199.99,
      "last_updated":"2016-05-12"
   },
   {
      "id":2,
      "sku":"IOL123",
      "name":"Optimus Prime",
      "category":"toys",
      "price":13.37,
      "last_updated":"2016-05-12"
   },
   {
      "id":3,
      "sku":"XYZ904",
      "name":"Sega Genesis",
      "category":"toys",
      "price":149.99,
      "last_updated":"2016-05-12"
   }
]
  
3. http://localhost:8080/myRetail/productList/{category name}
  This service returns a list of all products in the given category
  
  Sample output:
  http://localhost:8080/myRetail/productList/toys
  [
   {
      "id":2,
      "sku":"IOL123",
      "name":"Optimus Prime",
      "category":"toys",
      "price":13.37,
      "last_updated":"2016-05-12"
   },
   {
      "id":3,
      "sku":"XYZ904",
      "name":"Sega Genesis",
      "category":"toys",
      "price":149.99,
      "last_updated":"2016-05-12"
   }
]

