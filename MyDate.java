public class MyDate {

    private int day, month, year;   //Jan is 0 ... Dec 11
    int[] maxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month-1;
        this.year = year;
    }

    public void incrementDay() {
        int newDay = day+1;
        int maxDay = maxDays[month];

        if (newDay > maxDay) {
            incrementMonth();
            day = 1;
        }else if (month == 1 && newDay == 29 && !leapYear()){
            day = 1;
            incrementMonth();
        }else{
            day = newDay;
        }
    }

    private boolean leapYear() {
        return year % 4 == 0;
    }

    public void incrementYear(int diff) {
        year += diff;
        if(month == 1 && day==29 && !leapYear()){
            day = 28;
        }
    }

    public void decrementDay() {
        int newDay = day -1;
        if (newDay == 0){
            day = 31;
            decrementMonth();
        }else{
            day = newDay;
        }
    }

    public void decrementYear() {
        incrementYear(-1);
    }

    public void decrementMonth() {
        incrementMonth(-1);
    }

    public void incrementDay(int diff) {
        while( diff > 0){
            incrementDay();
            diff--;
        }
    }

    public void decrementMonth(int month) {
        incrementMonth(-month);
    }

    public void decrementDay(int diff) {
        while( diff > 0){
            decrementDay();
            diff--;
        }
    }

    public void incrementMonth(int diff) {
        int newMonth = (month + diff ) % 12;
        int yearDiff = 0;

        if (newMonth < 0){
            newMonth += 12;
            yearDiff = -1;
        }

        yearDiff += (month+ diff) / 12;

        month = newMonth;
        year += yearDiff;


        if (day > maxDays[month]) {
            day = maxDays[month];
            if(month == 1 && day == 29 && !leapYear()){
                day = 28;

            }
        }
    }

    public void decrementYear(int year) {
        incrementYear(-year);
    }

    public void incrementMonth() {
        incrementMonth(1);
    }

    public void incrementYear() {
        incrementYear(1);
    }

    public boolean isBefore(MyDate anotherDate) {
        if (year < anotherDate.year){
            return true;
        }else if (month < anotherDate.month){
            return true;
        }else return day < anotherDate.day;
    }

    public boolean isAfter(MyDate anotherDate) {
        if (year > anotherDate.year){
            return true;
        }else if (month > anotherDate.month){
            return true;
        }else return day > anotherDate.day;
    }

    public int dayDifference(MyDate anotherDate) {
        int dayDiff = 0;
        if (year < anotherDate.year){
            if (month < anotherDate.month){
                for(int i = month; i< anotherDate.month; i++){
                    dayDiff += maxDays[i];
                }
                if((anotherDate.year - year) > 1 ) {
                    dayDiff += (anotherDate.year - year) * 365;
                }
                dayDiff += Math.abs(anotherDate.day - day);
            }else if (month == anotherDate.month){
                dayDiff += ((anotherDate.year - year)*365) + Math.abs(anotherDate.day-day);
            }else{
                for(int i = anotherDate.month; i<month; i++){
                    dayDiff += maxDays[i];
                }
                dayDiff += ((anotherDate.year-year)*365) + Math.abs(day- anotherDate.day);
            }

        }else if(year == anotherDate.year){
            if (month < anotherDate.month){
                for(int i = month; i< anotherDate.month; i++){
                    dayDiff += maxDays[i];
                }
                dayDiff += Math.abs(anotherDate.day - day);
            }else if (month == anotherDate.month){
                dayDiff += Math.abs(anotherDate.day - day);
            }else{
                for(int i = anotherDate.month; i<month; i++){
                    dayDiff += maxDays[i];
                }
            }
        }else{
            if(month < anotherDate.month){
                if((year - anotherDate.year) > 1){
                    dayDiff += (year - anotherDate.year)*365;
                for(int i = month; i< anotherDate.month;i++){
                    dayDiff += maxDays[i];
                    }
                dayDiff += Math.abs(day- anotherDate.day);
                }else if(month == anotherDate.month){
                    if(year- anotherDate.year >=1){
                        dayDiff += ((year- anotherDate.year)*365)+Math.abs(day- anotherDate.day);
                    }
                }else{
                    dayDiff += ((year- anotherDate.year)*365);
                    for(int i = anotherDate.month;i<month;i++){
                        dayDiff += maxDays[i];
                    }
                    dayDiff += Math.abs(day- anotherDate.day);
                }
            }
        }
        return dayDiff;
    }

    public String toString() {
        return year+ "-"+ ((month+1) < 10 ? "0" : "")+(month+1)+"-"+(day < 10 ? "0" : "")+day;
    }
}
