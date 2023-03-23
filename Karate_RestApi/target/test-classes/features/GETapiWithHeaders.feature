Feature: Get the API headers feature


Scenario: Get the user details by passing request headres-Part1

Given header Accept = '*/*'
#And header Accept-Encoding = 'gzip, deflate, br'
And header Connection = 'keep-alive'
And header Authorization = 'Bearer 4134efa5f6ab5687726a5c97fa5c47abd22b702ca1cb2bcafa514adaefbe7d2f'

Given url UrlBase+'/public/v2/users/'
And path '838474'
When method GET
Then status 200
* print response


Scenario: pass the Get request by passing request headres-Part2

* def request_headres = {Accept: '*/*', Connection: 'keep-alive', Authorization: 'Bearer 4134efa5f6ab5687726a5c97fa5c47abd22b702ca1cb2bcafa514adaefbe7d2f'}
Given headers request_headres
Given url UrlBase+'/public/v2/users/'
And path '838474'
When method GET
Then status 200
* print response


Scenario: pass the Get request by passing request headres-Part3

* configure headers = {Accept: '*/*', Connection: 'keep-alive', Authorization: 'Bearer 4134efa5f6ab5687726a5c97fa5c47abd22b702ca1cb2bcafa514adaefbe7d2f'}

Given url UrlBase+'/public/v2/users/'
And path '838474'
When method GET
Then status 200
* print response
* print tokenID