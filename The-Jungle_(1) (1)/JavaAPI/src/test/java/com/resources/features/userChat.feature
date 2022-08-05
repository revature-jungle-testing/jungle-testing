Feature: User should be able to access the chat page and send messages and images

    Scenario: User can join global chat
        Given the user is on their home page
        When the user clicks the chat room button
        Then the users should be redirected to chat room

    Scenario: User can leave a chatroom
        Given the user is in the chatroom
        When the user clicks on the logo
        Then they are redirected to their home page

    Scenario: User can send a message
        Given the user is in the chatroom
        When the user enters their chat message
        When the user clicks the send chat message button
        Then the message will appear in chat

    Scenario: User can send images through chatroom
        Given the user is in the chatroom
        When the user clicks on the Choose File button in chatroom
        When the user selects their chat image they want to send
        Then the image appears in the group chat

    Scenario: User images that are too big does not get sent
        Given the user is in the chatroom
        When the user clicks on the Choose File button in chatroom
        When the user selects their chat image that is too big
        Then the user clicks the alert button saying File is too big to send
   
    Scenario: User sees their previous chat history
        Given the user is in the chatroom
        When the user enters their chat message
        When the user clicks the send chat message button
        When the user clicks on the refresh button
        Then the user will see their previous messages


