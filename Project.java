//Krish Israni
//ID:113227084

import java.util.Scanner;
public class Project
        {
                public static void main (String[] args)
                {
                        String[][] board = createPattern();
                        int count = 0;
                        boolean loop = true;

                        printPattern(board);
                        while(loop)
                        {
                                if (count % 2 == 0) redPattern(board);
                                else yellowPattern(board);
                                count++;
                                printPattern(board);

                                if (checkWinner(board) != null)
                                {
                                        if (checkWinner(board) == "R")
                                                System.out.println("The red player won.");
                                        else if (checkWinner(board)== "Y")
                                                System.out.println("The yellow player won.");
                                        loop = false;
                                }
                        }
                }
                public static String[][] createPattern()
                {

                        String[][] a = new String[7][15];
                        for (int i =0;i<a.length;i++)
                        {
                                for (int j =0;j<a[i].length;j++)
                                {

                                        if (j% 2 == 0) a[i][j] ="|";
                                        else a[i][j] = " ";

                                        if (i==6) a[i][j]= "-";
                                }
                        }
                        return a;
                }

                public static void printPattern(String[][] b)
                {
                        for (int i =0;i<b.length;i++)
                        {
                                for (int j=0;j<b[i].length;j++)
                                {
                                        System.out.print(b[i][j]);
                                }
                                System.out.println();
                        }
                }


                public static void redPattern(String[][] c)
                {

                        System.out.println("Drop a red disk at column (0–6): ");
                        Scanner scan = new Scanner (System.in);
                        int d = 2*scan.nextInt()+1;
                        for (int i =5;i>=0;i--)
                        {
                                if (c[i][d] == " ")
                                {
                                        c[i][d] = "R";
                                        break;
                                }
                        }
                }

                public static void yellowPattern(String[][] c)
                {
                        System.out.println("Drop a yellow disk at column (0–6): ");
                        Scanner scan = new Scanner (System.in);
                        int d = 2*scan.nextInt()+1;
                        for (int i =5;i>=0;i--)
                        {
                                if (c[i][d] == " ")
                                {
                                        c[i][d] = "Y";
                                        break;
                                }
                        }
                }

                public static String checkWinner(String[][] c)
                {


                        for (int i =0;i<6;i++)
                        {

                                for (int j=0;j<7;j+=2)
                                {
                                        if ((c[i][j+1] != " ")
                                                && (c[i][j+3] != " ")
                                                && (c[i][j+5] != " ")
                                                && (c[i][j+7] != " ")
                                                && ((c[i][j+1] == c[i][j+3])
                                                && (c[i][j+3] == c[i][j+5])
                                                && (c[i][j+5] == c[i][j+7])))

                                                return c[i][j+1];
                                }
                        }
                        for (int i=1;i<15;i+=2)
                        {
                                for (int j =0;j<3;j++)
                                {
                                        if((c[j][i] != " ")
                                                && (c[j+1][i] != " ")
                                                && (c[j+2][i] != " ")
                                                && (c[j+3][i] != " ")
                                                && ((c[j][i] == c[j+1][i])
                                                && (c[j+1][i] == c[j+2][i])
                                                && (c[j+2][i] == c[j+3][i])))
                                                return c[j][i];
                                }
                        }
                        for (int i=0;i<3;i++)
                        {
                                for (int j=1;j<9;j+=2)
                                {
                                        if((c[i][j] != " ")
                                                && (c[i+1][j+2] != " ")
                                                && (c[i+2][j+4] != " ")
                                                && (c[i+3][j+6] != " ")
                                                && ((c[i][j] == c[i+1][j+2]
                                                && (c[i+1][j+2] == c[i+2][j+4])

                                                && (c[i+2][j+4] == c[i+3][j+6]))))
                                                return c[i][j];
                                }
                        }

                        for (int i=0;i<3;i++)
                        {
                                for (int j=7;j<15;j+=2)
                                {
                                        if((c[i][j] != " ")
                                                && (c[i+1][j-2] != " ")
                                                && (c[i+2][j-4] != " ")
                                                && (c[i+3][j-6] != " ")
                                                && ((c[i][j] == c[i+1][j-2])
                                                && (c[i+1][j-2] == c[i+2][j-4])
                                                && (c[i+2][j-4] == c[i+3][j-6])))
                                                return c[i][j];
                                }
                        }

                        return null;
                }

        }
