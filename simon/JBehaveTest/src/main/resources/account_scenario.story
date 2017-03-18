Scenario: Move money when I have enough money
Given an account with 10 euros
And another with 0 euros
When I transfer 5 euros
Then the first account should have 5 euros
And the second one 5 euros


Scenario: Move money without enough money
Given an account with 5 euros
And another with 0 euros
When I transfer 10 euros
Then the first account should have 5 euros
And the second one 0 euros
