Feature: Sigingnup
@test
Scenario Outline: Someone who wants to sign up
Given I have used "<chrome>"
When I have entered "<email>" into the signup
When User enters "<username>" and "<password>" 
When I press sign up
Then I should be signed up "<result>"
Examples: 
| browser | email | username | password | result |
| Chrome | | noemailuser | HelloWorldddddddd234! | Please enter a value |
| Chrome | asdaadfffsd@asd.com | randomuser | HelloWorlddddddd234! | Signup sucess |
| Chrome | asdassadffd@asd.com | alreadytaken | HelloWorlddddddd234! | Another user with this username already exists. Maybe it's your evil twin. Spooky. |
| Chrome | asdasddssd@asd.com | longuser | HelloWorlddddddd234! | Enter a value less than 100 characters long |

