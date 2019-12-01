/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab4;

/**
 *
 * @author AirDr
 */
public class Account {
    double cash;
    String name;
    int number;
    public Account(String name, int number, double initialBalence){
        this.name = name;
        this.number = number;
        this.cash = initialBalence;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return cash;
    }
    public int getNumber(){
        return number;
    }
    public boolean deposit(double amount){
        if(amount>0)//Check to see if the deposted amount is real.
        {
            cash+=amount;
            return true;
        }
        return false; 
    }
    public boolean withdraw(double amount){
        if(cash>amount && amount>0)//Checks to see if user has enough cash and amount is not a negative number.
        {
            cash-=amount;
            return true;
        }
            return false;
    }
  @Override public String toString() {
//DO NOT MODIFY
return "(" + getName() + ", " + getNumber() + ", " +String.format("$%.2f", getBalance()) + ")";}  
}
