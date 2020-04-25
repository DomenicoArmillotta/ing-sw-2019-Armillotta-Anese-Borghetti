package it.polimi.ingsw.model;

import it.polimi.ingsw.model.powertree.*;

public class ActionExecutor {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;
    private Power powerPtr;
    private Cell[][] map;

    private static ActionExecutor instance;

    public static ActionExecutor instance() {
        if (instance == null) {
            instance = new ActionExecutor();
            instance.createMap();
        }
        return instance;
    }

    public void cleanActionExecutor() {
        this.powerPtr = null;
        this.map = null;
        createMap();
    }

    public void setPowerPtr(Power powerPtr) {
        this.powerPtr = powerPtr;
    }

    public Power getNextPower() {
        if (this.powerPtr != null) {
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            this.powerPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            return currentPlayer.getPlayerGod().getPowerList().get(index);
        } else {
            powerPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            return currentPlayer.getPlayerGod().getPowerList().get(0);
        }
    }

    public Select getNextSelect() {
        if (this.powerPtr != null) {
            Select selectPtr = currentPlayer.getPlayerGod().getSelectList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && selectPtr != indexPtr; j++) {
                    selectPtr = currentPlayer.getPlayerGod().getSelectList().get(j);
                }
                if (indexPtr == selectPtr)
                    return selectPtr;
            }
            return null;
        } else {
            Select selectPtr = currentPlayer.getPlayerGod().getSelectList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && selectPtr != indexPtr; j++) {
                    selectPtr = currentPlayer.getPlayerGod().getSelectList().get(j);
                }
                if (indexPtr == selectPtr)
                    return selectPtr;
            }
            return null;
        }
    }

    public Select getPrevSelect() {
        if (this.powerPtr != null) {
            Select selectPtr = currentPlayer.getPlayerGod().getSelectList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (; index > 0; index--) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && selectPtr != indexPtr; j++) {
                    selectPtr = currentPlayer.getPlayerGod().getSelectList().get(j);
                }
                if (indexPtr == selectPtr)
                    return selectPtr;
            }
            return null;
        } else {
            /* Select selectPtr = currentPlayer.getPlayerGod().getSelectList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && selectPtr != indexPtr; j++) {
                    selectPtr = currentPlayer.getPlayerGod().getSelectList().get(j);
                }
                if (indexPtr == selectPtr)
                    return selectPtr;
            } */
            return null;
        }
    }

    public Move getNextMove() {
        if (this.powerPtr != null) {
            Move movePtr = currentPlayer.getPlayerGod().getMoveList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getMoveList().size() && movePtr != indexPtr; j++) {
                    movePtr = currentPlayer.getPlayerGod().getMoveList().get(j);
                }
                if (indexPtr == movePtr)
                    return movePtr;
            }
            return null;
        } else {
            Move movePtr = currentPlayer.getPlayerGod().getMoveList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && movePtr != indexPtr; j++) {
                    movePtr = currentPlayer.getPlayerGod().getMoveList().get(j);
                }
                if (indexPtr == movePtr)
                    return movePtr;
            }
            return null;
        }
    }

    public Move getPrevMove() {
        if (this.powerPtr != null) {
            Move movePtr = currentPlayer.getPlayerGod().getMoveList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (index -= 2; index > 0; index--) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getMoveList().size() && movePtr != indexPtr; j++) {
                    movePtr = currentPlayer.getPlayerGod().getMoveList().get(j);
                }
                if (indexPtr == movePtr)
                    return movePtr;
            }
            return null;
        } else {
            Move movePtr = currentPlayer.getPlayerGod().getMoveList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && movePtr != indexPtr; j++) {
                    movePtr = currentPlayer.getPlayerGod().getMoveList().get(j);
                }
                if (indexPtr == movePtr)
                    return movePtr;
            }
            return null;
        }
    }

    public Build getNextBuild() {
        if (this.powerPtr != null) {
            Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getBuildList().size() && buildPtr != indexPtr; j++) {
                    buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
                }
                if (indexPtr == buildPtr)
                    return buildPtr;
            }
            return null;
        } else {
            Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && buildPtr != indexPtr; j++) {
                    buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
                }
                if (indexPtr == buildPtr)
                    return buildPtr;
            }
            return null;
        }
    }

    public Build getPrevBuild() {
        if (this.powerPtr != null) {
            Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (index -= 2; index > 0; index--) { /* CONTROLLA!!! -=2 o -=1? Per Artemide serve prevMove??? */
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getBuildList().size() && buildPtr != indexPtr; j++) {
                    buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
                }
                if (indexPtr == buildPtr)
                    return buildPtr;
            }
            return null;
        } else {
            Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            for (int index = 0; index < currentPlayer.getPlayerGod().getPowerList().size(); index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && buildPtr != indexPtr; j++) {
                    buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
                }
                if (indexPtr == buildPtr)
                    return buildPtr;
            }
            return null;
        }
    }

    public void appendPower(Power nextPower) {
        currentPlayer.getPlayerGod().getPowerList().add(nextPower);
    }

    public void nextTurn() {
        this.powerPtr = null;

        Player tempPlayer = null;
        tempPlayer = this.currentPlayer;


        currentPlayer = nextPlayer;
        nextPlayer = prevPlayer;
        prevPlayer = tempPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public Player getPrevPlayer() {
        return prevPlayer;
    }

    public void createMap() {
        Cell[][] map = new Cell[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new Cell();
                map[i][j].setX(i);
                map[i][j].setY(j);
            }
        }
        this.map = map;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void setPrevPlayer(Player prevPlayer) {
        this.prevPlayer = prevPlayer;
    }
}
