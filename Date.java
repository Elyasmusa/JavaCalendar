
public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * @param
     *
     */
    public Date() {
    }

    public Date(int day, int month, int year) {
        setDate(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] = isLeapYear() ? 29 : 28;
        if (daysInMonths[month - 1] >= day) {
            this.day = day;
        } else {
            System.out.println("Too many days in month");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month <= 12) {
            this.month = month;
        } else {
            System.out.println("Too many months");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    // The test for leap year
    public boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }
    // gets the days in a month
    public int getNumberOfDaysInMonth() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] = isLeapYear() ? 29 : 28;

        return daysInMonths[month - 1];
    }
    //gets days that have passed in a year
    public int getDaysPassedInYear() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] = isLeapYear() ? 29 : 28;

        int sum = day - 1;
        for (int i = 0; i < month - 1; i++) {
            sum += daysInMonths[i];
        }
        return sum;
    }
    //gets days that are left in the year
    public int getDaysRemainingInYear() {
        int daysInYear = isLeapYear() ? 366 : 365;
        return daysInYear - getDaysPassedInYear();
    }
    // adds days to the current date that is stored
    public void addDays(int addDays) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] = isLeapYear() ? 29 : 28;

        for (int i = 0; i < addDays; i++) {
            if (getDay() < daysInMonths[getMonth() - 1]) {
                setDay(getDay() + 1);
            } else if (getDay() >= daysInMonths[getMonth() - 1]) {
                if (getMonth() < 12) {
                    setMonth(getMonth() + 1);
                } else {
                    setYear(getYear() + 1);
                    setMonth(1);
                }
                setDay(1);
            }
        }
    }

    public Date getDateCopy() {
        Date dateCopy = new Date(getDay(), getMonth(), getYear());
        return dateCopy;
    }

    public void cloneDate(Date anotherDate) {
        anotherDate.setDay(getDay());
        anotherDate.setMonth(getMonth());
        anotherDate.setYear(getYear());
    }

    public String to_String() {
        return month + "-" + day + "-" + year;
    }
}
