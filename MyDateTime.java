public class MyDateTime {

    MyDate date;
    MyTime time;

    public MyDateTime(MyDate date, MyTime time) {
        this.date = date;
        this.time = time;
    }

    public void incrementDay() {
        date.incrementDay();
    }

    public void incrementHour() {
        time.incrementHour();
    }

    public void incrementHour(int diff) {
        int dayDiff = time.incrementHour(diff);
        if (dayDiff < 0)
            date.decrementDay(-dayDiff);
        else
            date.incrementDay(dayDiff);
    }

    public void decrementHour(int diff) {
        incrementHour(-diff);
    }

    public void incrementMinute(int diff) {
        int dayDiff = time.incrementMinute(diff);
        if(dayDiff<0)
            date.decrementDay(-dayDiff);
        else
            date.incrementDay(dayDiff);
    }

    public void decrementMinute(int diff) {
        incrementMinute(-diff);
    }

    public void incrementYear(int diff) {
        date.incrementYear(diff);
    }

    public void decrementDay() {
        date.decrementDay();
    }

    public void decrementYear() {
        date.decrementYear();
    }

    public void decrementMonth() {
        date.decrementMonth();
    }

    public void incrementDay(int diff) {
        date.incrementDay(diff);
    }

    public void decrementMonth(int diff) {
        date.decrementMonth(diff);
    }

    public void decrementDay(int diff) {
        date.decrementDay(diff);
    }

    public void incrementMonth(int diff) {
        date.incrementMonth(diff);
    }

    public void decrementYear(int diff) {
        date.decrementYear(diff);
    }

    public void incrementMonth() {
        date.incrementMonth();
    }

    public void incrementYear() {
        date.incrementYear();
    }

    public boolean isBefore(MyDateTime anotherDateTime) {
        if(date.isBefore(anotherDateTime.date))
            return true;
        else if (date.isAfter(anotherDateTime.date))
            return false;
        if (time.isBefore(anotherDateTime.time))
            return true;
        return false;
    }

    public boolean isAfter(MyDateTime anotherDateTime) {
        if(date.isAfter(anotherDateTime.date))
            return true;
        else if (date.isBefore(anotherDateTime.date))
            return false;
        if (time.isAfter(anotherDateTime.time))
            return true;
        return false;
    }

    public String dayTimeDifference(MyDateTime anotherDateTime) {
        int dayDiff = 0;
        dayDiff += date.dayDifference(anotherDateTime.date);
        if(time.minute> anotherDateTime.time.minute)
            dayDiff =dayDiff -1;



        if(dayDiff ==0)
            return time.timeDifference(anotherDateTime.time);
        else
            return dayDiff + " days" + time.timeDifference(anotherDateTime.time);
    }

    public String toString(){
        return date.toString() + " " + time.toString();
    }
}
