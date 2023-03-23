Feature: GET API token

Scenario: GET API token from Karate config.js

* print tokenID
* def query = {gender:'male'}
Given header Authorization = tokenID
Given url UrlBase+'/public/v2/users/'
And params query
When method GET
Then status 200
* print response


