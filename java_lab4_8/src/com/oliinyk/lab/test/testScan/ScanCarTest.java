package com.oliinyk.lab.test.testScan;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.menu.commands.scan.ScanCar;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScanCarTest {

    @Test
    void scanCarTest() throws FileNotFoundException {

        ScanCar scanCar = new ScanCar();

        File file = new File("D:\\University\\Applied Programming\\java_lab\\additional_info\\testScan\\sourceCar.txt");

        Scanner fileScan = new Scanner(file);

        List<BasicInsurance> derevative1 = new ArrayList<>(1);
        List<BasicInsurance> derevative2 = new ArrayList<>(1);

        scanCar.scan(derevative1, fileScan);

        CarInsurance insurance2 = (CarInsurance) CarInsurance
                .builder()
                .model("Model EX")
                .kmrun(25000)
                .risk(2.0)
                .expCompens(500000)
                .build();


        derevative2.add(insurance2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());
    }

}