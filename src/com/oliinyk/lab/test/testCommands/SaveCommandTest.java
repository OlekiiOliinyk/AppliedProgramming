package com.oliinyk.lab.test.testCommands;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.insurance.CarInsurance;
import com.oliinyk.lab.insurance.EstateInsurance;
import com.oliinyk.lab.menu.commands.SaveCommand;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveCommandTest {

    @Test
    void saveTest() throws IOException{

        SaveCommand saveCommand = new SaveCommand();

        String filePath = "D:\\University\\Applied Programming\\java_lab\\additional_info\\testSave\\testSave.txt";

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

        EstateInsurance insurance3 = (EstateInsurance) EstateInsurance.builder()
                .location("lviv")
                .area(58)
                .risk(5)
                .expCompens(300000)
                .build();

        derevative.add(insurance3);

        saveCommand.saveFile(derevative, filePath);

        String expectedSave = "Дериватив:\r\n" +
                "1. Страхування: Авто               Модель:  Tesla1                                   Пробіг:  20000.0      Ризик: 10.0 %    Компенсація: 500000      Ціна: 5555.6    \r\n" +
                "2. Страхування: Авто               Модель:  Tesla2                                   Пробіг:  20000.0      Ризик: 1.0  %    Компенсація: 500000      Ціна: 5050.5    \r\n" +
                "3. Страхування: Нерухосмість       Адреса:  lviv                                     Площа:   58           Ризик: 5.0  %    Компенсація: 300000      Ціна: 8700      \r\n";

        byte[] content =  Files.readAllBytes(Paths.get(filePath));
        assertEquals(expectedSave,new String(content));

    }
}