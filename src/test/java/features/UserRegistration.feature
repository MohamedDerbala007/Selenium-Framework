Feature: User Registration
   Description : I want to check that the user can register in our e-commerce website.
   
Scenario Outline: User Registration
Given the user is in the home page
When I click on register link
And I entered "<firstName>" , "<lastName>" , "<email>" , "<oldPassword>"
Then The registration page displayed successfully 

Examples:
  | firstName | lastName | email | oldPassword |
  | Mohamed | Derbala | Mohamedderbala1266@test.com | 123456 |
  | Test | User1 | Test.user1@test.com | 1234567 |
  | Test | User2 | Test.user2@test.com | 12345678 |