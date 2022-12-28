import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentLinkedList<S extends Comparable>{

    protected Node<S> head;

    public Node<S> NodeCreator(S val){
        return new Node<>(val);
    }

    public void AddStudent(S val){
        Node<S> iterator=head;
        if(head==null)
            head=NodeCreator(val);
        else{                                                   //This basically add to end of node a new chain
            while (iterator.next != null){
                iterator=iterator.next;
            }
            iterator.next=NodeCreator(val);
            iterator.next.previous=iterator;
        }
    }

    public void DisplayStudents(){
        Node<S> iterator=head;
        while(iterator!=null){
            System.out.println(iterator.value);
            iterator=iterator.next;
        }
    }


    public void GetStudentList(){

        File studentgrades = new File("students.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(studentgrades);
        } catch (FileNotFoundException e) {                                             //I got students using a scanner and if user dont enter
            System.out.println("Invalid file name.");                                       //correct file path I warned user with a line
        }
        while (scanner.hasNextLine()) {

            AddStudent((S) scanner.nextLine());
        }
    }

    public void LowestDataGrade(){
        Node<S> iterator=head;
        String[] tempLine;
        int lowest = 0;
        while(iterator!=null){
            tempLine= String.valueOf(iterator).split("\\s+", 3);
            for (int i = 2; i < tempLine.length; i=i+2) {

                if(lowest==0)
                    lowest=Integer.parseInt(tempLine[i].split("\\s+")[1]);
                else{
                    if(lowest>Integer.parseInt(tempLine[i].split("\\s+")[1]))
                        lowest=Integer.parseInt(tempLine[i].split("\\s+")[1]);

                }

                }
            iterator=iterator.next;

        }
        Node<S> temp_iterator=head;
        String[] temp_line;
        while (temp_iterator!=null){
            temp_line=String.valueOf(temp_iterator).split("\\s+", 3);
            for (int k = 2; k < temp_line.length; k=k+2){
                int temporarygrade=Integer.valueOf(temp_line[2].split("\\s+")[1]);
                if(temporarygrade==lowest)
                    System.out.println(temp_line[1]+" with lowest data structure grade of "+ "'"+lowest+"'"+".");
            }
            temp_iterator=temp_iterator.next;
        }




    }

    public void mathAverage(){
        Node<S> iterator=head;
        int count=0;
        double avg = 0;
        String[] tempLine;
        while(iterator!=null){
            tempLine= String.valueOf(iterator).split("\\s+", 3);
            for (int i = 2; i < tempLine.length; i=i+2){

                avg+=Integer.valueOf(tempLine[i].split("\\s+")[0]);
            }
            iterator=iterator.next;
            count++;
        }
        avg = avg/count;
        System.out.println("Average grade of math is: "+ avg);
    }
    public void aboveMathAverage() {
        Node<S> iterator = head;
        int count = 0;
        double avg = 0;
        String[] tempLine;
        while (iterator != null) {
            tempLine = String.valueOf(iterator).split("\\s+", 3);
            for (int i = 2; i < tempLine.length; i = i + 2) {

                avg += Integer.valueOf(tempLine[i].split("\\s+")[0]);
            }
            iterator = iterator.next;
            count++;
        }
        avg = avg / count;

        Node<S> temp_iterator = head;
        String[] temp_line;
        while (temp_iterator != null) {
            temp_line = String.valueOf(temp_iterator).split("\\s+", 3);
            for (int k = 2; k < temp_line.length; k = k + 2) {
                int temporarygrade = Integer.valueOf(temp_line[2].split("\\s+")[0]);
                if (temporarygrade >= avg)
                    System.out.println(temp_line[0]+" "+temp_line[1]+" with grade: "+temporarygrade+
                            " passed Math course.");
            }
            temp_iterator=temp_iterator.next;
        }
    }

    public void aboveDataAverage() {
        Node<S> iterator = head;
        int count = 0;
        double avg = 0;
        String[] tempLine;
        while (iterator != null) {
            tempLine = String.valueOf(iterator).split("\\s+", 3);
            for (int i = 2; i < tempLine.length; i = i + 2) {

                avg += Integer.valueOf(tempLine[i].split("\\s+")[1]);
            }
            iterator = iterator.next;
            count++;                                                                    //To calculate and display students that have grade above average I used some lists to keep data
        }                                                                                 //
        avg = avg / count;

        Node<S> temp_iterator = head;
        String[] temp_line;
        while (temp_iterator != null) {
            temp_line = String.valueOf(temp_iterator).split("\\s+", 3);
            for (int k = 2; k < temp_line.length; k = k + 2) {
                int temporarygrade = Integer.valueOf(temp_line[2].split("\\s+")[1]);
                if (temporarygrade >= avg)
                    System.out.println(temp_line[0]+" "+temp_line[1]+" with grade: "+temporarygrade+
                            " passed Data Structure course.");
            }
            temp_iterator=temp_iterator.next;
        }
    }
    public void studentcount(){
        Node<S> iterator=head;
        int count=0;
        while(iterator!=null){                      //basically counting number of nodes with iterator
            count++;
            iterator=iterator.next;
        }
        System.out.println("Number of student(s) is: "+ count);
    }

    public void addingStudentbyUser(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the asked values with given type. (ID Name Grades(Place space between them)");
        String data=sc.nextLine();                                                                                          //This method add student by getting data from user and adding it to end of node
        AddStudent((S) data);
        System.out.println(data.split("\\s+")[0]+" "+data.split("\\s+")[1]+" student succesfully added.");
    }
    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of student you want to delete: ");
        String id = sc.nextLine();                                                                  //This module gets info from user and deletes student from node without breaking chain
        Node<S> iterator = head;
        Node<S> temporaryiterator=head;
        String[] tempLine;
        while (iterator != null) {
            tempLine = String.valueOf(iterator).split("\\s+", 3);
            if(tempLine[0].equals(id)){
                temporaryiterator=temporaryiterator.next;
                Node<S> next= temporaryiterator.next.next;
                temporaryiterator.next=next;
                System.out.println("Student "+tempLine[0]+' '+tempLine[1]+" succesfully deleted.");
            }
            iterator=iterator.next;
        }
    }

    public void dataStructureSorted(){
        Node<S> iterator = head;
        String[] tempLine;
        List<Integer> grades= new ArrayList<>();
        while(iterator!=null){
            tempLine = String.valueOf(iterator).split("\\s+", 3);
            for (int i = 2; i < tempLine.length; i = i + 2) {                                                               //This part i tried to do but i could achieve it
                grades.add(Integer.valueOf(tempLine[i].split("\\s+")[1]));
            }
            iterator=iterator.next;
        }
        Collections.sort(grades, Collections.reverseOrder());


        Node<S> temp_iterator=head;
        String[] temp_line;
        List<String> students=new ArrayList<>();
        while(temp_iterator!=null){
            temp_line = String.valueOf(temp_iterator).split("\\s+", 3);
            for (int x = 0; x < grades.size(); x++) {

                if((grades.get(x)==Integer.valueOf(temp_line[2].split("\\s+")[1]))&&!students.contains(temp_line[0]))
                    students.add(temp_line[0]);

            }
            temp_iterator=temp_iterator.next;
        }

        System.out.println(students);
        System.out.println(grades);


    }
}
