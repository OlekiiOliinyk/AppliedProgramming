package com.oliinyk.lab.menu;

import com.oliinyk.lab.insurance.BasicInsurance;
import com.oliinyk.lab.menu.commands.*;

import java.util.*;

public class Menu {
    private Map<String, Command> commands;

    public Menu(){
        commands = new HashMap<>();

        commands.put("insert",          new InsertCommand());
        commands.put("delete",          new DeleteCommand());
        commands.put("print",           new PrintCommand());
        commands.put("readfile",        new ReadfileCommand());
        commands.put("sort",            new SortCommand());
        commands.put("search",          new SearchCommand());
        commands.put("help",            new HelpCommand());
        commands.put("save",            new SaveCommand());
        commands.put("exit",            new ExitCommand());
    }

    public void execute(String command, List<BasicInsurance> derevative) {
        commands.getOrDefault(command, (List<BasicInsurance> error) ->
        System.out.println("Неправильна команда... Спробуйде ще раз")).execute(derevative);
    }

    public void printCommands(){
        for (Map.Entry<String, Command> set : commands.entrySet()) {

            System.out.printf("%-10s - %-30s%n", set.getKey(), set.getValue().getDescription());

        }
    }

}
