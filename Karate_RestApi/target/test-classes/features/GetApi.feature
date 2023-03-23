Feature: GET api feature

Scenario: get the user details

Given url 'https://gorest.co.in/public/v2/users/'
And path '331868'
When method GET
Then status 200 
* print response 
* def jsonResponse = response
* print jsonResponse
* def userName = jsonResponse.name
* def userEmail = jsonResponse.email
* def userGender = jsonResponse.gender
* def userStatus = jsonResponse.status  
* print userName
* match userName == 'Anjushri Pandey'

#Get user info with invalid id
Scenario: get the user details

Given url 'https://gorest.co.in/public/v2/users/'
And path '8446'
When method GET
Then status 404 

# Get API with query parameters
Scenario: get all active female users details

* def query = {status:"active", gender:"female"}
Given url 'https://gorest.co.in/public/v2/users/'
And params query
When method GET
Then status 200 
* print response


Scenario: get all active male users details

* def query = {status:"active", gender:"male"}
Given url 'https://gorest.co.in/public/v2/users/'
And params query
When method GET
Then status 200 
* print response


# Get all the active users count
Scenario: GET all active users

* def query = {status:"active"}
Given url 'https://gorest.co.in/public/v2/users/'
And params query
When method GET
Then status 200
* print response
* def countofActiveUsers = response.length
* print countofActiveUsers
* match countofActiveUsers == 10










