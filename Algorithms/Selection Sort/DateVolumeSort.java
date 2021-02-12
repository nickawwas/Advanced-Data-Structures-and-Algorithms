/*
 * DateVolumeSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented Data and Volume Class for Objects Read from File
*/

public class DateVolumeSort {
    private String[] date;
    private int volume;

    public DateVolumeSort(String d, int v) {
        date = d.split("-");
        volume = v;
    }

    public String getDate() {
        return date[0];
    }

    public String getMonth() {
        return date[1];
    }

    public String getYear() {
        return date[2];
    }

    public String getFullDate() {
        return getDate() + "-" + getMonth() + "-" + getYear();
    }

    public int getVolume(){
        return volume;
    }

}
