Feature: Automated End2End Tests
   Description: The purpose of this feature is to test End 2 End integration.
   
   Scenario Outline: Customer place an order by purchasing an item from search
      Given the user is in the home page
      When he search for "<productName>"
      And choose to buy two items
      And moves to checkout cart and enter personal details on checkout page and place the order
      Then he can view the order and download the invoice
      
      
      Examples:
        | productName |
        | Apple MacBook Pro 13-inch |
