package com.bukanjoker.witchvillager2.entity;

import java.util.ArrayList;
import java.util.List;

public class Witch {
    private List<Villager> people;

    public Witch(List<Villager> list) {
        this.people = list;
    }

    public Witch() {
        this.people = new ArrayList<>();
    }

    public List<Villager> getList() {
        return people;
    }

    public void setList(List<Villager> list) {
        this.people = list;
    }

    public Boolean validatePeople() {
        Boolean isValid = true;

        for (int i = 0; i < this.people.size(); i++) {
            if (!this.people.get(i).isYearBornValid()) isValid = false;
        }

        return isValid;
    }

    public double getKillingNumber() {
        double totalKilled = 0;
        for (int i = 0; i < this.people.size(); i++) {
            totalKilled = totalKilled + this.fibonacci(this.people.get(i).getYearBorn());
        }

        return totalKilled/this.people.size();
    }

    public int fibonacci(int year) {
        int numberKilled = 0;
        List<Integer> dump = new ArrayList<>();
        dump.add(1);
        dump.add(1);

        for (int i = 0; i < year; i++) {
            if (i > 0) {
                dump.add(dump.get(i) + dump.get(i-1));
            }
            numberKilled = numberKilled + dump.get(i);
        }

        return numberKilled;
    }
}
