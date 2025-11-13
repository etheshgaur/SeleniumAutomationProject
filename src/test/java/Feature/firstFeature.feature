Feature: Test all Feature

@test
Scenario Outline: Search for Series 
Given user search for Series "<Movie>"
When user fetch the Rating 

Examples:
|Movie|
|Stranger Things|