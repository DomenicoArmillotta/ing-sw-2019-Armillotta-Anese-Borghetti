package it.polimi.ingsw;

/*
               / _\ #
               \c /  #
               / \___ #
               \`----`#==>
               |  \  #
    ,%.-"""---'`--'\#_
   %%/             |__`\
  .%'\     |   \   /  //
  ,%' >   .'----\ |  [/
     < <<`       ||
      `\\\       ||
        )\\      )\
^^^jgs^^"""^^^^^^""^^^^^^^^^^
 */

public class BasicBuildConcrete implements BuildBlockStrategy {
    @Override
    public void buildBlock(int blockX, int blockY, Turn turn) {
        if (!(turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).equals(Level.DOME)) {
            Level nextLevel = (turn.getMatch().getCell(blockX, blockY).getBuildingLevel()).getNext();
            turn.getMatch().getCell(blockX, blockY).setBuildingLevel(nextLevel);
        }
    }
}

/*
TO DO LIST

Interfaccia 1. Cell[2] doShowSelectOptions(Match); Matteo
Interfaccia 2. Worker doSelectWorker(Cell); Matteo
3. Cell[*] doShowBuildOptions(Worker); Marco
4. Void doPossibleBuildBeforeMove(Cell); Marco
Interfaccia 5. Cell[*] doShowMoveOptions(Worker); Matteo
Interfaccia 6. Cell[*] doSubstractRestraints(Worker, Cell[*]); Matteo
Interfaccia 7. Void doMoveWorker(Worker, Cell); Domenico
8. Cell[*] doShowMoveOptions(Worker); Matteo
9. Cell[*] doSubstractRestraints(Worker, Cell[*]); Matteo
10. Void doPossibleSecondMove(Worker, Cell); Domenico
Interfaccia 11. Cell[*] doShowBuildOptions(Worker); Marco
Interfaccia 12. Void doBuildBlock(Cell); Marco
13. Cell[*] doShowBuildOptions(Worker); Marco
14. Void doPossibleSecondBuildBlock(Cell); Marco

 */