![My Plant Diary Login Use Case](https://github.com/discospiff/MyPlantDiary23SS7060/blob/58432f389d4f1bd395fbce9654882418044697a5/MyPlantDiaryUseCase.jpg)

#My Plant Diary
Use Case Name: Login
Importance Level: High
##Stakeholders and Interests
•	My Plant Diary user
•	Third party authentication provider (Google, Apple, Microsoft, Yahoo, etc.)
##Description
When a user wishes to perform an operation that requires persistence (saving data or retrieving data), and the user is not yet known to My Plant Diary, the user will be prompted to login.  
##Trigger
User performs an operation that requires persistence (Add a Photo, Add Plant Care, Add a Plant) if the user is not already logged in.
##Natural Flow of Events
1.	User attempts to access persistent storage.
2.	The system checks if the user is already logged in.  If not, the system requires the user to login.
a.	If login credentials are already stored, the system will use those and not prompt the user.
b.	If the user chooses to create a My Plant Diary account, the system will prompt with a username/password specific to My Plant Diary.
c.	If the user chooses third party authentication, the user will be prompted to choose an authentication provider (Google, Apple, Microsoft, Yahoo, etc.)  The system will then redirect to the appropriate third party login provider.
3.	Once logged in, the user will be able to access persistence.
##Subflows
When using third party authentication, the system will redirect to the appropriate provider.  The provider will then manage the login flow, and return an authorized or not authorized message.
##Alternate/Exception Flows
1.	If the third party authentication provider returns any response aside from Authorized, return the user to the login flow.
2.	If the third party authentication provider is unreachable, return the user to the login flow and display a message.
3.	If the user has a MyPlantDiary account and cannot login after five tries, lock the account and prompt the user to change password.

