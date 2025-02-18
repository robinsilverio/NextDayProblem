import java.util.HashMap;

public class NextDate {

    private int day;
    private int month;
    private int year;
    private HashMap<Integer, String> monthDictionary = new HashMap<Integer,
            String>() {
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

    public NextDate(int paramMonth, int paramDay, int paramYear) {
        this.month = paramMonth;
        this.day = paramDay;
        this.year = paramYear;
    }

    public String showNewDate() {
        return this.dateAsString;
    }

    public void generateNewDay() {

        if (isValidDate()) {
            if (isLastMonth()) {
                this.year++;
            }
            if (isLastDayOfTheMonth()) {
                this.month = (this.month != 12) ? this.month + 1 : 1;
                this.day = 1;
            } else {
                this.day++;
            }
            this.dateAsString = this.monthDictionary.get(this.month) + " " +
                    this.day + ", " + this.year;
        } else {
            throw new RuntimeException("error");
        }
    }

    // Condities voor het toestaan van valide datums
    private boolean isValidDate() {
        return isValidInputDay() && isValidInputMonth() &&
                isValidInputYear() && isExistentDate();
    }
    private boolean isValidInputDay() {
        return (1 <= day && day <= 31);
    }
    private boolean isValidInputMonth() {
        return (1 <= month && month <= 12);
    }
    private boolean isValidInputYear() {
        return (1812 <= year && year <= 2012);
    }
    private boolean isExistentDate() {
        return !(isExceedingDateInFirstSemester() ||
                isExceedingDateInSecondSemester());
    }

    private boolean isExceedingDateInSecondSemester() {
        return ((month % 2 == 0 && day > 31) || (month % 2 != 0 && day > 30)) && month > 7;
    }

    private boolean isExceedingDateInFirstSemester() {
        return ((month % 2 != 0 && day > 31) || (month % 2 == 0 && (day > 30 || day > 28))) && month < 8;
    }

    // Condities voor het veranderen van jaar en maand.
    private boolean isLastMonth() {
        return this.month == 12 && this.day == 31;
    }
    private boolean isLastDayOfTheMonth() {
        // Invoer: day = 30; month = 12;
        return ((((month % 2 != 0 && day == 31) ||
                (month % 2 == 0 && day == 30)) && month <= 7) ||
                (((month % 2 == 0 && day == 31) ||
                        (month % 2 != 0 && day == 30)) && month > 7));
    }
}
