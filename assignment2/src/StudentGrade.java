import java.util.Scanner;


public class StudentGrade {
    public static void main(String[] args) {
        char student_nm;
        String new_student;
        int total_students, total_As, total_Bs, total_Cs, total_Ds, total_Fs;
        Double student_score, total_score, avg_score;
        total_score = 0.00;
        avg_score = 0.00;
        total_students = 0;
        total_As = 0;
        total_Bs = 0;
        total_Cs = 0;
        total_Ds = 0;
        total_Fs = 0;

        do {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            student_nm = scanner.next().charAt(0);
            System.out.print("Enter student's score: ");
            student_score = scanner.nextDouble();

            if (student_score >= .93) {
                total_As = total_As + 1;
                System.out.println(student_nm + "'s Grade is A");
            }
            if (student_score < .93 & student_score >= .90) {
                System.out.println(student_nm + "'s Grade is A-");
                total_As = total_As + 1;
            }
            if (student_score < .90 & student_score >= .87) {
                System.out.println(student_nm + "'s Grade is B+");
                total_Bs = total_Bs + 1;
            }
            if (student_score < .87 & student_score >= .83) {
                System.out.println(student_nm + "'s Grade is B");
                total_Bs = total_Bs + 1;
            }
            if (student_score < .83 & student_score >= .80) {
                System.out.println(student_nm + "'s Grade is B-");
                total_Bs = total_Bs + 1;
            }
            if (student_score < .80 & student_score >= .77) {
                System.out.println(student_nm + "'s Grade is C+");
                total_Cs = total_Cs + 1;
            }
            if (student_score < .77 & student_score >= .73) {
                System.out.println(student_nm + "'s Grade is C");
                total_Cs = total_Cs + 1;
            }
            if (student_score < .73 & student_score >= .70) {
                System.out.println(student_nm + "'s Grade is C-");
                total_Cs = total_Cs + 1;
            }
            if (student_score < .70 & student_score >= .67) {
                System.out.println(student_nm + "'s Grade is D+");
                total_Ds = total_Ds + 1;
            }
            if (student_score < .67 & student_score >= .63) {
                System.out.println(student_nm + "'s Grade is D");
                total_Ds = total_Ds + 1;
            }
            if (student_score < .63 & student_score >= .60) {
                System.out.println(student_nm + "'s Grade is D-");
                total_Ds = total_Ds + 1;
            }
            if (student_score < .60 & student_score >= 0) {
                System.out.println(student_nm + "'s Grade is F");
                total_Fs = total_Fs + 1;
            }
            total_students = total_students + 1;
            total_score = total_score + student_score;
            scanner.nextLine();
            System.out.print("Another Student (yes/no): ");
            new_student = scanner.nextLine();
            if (new_student.equalsIgnoreCase("no")) break;

        }while (true);

        avg_score = total_score / total_students;

        System.out.println("Total Number of Students: " + total_students);
        System.out.println("Average class score: " + avg_score);
        System.out.println("Total Number of A Grades: " + total_As);
        System.out.println("Total Number of B Grades: " + total_Bs);
        System.out.println("Total Number of C Grades: " + total_Cs);
        System.out.println("Total Number of D Grades: " + total_Ds);
        System.out.println("Total Number of F Grades: " + total_Fs);


    }

}
