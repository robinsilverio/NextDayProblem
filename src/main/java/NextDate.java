import java.util.HashMap;

public class NextDate {

    private int day;
    private int month;
    private int year;
    private HashMap<Integer, String> monthDictionary = new HashMap<Integer, String>() {
        {
            put(1, "January");
            put(2, "February");
            put(3, "March");
            put(4, "April");
            put(5, "May");
            put(6, "June");
            put(7, "July");
            put(8, "August");
            put(9, "September");
            put(10, "October");
            put(11, "November");
            put(12, "December");
        }
    };

    private String dateAsString = "";

    public NextDate(int paramDay, int paramMonth, int paramYear) {
        this.day = paramDay;
        this.month = paramMonth;
        this.year = paramYear;
    }

    public String showNewDate() {
        return this.dateAsString;
    }

    public void generateNewDay() {

        if (isValidInputDay() && isValidInputMonth() && isValidInputYear()) {

            if (this.month == 12 && this.day == 31) {
                this.year++;
            }
            // Invoer: day = 30; month = 9
            if (((this.month % 2 != 0 || this.month == 8 || month == 12) && (this.day == 31 || this.day == 30)) || (this.month % 2 == 0 && (this.day == 30 || this.day == 28))) {
                this.month = (this.month != 12) ? this.month + 1 : 1;
                this.day = 1;
            } else {
                this.day++;
            }
            this.dateAsString = this.year + " " + this.monthDictionary.get(this.month) + ", " + this.day;
        } else {
            throw new RuntimeException("error");
        }
    }

    private boolean isValidInputDay() { return (1 <= this.day && this.day <= 31); }
    private boolean isValidInputMonth() { return (1 <= month && month <= 12); }
    private boolean isValidInputYear() { return (1812 <= year && year <= 2012); }
}
