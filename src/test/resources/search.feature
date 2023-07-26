Feature: Github search feature and about page navigation

  Scenario Outline: searching Github for a specific term as a guest
    Given user goes to the github website
    When user searches for the specific term by name "<searchOption>"
    And user clicks on Enter button
    Then user finds and verifies "<searchResult>" as the first result
    Examples:
      | searchOption     | searchResult              |
      | create-react-app | facebook/create-react-app |




  Scenario: verifying if clicking the About button redirects user to the GitHub About page
    Given user goes to the github website
    And user scrolls down to the page footer
    When user clicks on About button
    Then user is redirected to about page