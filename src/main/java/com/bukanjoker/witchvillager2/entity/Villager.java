package com.bukanjoker.witchvillager2.entity;

public class Villager {
    private int ageOfDeath;
    private int yearOfDeath;

    public Villager(int ageOfDeath, int yearOfDeath) {
        this.ageOfDeath = ageOfDeath;
        this.yearOfDeath = yearOfDeath;
    }

    public Villager() {
        this.ageOfDeath = 0;
        this.yearOfDeath = 0;
    }

    public int getAgeOfDeath() {
        return ageOfDeath;
    }

    public void setAgeOfDeath(int ageOfDeath) {
        this.ageOfDeath = ageOfDeath;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public int getYearBorn() {
        return this.yearOfDeath - this.ageOfDeath;
    }

    public Boolean isYearBornValid() {
        return this.yearOfDeath > this.ageOfDeath;
    }
}
