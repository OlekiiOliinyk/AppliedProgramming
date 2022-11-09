package com.oliinyk.lab.test.testScan;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.MedicalInsurance;
import com.oliinyk.lab.menu.commands.scan.ScanMed;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScanMedTest {

    @Test
    void scanMedTest() throws FileNotFoundException {

        ScanMed scanMed = new ScanMed();

        File file = new File("info\\testScan\\sourceMed.txt");

        Scanner fileScan = new Scanner(file);

        List<BasicInsurance> derevative1 = new ArrayList<>(1);
        List<BasicInsurance> derevative2 = new ArrayList<>(1);

        scanMed.scan(derevative1,fileScan);

        MedicalInsurance insurance2 = (MedicalInsurance) MedicalInsurance
                .builder()
                .name("Olaf Vinegar")
                .age(24)
                .risk(10)
                .expCompens(100000)
                .build();

        derevative2.add(insurance2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());
    }
}