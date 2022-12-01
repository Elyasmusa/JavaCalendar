public class ExtDate extends Date {
    private String monthName;

    /**
     * @param
     *
     */
    public ExtDate() {
        super(1,1,1500);
    }

    public ExtDate(int day, int month, int year) {
        super(day, month, year);
    }

    public String getMonthName() {
        return monthName;
    }
    // changed the month from an int to a string
    public void setMonthName() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.monthName = months[getMonth() - 1];
    }

    @Override
    public void setDate(int day, int month, int year) {
        super.setDate(day, month, year);
        setMonthName();
    }

    public String printDateMDY() {
        return (getMonthName() + " " + getDay() + ", " + getYear());
    }

    public String printDateMY() {
        return (getMonthName() + " " + getYear());
    }

    @Override
    public void addDays(int addDays) {
        super.addDays(addDays);
        setMonthName();
    }
}
