
def main():
    menu = Menu("CENG113_hw4.txt")
    menu.create_item()  
    menu.categories()  
    menu.order()


class Menu:
    def __init__(self, file_name):
        self.file_name = file_name
        self.category_names = []
        self.items = []
        self.obj_items = []
        self.clients_items = []
        self.category = []
        self.name = []
        self.portion = []
        self.price = []

# reads lines from the file, deletes uncessary things from the lines,
# creates menu objects and assign category, name, portion and price of the item 
    def create_item(self):
        file = open(self.file_name, "r")
        self.items = file.readlines()
        for item in range(1, len(self.items)):
            item = self.items[item].split(";")
            for j in range(len(item)):
                item[j] = item[j].strip()
            """menu_obj = Menu(self.file_name)
            menu_obj.category = item[0]
            menu_obj.name = item[1]
            menu_obj.portion = item[2]
            menu_obj.price = item[3]"""
            self.obj_items.append(item)
        file.close()

# category names being gotten from the items
    def categories(self):
        category_names = []
        for item in self.obj_items:
            if item[0] not in category_names:
                category_names.append(item[0])
        self.category_names = category_names

# for the requested category, it gives the list of the items' names
    def names(self, category):
        item_names = []
        for item in self.obj_items:
            if (item[0] == category) and item[1] not in item_names:
                item_names.append(item[1])
        return item_names

# for the requested name, it gives the list of the portions
    def portions(self, name):
        item_portions = []
        for item in self.obj_items:
            if item[1] == name:
                item_portions.append(item[2])
        return item_portions

# prints the categories
    def give_categories(self):
        print("Product Categories")
        num = 1
        for i in self.category_names:
            print(str(num) + ". " + i)
            num += 1

# prints the requested category's items
    def give_names(self, category, names):
        print("Products in " + category + " :")
        num = 1
        for i in names:
            print(str(num) + ". " + i)
            num += 1

# prints the requested name's portions
    def give_portions(self, name, portions):
        print(name + " Portions:")
        num = 1
        for i in portions:
            print(str(num) + ". " + i)
            num += 1

# gets category, name, portion, adds the item in the clients_items list for every item. if client chooses
# to checkout, gives the purchased items, calculates the total cost and shows it
    def order(self):

        print("--------------------")
        Menu.give_categories(self)
        num_cat = int(input("Please select product category: ")) - 1
        choice_cat = self.category_names[num_cat]
        
        print("--------------------")
        names = Menu.names(self, choice_cat)
        Menu.give_names(self, choice_cat, names)
        num_name = int(input("Please select product name: ")) - 1
        choice_name = names[num_name]

        print("--------------------")
        portions = Menu.portions(self, choice_name)
        Menu.give_portions(self, choice_name, portions)
        num_por = int(input("Please select product portion: ")) - 1
        choice_por = portions[num_por]
  
        for item in self.items:
            if (item[0] == choice_cat) and (item[1] == choice_name) and (item[2] == choice_por):
                i = [item[1], item[2], item[3]]
                self.clients_items.append(i)

        print("""1. Add New\n2. Checkout""")
        choice = int(input("Please select an operation:"))

        if choice == 1:
            Menu.order(self)

        elif choice == 2:
            print("----------------------------------------------------------------------")
            for i in self.clients_items:
                print(self.clients_items[i][0] + "\t" + self.clients_items[i][1] + "\t" +  self.clients_items[i][2])
            print("----------------------------------------------------------------------")
            cost = 0
            for item in self.clients_items:
                cost += float(self.clients_items[item][2].split("$"))
            print("Total: " + str(cost) + "$")

        else:
            while not((choice == 1) or (choice == 2)):
                choice = int(input("""Invalid Input\n
                                Please select an operation:"""))
                print("--------------------")



main()