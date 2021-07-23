package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RecordList {

    ArrayList<Record> listOfRecords = new ArrayList<>();
    ArrayList<Double> maxTemps = new ArrayList<>();

    public void loadFromFile(String file){
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                listOfRecords.add(Record.parseText(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebyl nalezen: "+e.getLocalizedMessage());
        }
    }

    public void findMax(){
        listOfRecords.sort(Comparator.comparingDouble(Record::getMaxTemp));
        Record maxNum = listOfRecords.get(listOfRecords.size()-1);
        System.out.println("Maximum temperature for the reporting period: " + maxNum.printMax());
    }

    public void findMin(){
        listOfRecords.sort(Comparator.comparingDouble(Record::getMinTemp));
        Record minNum = listOfRecords.get(0);
        System.out.println("Minimum temperature for the reporting period: " + minNum.printMin());
    }

    public void windyDays(){
        int day = 0;
        for (Record r: listOfRecords){
            if (r.getAirSpeed() >= 4.2) {
                day++;
            }
        }
        System.out.println("Number of windy days: " + day);
    }

    public void calmDays(){
        int day = 0;
        for (Record r: listOfRecords){
            if (r.getAirSpeed() <= 1.8) {
                day++;
            }
        }
        System.out.println("Number of calm days: " + day);
    }

    public void precipitation(){
        listOfRecords.sort(Comparator.comparingInt(Record::getDay));
        double firstDecade = 0;
        double secondDecade = 0;
        double thirdDecade = 0;
        for (int i = 0; i < listOfRecords.size()-21; i++) {
            Record r = listOfRecords.get(i);
            firstDecade += r.getPrecipitation();
            Math.round(firstDecade);
        }
        for (int i = 10; i < listOfRecords.size()-11; i++) {
            Record r = listOfRecords.get(i);
            secondDecade += r.getPrecipitation();
        }
        for (int i = 20; i < listOfRecords.size(); i++) {
            Record r = listOfRecords.get(i);
            thirdDecade += r.getPrecipitation();
        }
        System.out.println("Precipitation summary in month decades: " + String.format("%.1f", firstDecade) + " --- " + secondDecade + " --- " + thirdDecade);

    }

    public void diagram() {
        System.out.println("   | 00--------10--------20--------30--------40");
        for (int i = 0; i < listOfRecords.size(); i++) {
            Record r = listOfRecords.get(i);
            long max = Math.round(r.getMaxTemp());
            long min = Math.round(r.getMinTemp());
            System.out.print(String.format("%02d", r.getDay()) + " | ");
            for (int j = 0; j <= 40; j++) {
                if (min <= j && j <= max) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public int sizeOfList(){
        return listOfRecords.size();
    }

    public Record getRecord(int index){
        return listOfRecords.get(index);
    }

    public void addRecord(Record record){
        listOfRecords.add(record);
    }

}
