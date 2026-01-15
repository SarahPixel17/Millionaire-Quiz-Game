/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a222_skip1103_project;

public class Bank {
    private int AvaiBank = 0;   // current bank balance

    /**
     * Constructor for bank class
     */
    public Bank() {
    }

    /**
     *
     * @return current bank balance.
     */
    public int getAvaiBank() {
        return AvaiBank;
    }

    /**
     * Add money to player bank
     *
     * @param moneyAmount
     */
    public void setMoney(int moneyAmount) {
        AvaiBank = moneyAmount;
    }
}
