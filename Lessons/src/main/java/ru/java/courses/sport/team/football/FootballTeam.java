package ru.java.courses.sport.team.football;

import ru.java.courses.sport.Coach;
import ru.java.courses.sport.Team;
import ru.java.courses.sport.Athlete;

public class FootballTeam extends Team {
    private final int MAX_COACHES = 1;
    private final int MAX_PLAYERS = 20;
    private final int MAX_ACTIVE_PLAYERS = 11;

    private Player players;
    private int playerCount;
    private int activePlayers;
    private int nonActivePlayers;
    private int coachesCount;

    Coach coach;

    //1. Модель должна содержать команду, включающую в себя тренера и игроков.

    public FootballTeam(String name) {
        super(name);
        this.players = new Player();
    }


    public void setCoach(Coach coach) {
        //6. В команде может быть только один тренер.
        if (coachesCount == MAX_COACHES) {
            throw new IllegalArgumentException("В команде максимальное количество тренеров " + MAX_COACHES);
        }

        this.coach = coach;
        this.coach.setActive(true);
        coachesCount++;
    }

    public Coach getCoach() {
        return coach;
    }

    //10.Должна быть возможность получить количество голов забитых всеми игроками в команде.
    public int getScore() {
        return players.getScore();
    }

    //2. Игроки могут как попадать в команду, так и удаляться из нее.

    @Override
    public void addPlayer(Athlete... athlete) {
        players.addPlayer(athlete);
    }

    public void addPlayers(Athlete... athlete) {
        addPlayer(athlete);
    }

    @Override
    public void removePlayer(Athlete... athlete) {
        players.removePlayer(athlete);
    }

    //11.Должна быть возможность получения количества игроков в команде.
    @Override
    public int getPlayersCount() {
        return playerCount;
    }

    @Override
    public int getMaxPlayersCount() {
        return MAX_PLAYERS;
    }

    public Player getPlayers() {
        return players;
    }

    //внутренний класс создается потому, что коллекции еще не пройдены, а в тестах есть конструкция типа team.getPlayers().get(0).
    public class Player {

        private FootballPlayer[] players;

        public Player() {
            players = new FootballPlayer[MAX_PLAYERS];
        }

        private int getScore() {
            int score = 0;
            for (FootballPlayer p : players) {
                if (p != null) {
                    score += p.getScore();
                }
            }
            return score;
        }

        private void addPlayer(Athlete... athlete) {

            for (Athlete a : athlete) {
                if (!(a instanceof FootballPlayer)) {
                    throw new IllegalArgumentException("В футбольную команду можно добавлять только футболистов");
                }
                //4. Игроков в команде может быть не больше 20.
                if (playerCount < MAX_PLAYERS) {
                    players[playerCount] = (FootballPlayer) a;
                    playerCount++;
                } else {
                    throw new IllegalArgumentException("В команде может быть только " + getMaxPlayersCount() + " футболистов");
                }
                //если активных участников меньше нормы, все новые футболисты будут автоматически активными
                if (activePlayers < MAX_ACTIVE_PLAYERS) {
                    a.setActive(true);
                    activePlayers++;
                } else {
                    a.setActive(false);
                    nonActivePlayers++;
                }

            }

        }

        private void removePlayer(Athlete... athlete) {

            for (Athlete a : athlete) {
                if (!(a instanceof FootballPlayer)) {
                    throw new IllegalArgumentException("Нельзя удалить из футбольной команды не футболиста");
                }

                for (int i = 0; i <= playerCount; i++) {
                    if (players[i].equals(a)) {
                        if(players[i].isActive()) {
                            activePlayers--;
                        } else {
                            nonActivePlayers--;
                        }
                        //отдельный метод для перетасовки массива при удалении
                        rearrange(players, i, playerCount);
                        playerCount--;
                        break;
                    }
                }
            }


        }

        //все сдвинется до позиции удаляемого элемента, последний элемент обnullится
        private void rearrange(FootballPlayer[] players, int startPosition, int endPosition) {
            for (int i = startPosition; i < endPosition; i++) {
                players[i] = players[i+1];
            }
            players[endPosition] = null;
        }

        public FootballPlayer get(int i) {
            return players[i];
        }
    }
}

