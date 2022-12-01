public class Calendar {
    ExtDate date;
    Day day;
    /**
     * @param
     *
     */
    public Calendar(ExtDate date) {
        this.date = date;
    }
    //calculates the first day of the month
    public Day firstDayOfMonth() {
        ExtDate tempDate = new ExtDate();
        day = new Day();
        day.setDay("Mon");

        for (int i = 1500; i < getYear(); i++) {
            tempDate.setYear(i);
            if (tempDate.isLeapYear()) {
                day.calculateDay(2);//2 is used because 366%7 =2
            } else {
                day.calculateDay(1);//1 is used because 365%7 =1
            }
        }

        day.calculateDay(date.getDaysPassedInYear() - (date.getDay() - 1));
        return day;
    }

    public void setMonth(int month) {
        date.setMonth(month);
    }

    public void setYear(int year) {
        date.setDay(year);
    }

    public String getMonth() {
        return date.getMonthName();
    }

    public int getYear() {
        return date.getYear();
    }
    // prints the calendar
    public void printCalendarForMonth() {
        System.out.println("\t\t\t\t\t" + getMonth() + " " + getYear());
        System.out.println("Sun\t\tMon\t\tTue\t\tWed\t\tThur\tFri\t\tSat");

        boolean firstLine = true;
        Day currentDay = firstDayOfMonth();
        int firstDayOfMonthIndex = currentDay.getDayIndex();

        for (int i = 0; i <= date.getNumberOfDaysInMonth(); i++) {
            if (firstLine) {
                for (int j = 0; j < firstDayOfMonthIndex; j++) {
                    System.out.print("\t\t");
                }
                firstLine = false;
            } else {
                System.out.print(i + "\t\t");
                if (currentDay.getDayIndex() == 6) {
                    System.out.print("\n");
                }
                currentDay.setDay(currentDay.getNextDay());
            }
        }
        System.out.println();
    }
}