import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // gets the number of cars
        System.out.print("Enter available car account, N=");
        int numOfCars = scanner.nextInt();
        System.out.println();
        ArrayDeque<Car> cars = new ArrayDeque<>(numOfCars);

        //gets the number of costumers
        System.out.print("Enter costumer count, k=");
        int numOfCostumers = scanner.nextInt();
        while(numOfCostumers > numOfCars) 
        {
        	System.out.print("Costumer count is more than the cars, please enter the costumer count again, k=");
        	numOfCostumers = scanner.nextInt();
        }
        System.out.println();
        ArrayQueue<Costumer> costumers = new ArrayQueue<>(numOfCostumers);

        for (int i = 1; i <= numOfCars; i++) {
            Car x = new Car("Car" + i);
            cars.addToBack(x);
        }

        for (int i = 1; i <= numOfCostumers; i++) {
            Costumer x = new Costumer("Cost" + i);
            costumers.enqueue(x);
        }

        // begins the simulation
        renting(cars, costumers);

    }

    
    
    // gets the car deque and costumer queue and runs the renting process
    public static void renting(ArrayDeque<Car> cars, ArrayQueue<Costumer> costumers) {
        // the queue that will hold the rented cars for each day
        ArrayQueue<Car> rentedCars = new ArrayQueue<>();

        // the queue that will hold the rejected cars by each costumer
        ArrayQueue<Car> rejectedCars = new ArrayQueue<>();

        // the queue that will hold the costumers who have rejected a car for each day
        ArrayQueue<Costumer> rejectedCostumers = new ArrayQueue<>();

        int numOfDay = 0;

        // while there is costumer
        while (!costumers.isEmpty())
        {
            // increment the number of the day
            numOfDay++;

            System.out.println("***************Day" + numOfDay + "**************");

            // while there is car to rent
            while (!cars.isEmpty())
            {
                // gets the first car in the deque
                Car car = cars.removeFront();

                // if the car's occupancy is not 0, then this means the car is already rented
                while (car.getOccupancy() != 0) {
                    // decrement the occupancy of the car
                    car.setOccupancy(car.getOccupancy() - 1);
                    // add this car to the rented cars list for this day
                    rentedCars.enqueue(car);
                    // get the next car from the car deque
                    car = cars.removeFront();
                }

                // while there is still costumer that has not rejected a car in this day
                //if(!costumers.isEmpty()){
                    System.out.println("Current " + car.getNameOfCar() +
                            " quality=" + String.format("%.2f", car.getQuality()) + " is offering to");
                //}

                // creates a new costumer object
                Costumer costumer = new Costumer();

                // if there is still a costumer that has never rejected a car in this day
                if(!costumers.isEmpty()){
                    // gets the costumer from the costumers queue
                    costumer = costumers.dequeue();
                }


                //else if(!rejectedCostumers.isEmpty()){
                    //costumer = rejectedCostumers.dequeue();
                //}

                System.out.print("        Current " + costumer.getNameOfCostumer() +
                        " threshold=" + String.format("%.2f", costumer.getThreshold()));

                // if the car is good enough for the costumer she will accept it
                if (car.getQuality() >= costumer.getThreshold()) {
                    System.out.println("        --- accepted");
                    // car's occupant is now the costumer
                    car.setOccupant(costumer);
                    // occupancy is set randomly
                    car.setOccupancy((int)(Math.random() * ((5 - 1) + 1)));
                    // car is now rented
                    rentedCars.enqueue(car);
                    // for this car loop is completed
                    continue;
                }
                // if the car is not good enough, she will not accept it
                else
                {
                    System.out.println("        --- not accepted");
                    // costumer's threshold will be changed
                    costumer.setThreshold();
                    // this costumer has rejected a car in this day now
                    rejectedCostumers.enqueue(costumer);
                    // car has been rejected this day
                    rejectedCars.enqueue(car);
                }

                // clears the rejected costumers queue for the next car
                while(!rejectedCostumers.isEmpty())
                {
                    Costumer tempCost = rejectedCostumers.dequeue();
                    costumers.enqueue(tempCost);
                }
            } // each car is asked


            // gives the statistics for each day
            System.out.println("All cars have seen");

            // day has ended but there are costumers
            if (!costumers.isEmpty())
            {
                System.out.println("But there are still costumers waiting.");

                // if some cars are rented
                if (!rentedCars.isEmpty()) {
                    System.out.println("Rented cars:");
                }
                while (!rentedCars.isEmpty()) {
                    Car tempCar = rentedCars.dequeue();
                    System.out.println("    " + tempCar.getNameOfCar() + " by " + tempCar.getOccupant() +
                            " occupancy=" + tempCar.getOccupancy());
                }

                // if some of the cars rejected that day
                if (!rejectedCars.isEmpty()) {
                    System.out.println("Available cars:");
                }
                ArrayQueue<Car> tempCarQueue = new ArrayQueue<>();
                while (!rejectedCars.isEmpty()) {
                    Car tempCar = rejectedCars.dequeue();
                    System.out.println("    " + tempCar.getNameOfCar());
                    tempCarQueue.enqueue(tempCar);
                }

                // clears rejected cars queue for the next day
                while (!tempCarQueue.isEmpty()) {
                    Car tempCar = tempCarQueue.dequeue();
                    cars.addToBack(tempCar);
                }
                System.out.println("**************End of Day**************");
            }

            // if there are no more costumers
            else
            {
                System.out.println("All costumers rent a car");
                break;
            }

        }

    }

}