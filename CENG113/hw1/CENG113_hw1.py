"""

CHARACTER PALETTE
You can copy the necessary characters for drawing cards from here.

Horizontal lines:  │

Vertical lines:  ─

Corners of a card:  ┐  ┌  ┘  └

Intersections of two cards:

    if card1_height == card2_height:  ┬  ┴

    if card1_height < card2_height:  ┤

    if card1_height > card2_height:  ├

"""

print("This program will draw two cards next to each other.")
print("─" * 20)

print("Texts must not be empty.")
card1_text = input("Text of first card: ")
card2_text = input("Text of second card: ")
print("─" * 20)

##############################
# INSERT YOUR CODE HERE
# Assign proper values to card1_min_width and card2_min_width here.
# They are length of the corresponding text + 2.
# For example, if card1_text contains 5 characters, then card1_min_width must be 7.
card1_min_width = len(card1_text) + 2
card2_min_width = len(card2_text) + 2
# DO NOT EDIT THE CODE UNDER THIS LINE.
##############################

print("Width of first card must be at least " + str(card1_min_width) + ".")
card1_width = int(input("Width of first card: "))
print("Width of second card must be at least " + str(card2_min_width) + ".")
card2_width = int(input("Width of second card: "))
print("─" * 20)

print("Heights must be odd and at least 3.")
card1_height = int(input("Height of first card: "))
card2_height = int(input("Height of second card: "))
print("─" * 20)


##############################
# INSERT YOUR CODE HERE
# Assign the proper value to is_invalid.
# Check if there is at least one problem in the inputs.
# I added two conditions, add more to the line below.
is_invalid = len(card1_text) == 0 or len(card2_text) == 0 or card1_width < card1_min_width or card2_width < card2_min_width or card1_height < 3 or card1_height % 2 == 0 or card2_height < 3 or card2_height % 2 == 0
# DO NOT EDIT THE CODE UNDER THIS LINE.
##############################

if is_invalid:
    print("ERROR: Invalid inputs.")

else:

    if card1_height == card2_height:

        ##############################
        # INSERT YOUR CODE HERE
        # Case 1
        # You can add as many new lines as you need.

      
        right_bottom = "┘"
        right_top = "┐"
        left_bottom = "└"
        left_top = "┌"
        horizontal_line = "─"
        vertical_line = "│"
        between_top_corner = "┬"
        between_bottom_corner = "┴"
        empty = " "

        space_between_lines_card1 = (card1_width - 2)
        space_between_lines_card2 = (card2_width - 2)

        number_upper_lines = (card1_height - 3) // 2
        number_lower_lines = card1_height - 3 - number_upper_lines

      

        card1_left_of_text = (space_between_lines_card1 - len(card1_text)) // 2
        card1_right_of_text = space_between_lines_card1 - len(card1_text) - card1_left_of_text
        card2_left_of_text = (space_between_lines_card2 - len(card2_text)) // 2
        card2_right_of_text = space_between_lines_card2 - len(card2_text) - card2_left_of_text 

        top_line = left_top + (horizontal_line * space_between_lines_card1) + between_top_corner + (horizontal_line * space_between_lines_card2) + right_top
        upper_lines = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        center_line = vertical_line + (empty * card1_left_of_text) + card1_text + (empty * card1_right_of_text) + vertical_line + (empty * card2_left_of_text) + card2_text + (empty * card2_right_of_text) + vertical_line
        lower_lines = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        bottom_line = left_bottom + (horizontal_line * space_between_lines_card1) + between_bottom_corner + (horizontal_line * space_between_lines_card2) + right_bottom 
        

        print(top_line)
        while number_upper_lines > 0:
          print(upper_lines, sep="\n")
          number_upper_lines -= 1
        print(center_line)
        while number_lower_lines > 0:
          print(lower_lines, sep="\n")
          number_lower_lines -= 1
        print(bottom_line)


        # DO NOT EDIT THE CODE UNDER THIS LINE.
        ##############################


    elif card1_height > card2_height:

        ##############################
        # INSERT YOUR CODE HERE
        # Case 2
        # You can add as many new lines as you need.

        right_bottom = "┘"
        right_top = "┐"
        left_bottom = "└"
        left_top = "┌"
        horizontal_line = "─"
        vertical_line = "│"
        between_right_corner = "┤"
        between_left_corner = "├"
        empty = " "

        space_between_lines_card1 = (card1_width - 2)
        space_between_lines_card2 = (card2_width - 2)

        number_upper_lines_card1 = (card1_height - card2_height - 2) // 2
        number_lower_lines_card1 = (card1_height - card2_height - 2) - number_upper_lines_card1
        number_upper_lines_card2 = (card2_height - 3) // 2
        number_lower_lines_card2 = card2_height - 3 - number_upper_lines_card2

        card1_left_of_text = (space_between_lines_card1 - len(card1_text)) // 2
        card1_right_of_text = space_between_lines_card1 - len(card1_text) - card1_left_of_text
        card2_left_of_text = (space_between_lines_card2 - len(card2_text)) // 2
        card2_right_of_text = space_between_lines_card2 - len(card2_text) - card2_left_of_text

        top_line = left_top + (horizontal_line * space_between_lines_card1) + right_top
        upper_lines_card1 = vertical_line + (empty * space_between_lines_card1 ) + vertical_line
        line_in_between1 = vertical_line + (empty * space_between_lines_card1) + between_left_corner + (horizontal_line * space_between_lines_card2) + right_top
        upper_lines_card2 = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        center_line = vertical_line + (empty * card1_left_of_text) + card1_text + (empty * card1_right_of_text) + vertical_line + (empty * card2_left_of_text) + card2_text + (empty * card2_right_of_text) + vertical_line
        lower_lines_card2 = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        line_in_between2 = vertical_line + (empty * space_between_lines_card1) + between_left_corner + (horizontal_line * space_between_lines_card2) + right_bottom
        lower_lines_card1 = vertical_line + (empty * space_between_lines_card1) + vertical_line
        bottom_line = left_bottom + (horizontal_line * space_between_lines_card1) + right_bottom

        print(top_line)
        while number_upper_lines_card1 > 0:
          print(upper_lines_card1, sep="\n")
          number_upper_lines_card1 -= 1
        print(line_in_between1)
        while number_upper_lines_card2 > 0:
          print(upper_lines_card2, sep="\n")
          number_upper_lines_card2 -= 1
        print(center_line)
        while number_lower_lines_card2 > 0:
          print(lower_lines_card2, sep="\n")
          number_lower_lines_card2 -= 1
        print(line_in_between2)
        while number_lower_lines_card1 > 0:
          print(lower_lines_card1, sep="\n")
          number_lower_lines_card1 -= 1
        print(bottom_line)

        # DO NOT EDIT THE CODE UNDER THIS LINE.
        ##############################


    else:

        ##############################
        # INSERT YOUR CODE HERE
        # Case 3
        # You can add as many new lines as you need.

        right_bottom = "┘"
        right_top = "┐"
        left_bottom = "└"
        left_top = "┌"
        horizontal_line = "─"
        vertical_line = "│"
        between_right_corner = "┤"
        between_left_corner = "├"
        empty = " "

        space_between_lines_card1 = (card1_width - 2)
        space_between_lines_card2 = (card2_width - 2)

        number_upper_lines_card2 = (card2_height - card1_height - 2) // 2
        number_lower_lines_card2 = (card2_height - card1_height - 2) - number_upper_lines_card2
        number_upper_lines_card1 = (card1_height - 3) // 2
        number_lower_lines_card1 = card1_height - 3 - number_upper_lines_card1

        card1_left_of_text = (space_between_lines_card1 - len(card1_text)) // 2
        card1_right_of_text = space_between_lines_card1 - len(card1_text) - card1_left_of_text
        card2_left_of_text = (card2_width - 2 - len(card2_text)) // 2
        card2_right_of_text = card2_width - 2 - len(card2_text) - card2_left_of_text

        top_line = (empty * (card1_width - 1)) + left_top + (horizontal_line * space_between_lines_card2) + right_top
        upper_lines_card2 = (empty * (card1_width - 1)) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        line_in_between1 = left_top + (horizontal_line * space_between_lines_card1) + between_right_corner + (empty * space_between_lines_card2) + vertical_line
        upper_lines_card1 = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        center_line = vertical_line + (empty * card1_left_of_text) + card1_text + (empty * card1_right_of_text) + vertical_line + (empty * card2_left_of_text) + card2_text + (empty * card2_right_of_text) + vertical_line
        lower_lines_card1 = vertical_line + (empty * space_between_lines_card1) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        line_in_between2 = left_bottom + (horizontal_line * space_between_lines_card1) + between_right_corner + (empty * space_between_lines_card2) + vertical_line
        lower_lines_card2 = (empty * (card1_width - 1)) + vertical_line + (empty * space_between_lines_card2) + vertical_line
        bottom_line = (empty * (card1_width - 1)) + left_bottom + (horizontal_line * space_between_lines_card2) + right_bottom

        print(top_line)
        while number_upper_lines_card2 > 0:
          print(upper_lines_card2, sep="\n")
          number_upper_lines_card2 -= 1
        print(line_in_between1)
        while number_upper_lines_card1 > 0:
          print(upper_lines_card1, sep="\n")
          number_upper_lines_card1 -= 1
        print(center_line)
        while number_lower_lines_card1 > 0:
          print(lower_lines_card1, sep="\n")
          number_lower_lines_card1 -= 1
        print(line_in_between2)
        while number_lower_lines_card2 > 0:
          print(lower_lines_card2, sep="\n")
          number_lower_lines_card2 -= 1
        print(bottom_line)




        # DO NOT EDIT THE CODE UNDER THIS LINE.
        ##############################
