package ru.java.courses.sport;

public class Coach extends Athlete {
    private int experience;

    public Coach(String name) {
        super(name);
    }

    //7. У тренера есть опыть работы в годах.
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
