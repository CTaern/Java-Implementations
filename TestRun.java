import java.util.Scanner;

public class TestRun {

    public static void main(String[] args){

        StudentLinkedList<String> studentlist = new StudentLinkedList<>();

        studentlist.GetStudentList();               //This gets information from text and places them to nodes

        boolean scan = true;
        while(scan){
            Scanner scann = new Scanner(System.in);
            System.out.println("To display sorted students overal average enter '0'"+ "Not working");
            System.out.println("To display students sorted by data structure grades enter '0'"+" Not working");
            System.out.println("To display students enter '1'");
            System.out.println("To display content of linkedlist enter '2'");
            System.out.println("To display math course average grade enter '3'");
            System.out.println("To display student(s) got lowest data structure grade enter '4'"); // My module that guide and helps to use
            System.out.println("To delete student enter '5'");
            System.out.println("To enter new student enter '6'");
            System.out.println("To display students that passed math course '7'");
            System.out.println("To display students that passed data structure course '8'");
            System.out.println("To display number of student(s): '9'");
            System.out.println("To exit '0'");
            Integer input = scann.nextInt();

            if (input==0)
                scan=false;
            else if(input==1)
                studentlist.DisplayStudents();
            else if(input==2)
                studentlist.DisplayStudents();
            else if(input==3)
                studentlist.mathAverage();
            else if(input==4)
                studentlist.LowestDataGrade();
            else if(input==5)
                studentlist.deleteStudent();
            else if(input==6)
                studentlist.addingStudentbyUser();
            else if(input==7)
                studentlist.aboveMathAverage();
            else if(input==8)
                studentlist.aboveDataAverage();
            else if(input==9)
                studentlist.studentcount();
            else
                scan=false;

        }
    }
}
