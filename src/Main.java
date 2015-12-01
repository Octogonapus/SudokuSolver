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
        ArrayList<Integer> possibilities = new ArrayList<>();
        Collections.addAll(possibilities, fullPossibilityList);

        Puzzle puzzle = new Puzzle();
        System.out.println("\n" + puzzle.toString());

        //puzzle = solvePuzzle(puzzle);
        //System.out.println(puzzle.toString());

        //System.out.println(getPeers(puzzle, 0, 0).toString());
        //System.out.println(symmetricDifference(getPeers(puzzle, 6, 8), possibilities));
        solvePuzzle(puzzle);

        System.out.println(puzzle.toString());
        System.out.println(symmetricDifference(getPeers(puzzle, 2, 7), possibilities));
    }

    public static Puzzle solvePuzzle(Puzzle puzzle)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (puzzle.data[i][j] == 0)
                    puzzle = solveCell(puzzle, i, j);
            }
        }

        return puzzle;
    }

    public static Puzzle solveCell(Puzzle puzzle, int i, int j)
    {
        ArrayList<Integer> possibilities = new ArrayList<>();
        Collections.addAll(possibilities, fullPossibilityList);

        ArrayList<Integer> tempList;

        for (int k = 0; k < 9; k++)
        {
            for (int l = 0; l < 9; l++)
            {
                tempList = symmetricDifference(getPeers(puzzle, k, l), possibilities);

                if (tempList.size() == 1 || tempList.size() == 2)
                {
                    puzzle.data[l][k] = tempList.get(tempList.size() - 1);
                    if (puzzle.data[l][k] != tempList.get(tempList.size() - 1))
                        System.out.print("Error");
                }
            }
        }

        return puzzle;
    }

    /**
     * Returns the peers of a cell (duplicate peers are removed)
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
        {
            if (x != i)
            {
//                System.out.print(puzzle.data[j][x]);
                peers.add(puzzle.data[j][x]);
            }
//            else
//                System.out.print("x");
        }

//        System.out.print(",");

        //Add peers in the same column
        for (int y = 0; y < 9; y++)
        {
            if (y != j)
            {
//                System.out.print(puzzle.data[y][i]);
                peers.add(puzzle.data[y][i]);
            }
//            else
//                System.out.print("y");
        }

//        System.out.print("\n");

        //Add peers in same section
        //Left section
        if (i <= 2)
        {
            //Top section
            if (j <= 2)
            {
                for (int k = 0; k <= 2; k++)
                {
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 0; k <= 2; k++)
                {
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Middle section
            else
            {
                for (int k = 0; k <= 2; k++)
                {
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
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
                {
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 6; k <= 8; k++)
                {
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Middle section
            else
            {
                for (int k = 6; k <= 8; k++)
                {
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
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
                {
                    for (int l = 0; l <= 2; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Bottom section
            else if (j >= 6)
            {
                for (int k = 3; k <= 5; k++)
                {
                    for (int l = 6; l <= 8; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
                }
            }
            //Middle section
            else
            {
                for (int k = 3; k <= 5; k++)
                {
                    for (int l = 3; l <= 5; l++)
                    {
                        if (k == i && l == j)
                            assert true;
                        else
                            peers.add(puzzle.data[l][k]);
                    }
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
     * Returns the symmetric difference of two sets
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
