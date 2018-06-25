Feature: Automated on Eko App

@First
Scenario: Verify message can send to another user
	Given I Login with admin user
	When I click next on first time open for admin
	And I click search icon
	And I search name "narongsak"
	And I click message box
	And I send message as "Hi Lek"
	And I send message as "I send this message from mobile"
	And I click back on chat page
	And I click back on search page
	And I click profile on home page
	And I click setting on profile page
	And I click logout on setting page
	And I Login with first staff
	And I click next on first time open for normal user
	And I click search icon
	And I search name "lek@ekoapp.com"
	Then I check message "Hi Lek" and "I send this message from mobile"
	And I click message box
	And I send message as "Acknowledged"
	
@Second
Scenario: Verify favorites user
	Given I Login with admin user
	When I click next on first time open for admin
	And I click directory on home page
	And I click name "narongsak" on directory page
	And I click star icon
	And I click back_on_directory_page
	And I click favorites tab
	Then I check name "narongsak" on directory page
	And I click name "narongsak" on directory page
	And I click star icon
	
@Third
Scenario: Verify adding task
	Given I Login with admin user
	When I click next on first time open for admin
	And I click tasks on home page
	And I click created task icon
	And I input task title "Lek task"
	And I click create button
	And I check task name "Lek task"
	


@Fourth
Scenario: Verify total in thumbs up
	Given I Login with admin user
	When I click next on first time open for admin
	And I click directory on home page
	And I click name "narongsak" on directory page
	And I click view all details
	And I check thumbs up total
	

@Fifth
Scenario: Verify logout
	Given I Login with admin user
	When I click next on first time open for admin
	And I click profile on home page
	And I click setting on profile page
	And I click logout on setting page
	Then I am on login page

	