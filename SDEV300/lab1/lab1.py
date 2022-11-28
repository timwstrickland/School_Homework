import sys
import time

first_name = None
last_name = None
age = "None"
citizen = None
state = None
zipcode = None
user_selection = "yes"


def run_user_selection():
    global user_selection
    user_selection = input("Would you like to continue using the voter"
                           " registration program? Please type \"yes\" or \"no\":")


print('****************************************************************')
print("Welcome to the US Voter registration program")
run_user_selection()
if user_selection == "no".lower():
    print("Thank you for using the voter registration program")
    time.sleep(5)
    sys.exit()
while user_selection == "yes".lower():
    first_name = input("What is your first name?")
    last_name = input("What is your last name?")
    while True:
        age = input("Please enter your age:")
        try:
            age = int(age)
            break
        except ValueError:
            print("Your age must be an integer!")
    if age < 18:
        print("You are not eligible to vote!")
        break
    else:
        pass
    run_user_selection()
    if user_selection == "yes".lower():
        pass
    elif user_selection == "no".lower():
        break
    else:
        while user_selection != "yes".lower() or "no".lower():
            input("Please enter \"yes\" or \"no\":")
    citizen = input("Are you a US Citizen?")
    if citizen == "yes".lower():
        pass
    elif citizen == "no".lower():
        print("You are not eligible to vote!")
        break
    else:
        while citizen != "yes".lower() or "no".lower():
            input("Please enter \"yes\" or \"no\":")
    state = input("In which state do you live? Please use 2 letters:")
    zipcode = input("What is your zipcode:")
    print("Here is the information we have on you:")
    print("Name: " + first_name + " " + last_name)
    print("Age: " + str(age))
    print("State: " + state)
    print("Zipcode: " + zipcode)
    break
print("Thank you for using the voter registration system")
time.sleep(5)
