def main():
    mid, qs, hs, final = get_scores()
    totalscore = total_score(mid, qs, hs, final)
    absrate = abs_rate()
    grade(totalscore,absrate)


def get_scores():
    exit = False
    while exit == False:
        try:
            mid = int(input("What is your Midterm score?: "))
            while mid > 100 or mid < 0:
                print("Your Midterm score is not in between 0 and 100!")
                mid = int(input("What is your valid Midterm score?: "))

            final = int(input("What is your Final score?: "))
            while final > 100 or final < 0:
                print("Your Final score is not in between 0 and 100!")
                final = int(input("What is your valid Final score?: "))
            
            quiz1 = int(input("What is your Quiz 1 score?: "))
            while quiz1 > 100 or quiz1 < 0:
                print("Your Quiz 1 score is not in between 0 and 100!")
                quiz1 = int(input("What is your valid Quiz 1 score?: "))

            quiz2 = int(input("What is your Quiz 2 score?: "))
            while quiz2 > 100 or quiz2 < 0:
                print("Your Quiz 2 score is not in between 0 and 100!")
                quiz2 = int(input("What is your valid Quiz 2 score?: "))

            quiz3 = int(input("What is your Quiz 3 score?: "))
            while quiz3 > 100 or quiz3 < 0:
                print("Your Quiz 3 score is not in between 0 and 100!")
                quiz3 = int(input("What is your valid Quiz 3 score?: "))

            quiz4 = int(input("What is your Quiz 4 score?: "))
            while quiz4 > 100 or quiz4 < 0:
                print("Your Quiz 4 score is not in between 0 and 100!")
                quiz4 = int(input("What is your valid Quiz 4 score?: "))

            hw1 = int(input("What is your Homework 1 score?: "))
            while hw1 > 100 or hw1 < 0:
                print("Your Homework 1 score is not in between 0 and 100!")
                hw1 = int(input("What is your valid Homework 1 score?: "))

            hw2 = int(input("What is your Homework 2 score?: "))
            while hw2 > 100 or hw2 < 0:
                print("Your Homework 2 score is not in between 0 and 100!")
                hw2 = int(input("What is your valid Homework 2 score?: "))

            hw3 = int(input("What is your Homework 3 score?: "))
            while hw3 > 100 or hw3 < 0:
                print("Your Homework 3  score is not in between 0 and 100!")
                hw3 = int(input("What is your valid Homework 3 score?: "))

            hw4 = int(input("What is your Homework 4 score?: "))
            while hw4 > 100 or hw4 < 0:
                print("Your Homework 1 score is not in between 0 and 100!")
                hw4 = int(input("What is your valid Homework 4 score?: "))

            exit = True
        except:
            print("You give an invalid value, please try again.")

    print("Your scores are saved as:", mid, final, quiz1, quiz2, quiz3, quiz4, hw1, hw2, hw3, hw4)
    # qs is avarage quiz score
    qs = (quiz1 + quiz2 + quiz3 + quiz4)/4
    # hs is avarage homework score
    hs = (hw1 + hw2 + hw3 + hw4)/4
    return mid, qs, hs, final
    

def total_score(mid, qs, hs, final):
    totalscore = mid*0.25 + qs*0.20 + hs*0.20 + final*0.35
    print("Your total score is:", totalscore)
    return totalscore

def abs_rate():
    num_of_weeks = 14
    abs = int(input("What is your number of absences?: "))
    absrate = (abs/num_of_weeks) * 0.01
    print("Your absenteeism rate is", absrate)
    return absrate


def grade(totalscore, absrate):
    if absrate > 0.25:
        grade = "NA"
    else:
        if totalscore < 50:
            grade = "FF"
        elif totalscore < 60:
            grade = "FD"
        elif totalscore < 65:
            grade = "DD"
        elif totalscore < 70:
            grade = "DC"
        elif totalscore < 75:
            grade = "CC"
        elif totalscore < 80:
            grade = "CB"
        elif totalscore < 85:
            grade = "BB"
        elif totalscore < 90:
            grade = "AB"
        else:
            grade = "AA"

    print("Your grade is,", grade)

main()


