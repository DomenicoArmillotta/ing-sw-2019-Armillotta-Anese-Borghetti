package it.polimi.ingsw;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StrategiesTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        int userChoice;
        String startMessage;
        startMessage = "SIMULAZIONE DI SANTORINI";
        System.out.println(startMessage);
        Scanner userInput = new Scanner(System.in);

        Player player1 = new Player("Domenico");
        Player player2 = new Player("Matteo");
        List<Player> playerQueue = new ArrayList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);
        GameMaster myMaster = new GameMaster(2, playerQueue);
        myMaster.createMatch();
        Match match = myMaster.getMatch();
        match.createMap();
        match.createGodList();
        Cell[][] map = match.getMap();
        player1.setCurrentMatch(match);
        player2.setCurrentMatch(match);
        match.startFirstTurn(playerQueue);
        System.out.println("Giocatori: " + ANSI_YELLOW + player1.getName() + ANSI_RESET + ", " + ANSI_BLUE + player2.getName() + ANSI_RESET + ".");

        System.out.println(ANSI_CYAN + "Setup" + ANSI_RESET);

        System.out.print(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", scegli una Carta Divinità: ");
        String chosenGod;
        chosenGod = userInput.nextLine();
        while (!chosenGod.equals("Apollo") && !chosenGod.equals("Atena") && !chosenGod.equals("Artemide") && !chosenGod.equals("Demetra") &&
                !chosenGod.equals("Atlante") && !chosenGod.equals("Efesto") && !chosenGod.equals("Minotauro") && !chosenGod.equals("Pan") &&
                !chosenGod.equals("Prometeo")) {
            System.out.println(ANSI_RED + "Divinità non esistente (controlla che la prima lettera sia MAIUSCOLA)" + ANSI_RESET);
            System.out.print(ANSI_RED + "Ripeti la Carta Divinità: " + ANSI_RESET);
            chosenGod = userInput.nextLine();
        }

        switch (chosenGod) {
            case "Apollo":
                player1.setPlayerGod(match.getGodList().get(God.APOLLO.ordinal()));
                break;
            case "Artemide":
                player1.setPlayerGod(match.getGodList().get(God.ARTEMIDE.ordinal()));
                break;
            case "Atena":
                player1.setPlayerGod(match.getGodList().get(God.ATENA.ordinal()));
                break;
            case "Atlante":
                player1.setPlayerGod(match.getGodList().get(God.ATLANTE.ordinal()));
                break;
            case "Demetra":
                player1.setPlayerGod(match.getGodList().get(God.DEMETRA.ordinal()));
                break;
            case "Efesto":
                player1.setPlayerGod(match.getGodList().get(God.EFESTO.ordinal()));
                break;
            case "Minotauro":
                player1.setPlayerGod(match.getGodList().get(God.MINOTAURO.ordinal()));
                break;
            case "Pan":
                player1.setPlayerGod(match.getGodList().get(God.PAN.ordinal()));
                break;
            case "Prometeo":
                player1.setPlayerGod(match.getGodList().get(God.PROMETEO.ordinal()));
                break;
        }
        System.out.println("La Carta Divinità di " + ANSI_YELLOW + player1.getName() + ANSI_RESET + " è " + player1.getPlayerGod().getGodName());


        player2.setPlayerGod(match.getGodList().get(God.PAN.ordinal()));

        System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", inserisci le coordinate del primo operaio");

        int userX;
        int userY;

        do {
            try {
                System.out.print("Inserisci la coordinata X: ");
                userX = userInput.nextInt();
                if (userX < 0 || userX > 4)
                    System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                userX = -1;
            }
            userInput.nextLine(); // clears the buffer
        } while (userX < 0 || userX > 4);

        do {
            try {
                System.out.print("Inserisci la coordinata Y: ");
                userY = userInput.nextInt();
                if (userY < 0 || userY > 4)
                    System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                userY = -1;
            }
            userInput.nextLine(); // clears the buffer
        } while (userY < 0 || userY > 4);

        player1.initFirstWorker(userX, userY);
        System.out.println("Le coordinate del primo operaio di " + ANSI_YELLOW + player1.getName() + ANSI_RESET + " sono: (" + player1.getFirstWorker().getCurrentPosition().getX() + "," + player1.getFirstWorker().getCurrentPosition().getY() + ")");

        System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", inserisci le coordinate del secondo operaio");

        do {
            do {
                try {
                    System.out.print("Inserisci la coordinata X: ");
                    userX = userInput.nextInt();
                    if (userX < 0 || userX > 4)
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userX = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userX < 0 || userX > 4);

            do {
                try {
                    System.out.print("Inserisci la coordinata Y: ");
                    userY = userInput.nextInt();
                    if (userY < 0 || userY > 4)
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userY = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userY < 0 || userY > 4);
            if (match.getMap()[userX][userY].getWorkerOnCell() != null)
                System.out.println(ANSI_RED + "La cella che hai selezionato è già occupata!" + ANSI_RESET);
        } while (match.getMap()[userX][userY].getWorkerOnCell() != null);

        player1.initSecondWorker(userX, userY);
        System.out.println("Le coordinate del secondo operaio di " + ANSI_YELLOW + player1.getName() + ANSI_RESET + " sono: (" + player1.getSecondWorker().getCurrentPosition().getX() + "," + player1.getSecondWorker().getCurrentPosition().getY() + ")");

        System.out.print(ANSI_BLUE + player2.getName() + ANSI_RESET + ", scegli una Carta Divinità: ");

        chosenGod = userInput.nextLine();
        while (!chosenGod.equals("Apollo") && !chosenGod.equals("Atena") && !chosenGod.equals("Artemide") && !chosenGod.equals("Demetra") &&
                !chosenGod.equals("Atlante") && !chosenGod.equals("Efesto") && !chosenGod.equals("Minotauro") && !chosenGod.equals("Pan") &&
                !chosenGod.equals("Prometeo")) {
            System.out.println(ANSI_RED + "Divinità non esistente (controlla che la prima lettera sia MAIUSCOLA)" + ANSI_RESET);
            System.out.print(ANSI_RED + "Ripeti la Carta Divinità: " + ANSI_RESET);
            chosenGod = userInput.nextLine();
        }

        switch (chosenGod) {
            case "Apollo":
                player2.setPlayerGod(match.getGodList().get(God.APOLLO.ordinal()));
                break;
            case "Artemide":
                player2.setPlayerGod(match.getGodList().get(God.ARTEMIDE.ordinal()));
                break;
            case "Atena":
                player2.setPlayerGod(match.getGodList().get(God.ATENA.ordinal()));
                break;
            case "Atlante":
                player2.setPlayerGod(match.getGodList().get(God.ATLANTE.ordinal()));
                break;
            case "Demetra":
                player2.setPlayerGod(match.getGodList().get(God.DEMETRA.ordinal()));
                break;
            case "Efesto":
                player2.setPlayerGod(match.getGodList().get(God.EFESTO.ordinal()));
                break;
            case "Minotauro":
                player2.setPlayerGod(match.getGodList().get(God.MINOTAURO.ordinal()));
                break;
            case "Pan":
                player2.setPlayerGod(match.getGodList().get(God.PAN.ordinal()));
                break;
            case "Prometeo":
                player2.setPlayerGod(match.getGodList().get(God.PROMETEO.ordinal()));
                break;
        }
        System.out.println("La Carta Divinità di " + ANSI_BLUE + player2.getName() + ANSI_RESET + " è " + player2.getPlayerGod().getGodName());


        System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + ", inserisci le coordinate del primo operaio");

        do {
            do {
                try {
                    System.out.print("Inserisci la coordinata X: ");
                    userX = userInput.nextInt();
                    if (userX < 0 || userX > 4)
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userX = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userX < 0 || userX > 4);

            do {
                try {
                    System.out.print("Inserisci la coordinata Y: ");
                    userY = userInput.nextInt();
                    if (userY < 0 || userY > 4)
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userY = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userY < 0 || userY > 4);
            if (match.getMap()[userX][userY].getWorkerOnCell() != null)
                System.out.println(ANSI_RED + "La cella che hai selezionato è già occupata!" + ANSI_RESET);
        } while (match.getMap()[userX][userY].getWorkerOnCell() != null);

        player2.initFirstWorker(userX, userY);
        System.out.println("Le coordinate del primo operaio di " + ANSI_BLUE + player2.getName() + ANSI_RESET + " sono: (" + player2.getFirstWorker().getCurrentPosition().getX() + "," + player2.getFirstWorker().getCurrentPosition().getY() + ")");

        System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + ", inserisci le coordinate del secondo operaio");

        do {
            do {
                try {
                    System.out.print("Inserisci la coordinata X: ");
                    userX = userInput.nextInt();
                    if (userX < 0 || userX > 4)
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userX = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userX < 0 || userX > 4);

            do {
                try {
                    System.out.print("Inserisci la coordinata Y: ");
                    userY = userInput.nextInt();
                    if (userY < 0 || userY > 4)
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    userY = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userY < 0 || userY > 4);
            if (match.getMap()[userX][userY].getWorkerOnCell() != null)
                System.out.println(ANSI_RED + "La cella che hai selezionato è già occupata!" + ANSI_RESET);
        } while (match.getMap()[userX][userY].getWorkerOnCell() != null);

        player2.initSecondWorker(userX, userY);
        System.out.println("Le coordinate del secondo operaio di " + ANSI_BLUE + player2.getName() + ANSI_RESET + " sono: (" + player2.getSecondWorker().getCurrentPosition().getX() + "," + player2.getSecondWorker().getCurrentPosition().getY() + ")");

        System.out.println(" ");
        System.out.println(ANSI_CYAN + "LEGENDA MAPPA" + ANSI_RESET);
        System.out.println("0: GROUND, 1: BASE, 2: MID, 3: TOP, 4: DOME");
        System.out.println("Le celle occupate dagli operai di " + ANSI_YELLOW + player1.getName() + ANSI_RESET + " sono " + ANSI_YELLOW + "gialle" + ANSI_RESET);
        System.out.println("Le celle occupate dagli operai di " + ANSI_BLUE + player2.getName() + ANSI_RESET + " sono " + ANSI_BLUE + "blu" + ANSI_RESET);
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player1))
                    System.out.print(ANSI_YELLOW + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                else if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player2))
                    System.out.print(ANSI_BLUE + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                else System.out.print(match.getMap()[i][j].getBuildingLevel().ordinal() + " ");
            }
            System.out.print(ANSI_GREEN + j + ANSI_RESET);
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(ANSI_GREEN + i + ANSI_RESET + " ");
        }
        System.out.println();

        do {

            System.out.println("Turno di " + match.getCurrentTurn().getCurrentPlayer().getName());

            List<Cell> selectOptionsCells;
            selectOptionsCells = player1.getPlayerGod().getEffect().doReturnSelectOptions(match);

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", seleziona uno dei tuoi operai");
            Boolean selectable = false;
            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                selectable = false;
                for (int i = 0; i < selectOptionsCells.size(); i++) {
                    if (selectOptionsCells.get(i).equals(match.getMap()[userX][userY]))
                        selectable = true;
                }
                if (!selectable) System.out.println(ANSI_RED + "Selezione non valida" + ANSI_RESET);
            } while (!selectable);

            Worker worker11;
            worker11 = player1.getPlayerGod().getEffect().doSelectWorker(match.getMap()[userX][userY]);

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + " ha selezionato l'operaio in posizione (" + worker11.getCurrentPosition().getX() + "," + worker11.getCurrentPosition().getY() + ")");

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", dove vuoi muovere l'operaio?");
            List<Cell> moveOptionsCells;
            moveOptionsCells = player1.getPlayerGod().getEffect().doReturnFirstMoveOptions(worker11);

            Boolean movable = false;
            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                movable = false;
                for (int i = 0; i < moveOptionsCells.size(); i++) {
                    if (moveOptionsCells.get(i).equals(match.getMap()[userX][userY]))
                        movable = true;
                }
                if (!movable) System.out.println(ANSI_RED + "Movimento non valido" + ANSI_RESET);
            } while (!movable);

            player1.getPlayerGod().getEffect().doMoveWorkerFirstTime(worker11, match.getMap()[userX][userY]);

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + " ha mosso l'operaio selezionato in posizione (" + worker11.getCurrentPosition().getX() + "," + worker11.getCurrentPosition().getY() + ")");

            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player1))
                        System.out.print(ANSI_YELLOW + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player2))
                        System.out.print(ANSI_BLUE + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else System.out.print(match.getMap()[i][j].getBuildingLevel().ordinal() + " ");
                }
                System.out.print(ANSI_GREEN + j + ANSI_RESET);
                System.out.println();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(ANSI_GREEN + i + ANSI_RESET + " ");
            }
            System.out.println();

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + ", dove vuoi costruire?");
            List<Cell> buildOptionsCells;
            buildOptionsCells = player1.getPlayerGod().getEffect().doReturnFirstBuildOptionsAfterMove(worker11);

            Boolean buildable = false;
            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                buildable = false;
                for (int i = 0; i < buildOptionsCells.size(); i++) {
                    if (buildOptionsCells.get(i).equals(match.getMap()[userX][userY]))
                        buildable = true;
                }
                if (!buildable) System.out.println(ANSI_RED + "Costruzione non valida" + ANSI_RESET);
            } while (!buildable);

            player1.getPlayerGod().getEffect().doBuildFirstBlockAfterMove(match.getMap()[userX][userY]);

            System.out.println(ANSI_YELLOW + player1.getName() + ANSI_RESET + " ha costruito un blocco in posizione (" + match.getMap()[userX][userY].getX() + "," + match.getMap()[userX][userY].getY() + ")");

            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player1))
                        System.out.print(ANSI_YELLOW + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player2))
                        System.out.print(ANSI_BLUE + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else System.out.print(match.getMap()[i][j].getBuildingLevel().ordinal() + " ");
                }
                System.out.print(ANSI_GREEN + j + ANSI_RESET);
                System.out.println();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(ANSI_GREEN + i + ANSI_RESET + " ");
            }
            System.out.println();

            match.getCurrentTurn().nextTurn();
            System.out.println("Turno di " + match.getCurrentTurn().getCurrentPlayer().getName());

            List<Cell> selectOptionsCells2 = player2.getPlayerGod().getEffect().doReturnSelectOptions(match);

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + ", seleziona uno dei tuoi operai");

            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                selectable = false;
                for (int i = 0; i < selectOptionsCells2.size(); i++) {
                    if (selectOptionsCells2.get(i).equals(match.getMap()[userX][userY]))
                        selectable = true;
                }
                if (!selectable) System.out.println(ANSI_RED + "Selezione non valida" + ANSI_RESET);
            } while (!selectable);


            Worker worker12 = player2.getPlayerGod().getEffect().doSelectWorker(match.getMap()[userX][userY]);

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + " ha selezionato l'operaio in posizione (" + worker12.getCurrentPosition().getX() + "," + worker12.getCurrentPosition().getY() + ")");

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + ", dove vuoi muovere l'operaio?");

            List<Cell> moveOptionsCells2 = player2.getPlayerGod().getEffect().doReturnFirstMoveOptions(worker12);

            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                movable = false;
                for (int i = 0; i < moveOptionsCells2.size(); i++) {
                    if (moveOptionsCells2.get(i).equals(match.getMap()[userX][userY]))
                        movable = true;
                }
                if (!movable) System.out.println(ANSI_RED + "Movimento non valido" + ANSI_RESET);
            } while (!movable);

            player2.getPlayerGod().getEffect().doMoveWorkerFirstTime(worker12, match.getMap()[userX][userY]);

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + " ha mosso l'operaio selezionato in posizione (" + worker12.getCurrentPosition().getX() + "," + worker12.getCurrentPosition().getY() + ")");

            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player1))
                        System.out.print(ANSI_YELLOW + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player2))
                        System.out.print(ANSI_BLUE + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else System.out.print(match.getMap()[i][j].getBuildingLevel().ordinal() + " ");
                }
                System.out.print(ANSI_GREEN + j + ANSI_RESET);
                System.out.println();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(ANSI_GREEN + i + ANSI_RESET + " ");
            }
            System.out.println();

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + ", dove vuoi costruire?");

            List<Cell> buildOptionsCells2 = player2.getPlayerGod().getEffect().doReturnFirstBuildOptionsAfterMove(worker12);

            do {
                do {
                    try {
                        System.out.print("Inserisci la coordinata X: ");
                        userX = userInput.nextInt();
                        if (userX < 0 || userX > 4)
                            System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata X non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userX = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userX < 0 || userX > 4);

                do {
                    try {
                        System.out.print("Inserisci la coordinata Y: ");
                        userY = userInput.nextInt();
                        if (userY < 0 || userY > 4)
                            System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(ANSI_RED + "Coordinata Y non valida (inserisci un numero intero compreso tra 0 e 4)" + ANSI_RESET);
                        userY = -1;
                    }
                    userInput.nextLine(); // clears the buffer
                } while (userY < 0 || userY > 4);
                buildable = false;
                for (int i = 0; i < buildOptionsCells2.size(); i++) {
                    if (buildOptionsCells2.get(i).equals(match.getMap()[userX][userY]))
                        buildable = true;
                }
                if (!buildable) System.out.println(ANSI_RED + "Costruzione non valida" + ANSI_RESET);
            } while (!buildable);

            player2.getPlayerGod().getEffect().doBuildFirstBlockAfterMove(match.getMap()[userX][userY]);

            System.out.println(ANSI_BLUE + player2.getName() + ANSI_RESET + " ha costruito un blocco in posizione (" + match.getMap()[userX][userY].getX() + "," + match.getMap()[userX][userY].getY() + ")");

            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player1))
                        System.out.print(ANSI_YELLOW + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else if (match.getMap()[i][j].getWorkerOnCell() != null && match.getMap()[i][j].getWorkerOnCell().getOwner().equals(player2))
                        System.out.print(ANSI_BLUE + match.getMap()[i][j].getBuildingLevel().ordinal() + ANSI_RESET + " ");
                    else System.out.print(match.getMap()[i][j].getBuildingLevel().ordinal() + " ");
                }
                System.out.print(ANSI_GREEN + j + ANSI_RESET);
                System.out.println();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(ANSI_GREEN + i + ANSI_RESET + " ");
            }
            System.out.println();

            match.getCurrentTurn().nextTurn();

            do {
                try {
                    System.out.println("Continuare? (1: Sì, 0: No)");
                    userChoice = userInput.nextInt();
                    if (userChoice < 0 || userChoice > 1)
                        System.out.println(ANSI_RED + "Digita 1 per continuare, 0 per fermare la simulazione" + ANSI_RESET);
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Digita 1 per continuare, 0 per fermare la simulazione" + ANSI_RESET);
                    userChoice = -1;
                }
                userInput.nextLine(); // clears the buffer
            } while (userChoice < 0 || userChoice > 1);


        } while (userChoice == 1);

/*
        Boolean continueGame = true;
        int userChoice;
        List<Cell> selectOptionsCells = new ArrayList<>();
        while(continueGame) {
        System.out.println(player1.getName()+", seleziona un operaio tra questi:");
        selectOptionsCells = player1.getPlayerGod().getEffect().doReturnSelectOptions(match);
        for(int i = 0; i < selectOptionsCells.size(); i++)
        System.out.println("Operaio "+(i+1)+": "+selectOptionsCells.get(i).getX()+" "+selectOptionsCells.get(i).getY());
         userX = userInput.nextInt();
        userY = userInput.nextInt();
        System.out.println("Continuare? (S = 1 / n = 0)");
        System.out.println("Continuare? (S = 1 / n = 0)");
        userChoice = userInput.nextInt();
        if(userChoice == 0) continueGame = false;
        }
        Worker worker1 = player1.getFirstWorker();
        Cell selectedCell = match.getMap()[2][3];
        match.createGodList();
        worker1.getOwner().setPlayerGod(match.getGodList().get(God.ATLANTE.ordinal()));*/
       /* List<Cell> buildOptionsCells = new ArrayList<>();
        worker1.getOwner().getPlayerGod().getEffect().doBuildFirstBlockAfterMove(selectedCell);
        buildOptionsCells = worker1.getOwner().getPlayerGod().getEffect().doReturnFirstBuildOptionsAfterMove(worker1);
        assertEquals(buildOptionsCells.size(), 7);*/
    }

}