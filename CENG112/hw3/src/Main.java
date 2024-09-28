import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        /* beginning of the file io operations */
        /* splits .txt file's data into lines */
        String[] linesArray = readFileIntoArray("tasks.txt");

        /* splits lines into Tasks and add Tasks into an array */
        Task[] arrayOfTasks = new Task[linesArray.length];
        Task[] arrayOfTasksForSecondExecution = new Task[linesArray.length];
        for (int i = 0; i < linesArray.length; i++) {
            String[] task = linesArray[i].split(",");
            Task tempTask = new Task(task);
            arrayOfTasks[i] = tempTask;
            Task tempTaskForSecondExecution = new Task(task);
            arrayOfTasksForSecondExecution[i] = tempTaskForSecondExecution;
        }
        /* end of the file io operations */

        /* begging of the taskList operations */
        /* add Tasks on the tasksArray to our taskList */
        SortedList<Task> taskList = new SortedList<>();
        for (int i = 0; i < arrayOfTasks.length; i++) {
            Task tempTask = arrayOfTasks[i];
            taskList.add(tempTask);
        }

        /* displays the tasks in the taskList */
        System.out.println("The task list according to arrival dates:" + "\n" +
                "*****");
        for (int i=0; i < taskList.getLength(); i++){
           System.out.print(i+1 + ". ");
           taskList.getEntry(taskList.getLength()- i).display();
        }
        System.out.println("*****" + "\n");
        /* end of the taskList operations */


        /* sorting our arrayOfTasks according to arrival date*/
        /* we are doing this because we need both our priority queue and stack take tasks
            in an order according to arrival dates */
        for (int i = 0; i < arrayOfTasks.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arrayOfTasks.length; j++) {
                // Checking elements
                Task temp;
                if (arrayOfTasks[j].compareTo(arrayOfTasks[i]) < 0) {
                    // Swapping
                    temp = arrayOfTasks[i];
                    arrayOfTasks[i] = arrayOfTasks[j];
                    arrayOfTasks[j] = temp;
                }
            }
        }


        /* beginning of the taskPriorityQueue operations */

        PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
        PriorityQueue<Task> taskPriorityQueueToDisplay = new PriorityQueue<>();
        /* add Tasks on the tasksArray to our taskPriorityQueue */
        for (int i = 0; i < arrayOfTasks.length; i++) {
            Task tempTask = taskList.remove();
            taskPriorityQueue.enqueue(tempTask,tempTask.getPriority());
            taskPriorityQueueToDisplay.enqueue(tempTask,tempTask.getPriority());
        }

        /* displays the tasks in the taskPriorityQueue */
        System.out.println("The task queue according to priority from the head;" + "\n" +
                "*****");
        for (int i = 0; i < arrayOfTasks.length; i++) {
            System.out.print(i+1 + ". ");
            taskPriorityQueueToDisplay.dequeue().display();
        }
        System.out.println("*****" + "\n");
        /* end of the taskPriorityQueue operations */

        /* beginning of the execution operations for taskPriorityQueue */
        int timeForQueue = 0;
        int numberOfTasksRemoved = 0;
        while (!taskPriorityQueue.isEmpty() && taskPriorityQueue.getFront() != null){
            timeForQueue++;
            /* ıf burst time of the first task is zero than remove it from the queue*/
            if (taskPriorityQueue.getFront().getBurstTime() == 0) {
                taskPriorityQueue.dequeue();
                numberOfTasksRemoved++;

                /* displays tasks in the taskPriorityQueue after each 5 executions */
                if (numberOfTasksRemoved % 5 == 0) {
                    System.out.println("The current tasks in the queue at time " + timeForQueue +
                            ":" + "\n" + "*****");
                    PriorityQueue<Task> tempQueue = new PriorityQueue<>();
                    int numberOfTasks = taskPriorityQueue.getSize();
                    for (int i = 0; i < numberOfTasks; i++) {
                        System.out.print(i + 1 + ". ");
                        Task tempTask = taskPriorityQueue.dequeue();
                        tempQueue.enqueue(tempTask, tempTask.getPriority());
                        tempTask.display();
                    }
                    System.out.println("*****" + "\n");

                    /* adds tasks back to the taskPriorityQueue */
                    for (int i = 0; i < numberOfTasks; i++) {
                        Task tempTask = tempQueue.dequeue();
                        taskPriorityQueue.enqueue(tempTask, tempTask.getPriority());
                    }
                }
            }
            /* if burst time of the first node is not zero than decrement it */
            else{
                int temp = taskPriorityQueue.getFront().getBurstTime();
                taskPriorityQueue.getFront().setBurstTime(temp-1);
            }
        }
        System.out.println("All tasks in the queue are executed");
        /* end of the execution operations for taskPriorityQueue */



        /* beginning of taskStack operations */
        /* sorting our arrayOfTasks according to burst time from less to greater */
        BurstTimeComparator burstTimeComparator = new BurstTimeComparator();
        // Outer loop
        for (int i = 0; i < arrayOfTasksForSecondExecution.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arrayOfTasksForSecondExecution.length; j++) {
                // Checking elements
                Task temp;
                if (burstTimeComparator.compare(arrayOfTasksForSecondExecution[j],
                        arrayOfTasksForSecondExecution[i]) < 0) {
                    // Swapping
                    temp = arrayOfTasksForSecondExecution[i];
                    arrayOfTasksForSecondExecution[i] = arrayOfTasksForSecondExecution[j];
                    arrayOfTasksForSecondExecution[j] = temp;
                }
            }
        }

        /* adds sorted tasks into the taskStack, first the one with the greatest burst time */
        Stack<Task> taskStack = new Stack<>();
        Stack<Task> taskStackToDisplay = new Stack<>();
        for (int i=0; i < arrayOfTasksForSecondExecution.length; i++){
            taskStack.push(arrayOfTasksForSecondExecution
                    [arrayOfTasksForSecondExecution.length - (i+1)]);
            taskStackToDisplay.push(arrayOfTasksForSecondExecution
                    [arrayOfTasksForSecondExecution.length - (i+1)]);
        }

        /* displays the tasks in the taskStack */
        System.out.println("The task pile according to burst time from the top:" + "\n" +
                "*****");
        for (int i=0; i< arrayOfTasksForSecondExecution.length; i++){
            taskStackToDisplay.pop().display();
        }
        System.out.println("*****" + "\n");
        /* end of the taskStack operations */


        /* beginning of the execution operations for taskStack */
        int timeForStack = 0;
        numberOfTasksRemoved = 0;
        while (!taskStack.isEmpty()){
            timeForStack++;
            /* if burst time of the first task is zero than remove it from the stack*/
            if (taskStack.peek().getBurstTime() == 0) {
                taskStack.pop();
                numberOfTasksRemoved++;

                /* displays tasks in the taskStack after each 5 executions */
                if (numberOfTasksRemoved % 5 == 0) {
                    System.out.println("The current tasks in the pile at time " + timeForStack +
                            ":" + "\n" + "*****");
                    Stack<Task> tempStack = new Stack<>();
                    int numberOfTasks = taskStack.getNumberOfEntries();
                    for (int i = 0; i < numberOfTasks; i++) {
                        System.out.print(i + 1 + ". ");
                        Task tempTask = taskStack.pop();
                        tempStack.push(tempTask);
                        tempTask.display();
                    }
                    System.out.println("*****" + "\n");

                    /* adds tasks back to the taskStack */
                    for (int i = 0; i < numberOfTasks; i++) {
                        Task tempTask = tempStack.pop();
                        taskStack.push(tempTask);
                    }
                }
            }
            /* if burst time of the first node is not zero than decrement it */
            else{
                int temp = taskStack.peek().getBurstTime();
                taskStack.peek().setBurstTime(temp-1);
            }
        }
        System.out.println("All tasks in the pile are executed");
        /* end of the execution operations for taskStack */





    }





    public static String[] readFileIntoArray(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            // reads file and converts all file to a single string
            StringBuilder sb = new StringBuilder();
            String line = br.readLine(); // reads lines from the file
            while (line != null)
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString(); // creates a string from the file's contents

            // splits the string according to lines and creates a new array of them
            String[] allLines = everything.split("\n");
            return allLines;
        }
        finally
        {
            br.close();
        }
    }

}