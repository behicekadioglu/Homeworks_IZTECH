public class ClimateMeasurement {
    private int year;
    private int month;
    private String stringMonth;

    // default constructor
    public  ClimateMeasurement(){
        this(0,0);
    }

    // constructor
    public ClimateMeasurement(int year, int month) {
        this.year = year;
        this.month = month;

        if (month == 1) {
            this.stringMonth = "January";
        } else if (month == 2) {
            this.stringMonth = "February";
        } else if (month == 3) {
            this.stringMonth = "March";
        } else if (month == 4) {
            this.stringMonth = "April";
        } else if (month == 5) {
            this.stringMonth = "May";
        } else if (month == 6) {
            this.stringMonth = "June";
        } else if (month == 7) {
            this.stringMonth = "July";
        } else if (month == 8) {
            this.stringMonth = "August";
        } else if (month == 9) {
            this.stringMonth = "September";
        } else if (month == 10) {
            this.stringMonth = "October";
        } else if (month == 11) {
            this.stringMonth = "November";
        } else if (month == 12) {
            this.stringMonth = "December";
        }
        else{
            this.stringMonth = "noData";
        }
    }

    // copy constructor
    public ClimateMeasurement(ClimateMeasurement otherMeasurement){
        this.stringMonth = otherMeasurement.getStringMonth();
        this.month = otherMeasurement.getMonth();
        this.year = otherMeasurement.getYear();
    }

    // getters and setters
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStringMonth() {
        return stringMonth;
    }

    public void setStringMonth(String stringMonth) {
        this.stringMonth = stringMonth;
    }

    // equals method looks for year and month
    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        else if (getClass() != otherObject.getClass()){
            return false;
        }
        else{
            ClimateMeasurement otherMeasurement = (ClimateMeasurement) otherObject;
            return(this.year == otherMeasurement.year && this.month == otherMeasurement.year);
        }
    }
}

