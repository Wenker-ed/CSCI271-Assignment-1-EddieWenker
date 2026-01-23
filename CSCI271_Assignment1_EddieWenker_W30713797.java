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
        // Read integer A
        
        String in = "y";
        //While loop to continue reading until there are no more inputs
        while (in.equals("y")) 
        {
            int AssignmentSum = 0; // sum of scores
            //We are reading in 7 assignments and calculating the average score
            for (int i = 0; i < 7; i++) 
            {
                int Assignment = input.nextInt(); // each assignment score
                AssignmentSum += Assignment; // add each score to sum
            }
            double AssignmentAverage = (double)AssignmentSum / 7.0; // average of Assignment scores

            int TestSum = 0; // sum of scores
            for (int i = 0; i < 7; i++) 
            {
                int Test = input.nextInt(); // each assignment score
                TestSum += Test; // add each score to sum
            }
            double TestAverage = (double)TestSum / 7.0; // average of Test scores
            int MidTerm = input.nextInt(); // midterm score
            int FinalExam = input.nextInt(); // final exam score

            double CombinedExamGrade = (0.4 * FinalExam + 0.2 * (double)MidTerm + 0.1 * (double)TestAverage) / 0.7; // average of exam scores (diveded by 0.7 to get weighted average)
            System.out.println("Exams Average: " + CombinedExamGrade);
            double Weight = (CombinedExamGrade - 60) / 20 * 0.3;
            double FinalGrade = 0.0; // Used to calculate final grade

            if (CombinedExamGrade < 60)
            {
                FinalGrade = CombinedExamGrade;
                System.out.println("Final Grade: " + FinalGrade);
            }
            else if (CombinedExamGrade >= 60 && CombinedExamGrade < 80)
            {
                FinalGrade = (1 - Weight) * CombinedExamGrade + Weight * AssignmentAverage;
                System.out.println("Final Grade: " + FinalGrade);
            }
            else 
            {
                FinalGrade = 0.4 * FinalExam + 0.2 * (double)MidTerm + 0.1 * (double)TestAverage + 0.3 * AssignmentAverage;
                System.out.println("Final Grade: " + FinalGrade);
            }
            
            System.out.println("Keep going? (y/n): ");
            in = input.next(); // read in y or n to continue or stop
        }

        input.close(); // Close the scanner

    }
}
