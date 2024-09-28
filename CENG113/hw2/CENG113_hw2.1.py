# tell user to the username requirenments and get an username
print('''Hello user, you need to have an username and a password.
Let's begin with the username
    It must begin with "e".
    It cannot contain characters other than alphanumeric characters.
    The number of characters in the username must be in between 6 and 12.''')

username = input("What will be your username?: ")

# check the username's first character, and the number of characters in it
# if something is invalid then ask for another username
while username[0] != "e" or len(username)<6 or len(username)>12:
    if username[0] != "e":
        print('Username must begin with "e"!' )
        username = input("Please, give a valid username: ")
    elif len(username)<6 or len(username)>12:
        if len(username)<6:
            print("Username must have more than 6 characters!")
        else:
            print("Username must have less than 12 characters!")
        username = input("Please, give a valid username: ")

# look at that the username's characters is alphanumeric or not
# if there is a characters other than alphanumeric ones then ask for another username
while not username.isalnum(): 
    print("Username cannot have any characters other than alphanumeric characters!")
    username = input("Please, give a valid username: ")

# tell user that username is set
print('"' + username + '" is valid and saved as your username.')

# tell user requirements of password and get a password
print('''Let's choose a password
    It must have at least 8 characters.''')

password = input("What will be your password?: ")

# check the pasword's number of character
# if it is invalid then ask for another password
while len(password)<8:
    print("Password must have at least 8 characters!")
    password = input("Please, give a valid password: ")

# tell user the password is set
print('It is valid and saved as your password')
# let user to use the website
print("Thank you for being a member. Now, you can use the website.")