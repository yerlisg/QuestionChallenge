package com.home.questionchallenge.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CsvReading {

    private CsvReading(){}

    public static List<List<String>> readCSV(String fileName){
        List<List<String >> dataList =  new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] data;
            while((data = reader.readNext()) != null){
                dataList.add(Arrays.asList(data));
            }
        } catch (CsvValidationException | IOException e){
            System.err.println("Ha ocurrido un error en la lectura del archivo CSV: " + e.getMessage());
            System.exit(1);
        }
        return  dataList;
    }




}
