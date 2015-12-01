import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan Benasutti on 11/30/2015.
 */

public class Main
{
    //A list of all possible cell values
    public static final Integer fullPossibilityList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args)
    {
        //Convert int array to ArrayList<Integer>
        ArrayList<Integer> possibilities = new ArrayList<>();
        Collections.addAll(possibilities, fullPossibilityList);

        //Make a new puzzle
        Puzzle puzzle = new Puzzle();

        //Use test case 1
        puzzle.makeTestCase1();

        //Print out the unsolved puzzle
        System.out.println("\n" + puzzle.toString());

        //Solve the puzzle
        Puzzle solvedPuzzle = solvePuzzle(puzzle);

        //Print out the solved puzzle
        System.out.println(solvedPuzzle.toString());

        //Print out the coordinates of any remaining unknown cells and their possibilities
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (solvedPuzzle.data[i][j] == 0)
                    System.out.println("(" + i + ", " + j + "): " + symmetricDifference(getPeers(solvedPuzzle, i, j), possibilities));
    }

    /**
     * Solves a puzzle
     *
     * @param puzzle The puzzle to solve
     * @return       The solves puzzle
     */
    public static Puzzle solvePuzzle(Puzzle puzzle)
    {
        Puzzle solvedPuzzle = new Puzzle();
        boolean keepSolving = true, foundZero;

        while (keepSolving)
        {
            //Assume no zero will be found
            foundZero = false;

            //Solve each cell
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (puzzle.data[i][j] == 0)
                        solvedPuzzle = solveCell(puzzle, i, j);

            //Scan the puzzle for zeroes
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (solvedPuzzle.data[i][j] == 0)
                        foundZero = true;

            //Solve again if a zero was found
            keepSolving = foundZero;
        }

        return solvedPuzzle;
    }

    /**
     * Solves one cell based on possible values
     *
     * @param puzzle The puzzle with the unsolved cell
     * @param i      The x coordinate of the cell
     * @param j      The y coordinate of the cell
     * @return       The puzzle with the solved cell
     */
    public static Puzzle solveCell(Puzzle puzzle, int i, int j)
    {
        ArrayList<Integer> possibilities = new ArrayList<>();
        Collections.addAll(possibilities, fullPossibilityList);

        ArrayList<Integer> tempList;

        tempList = symmetricDifference(getPeers(puzzle, i, j), possibilities);

        if (tempList.size() == 1 || tempList.size() == 2)
        {
            puzzle.data[i][j] = tempList.get(tempList.size() - 1);
            if (puzzle.data[i][j] != tempList.get(tempList.size() - 1))
                System.out.print("Error");
        }

//        for (int k = 0; k < 9; k++)
//            for (int l = 0; l < 9; l++)
//            {
//                tempList = symmetricDifference(getPeers(puzzle, k, l), possibilities);
//
//                if (tempList.size() == 1 || tempList.size() == 2)
//                {
//                    puzzle.data[k][l] = tempList.get(tempList.size() - 1);
//                    if (puzzle.data[k][l] != tempList.get(tempList.size() - 1))
//                        System.out.print("Error");
//                }
//            }

        return puzzle;
    }

    /**
     * Gets the peers of a cell (duplicate peers are removed)
     *
     * @param puzzle The puzzle to get peers from
     * @param i      The x coordinate of the cell
     * @param j      The y coordinate of the cell
     * @return       An ArrayList of the values of the peers of the cell at (x, y) in puzzle
     */
    public static ArrayList<Integer> getPeers(Puzzle puzzle, int i, int j)
    {
        ArrayList<Integer> peers = new ArrayList<>();

        //Add peers in the same row
        for (int x = 0; x < 9; x++)
            if (x != i)
                peers.add(puzzle.data[x][j]);

        //Add peers in the same column
        for (int y = 0; y < 9; y++)
            if (y != j)
                peers.add(puzzle.data[i][y]);

        //Add peers in same section
        //Left section
        if (i <= 2)
        {
            //Top section
            if (j <= 2)
            {
                for (int k = 0; k <= 2; k++)
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 0; k <= 2; k++)
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Middle section
            else
            {
                for (int k = 0; k <= 2; k++)
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
        }
        //Right section
        else if (i >= 6)
        {
            //Top section
            if (j <= 2)
            {
                for (int k = 6; k <= 8; k++)
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 6; k <= 8; k++)
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Middle section
            else
            {
                for (int k = 6; k <= 8; k++)
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
        }
        //Middle section
        else
        {
            //Top section
            if (j <= 2)
            {
                for (int k = 3; k <= 5; k++)
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 3; k <= 5; k++)
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
            //Middle section
            else
            {
                for (int k = 3; k <= 5; k++)
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[k][l]);
                    }
            }
        }

        //Remove duplicates
        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(peers);
        peers.clear();
        peers.addAll(tempSet);

        return peers;
    }

    /**
     * Calculates the symmetric difference of two sets
     *
     * @param a Set a
     * @param b Set b
     * @return  The symmetric difference of sets a and b
     */
    public static ArrayList<Integer> symmetricDifference(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        Set<Integer> result = new HashSet<>(a);

        for (Integer element : b)
            if (!result.add(element))
                result.remove(element);

        ArrayList<Integer> realResult = new ArrayList<>();
        realResult.addAll(result);

        return realResult;
    }
}
