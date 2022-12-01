public class Day {
    private String day;
    /**
     * @param
     *
     */
    private String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

    public Day() {
        this.day = daysOfWeek[0];
    }

    public Day(int dayIndex) {
        this.day = daysOfWeek[dayIndex];
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void printDay() {
        System.out.println(day);
    }

    public String getPreviousDay() {
        int previousDayIndex = getDayIndex() == 0 ? 6 : getDayIndex() - 1;
        return daysOfWeek[previousDayIndex];
    }

    public String getNextDay() {
        int nextDayIndex = getDayIndex() == 6 ? 0 : getDayIndex() + 1;
        return daysOfWeek[nextDayIndex];
    }

    public void calculateDay(int days) {
        int calculatedDayIndex = ((getDayIndex() + (days % 7)) % 7);
        setDay(daysOfWeek[calculatedDayIndex]);
    }

    public int getDayIndex() {
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equals(getDay())) {
                return i;
            }
        }
        return 0;
    }
}
