Feature: Login into Application

Scenario Outline: Positive test validating login

Given Initialize the browser with chrome
And Navigate to the "http://www.qaclickacademy.com" site
And Click on Login link in home page to land on secure sing in page
When User enters <username> and <password> and longs in
Then Verify that user is succesfully logged in

Examples:
|username		|password	|
|asd@asd.com	|1234		|
|asd123@wqe.com	|6789		|