Feature: Edit a new lead in Leaftaps Application

Background: Positive Login
Given Type the username as 'Demosalesmanager'
And Type the password as 'crmsfa'
When Click on the Login button
Then Verify the home page is displayed

Scenario Outline: Edit Lead with different data
Given Click CRM Link
And Click the button Leads
And Click Find Leads Link
When Type the First Name as <firstName>
And Click Find Leads button
And Click the first resulting lead
Then Verify the Title of the page
And Click Edit button
When Change the Company Name <updateCompanyName>
And Click Update button
Then Verify the company name is updated

Examples:
|firstName|updateCompanyName|
|Rajee|TestLeaf|
|Babu|Qeagle|
