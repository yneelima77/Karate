Feature: Delete user details 
Background: 
  * url  'https://gorest.co.in/'
  * def random_String = 
    """
     function(s){
     var text = "";
     var pattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  
     for(var i=0; i<s; i++)
     text += pattern.charAt(Math.floor(Math.random()*pattern.length()));
     return text;
     }
     """
   * def Random_EmailString = random_String(10)  
   * def RequestPayload = 
    """
    { 
        "name": "Joe",
        "gender": "male",
        "status": "active"
    }
    """
     * set RequestPayload.email = Random_EmailString +'@gmail.com'
     * print RequestPayload
    
 Scenario: Adding user details using POST api

 Given path 'public/v2/users'
 And request RequestPayload
 And headers Authorization = tokenID   
 When method POST
 Then status 201
 * print response
 * def user_id = response.id
 * match $.email = RequestPayload.email
 
 
 Scenario: Delete user using delete Api
 
  Given path 'public/v2/users'
  And path user_id
  And headers Authorization = tokenID   
  When method Delete
  Then status 200
 
 
 
 
 