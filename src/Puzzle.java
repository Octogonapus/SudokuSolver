/**
 * Created by Ryan Benasutti on 11/30/2015.
 *
 * A representation of a 9x9 sudoku puzzle
 */


public class Puzzle
{
    //Puzzle data
    public int data[][] = new int[9][9];

    public Puzzle()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                data[i][j] = 0;
            }
        }

        //Test case 1
//        data[0][0] = 9;
//        data[0][1] = 5;
//        data[0][5] = 4;
//        data[0][7] = 8;
//
//        data[1][2] = 4;
//        data[1][7] = 9;
//        data[1][8] = 5;
//
//        data[2][0] = 8;
//        data[2][1] = 2;
//        data[2][4] = 1;
//        data[2][8] = 3;
//
//        data[3][0] = 4;
//        data[3][3] = 5;
//        data[3][7] = 3;
//        data[3][8] = 8;
//
//        data[4][0] = 3;
//        data[4][1] = 9;
//        data[4][3] = 8;
//        data[4][5] = 1;
//        data[4][7] = 5;
//        data[4][8] = 2;
//
//        data[5][0] = 5;
//        data[5][1] = 8;
//        data[5][5] = 9;
//        data[5][8] = 7;
//
//        data[6][0] = 6;
//        data[6][4] = 4;
//        data[6][7] = 2;
//        data[6][8] = 9;
//
//        data[7][0] = 1;
//        data[7][1] = 4;
//        data[7][6] = 5;
//
//        data[8][1] = 3;
//        data[8][3] = 6;
//        data[8][7] = 1;
//        data[8][8] = 4;

        //Test case 2
        data[0][1] = 5;
        data[0][4] = 7;
        data[0][5] = 3;
        data[0][6] = 1;
        data[0][7] = 8;
        data[0][8] = 4;

        data[1][4] = 4;
        data[1][7] = 5;

        data[2][2] = 1;
        data[2][3] = 2;
        data[2][8] = 3;

        data[3][0] = 5;
        data[3][1] = 3;
        data[3][2] = 8;
        data[3][5] = 2;
        data[3][6] = 9;

        data[4][2] = 6;
        data[4][6] = 3;

        data[5][2] = 9;
        data[5][3] = 7;
        data[5][6] = 5;
        data[5][7] = 6;
        data[5][8] = 2;

        data[6][0] = 8;
        data[6][5] = 5;
        data[6][6] = 6;

        data[7][1] = 6;
        data[7][4] = 8;

        data[8][0] = 7;
        data[8][1] = 1;
        data[8][2] = 4;
        data[8][3] = 6;
        data[8][4] = 2;
        data[8][7] = 3;

        //Test case 3
//        data[6][0] = 4;
//
//        data[2][1] = 4;
//        data[3][1] = 7;
//        data[4][1] = 6;
//        data[5][1] = 2;
//
//        data[1][2] = 9;
//        data[3][2] = 3;
//
//        data[0][3] = 4;
//        data[2][3] = 9;
//        data[3][3] = 2;
//        data[6][3] = 6;
//        data[7][3] = 3;
//
//        data[0][4] = 8;
//        data[4][4] = 5;
//        data[8][4] = 7;
//
//        data[1][5] = 2;
//        data[2][5] = 6;
//        data[5][5] = 4;
//        data[6][5] = 1;
//        data[8][5] = 5;
//
//        data[5][6] = 3;
//        data[7][6] = 5;
//
//        data[3][7] = 9;
//        data[4][7] = 2;
//        data[5][7] = 1;
//        data[6][7] = 3;
//
//        data[2][8] = 8;
    }

    @Override
    public String toString()
    {
        String string = "";

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                string += j == 2 || j == 5 ? data[i][j] + "|" : data[i][j];
            }
            string += i == 2 || i == 5 ? "\n---+---+---\n" : "\n";
        }

        return string;
    }
}
