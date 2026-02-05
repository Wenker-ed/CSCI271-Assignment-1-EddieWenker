/*************************************************************************
* Assignment 1 CSCI 271-001 Spring 2026
*
* Author: Eddie Wenker
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: January 21, 2026
*
* Purpose
* This program calculates the final grade of a student in CSCI 271.
* The program reads in the name of the student and their grade scores 
* and the final grade is calculated based on the grading scheme provided 
* in the class syllabus.
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
*************************************************************************/

import java.util.Scanner;

public class CSCI271_Assignment1_EddieWenker_W30713797 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        //While loop to continue reading until there are no more inputs or until user inputs anything other than 'y'
        String in = "y"; // variable to control while loop
        while (in.equals("y")) 
        {

            //   The User must now how to input the data correctly.
            //   Input goes as follows: Student Name (String), 7 Assignment Scores (int),
            //   7 In-Class Test Scores (int), Midterm Score (int), Final Exam Score (int).
            //   All inputs are space separated and after getting all inputs for one student, 
            //   the program will output the final grade with 2 decimal precision.
            System.out.println("Enter student name followed by grades: ");
            String StudentName = input.next(); // read in student name as first input
            //The start of the block of code meant for grade inputs
            //The first 7 inputs are assignment scores
            //This for loop reads in each assignment score and adds it to the sum, the average is calculater after 7 scores are read
            int AssignmentSum = 0; // sum of scores
            for (int i = 0; i < 7; i++) 
            {
                int Assignment = input.nextInt(); // each assignment score
                AssignmentSum += Assignment; // add each score to sum
            }
            double AssignmentAverage = (double)AssignmentSum / 7.0; // average of Assignment scores, converted to double for accuracy

            //The next 7 inputs are in-class test scores
            //This for loop reads in each test score and adds it to the sum, the average is calculater after 7 scores are read
            int TestSum = 0; // sum of scores
            for (int i = 0; i < 7; i++) 
            {
                int Test = input.nextInt(); // each assignment score
                TestSum += Test; // add each score to sum
            }
            double TestAverage = (double)TestSum / 7.0; // average of Test scores, converted to double for accuracy

            int MidTerm = input.nextInt(); // midterm score read in as the second to last input
            int FinalExam = input.nextInt(); // final exam score read in as the last input
        
            double FinalGrade = 0.0; // Used to calculate final grade
            //end of grade reading block

            //The next block of code is used to determine final grade based off of the grades read in above
            // if-else statement to determine which part of the piecewise function the FinalGrade will be calculated from, based of CombinedExamGrade
            double CombinedExamGrade = (0.4 * FinalExam + 0.2 * (double)MidTerm + 0.1 * (double)TestAverage) / 0.7; // This is the grade from tests and exams combined (divided by 0.7 to get weighted average)! THIS WAS THE BUG
            if (CombinedExamGrade < 60) //If combined test and exam grade is less than 60, final grade is equal to combined exam grade - FAIL
            {
                FinalGrade = CombinedExamGrade;
                System.out.printf(StudentName + "-Final Grade: %.2f%n", FinalGrade); // Set precision to 2 decimal places
            }
            else if (CombinedExamGrade >= 60 && CombinedExamGrade < 80) // Combined test and exam grade was between 60 and 80, extra weight calculation is added for this section only
            {
                double Weight = (CombinedExamGrade - 60) / 20 * 0.3; // Weight ranges from 0 to 0.3 and is based on performance on tests and exams
                FinalGrade = (1 - Weight) * CombinedExamGrade + Weight * AssignmentAverage; // Final grade calculation with variable weight (1 - 0.7 for tests and exams)
                System.out.printf(StudentName + "-Final Grade: %.2f%n", FinalGrade); // Set precision to 2 decimal places
            }
            else // combined test and exam grade is 80 or more and all grades are included in final grade
            {
                FinalGrade = 0.4 * FinalExam + 0.2 * (double)MidTerm + 0.1 * (double)TestAverage + 0.3 * AssignmentAverage; // Final grade calculation with regular weights 
                System.out.printf(StudentName + "-Final Grade: %.2f%n", FinalGrade); // Set precision to 2 decimal places
            } // end of if-else
            
            //added to keep loop going and end when user decides
            System.out.println("Keep going? (y/n): ");
            in = input.next(); // read in y to continue or n to stop
        }

        input.close(); // Close the scanner

    }
}
