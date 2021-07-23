package com.company;

public class Record {

    private static String COMMA = ",";

    private int year;
    private int month;
    private int day;
    private double averageTemp;
    private double maxTemp;
    private double minTemp;
    private double pressure;
    private double airSpeed;
    private int humidity;
    private double precipitation;

    public Record(int year, int month, int day, double averageTemp, double maxTemp, double minTemp, double pressure, double airSpeed, int humidity, double precipitation) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.averageTemp = averageTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.pressure = pressure;
        this.airSpeed = airSpeed;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    //GETTERS & SETTERS


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(double airSpeed) {
        this.airSpeed = airSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    //***GETTERS & SETTERS***//

    public static Record parseText(String record) {
        String[] items = record.split(COMMA);

        if (items.length != 10) {
            throw new ArrayIndexOutOfBoundsException("Chyba rozsahu! ");
        }

       int year = Integer.parseInt(items[0]);
       int month = Integer.parseInt(items[1]);
       int day = Integer.parseInt(items[2]);
       double averageTemp = Double.parseDouble(items[3]);
       double maxTemp = Double.parseDouble(items[4]);
       double minTemp = Double.parseDouble(items[5]);
       double pressure = Double.parseDouble(items[6]);
       double airSpeed = Double.parseDouble(items[7]);
       int humidity = Integer.parseInt(items[8]);
       double precipitation = Double.parseDouble(items[9]);

       return new Record(year, month, day, averageTemp, maxTemp, minTemp, pressure, airSpeed, humidity, precipitation);

    }

    public String getAll(){
        return getYear()+", "+getMonth()+", "+getDay()+", "+getAverageTemp()+", "+getMaxTemp()+", "+getMinTemp()+", "+getPressure()+", "+getAirSpeed()+", "+getHumidity()+", "+getPrecipitation();
    }


    public String printMax(){
        return getYear() + "-" + getMonth() + "-" + getDay() + ": " + getMaxTemp();
    }

    public String printMin(){
        return getYear() + "-" + getMonth() + "-" + getDay() + ": " + getMinTemp();
    }
}
