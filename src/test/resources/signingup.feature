Feature: Sigingnup
@test
Scenario Outline: Someone who wants to sign up
Given I have used "<chrome>"
When I have entered "<email>" into the signup
When User enters "<username>" and "<password>" 
When I press sign up
Then The "<result>" should be for "<username>"

Examples: 
| browser | email | username | password | result |
| Chrome | | noemailuser | HelloWorldddddddd234! | Please enter a value |
| Chrome | asdaadfffsd@asd.com | randomuser | HelloWorlddddddd234! | Check your email |
| Chrome | asdassadffd@asd.com | alreadytaken | HelloWorlddddddd234! | Another user with this username already exists. Maybe it's your evil twin. Spooky. |
| Chrome | asdasddssd@asd.com | longuser | HelloWorlddddddd234! | Enter a value less than 100 characters long |

