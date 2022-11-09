package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.menu.commands.PrintCommand;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintCommandTest {

    @Test
    void printTest() {

        PrintCommand printCommand = new PrintCommand();

        List<BasicInsurance> derevative = new ArrayList<>(10);

        CarInsurance insurance1 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla1")
                .kmrun(20000)
                .risk(10)
                .expCompens(500000)
                .build();

        derevative.add(insurance1);

        CarInsurance insurance2 = (CarInsurance) CarInsurance
                .builder()
                .model("Tesla2")
                .kmrun(20000)
                .risk(1)
                .expCompens(500000)
                .build();

        derevative.add(insurance2);
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        printCommand.printInfo(derevative);

        String caption1 = "Дериватив:\r\n" +
                "1. Страхування: Авто               Модель:  Tesla1                                   Пробіг:  20000.0      Ризик: 10.0 %    Компенсація: 500000      Ціна: 5555.6    \r\n" +
                "2. Страхування: Авто               Модель:  Tesla2                                   Пробіг:  20000.0      Ризик: 1.0  %    Компенсація: 500000      Ціна: 5050.5";
        String caption2 = outputStreamCaptor.toString().trim();

        assertEquals(caption1,caption2);

        System.setOut(new PrintStream(standardOut));

    }
}