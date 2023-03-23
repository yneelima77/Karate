Feature: Create user data with POST call by passing JSON payload

Background: 
 * url 'https://gorest.co.in/'
 * def RequestPayload = read('classpath:src\test\resources\Payload\userInfo.json')

Scenario: Create a new user
Given path 'public/v2/users'
And request RequestPayload
And headers Authorization = 'Bearer' + tokenID
When method POST
Then status 201
* print response