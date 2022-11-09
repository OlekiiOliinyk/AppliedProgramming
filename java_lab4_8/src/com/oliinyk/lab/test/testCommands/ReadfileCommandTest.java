package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.menu.commands.ReadfileCommand;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReadfileCommandTest {
    @Test
    void readfileTest() throws FileNotFoundException {

        ReadfileCommand readfileCommand = new ReadfileCommand();

        String constTypes = "med\n" + "est\n" + "car\n" + "car\n" + "med\n"
                     + "med\n" + "est\n" + "tuvalu\n" + "est\n" + "med\n" + "yota\n";

        File file = new File("D:\\University\\Applied Programming\\" +
                    "java_lab\\additional_info\\testScan\\sourceType.txt");

        Scanner fileScan = new Scanner(file);

        String types = "";

        while (fileScan.hasNext()) {
            types += readfileCommand.findType(fileScan) + "\n";
        }

        assertEquals(constTypes, types);

    }

}