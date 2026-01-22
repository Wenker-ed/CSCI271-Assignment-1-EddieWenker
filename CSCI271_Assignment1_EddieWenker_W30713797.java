/*************************************************************************
* Assignment 1 CSCI 271-001 Spring 2026
*
* Author: Eddie Wenker
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: January 21, 2026
*
* Purpose
* This program reads a list of scores from an input file, counts how many
* scores there are in the list, and computes their sum and average.
*
**************************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Eddie Wenker
* W30713797
*************************************************************************/

//DELETE THIS COMMENT BLOCK WHEN YOU FILL IN THE CODE
//inputfile > program or something like this (redirection)
//Don't need error checking

import java.util.Scanner;

public class CSCI271_Assignment1_EddieWenker_W30713797 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        //THERE IS A BUG THAT YOU HAVE TO FIX
        // Read integer N
        int N = input.nextInt();
        input.nextLine(); // Consume the remaining newline

        // Read N lines of text
        for (int i = 0; i < N; i++) {
            String line = input.nextLine();
            System.out.println(line);
        }

        input.close(); // Close the scanner



    }
}
