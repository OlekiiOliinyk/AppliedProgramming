package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.menu.Menu;
import com.oliinyk.lab.menu.commands.insert.InsertMenu;
import com.oliinyk.lab.menu.commands.scan.Scan;
import com.oliinyk.lab.menu.commands.scan.ScanCar;
import com.oliinyk.lab.menu.commands.scan.ScanEst;
import com.oliinyk.lab.menu.commands.scan.ScanMed;

import java.util.*;

public class InsertCommand implements Command {

    public void execute(List<BasicInsurance> derevative) {

        String type;
        Scanner scanner = new Scanner(System.in);
        InsertMenu insertMenu = new InsertMenu();
        System.out.print("Введіть тип страхування " + insertMenu.getTypes() + " :");
        type = scanner.nextLine().trim();
        insertMenu.execute(type, derevative);

    }

    public String getDescription() {
        return"вставлення зобов'язання в дериватив";
    }
}
