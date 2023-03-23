Feature: Testing Delete user API

Background: 
 * url  'https://gorest.co.in/public/v2/users/'
 
Scenario: Deleting the user details
Given path '291127'
And headers Authorization = 'Bearer' + tokenID
When method Delete
Then status 204


# verifying user deleted or not

Given path '291127'
And headers Authorization = 'Bearer' + tokenID
When method Get
Then status 404
* print response
* match $.message = 'Resource not found'