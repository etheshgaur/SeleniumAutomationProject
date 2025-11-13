Feature: Test all Feature

@test
Scenario Outline: Search for Series 
Given user search for Series "<Movie>"
When user fetch the Rating 
And user fetch Genre
Examples:
|Movie|
|Stranger Things|