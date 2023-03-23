Feature: Print some Messages

Scenario: Print hello world message
 * print 'Hello World'
 * print 'sample Karate test'
 
Scenario: Do math on two numbers

 * def a = 10
 * def b = 20
 * print 'ResultSet-->' + (a + b) 
 
 Scenario: Sum of numbers
 
 * def rent = 200
 * def food = 50
 * def Remaining = 300
 * print 'Total = ' + rent + food + Remaining + '--> concatination'
 * print 'Total = ' + (rent+ food + Remaining) 