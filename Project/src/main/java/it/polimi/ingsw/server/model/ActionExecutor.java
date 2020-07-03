package it.polimi.ingsw.server.model;
import it.polimi.ingsw.server.model.powertree.*;

/**
 * ActionExecutor is used to manage the current,next and prev player
 * and to move between the powers pointer
 */
public class ActionExecutor {
    private Player currentPlayer;
    private Player nextPlayer;
    private Player prevPlayer;
    private Power powerPtr;
    private Power finalState;
    private Cell[][] map;

    private void endGame() {
        this.powerPtr = finalState;
    }

    private static ActionExecutor instance;

    /**
     * constructor of ActionExecutor
     * @return the instance of ActionExecutor
     */
    public static ActionExecutor instance() {
        if (instance == null) {
            instance = new ActionExecutor();
            instance.createMap();
            instance.finalState = new Move(); /* stato terminatore, cambiare Move */
        }
        return instance;
    }

    /**
     * set the map null and the power pointer as null
     */
    public void cleanActionExecutor() {
        this.powerPtr = null;
        this.map = null;
        createMap();
    }

    public void nullActionExecutor() {
        instance = null;
    }

    public Power getPowerPtr() {
        return powerPtr;
    }

    public void setPowerPtr(Power powerPtr) {
        this.powerPtr = powerPtr;
    }

    /**
     * used to move to the next power
     * @return the power pinter
     */
    public Power getNextPower() {
        if (powerPtr == finalState)
            return finalState;
        if (this.powerPtr != null) {
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            if (index == currentPlayer.getPlayerGod().getPowerList().size()) {
                this.nextTurn();
                this.powerPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
                return this.currentPlayer.getPlayerGod().getPowerList().get(0);
            } else {
                this.powerPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                return currentPlayer.getPlayerGod().getPowerList().get(index);
            }
        } else {
            powerPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            return currentPlayer.getPlayerGod().getPowerList().get(0);
        }
    }

    /**
     * used for switch to next select
     * @return the select pointer
     */
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
    /**
     * used for switch to previous select
     * @return the select pointer
     */
    public Select getPrevSelect() {
        if (this.powerPtr != null) {
            Select selectPtr = currentPlayer.getPlayerGod().getSelectList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (index -= 2; index > 0; index--) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                int j;
                for (j = 0; j < currentPlayer.getPlayerGod().getSelectList().size() && selectPtr != indexPtr; j++) {
                    selectPtr = currentPlayer.getPlayerGod().getSelectList().get(j);
                }
                if (indexPtr == selectPtr) {
                    return selectPtr;
                }
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
    /**
     * used for switch to next move
     * @return the move pointer
     */
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

    /**
     * used for switch to previous move
     * @return the move pointer
     */
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
        } /*else
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
        }*/
        return null;
    }
/*
public Move getPrevMove() {
    if (this.powerPtr != null) {
        Move movePtr = currentPlayer.getPlayerGod().getMoveList().get(0);
        Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
        int index;
        for (index = 1; indexPtr != powerPtr; index++) {
            indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
        }
        for (; index > 0; index--) {
            indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            for (int j = 0; j < currentPlayer.getPlayerGod().getMoveList().size() && movePtr != indexPtr; j++) {
                movePtr = currentPlayer.getPlayerGod().getMoveList().get(j);
            }
            if (indexPtr == movePtr) {
                return movePtr;
            }
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
}*/
    /**
     * used for switch to next build
     * @return the build pointer
     */
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

    /**
     * used for switch to previous build
     * @return the build pointer
     */
    public Build getPrevBuild() {
        if (this.powerPtr != null) {
            Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
            Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
            int index;
            for (index = 1; indexPtr != powerPtr; index++) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            }
            for (index -= 2; index > 0; index--) {
                indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
                for (int j = 0; j < currentPlayer.getPlayerGod().getBuildList().size() && buildPtr != indexPtr; j++) {
                    buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
                }
                if (indexPtr == buildPtr)
                    return buildPtr;
            }
            return null;
        }
        return null;
    }/*
public Build getPrevBuild() {
    if (this.powerPtr != null) {
        Build buildPtr = currentPlayer.getPlayerGod().getBuildList().get(0);
        Power indexPtr = currentPlayer.getPlayerGod().getPowerList().get(0);
        int index;
        for (index = 1; indexPtr != powerPtr; index++) {
            indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
        }
        for (; index > 0; index--) {
            indexPtr = currentPlayer.getPlayerGod().getPowerList().get(index);
            for (int j = 0; j < currentPlayer.getPlayerGod().getBuildList().size() && buildPtr != indexPtr; j++) {
                buildPtr = currentPlayer.getPlayerGod().getBuildList().get(j);
            }
            if (indexPtr == buildPtr) {
                return buildPtr;
            }
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
            }
        return null;
    }
}*/
    public void appendPower(Power nextPower) {
        currentPlayer.getPlayerGod().getPowerList().add(nextPower);
    }

    /**
     * used to move to the next round of the game
     */
    public void nextTurn() {
        this.powerPtr = null;
        Player tempPlayer = null;
        tempPlayer = this.currentPlayer;
        if(this.nextPlayer.equals(this.prevPlayer)){
            this.currentPlayer = this.prevPlayer;
            this.prevPlayer=tempPlayer;
            this.nextPlayer=tempPlayer;
        }else {
            currentPlayer = nextPlayer;
            nextPlayer = prevPlayer;
            prevPlayer = tempPlayer;
        }
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

    /**
     * create the map formed of cells
     */
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
