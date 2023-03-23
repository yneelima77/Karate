Feature: Create user using POST method

Background: 
    * url 'https://gorest.co.in/'    
    * def RequestPayload =
  """
  {
        "name": "Joe",
        "email": "joe123@gmail.com",
        "gender": "male",
        "status": "active"
  }
    
  """
  
Scenario: Create user data using given payload

Given path 'public/v1/users'
And request RequestPayload
And header Authorization = 'Bearer' + tokenID
When method POST
Then status 201
* print response
And match $.data.id ==  '#present'
And match $.data.name == '#present'
And match $.data.email ==  '#present'
And match $.data.gender == '#present'
And match $.data.status ==  '#present'

