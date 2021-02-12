/*
 * Time.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented Comparable Time Class + Sort Randomly Generated Array of Time Objects
*/

public class Time implements Comparable<Time> {
    public int sec;
    public int min;
    public int hour;

    //Default Constructor
    public Time() {
        sec = 0;
        min = 0;
        hour = 0;
    }

    //Regular Constructor
    public Time(int h, int m, int s) {
        sec = s;
        min = m;
        hour = h;
    }

    //Compare To Method
    public int compareTo(Time that) {
        //Later in Time by Hours
        if(this.getHour() > that.getHour())
            return 1;
        //Same Hour, Check Mins
        else if(this.getHour() == that.getHour()) {
            //Later in Time by Mins
            if(this.getMin() > that.getMin())
                return 1;
            //Same Min, Check Seconds
            else if(this.getMin() == that.getMin()) {
                //Later in Time by Secs
                if(this.getSec() > that.getSec())
                    return 1;
                //Same Exact Time (Hrs, Mins, Secs)
                else if(this.getSec() == that.getSec())
                    return 0;
                //Earlier in Time by Secs
                else
                    return -1;
            }
            //Earlier in Time by Mins
            else
                return -1;
        }
        //Earlier in Time by Hours
        else
            return -1;
    }

    //Randomly Generate Time Values
    public Time randTime() {
        int s = (int) Math.floor(Math.random() * 60);
        int m = (int) Math.floor(Math.random() * 60);
        int h = (int) Math.floor(Math.random() * 24);

        return new Time(h, m, s);
    }

    //Get Time Attributes (Sec, Min, Hour)
    public int getSec() {
        return sec;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }
}