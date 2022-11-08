package com.oliinyk.lab.menu.commands.scan;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.List;
import java.util.Scanner;

public interface Scan {
    void execute(List<BasicInsurance> derevative, Scanner fileScan);
}
