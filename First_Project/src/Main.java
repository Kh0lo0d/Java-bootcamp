import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int index1;

        char[][] array = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        System.out.println(array[0][0] + " " + array[0][1] + " " + array[0][2] + " " + array[0][3] + '\n' +
                " " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " " + array[1][3] + array[1][4] + '\n' +
                array[2][0] + " " + array[2][1] + " " + array[2][2] + " " + array[2][3] + '\n' +
                " " + array[3][0] + " " + array[3][1] + " " + array[3][2] + " " + array[3][3] + array[3][4] + '\n' +
                "" + array[4][0] + " " + array[4][1] + "  " + array[4][2] + "" + array[4][3] + '\n');


//*******************************************************************************************************


        int first_index, check;
        System.out.println(("Where would you like to play ? (1,9)"));
        first_index = input.nextInt();
        check = checkNum(first_index);
        put_Array(check, array);


        Random random = new Random();
        // generate random number from 0 to 3
        int number = random.nextInt(10);
        if (number != first_index && number != 0) {

            System.out.println("the computer choose: " + number);
            Fill_Array(number, array);

        } else {
            System.out.println(" the computer entered number repeater !! ");
            int again_number;
            again_number = random.nextInt(10);
            System.out.println("the computer choose again: " + again_number);

            Fill_Array(again_number, array);

        }

//***********************************************************************

//2
        int n2, r2, ch2;

        System.out.println(("Where would you like to play ? (1,9)"));
        n2 = input.nextInt();
        ch2 = checkNum(n2);
        if (n2 != first_index && n2 != number)
            put_Array(ch2, array);
        else {
            System.out.println("is not a valid move :");
            System.out.println(("Where would you like to play ? (1,9)"));
            n2 = input.nextInt();
            ch2 = checkNum(n2);
            put_Array(ch2, array);
        }

        r2 = random.nextInt(10);

        if (r2 != first_index && r2 != number && r2 != n2) {

            System.out.println("the computer choose: " + r2);
            Fill_Array(r2, array);
        } else {
            System.out.println("the computer entered number repeater !! ");
            int n = random.nextInt(10);
            ;
            System.out.println("the computer choose again " + n);
            Fill_Array(n, array);
        }

        if (r2 == 0) {
            r2 = random.nextInt(10);
            System.out.println("the computer choose: " + r2);
            Fill_Array(r2, array);
        }


//*****************************************************************************8
        //3
        int n3, r3, ch3;

        System.out.println(("Where would you like to play ? (1,9)"));
        n3 = input.nextInt();
        ch3 = checkNum(n3);
        if (n3 != first_index && n3 != number && n3 != n2 && n3 != r2)
            put_Array(ch3, array);
        else {
            System.out.println("is not a valid move :");
            System.out.println(("Where would you like to play ? (1,9)"));
            n3 = input.nextInt();
            ch3 = checkNum(n3);
            put_Array(ch3, array);
        }

        r3 = random.nextInt(10);
        if (r3 != 0) {
            if (r3 != first_index && r3 != number && r3 != n2 && r3 != n3 && r3 != r2) {
                System.out.println("the computer choose: " + r3);
                Fill_Array(r3, array);
            } else {
                System.out.println(" the computer entered number repeater !! ");
                int w = random.nextInt(10);
                ;
                System.out.println("the computer choose a gain" + w);

                Fill_Array(w, array);
            }
        }
        win(array);
//**********************************************************************
        //4

        int n4, r4, ch4;

        System.out.println(("Where would you like to play ? (1,9)"));
        n4 = input.nextInt();
        ch4 = checkNum(n4);
        if (n4 != first_index && n4 != number && n4 != n2 && n4 != r2 && n4 != n3 && n4 != r3)
            put_Array(ch4, array);
        else {
            System.out.println("is not a valid move :");
            System.out.println(("Where would you like to play ? (1,9)"));
            n4 = input.nextInt();
            ch4 = checkNum(n4);
            put_Array(ch4, array);
        }

        r4 = random.nextInt(10);
        if (r4 == 0) {
            r4 = random.nextInt(10);
            System.out.println("the computer choose: Again" + r4);
            Fill_Array(r4, array);
        }
        if (r4 != first_index && r4 != number && r4 != n2 && r4 != n3 && r4 != r2 && r4 != r3 && r4 != 0 && r4 != n4) {
            System.out.println("the computer choose: " + r4);
            Fill_Array(r4, array);
        } else {
            System.out.println(" the computer entered number repeater !! ");
            int q = random.nextInt(10);
            ;
            System.out.println("the computer choose  Again " + q);

            Fill_Array(q, array);

        }
        win(array);
        //5

        int n5, r5, ch5;

        System.out.println(("Where would you like to play ? (1,9)"));
        n5 = input.nextInt();
        ch5 = checkNum(n5);
        if (n5 != first_index && n5 != number && n5 != n2 && n5 != r2 && n5 != n3 && n5 != r3)
            put_Array(ch5, array);
        else {
            System.out.println("is not a valid move :");
            System.out.println(("Where would you like to play ? (1,9)"));
            n5 = input.nextInt();
            ch5 = checkNum(n5);
            put_Array(ch5, array);
        }

        r5 = random.nextInt(10);
        if (r5 == 0) {
            r5 = random.nextInt(10);
            System.out.println("the computer choose: Again" + r5);
            Fill_Array(r5, array);
        }
        if (r5 != first_index && r5 != number && r5 != n2 && r5 != n3 && r5 != r2 && r5 != r3 && r5 != 0 && r5 != n4) {
            System.out.println("the computer choose: " + r5);
            Fill_Array(r4, array);
        } else {
            System.out.println(" the computer entered number repeater !! ");
            int q = random.nextInt(10);
            ;
            System.out.println("the computer choose  Again " + q);

            Fill_Array(q, array);

        }
        win(array);}




    public static void win(char[][] array) {
        char x = 'x';
        char y = 'O';

        if (array[0][0] == x && array[0][2] == x && array[0][4] == x){
            System.out.println("you win , end game");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
        print(array2);}

        if (array[0][0] == y && array[0][2] == y && array[0][4] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
//*********************************************************
        if (array[2][0] == x && array[2][2] == x && array[2][4] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[2][0] == y && array[2][2] == y && array[2][4] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}

//************************************************************
        if (array[4][0] == x && array[4][2] == x && array[4][4] == x)
        {
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[4][0] == y && array[4][2] == y && array[4][4] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        //********************************************************************
        //********************************************************************
        if (array[0][0] == x && array[2][0] == x && array[4][0] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[0][0] == y && array[2][0] == y && array[4][0] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}

        //*********************************************************************
        if (array[0][2] == x && array[2][2] == x && array[4][2] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[0][2] == y && array[2][2] == y && array[4][2] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}

        //***********************************************************************
        if (array[0][4] == x && array[2][4] == x && array[4][4] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[0][4] == y && array[2][4] == y && array[4][4] == y)
        {
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}


        //************************************************************************
        //***********************************************************************
        if (array[0][0] == x && array[2][2] == x && array[4][4] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);;}
        if (array[0][0] == y && array[2][2] == y && array[4][4] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);;}

//*****************************************************************************

        if (array[0][4] == x && array[2][2] == x && array[4][0] == x){
            System.out.println("you win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}
        if (array[0][4] == y && array[2][2] == y && array[4][0] == y){
            System.out.println("computer win");
            char[][] array2 = {{' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
            print(array2);}


    }









public static void put_Array(int index , char[][]array)
    {


        while (index >= 1 && index <= 9) {
            if (index == 1){
                array[0][0] = 'x';
                print(array);
                break;}
            if (index == 2){
                array[0][2] = 'x';
                print(array);
                break;}
            if (index == 3){
                array[0][4] = 'x';
            print(array);
            break;}
            if (index == 4){
                array[2][0] = 'x';
                print(array);
                break;}
            if (index == 5){
                array[2][2] = 'x';
                print(array);
                break;}
            if (index == 6) {
                array[2][4] = 'x';
                print(array);
                break;}
            if (index == 7){
                array[4][0] = 'x';
                print(array);
                break;}
            if (index == 8){
                array[4][2] = 'x';
            print(array);
            break;}
            if (index == 9){
                array[4][4] = 'x';
            print(array);
            break;}


        }}

    public static void Fill_Array(int index , char[][]array)
    {


        while (index >= 1 && index <= 9) {
            if (index == 1){
                array[0][0] = 'O';
                print(array);
                break;}
            if (index == 2){
                array[0][2] = 'O';
                print(array);
                break;}
            if (index == 3){
                array[0][4] = 'O';
                print(array);
                break;}
            if (index == 4){
                array[2][0] = 'O';
                print(array);
                break;}
            if (index == 5){
                array[2][2] = 'O';
                print(array);
                break;}
            if (index == 6) {
                array[2][4] = '0';
                print(array);
                break;}
            if (index == 7){
                array[4][0] = 'O';
                print(array);
                break;}
            if (index == 8){
                array[4][2] = 'O';
                print(array);
                break;}
            if (index == 9){
                array[4][4] = 'O';
                print(array);
                break;}


        }}

    public static int checkNum(int num)
    {
       if(num>0 && num<10)
           return num;
       else {
           System.out.println("Enter a nother number ");
           Scanner input = new Scanner(System.in);
           int w= input.nextInt();
           return w;


       }



    }



      public static void print(char[][]array)
        {

            System.out.println(array[0][0] + " " + array[0][1] + " " + array[0][2] + " " + array[0][3] + array[0][4]+'\n' +
                    " " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " " + array[1][3] + array[1][4] + '\n' +
                    array[2][0] + " " + array[2][1] + " " + array[2][2] + " " + array[2][3] + array[2][4]+'\n' +
                    " " + array[3][0] + " " + array[3][1] + " " + array[3][2] + " " + array[3][3] + array[3][4] +  '\n' +
                    "" + array[4][0] + " " + array[4][1] + "  " + array[4][2] + "" + array[4][3] +array[4][4] + '\n');

    }


    }















