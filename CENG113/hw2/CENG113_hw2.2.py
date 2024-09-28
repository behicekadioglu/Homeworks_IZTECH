# get the text and the special character from the user
text = input("Give a text: ")
special_cha = input("Which character do you want to count in your text?: ")

# assign an accumulator to count the characters
number_of_cha = 0

# look at each character in the text seperatly and decide which ones are the special ones
# if some character is the special one then add 1 to the accumulator
for cha_num in range(len(text)):
    if text[cha_num] == special_cha:
        number_of_cha += 1

# display the number of the special characters
print("Your text has", str(number_of_cha), str(special_cha), '.')