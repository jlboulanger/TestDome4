import java.util.HashSet;
import java.util.Set;

public class RoutePlanner {

    public static boolean routeExistsRecur(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix, Set<String> visited) {


        //si destination pas une route -> false
        if (!mapMatrix[toRow][toColumn]) {
            return false;
        }
        //si depart pas une route -> false
        if (!mapMatrix[fromRow][fromColumn]) {
            return false;
        }

        //si on est à destination
        if (fromRow == toRow && fromColumn == toColumn) {
            return mapMatrix[toRow][toColumn];
        }


        Set<String> newVisited = new HashSet<>(visited);
        newVisited.add(fromRow +"-" + fromColumn);
        //celulle à droite
        if (fromColumn +1 <= toColumn && mapMatrix[fromRow][fromColumn+1] && !visited.contains(fromRow +"-" + (fromColumn+1))
                && routeExistsRecur(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, newVisited)) {
            return true;
        }
        //cellule  en bas
        else if (fromRow+1 <= toRow && mapMatrix[fromRow+1][fromColumn] && !visited.contains((fromRow+1) +"-" + fromColumn)
                && routeExistsRecur(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, newVisited)) {
            return true ;
        }
        //cellule à gauche
        else if (fromColumn > 0 && mapMatrix[fromRow][fromColumn-1] && !visited.contains(fromRow +"-" + (fromColumn-1))
                && routeExistsRecur(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, newVisited)) {
            return true ;
        }
        //cellule en haut
        else if (fromRow > 0 && mapMatrix[fromRow-1][fromColumn] && !visited.contains((fromRow-1) +"-" + fromColumn)
                && routeExistsRecur(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, newVisited)) {
            return true;
        }
        return false;
    }

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        return routeExistsRecur(fromRow, fromColumn, toRow, toColumn, mapMatrix, new HashSet<>());
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, true},
                {true,  true,  false},
                {false, true,  false}
        };

        System.out.println(routeExists(1, 0, 0, 2, mapMatrix));
    }
}
