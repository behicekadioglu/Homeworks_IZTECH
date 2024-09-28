import java.time.LocalDateTime;

public class Task implements Comparable<Task> {
    private LocalDateTime arrivalDate;
    private int burstTime;
    private int priority;

    public Task(String[] taskArray) {
        if (taskArray[0].equals("security management")) {
            priority = 6;
        } else if (taskArray[0].equals("process management")) {
            priority = 5;
        } else if (taskArray[0].equals("memory management")) {
            priority = 4;
        } else if (taskArray[0].equals("user management")) {
            priority = 3;
        } else if (taskArray[0].equals("device management")) {
            priority = 2;
        } else if (taskArray[0].equals("file management")) {
            priority = 1;
        }


        burstTime = Integer.parseInt(taskArray[1]);

        String[] date = taskArray[2].split("/");
        String[] time = taskArray[3].split(":");

        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1].trim());

        arrivalDate = LocalDateTime.of(year, month, day, hour, minute);
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int newBurstTime) {
        burstTime = newBurstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int newPriority) {
        priority = newPriority;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime newArrivalDate) {
        arrivalDate = newArrivalDate;
    }

    public int compareTo(Task task2) {
         return task2.getArrivalDate().compareTo(this.getArrivalDate());
    }




   public void display(){
        System.out.println("Priority=" + priority);
        System.out.println("Burst time=" + burstTime);
        System.out.println("Arrival time=" + arrivalDate);
   }


}