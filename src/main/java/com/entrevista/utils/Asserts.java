package com.entrevista.utils;

import java.time.LocalDate;
import java.time.Period;

public class Asserts {

    public static Boolean validateAge(LocalDate birthDate){
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age >= Constants.MIN_AGE && age <= Constants.MAX_AGE;
    }

    public static Boolean validateAmount(Integer amount){
        return amount >= Constants.MIN_AMOUNT && amount <= Constants.MAX_AMOUNT;
    }

}
