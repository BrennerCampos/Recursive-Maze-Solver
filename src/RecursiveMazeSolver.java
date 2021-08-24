import java.util.Arrays;
import java.util.Scanner;

public class RecursiveMazeSolver
{


        public static int[][] dungeon = new int[10][10];

        /*

        static int currentX;
        static int currentY;
        static int previousHP = 3;
        static int hitPoints = 3;
        //static int currentHP = 3;

        */

        static int youX;
        static int youY;
        static int exitX;
        static int exitY;
        static int counter =0;
        static int isEmpty = 0;

        public static void dungeonCrawl(int y, int x, int hp)
        {
            counter ++;

            if (isEmpty == 1) {       // Base case
                return;
            }

    /*
            currentX=x;
            currentY=y;
            currentHP=hp;
    */


            if (dungeon[y][x] >= 0 )
            {
                if (dungeon[y][x] >= hp)
                {
                    return;
                }
            }

            if  (dungeon[y][x] == -4)        //if it's the Exit ('E'), don't go any further and just return
            {
                return;
            }



            if  (dungeon[y][x] == -1)      //if it's a Wall ('*') or a pos number, don't go any further and just return
            {
                return;
            }


            if (dungeon[y][x] == -2)         // if current spot is a monster ('m'), change it to a $
            {
                dungeon[y][x] = hp -= 1;
               // return;
            }


            if (dungeon[y][x] == -3)          // if current spot it an empty room ('.'), change it to a $
            {
                dungeon[y][x] = hp;
            }


            if (dungeon[y][x] >= 0) //also has to check to see if it's a nunmber (aka, an hp value)
            dungeon[y][x] = hp;



            if (dungeon[y][x] == -5)        // if the current spot is the ('Y'), change that to $
            {
                dungeon[y][x] = 3;
            }


            if (hp == 0)
                return;



           // System.out.println("Step #"+counter);       // print test
           // printIt(y, x);




            if (y>0 &&
                    (dungeon[y - 1][x] != -1)  )    // up      ^     (if up doesn't contain a wall)
            {
                dungeonCrawl(y - 1, x, hp);
                // if (currentY<10)
              //  y += 1;
              //  currentHP=hp;
            }


            if (x<10 &&
                    (dungeon[y][x + 1] != -1) )        // right   -->
            {
                dungeonCrawl(y, x + 1, hp);
                // if (currentX>0)
              //  x -= 1;
               // currentHP=hp;
            }


            if (y<10 &&
                    (dungeon[y + 1][x] != -1)   )      // down    V
            {
                dungeonCrawl(y + 1, x, hp);
                //  if (currentY>0)
               // y -=  1;
                //currentHP=hp;
            }

            if (x>0 &&
                    (dungeon[y][x - 1] != -1)   )         // left   <--
            {
                dungeonCrawl(y, x-1, hp);
                //  if (currentX<10)
              //  x += 1;
                //currentHP=hp;
            }


          //  if ((y == youY ) && (x == youX)) {
           //    isEmpty = 1;
          //  }

           //currentHP = hp;
             // currentHP = previousHP;

        }


        public static void printIt(int m, int n)           // Printing function for dungeon
        {
            for (m = 0; m < 10; m++)                        // converting & printing the array
            {
                for (n = 0; n < 10; n++) {

                    if (dungeon[m][n] < 0)
                    {
                        if (dungeon[m][n] == -1) {
                            System.out.print('*');
                        }

                        if (dungeon[m][n] == -2) {
                            System.out.print('m');
                        }

                        if (dungeon[m][n] == -3) {
                            System.out.print('.');
                        }

                        if (dungeon[m][n] == -4) {
                            System.out.print('E');
                        }

                        if (dungeon[m][n] == -5) {
                            System.out.print('Y');
                        }
                    }
                    else
                    {
                        System.out.print(dungeon[m][n]);
                    }
                }
                System.out.println();
            }
        }




        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);


            String line;            //setting some local variables
            int i = 0;
            int j = 0;



            for (i = 0; i < 10; i++)   // filling the dungeon array
            {

                line = sc.next();

                for (j = 0; j < 10; j++) {
                    dungeon[i][j] = line.charAt(j);

                    if (dungeon[i][j] == 'Y')     // if you find You, mark down it's x,y coordinates
                    {
                        youY = i;
                        youX = j;
                        dungeon[i][j] = -5;
                    }

                    if (dungeon[i][j] == '*')     // if you find a Wall, mark down it's x,y coordinates
                    {
                        dungeon[i][j] = -1;
                    }

                    if (dungeon[i][j] == 'm')     // if you find a Monster, mark down it's x,y coordinates
                    {
                        dungeon[i][j] = -2;
                    }

                    if (dungeon[i][j] == '.')     // if you find an Empty Room, mark down it's x,y coordinates
                    {
                        dungeon[i][j] = -3;
                    }

                    if (dungeon[i][j] == 'E')     // if you find Exit, mark down it's x,y coordinates
                    {
                        exitY = i;
                        exitX = j;
                        dungeon[i][j] = -4;
                    }

                }


            }

             // System.out.println("youX = " + youX + "\nyouY = " + youY + "\nexitX = " +exitX+ "\nexitY = " +exitY);

            // System.out.println("BEGINNING DUNGEON: ");
              //System.out.println(Arrays.deepToString(dungeon));


/*
            for (i = 0; i < 10; i++)   // // converting & printing the array
            {
                for (j = 0; j < 10; j++) {

                    if (dungeon[i][j] == -1)
                    {
                        System.out.print('*');
                    }

                    if (dungeon[i][j] == -2)
                    {
                        System.out.print('m');
                    }

                    if (dungeon[i][j] == -3)
                    {
                        System.out.print('.');
                    }

                    if (dungeon[i][j] == -4)
                    {
                        System.out.print('E');
                    }

                    if (dungeon[i][j] == -5)
                    {
                        System.out.print('Y');
                    }
                }
                System.out.println();

                // System.out.println(Arrays.deepToString(dungeon));
            }
*/


            dungeonCrawl(youY, youX, 3);       // --- RECURSIVE FUNCTION ---------------------------



            //System.out.println("FINAL DUNGEON: ");
          //  System.out.println();


            printIt(i,j);

        }

    }


    /*

***E******
*.*m..*.**
*Y*.*....*
*.*.*.*.**
*..****.**
*....m...*
***.****.*
**..mm.***
*..***mm.*
**********






     */





