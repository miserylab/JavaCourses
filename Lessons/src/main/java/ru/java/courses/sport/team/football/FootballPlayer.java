package ru.java.courses.sport.team.football;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.ScoringPlayer;

import java.util.Objects;

public class FootballPlayer extends Athlete implements ScoringPlayer {

    private PlayerRole role;
    private int goals;
    private int id;
    private static int idGen;

    public FootballPlayer(String name, PlayerRole role) {
        super(name);
        //9. У каждого игрока обязательно должна быть определена роль.
        if (role == null) {
            throw new IllegalArgumentException("Роль не может быть null");
        }
        this.role = role;
        this.id = ++idGen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer player = (FootballPlayer) o;
        return id == player.id;
    }


    //Активные могут забивать голы, запасные - нет. Для каждого игрока свой счетчик голов.
    @Override
    public void score() {
        if (isActive()) {
            goals++;
        } else {
            throw new IllegalArgumentException("Запасные игроки не могу забивать голы");
        }
    }

    @Override
    public int getScore() {
        return getGoals();
    }

    public int getGoals() {
        return goals;
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Роль не может быть null");
        }
        this.role = role;
    }
}
