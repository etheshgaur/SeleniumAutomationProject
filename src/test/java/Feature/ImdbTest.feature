Feature: Test all Feature

@test
Scenario Outline: Search for Series 
Given user search for Series "<Movie>"
When user fetch the Rating 
And user fetch Genre
And user fetch the Star cast
And user fetch Year Released for movie "<Movie>"
And user fetch duration for movie "<Movie>"
Examples:
|Movie|
|Stranger Things|