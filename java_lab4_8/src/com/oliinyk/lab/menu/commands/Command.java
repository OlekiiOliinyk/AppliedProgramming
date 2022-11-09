package com.oliinyk.lab.menu.commands;

import com.oliinyk.lab.insurance.BasicInsurance;

import java.util.List;

public interface Command {
    void execute(List<BasicInsurance> derevative);

    public default String getDescription() {
        return null;
    }
}
