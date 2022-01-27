package ru.java.courses.sport;

public abstract class Team <T extends Athlete>{

    private String name;

    public Team(String name) {
        //8. У каждой команды всегда должно быть имя.
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public abstract void addPlayer(T... athlete);

    public abstract void removePlayer(T... athlete);

    public abstract int getMaxPlayersCount();

    public abstract int getPlayersCount();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }
}