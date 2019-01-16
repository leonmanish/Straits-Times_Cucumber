Feature: Test main article on Straits Times home page
        As a user I should able to login into my web application
 
 
  Scenario: I navigate to login page when click on login link on home page
 			Given I navigate to "https://www.straitstimes.com"
 				When I click on login link
        Then I should go to login page
      
 
 Scenario Outline: I login with valid credential
 			Given I am on the login page of Straits Times
       When I enter valid <username> and <password>
       And I click on login button
       Then I should get successfully logged-in

       
		Examples:
    |username|password|
    |"digitaltest10"|"Sphdigital1"|
    
 Scenario: Verify main article have media file
 		Given I am on the home page of logged in user
 		When I verify main article have media file
 		Then I get media file successfully
 		
 Scenario: Verify main article text content should be same as home page
 		Given I am on main article
 		When I verify text content of main article
 		Then I should get same text as home page
 		
 	
 		
 		

 