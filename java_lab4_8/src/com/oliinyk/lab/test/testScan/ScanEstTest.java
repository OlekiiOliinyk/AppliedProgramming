package com.oliinyk.lab.test.testScan;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.EstateInsurance;
import com.oliinyk.lab.menu.commands.scan.ScanEst;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScanEstTest {

    @Test
    void scanEsttest() throws FileNotFoundException {

        ScanEst scanEst = new ScanEst();

        File file = new File("info\\testScan\\sourceEst.txt");

        Scanner fileScan = new Scanner(file);

        List<BasicInsurance> derevative1 = new ArrayList<>(1);
        List<BasicInsurance> derevative2 = new ArrayList<>(1);

        scanEst.scan(derevative1, fileScan);

        EstateInsurance insurance2 = (EstateInsurance) EstateInsurance.builder()
                .location("New York, st. Neverson, 3, 4a")
                .area(100)
                .risk(3)
                .expCompens(1000000)
                .build();

        derevative2.add(insurance2);

        assertEquals(derevative1.get(0).toString(),derevative2.get(0).toString());
    }

}