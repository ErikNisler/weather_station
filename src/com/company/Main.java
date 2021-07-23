package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        RecordList recordList = new RecordList();
        RecordList maxTempsList = new RecordList();
        ArrayList<Record> listOfRecords = new ArrayList<>();

        /**Přivítat uživatele výpisem na standardní výstup:*/
        System.out.println("Welcome to the application for Meteorological Data Analysis.");
        System.out.println("=====================");
        /**Načte data ze souboru*/
        recordList.loadFromFile("B2BTUR01_07_2019.csv");

        /**celkový počet denních záznamů, které se budou vyhodnocovat*/
        int count = 0;
        for (int i = 0; i < recordList.sizeOfList(); i++) {
            ++count;
        }
        System.out.println("We have " + count + " meteorological daily records to analyze.");

        System.out.println();
        /**průměrnou denní teplotu za sledované období*/
        double sumOfAveTemp = 0;
        for (int i = 0; i < recordList.sizeOfList(); i++) {
            Record record = recordList.getRecord(i);
            System.out.println(record.getAll());
            sumOfAveTemp += record.getAverageTemp();
        }
        double result = 0;
        result = sumOfAveTemp / count;
        System.out.println("Average temperature for the reporting period: " + String.format("%.1f", result));

        /**maximální teplotu za sledované období s tím, že uvedete maximální teplotu a den, ve kterém bylo toto maximum zjištěno*/
        recordList.findMax();
        recordList.findMin();
        /**celkový počet větrných dnů za dané období
         * (za větrný den je považován ten, kdy průměrná denní rychlost větru je větší nebo rovna 4,2 m/s)*/
        recordList.windyDays();
        /**celkový počet klidných dnů za dané období
         * (za klidný den je považován ten, kdy průměrná denní rychlost větru je menší nebo rovna 1,8 m/s)*/
        recordList.calmDays();
        /**souhrnný přehled srážek za sledované období v rozdělení do měsíčních dekád
         * (jedná se nám tedy o úhrny srážek za prvních deset kalendářních dnů, za druhých deset kalendářních dnů, následuje pak úhrn srážek za všechny další dny)*/
        recordList.precipitation();

        /**Všechny vypočtené hodnoty uvádějte v přesnosti na jedno desetinné místo včetně odpovídajících jednotek.

         Vypsat na standardní výstup graf rozložení denních teplot.
         Jedná se nám o graf, ve kterém:

         jednotlivé řádky budou zobrazovat kalendářní dny
         v každém řádku bude vyznačen rozsah minimální a maximální teploty znakem *
         graf bude doplněn o osy*/

        System.out.println("Diagram of daily range max temps and min temps: ");
        recordList.diagram();
    }
}
