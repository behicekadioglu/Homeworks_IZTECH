#lang scheme

#| Items is a list
   It has number of distinct items lists
   sublists has:
                item's name (0 index)
                item's category (1 index)
                item's price (2 index) |#
(define Items (list (list 'Coffee 'Beveridges 3.50)
                    (list 'OrangeJuice 'Beveridges 3.25)
                    (list 'Tea 'Beveridges 2.75)
                    (list 'AppleJuice 'Beveridges 3.40)
                    (list 'Apples 'Fruits 1.40)
                    (list 'Bananas 'Fruits 1.75)
                    (list 'Orange 'Fruits 1.25)
                    (list 'Bread 'Bakery 2.00)
                    (list 'Milk 'Dairy 3.50)
                    (list 'Eggs 'Dairy 4.75)
                    (list 'Yogurt 'Dairy 2.75)
                    (list 'Cheese 'Dairy 5.50)
                    (list 'Fish 'Seafood 12.50)
                    (list 'Salmon 'Seafood 9.50)
                    (list 'Broccoli 'Vegetables 1.80)
                    (list 'Lettuce 'Vegetables 1.20)
                    (list 'Potatoes 'Vegetables 2.50)
                    (list 'Carrots 'Vegetables 1.10)
                    (list 'Spinach 'Vegetables 1.60)
                    (list 'Tomatoes 'Vegetables 1.50)
                    (list 'Onions 'Vegetables 1.20)
                    (list 'Chicken 'Meat 7.00)
                    (list 'Bacon 'Meat 6.25)
                    (list 'Beef 'Meat 8.00)
                    (list 'Pasta 'Pantry 3.75)
                    (list 'ChickenSoup 'CannedFoods 3.50)
                    (list 'Rice 'Grains 2.25)))



#| Customers is a list
   It has number of distinct customers lists
   sublists has:
                customer's name (index 0)
                customer's age (index 1)
                customer'S location (index 2) 
                customer's transactions (as lists) (index 3) |#
(define Customers (list (list 'JohnSmith 35 'NewYork (list '15.03.2024 'Apples 'Coffee 'Bread)
                                                     (list '22.03.2024 'Milk 'Bananas)
                                                     (list '29.03.2024 'Eggs 'OrangeJuice)
                                                     (list '5.04.2024 'Tea 'Fish 'Broccoli 'Orange)
                                                     (list '12.04.2024 'Chicken 'Lettuce 'Pasta 'Salmon))
                        (list 'AliceJohnson 28 'LosAngeles (list '20.03.2024 'Milk 'Bananas))
                        (list 'MichealBrown 45 'Miami (list '24.03.2024 'OrangeJuice 'Yogurt)
                                                      (list '28.03.2024 'Bacon)
                                                      (list '2.04.2024 'Coffee 'Bread 'Apples)
                                                      (list '5.04.2024 'Milk 'Bananas 'Eggs)
                                                      (list '10.04.2024 'Cheese 'Beef 'Potatoes 'ChickenSoup))
                        (list 'EmilyDavis 32 'Houston (list '24.03.2024 'Chicken 'Lettuce)
                                                      (list '28.03.2024 'Pasta 'Salmon 'Rice 'Potatoes)
                                                      (list '1.04.2024 'Carrots 'Spinach))
                        (list 'RobertWilson 40 'Miami (list '21.03.2024 'Salmon 'Rice)
                                                      (list '25.03.2024 'Potatoes 'Chicken 'Lettuce 'Pasta)
                                                      (list '29.02.2024 'Milk 'Bananas 'Eggs 'OrangeJuice)
                                                      (list '2.04.2024 'Bacon)
                                                      (list '6.04.2024 'Fish 'Broccoli))
                        (list 'SophiaMartinez 30 'NewYork (list '26.03.2024 'Carrots 'Spinach)
                                                          (list '30.03.2024 'Tea 'Fish 'Broccoli 'Orange))
                        (list 'WilliamTaylor 38 'Houston (list '19.03.2024 'Beef 'Potatoes)
                                                         (list '23.03.2024 'ChickenSoup 'Tomatoes 'AppleJuice 'Bread))
                        (list 'EmmaWhite 25 'LosAngeles (list '23.03.3024 'Tomatoes 'ChickenSoup)
                                                        (list '27.03.2024 'Milk 'Salmon 'Rice 'Potatoes)
                                                        (list '31.03.2024 'Chicken 'Lettuce 'Pasta 'Salmon))
                        (list 'JamesHarris 32 'Houston (list '25.03.2024 'Onions 'AppleJuice)
                                                       (list '29.03.2024 'Cheese 'Beef 'Potatoes 'ChickenSoup))
                        (list 'OliviaClark 29 'LosAngeles (list '25.03.2024 'Fish 'Broccoli)
                                                          (list '29.03.2024 'Orange 'Chicken 'Lettuce 'Pasta))))



#| this procedure returns a data according to a procedure and a variable with a list reference number
   according-to: the variable that we look according to
   get-procedure: the procedure we apply on the according-to variable
   list-ref-num: the index we want to refer in the list
   It is used for: (category-of-item name)
                   (price-of-item name)
                   (age-of-customer name)
                   (location-of-customer name) |#
(define (get-specific-data according-to get-procedure num)
  (list-ref (get-procedure according-to) num)) 

#| this procedure returns the category of the item that we know has name
   name: the name of the item |#
(define (category-of-item name)
  (get-specific-data name get-item-information 1))

#| this procedure returns the category of the item that we know has name
   name: the name of the item
   It is used for: (total-cost-of-items lst start-num start-cost) |#
(define (price-of-item name)
  (get-specific-data name get-item-information 2))

#| this procedure returns the age of the customer that we know has name
   name: the name of the customer
   It is used for: (items-purchased-by-age-group-with-list lst lower-age upper-age) |#
(define (age-of-customer name)
  (get-specific-data name get-customer-information 1))

#| this procedure returns the location of the customer that we know has name
   name: the name of the customer
   It is used for: (all-items-bought-by-location lst location)
                   (num-of-transactions-by-location lst location num) |#
(define (location-of-customer name)
  (get-specific-data name get-customer-information 2))



#| this procedure returns the transactions of the customer, that we know has name, as a list
   name: the name of the customer
   It is used for: (num-of-transactions-of-customer name)
                   (transaction-of-customer name tra-num)
                   (items-bought-by-a-specific-customer name num)
                   (retrieve-all-transactions lst)
                   (num-of-transactions-by-location lst location num) |#
(define (transactions-of-customer name)
  (list-tail (get-customer-information name) 3))

#| this procedure returns the number of transactions of the customer that we know has name
   name: the name of the customer
   It is used for: (transaction-of-customer name tra-num)
                   (items-bought-by-a-specific-customer name num)
                   (num-of-transactions-by-location lst location num) |#
(define (num-of-transactions-of-customer name)
  (length (transactions-of-customer name)))

#| this procedure returns the tra-num th transaction of the customer that we know has name
   name: the name of the customer
   tra-num: the number that we want to find tra-numth transaction
   It is used for: (items-bought-by-a-specific-customer name num) |#
(define (transaction-of-customer name tra-num)
  (if (<= tra-num (num-of-transactions-of-customer name))
      (list-tail(list-ref (transactions-of-customer name) (- tra-num 1)) 1)
      '()))



#| this porcedure returns a list of all items
   lst: the list of the items that we want to show |#
(define (retrieve-all-items lst)
  (if (null? (cdr lst))
      (list(list-ref (list-ref lst 0) 0))
      (append (list(list-ref (list-ref lst 0) 0)) (retrieve-all-items (cdr lst)))))



#| this procedure returns a list of all distinct categories of items
   lst: the list of items that we want to look their category
   It is used for: (most-popular-category flag) |#
(define (retrieve-all-categories lst)
  (cond ((null? (cdr lst))
         (list(list-ref (list-ref lst 0) 1)))
        ((not (equal? (list-ref (list-ref lst 0) 1) (list-ref (list-ref (cdr lst) 0) 1)))
         (append (list(list-ref (list-ref lst 0) 1)) (retrieve-all-categories (cdr lst))))
        (else
         (retrieve-all-categories (cdr lst)))))



#| this procedure returns a list of all distinct items that has category as their category
   lst: the list of all items that we want to look
   category: the category that we trying to find its items
   It is used for: (retrieve-items-purchased-by-category category) |#
(define (retrieve-items-by-category lst category)
  (cond ((and(null? (cdr lst)) (equal? category (list-ref (list-ref lst 0) 1)))
         (list(list-ref (list-ref lst 0) 0)))
        ((null? (cdr lst))
         '())
        ((and (equal? category (list-ref (list-ref lst 0) 1)) (not (null? (cdr lst))))
         (append (list (list-ref (list-ref lst 0) 0)) (retrieve-items-by-category (cdr lst) category))) 
        (else
         (retrieve-items-by-category (cdr lst) category))))



#| this procedure returns a list of something according to its name
   lst: is a list of different things as sublists that has their name in index 0
   It is used for: (get-item-information lst)
                   (get-customer-information lst) |#
(define (get lst name)
  (if (equal? (list-ref (list-ref lst 0) 0) name)
      (list-ref lst 0)
      (get (cdr lst) name)))

#| this procedure returns a customer as a list that has; its name in index 0
                                                        its age in index 1
                                                        its location in index 2
                                                        its transactions as sublists in index 3
   name: the name of the needed customer
   It is used for: (age-of-customer name)
                   (location-of-customer name)
                   (transactions-of-customer name)|#
(define (get-customer-information name)
  (get Customers name))

#| this procedure returns an item as a list that has; its name in index 0
                                                     its category in index 1
                                                     its price in index 2
   name: the name of the needed item
   It is used for: (category-of-item name)
                   (price-of-item name)
                   (retrieve-item-informations-by-item-list lst)|#
(define (get-item-information name)
  (get Items name))



#| this procedure returns a list that has items which have price as their price
   lst: the list of items that we want to look for
   price: the specified price that we are look for
   It is used for: (most-expensive-item lst)
                   (least-expensive-item lst) |#
(define (retrieve-items-by-price lst price)
  (cond ((and(null? (cdr lst)) (equal? price (list-ref (list-ref lst 0) 2)))
         (list(list-ref (list-ref lst 0) 0)))
        ((null? (cdr lst))
         '())
        ((and (equal? price (list-ref (list-ref lst 0) 2)) (not (null? (cdr lst))))
         (append (list (list-ref (list-ref lst 0) 0)) (retrieve-items-by-price (cdr lst) price))) 
        (else
         (retrieve-items-by-price (cdr lst) price))))



#| this procedure returns one of the extreme prices (smallest or largest) prices
   lst: the list of items that we are looking for
   num: the number which should be given according to the procedure we will apply
         (if we need to find the largest price then it is 0,
          if we want to find the smallest price then it is really large number that is larger than all prices)
   procedure: the procedure we will apply to prices
               (if we need to find the largest price then it is >,
                if we want to find the smallest price then it is >)
   It is used for: (retrieve-most-expensive-price lst num)
                   (retrieve-least-expensive-price lst num) |#
(define (retrieve-extreme-price lst num procedure)
  (cond ((null? (cdr lst))
         num)
        ((and (not (null? (cdr lst))) (procedure (list-ref (list-ref (cdr lst) 0) 2) num))
         (retrieve-extreme-price (cdr lst) (list-ref (list-ref (cdr lst) 0) 2) procedure))
        ((and (not (null? (cdr lst))) (not (procedure (list-ref (list-ref (cdr lst) 0) 2) num)))
         (retrieve-extreme-price (cdr lst) num procedure))))

#| this procedure returns the largest price
   lst: the list of items that we are looking for
   num: should be 0 in our implementation
   It is used for: (most-expensive-item lst) |#
(define (retrieve-most-expensive-price lst num)
  (retrieve-extreme-price lst num >))

#| this procedure returns the smallest price
   lst: the list of items that we are looking for
   num: it should be more than largest price in our implementation
   It is used for: (least-expensive-item lst) |#
(define (retrieve-least-expensive-price lst num)
  (retrieve-extreme-price lst num <))

#| this procedure returns the most expensive item's name
   lst: the list of items that we are looking for |#
(define (most-expensive-item lst)
  (retrieve-items-by-price lst (retrieve-most-expensive-price lst 0)))

#| this procedure returns the least expensive(cheapest) item's name
   lst: the list of items that we are looking for |#
(define (least-expensive-item lst)
  (retrieve-items-by-price lst (retrieve-least-expensive-price lst 1000000)))




#| this procedure gives the total price of the items in the list
   lst: the list of the items that we are looking for
   start-num: it should be 1 for our implementation, it indicates that we are beginning the procedure form tha first item
   start-cost: it should be 0 for our implementation, it indicates that we are begining the procedure with total price of 0
   It is used for: (total-cost-of-items-by-customer name)
                   (total-cost-of-transactions-with-num lst num)
                   (revenue-by-category category)
                   (average-spending-per-transaction-by-location lst location) |#
(define (total-cost-of-items lst start-num start-cost)
  (if (null? (cdr lst))
      (+ start-cost (price-of-item (car lst)))
      (total-cost-of-items (cdr lst) (+ start-num 1) (+ start-cost (price-of-item (car lst))))))



#| this procedure returns all item's names that are purchased by customer that has name as its name
   duplicate items is allowed in this list
   name: the name of the customer that we are looking for
   num: it should be 1 for our implementation, it indicates that we are statrting to look for from the first transaction
   It is used for: (total-cost-of-items-by-customer name)
                   (items-purchased-by-age-group-with-list lst lower-age upper-age)
                   (all-items-bought-by-location lst location) |#
(define (items-bought-by-a-specific-customer name num)
  (if (> num (num-of-transactions-of-customer name))
      (transaction-of-customer name num)
      (append (transaction-of-customer name num) (items-bought-by-a-specific-customer name (+ num 1)))))



#| this procedure returns the cost of items purchased by the customer that has name as its name
   name: the name of the customer that we are looking for
   It is used for: (total-cost-of-transactions-with-num lst num) |#
(define (total-cost-of-items-by-customer name)
  (total-cost-of-items (items-bought-by-a-specific-customer name 1) 1 0))

#| this procedure gives the total cost of the transactions that is in the list
   lst: the list of customers that we are looking for
   num: it should be 0 for our implementation, it indicates that we are beginning with total cost of 0
   It is used for: (total-cost-of-transactions lst) |#
(define (total-cost-of-transactions-with-num lst num)
  (if (null? (cdr lst))
      (+ num (total-cost-of-items-by-customer (car (car lst))))
      (total-cost-of-transactions-with-num (cdr lst) (+ num (total-cost-of-items-by-customer (car (car lst)))))))

#| this procedure gives the total cost of all transactions without a starting number
   lst: the list of customers that we are looking for |#
(define (total-cost-of-transactions lst)
  (total-cost-of-transactions-with-num lst 0))



#| this procedure returns a list of all transactions
   lst: the list of customer that we are looking for
   It is used for: (items-purchased-on-a-specific-date date)
                   (retrieve-items-purchased-by-category category) |#
(define (retrieve-all-transactions lst)
  (if (null? (cdr lst))
      (transactions-of-customer (car (car lst)))
      (append (transactions-of-customer (car (car lst))) (retrieve-all-transactions (cdr lst)))))

#| this procedure returns transactions that are done on date
   lst: the list of transactions that we are looking for
   date: the date we are looking for
   It is used for: (items-purchased-on-a-specific-date date) |#
(define (retrieve-transactions-on-date-with-list lst date)
  (cond ((and (null? (cdr lst)) (equal? date (car (car lst))))
         (list(car lst)))
        ((null? (cdr lst))
         '())
        ((and (not (null? (cdr lst))) (equal? date (car (car lst))))
         (append (list (car lst)) (retrieve-transactions-on-date-with-list (cdr lst) date)))
        ((and (not (null? (cdr lst))) (not (equal? date (car (car lst)))))
         (retrieve-transactions-on-date-with-list (cdr lst) date))))

#| this procedure returns a list of all items from a list of transactions
   duplicate items is allowed in this list
   lst: the list of transactions that we are looking for
   It is used for: (items-purchased-on-a-specific-date date)
                   (retrieve-items-purchased-by-category category) |#
(define (retrieve-all-items-by-transactions lst)
  (if (null? (cdr lst))
      (list-tail (car lst) 1)
      (append (list-tail (car lst) 1) (retrieve-all-items-by-transactions (cdr lst)))))

#| this procedure returns the list of items purchased on date
   duplicate items are allowed in this list
   date: the date we are looking for |#
(define (items-purchased-on-a-specific-date date)
  (retrieve-all-items-by-transactions (retrieve-transactions-on-date-with-list (retrieve-all-transactions Customers) date)))



#| this procedure returns a list of item's informations as sublists from a list of item names
   lst: the list of item names that we are looking for
   It is used for: (retrieve-items-purchased-by-category category)
                   (how-many-items-purchased-by-category category) |#
(define (retrieve-item-informations-by-item-list lst)
  (if (null? (cdr lst))
      (list (get-item-information (car lst)))
      (append (list (get-item-information (car lst))) (retrieve-item-informations-by-item-list (cdr lst)))))

#| this procedure returns a list of items that is purchased which has category as their category
   category: the category that we are looking for
   It is used for: (revenue-by-category category)
                   (how-many-items-purchased-by-category category) |#
(define (retrieve-items-purchased-by-category category)
  (retrieve-items-by-category
   (retrieve-item-informations-by-item-list
    (retrieve-all-items-by-transactions (retrieve-all-transactions Customers)))
   category))

#| this porcedure returns the revenue generated by items that has category as their category
   category: the category that we are looking for |#
(define (revenue-by-category category)
  (total-cost-of-items (retrieve-items-purchased-by-category category) 1 0))



#| this procedure returns the number of items, that have category as their category, purchased
   lst: the list of items that we are looking for
   category: the category tha twe are looking for
   num: it should be 0 for our implementation, it indicates in the beginning our total number is 0
   It is used for: (how-many-items-purchased-by-category category) |#
(define (how-many-items-purchased-by-category-with-list lst category num)
  (cond ((and (null? (cdr lst)) (equal? category (list-ref (car lst) 1)))
         (+ num 1))
        ((null? (cdr lst))
         num)
        ((and (not (null? (cdr lst))) (equal? category (list-ref (car lst) 1)))
         (how-many-items-purchased-by-category-with-list (cdr lst) category (+ num 1)))
        ((and (not (null? (cdr lst))) (not (equal? category (list-ref (car lst) 1))))
         (how-many-items-purchased-by-category-with-list (cdr lst) category num))))

#| this procedure returns the number of items, that have category as their category, purchased
   we are directly looking for category's item list
   category: the category that we are looking for
   It is used for: (retrieve-the-list-of-category-and-num-of-purchases category) |#                                                                          
(define (how-many-items-purchased-by-category category)
  (how-many-items-purchased-by-category-with-list
   (retrieve-item-informations-by-item-list
    (retrieve-items-purchased-by-category category))
   category
   0))

#| this procedure returns a list that has category in its index 0
   and the number of items bought that has category as their category in its index 1
   category: the category that we are looking for
   It is used for: (retrieve-all-lists-of-category-and-num-of-purchases lst) |#
(define (retrieve-the-list-of-category-and-num-of-purchases category)
  (list category (how-many-items-purchased-by-category category)))                                                                  

#| this procedure returns a list of lists that has a category in their index 0
   and the number of items bought that has category as their category in their index 1
   lst: the list of categories that we are looking for
   It is used for: (most-popular-category flag) |#
(define (retrieve-all-lists-of-category-and-num-of-purchases lst)
  (if (null? (cdr lst))
      (list(retrieve-the-list-of-category-and-num-of-purchases (car lst)))
      (append (list (retrieve-the-list-of-category-and-num-of-purchases (car lst)))
              (retrieve-all-lists-of-category-and-num-of-purchases (cdr lst)))))


#| this procedure returns the category that is most popular (that has most items bought)
   lst1: the list of lists that have category and the number of items bought that has category as their category
   lst2: it should be '(0 0), the index 0 can be anything but index 1 has to be 0
         because it indicates that we are starting from 0 bought items
   It is used for: (most-popular-category flag) |#
(define (most-popular-category-by-category-and-num-of-purchases lst1 lst2)
  (cond ((null? (cdr lst1))
         (car lst2))
        ((and (not (null? (cdr lst1))) (< (list-ref (car lst1) 1) (list-ref lst2 1)))
         (most-popular-category-by-category-and-num-of-purchases (cdr lst1) lst2))
        ((and (not (null? (cdr lst1))) (>= (list-ref (car lst1) 1) (list-ref lst2 1)))
         (most-popular-category-by-category-and-num-of-purchases (cdr lst1) (car lst1)))))
                                                                                                                                      
#| this procedure returns the most popular category ,that has most items bought
   flag: it can be anything, it is just there to make this a procedure |#
(define (most-popular-category flag)
  (most-popular-category-by-category-and-num-of-purchases
   (retrieve-all-lists-of-category-and-num-of-purchases
    (retrieve-all-categories Items))
   '(0 0)))



#| this procedure returns items purchased by the age group at most upper age and al least lower age from the list of customers
   lst: the list of customers that we are looking for
   lower-age: the minimum age that we are looking for (it is included in the range)
   upper-age: the maximum age that we are looking for (it is included in the range)
   It is used for: (items-purchased-by-age-group lower-age upper-age) |#
(define (items-purchased-by-age-group-with-list lst lower-age upper-age)
  (cond ((and (not (null? (cdr lst)))
              (>= (age-of-customer (car (car lst))) lower-age)
              (<= (age-of-customer (car(car lst))) upper-age))
         (append (items-bought-by-a-specific-customer (car (car lst)) 1)
                 (items-purchased-by-age-group-with-list (cdr lst) lower-age upper-age)))
        ((and (not (null? (cdr lst)))
              (or (<= (age-of-customer (car (car lst))) lower-age)
                  (>= (age-of-customer (car (car lst))) upper-age)))
         (items-purchased-by-age-group-with-list (cdr lst) lower-age upper-age))
        ((and (null? (cdr lst))
              (>= (age-of-customer (car (car lst))) lower-age)
              (<= (age-of-customer (car(car lst))) upper-age))
         (items-bought-by-a-specific-customer (car (car lst)) 1))
        ((and (null? (cdr lst))
              (or (<= (age-of-customer (car (car lst))) lower-age)
                  (>= (age-of-customer (car (car lst))) upper-age)))
         '())))
                                                                               
#| this procedure returns items purchased by the age group at most upper age and al least lower age
   lower-age: the minimum age that we are looking for (it is included in the range)
   upper-age: the maximum age that we are looking for (it is included in the range) |#
(define (items-purchased-by-age-group lower-age upper-age)
  (items-purchased-by-age-group-with-list Customers lower-age upper-age))



#| this procedure retuns a list of items that customers who made the transactions, that have the items, has location as their locations
   duplicate items is allowed in this list
   lst: the list of customers that we are looking for
   location: the location that we are looking for
   It is used for: (average-spending-per-transaction-by-location lst location) |#
(define (all-items-bought-by-location lst location)
  (cond ((and (not (null? (cdr lst))) (equal? location (location-of-customer (car (car lst)))))
         (append (items-bought-by-a-specific-customer (car (car lst)) 1)
                 (all-items-bought-by-location (cdr lst) location)))
        ((and (not (null? (cdr lst))) (not (equal? location (location-of-customer (car (car lst))))))
         (all-items-bought-by-location (cdr lst) location))
        ((and (null? (cdr lst)) (equal? location (location-of-customer (car (car lst)))))
         (items-bought-by-a-specific-customer (car (car lst)) 1))
        ((and (null? (cdr lst)) (not (equal? location (location-of-customer (car (car lst))))))
         '())))

#| this procedure returns the number of transactions has made by customers that has location as their location
   lst: the list of customers that we are looking for
   location: the location that we are looking for
   num: it should be 0, it indicates that in te-he beginning, our number of transactions is 0
   It is used for: (average-spending-per-transaction-by-location lst location) |#
(define (num-of-transactions-by-location lst location num)
  (cond ((and (not (null? (cdr lst))) (equal? location (location-of-customer (car (car lst)))))
         (num-of-transactions-by-location (cdr lst) location (+ num (num-of-transactions-of-customer (car (car lst))))))
        ((and (not (null? (cdr lst))) (not (equal? location (location-of-customer (car (car lst))))))
         (num-of-transactions-by-location (cdr lst) location num))
        ((and (null? (cdr lst)) (equal? location (location-of-customer (car (car lst)))))
         (+ num (num-of-transactions-of-customer (car (car lst)))))
        ((and (null? (cdr lst)) (not (equal? location (location-of-customer (car (car lst))))))
         num)))

#| this procedure returns the average spending of customers that has location as their location per these customer's number of transactions
   lst: the list of customers that we are looking for
   location: the location that we are looking for |# 
(define (average-spending-per-transaction-by-location lst location)
  (/
   (total-cost-of-items
    (all-items-bought-by-location lst location)
    1
    0)
   (num-of-transactions-by-location lst location 0)))

#| below function calls were my test cases
   the functions that asked us to write are there in order |#
(retrieve-all-items Items)
(retrieve-all-categories Items)
(retrieve-items-by-category Items 'Vegetables)
(get-customer-information 'EmilyDavis)
(get-item-information 'Carrots)
(most-expensive-item Items)
(least-expensive-item Items)
(total-cost-of-items-by-customer 'EmilyDavis)
(total-cost-of-transactions Customers)
(items-purchased-on-a-specific-date '25.03.2024)
(revenue-by-category 'Beveridges)
(most-popular-category 0)
(items-purchased-by-age-group 30 32)
(average-spending-per-transaction-by-location Customers 'NewYork)