import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static String calculateGrade(int marks) {

    if (marks >= 90) {
        return "A+";
    } else if (marks >= 80) {
        return "A";
    } else if (marks >= 70) {
        return "B";
    } else if (marks >= 60) {
        return "C";
    } else if (marks >= 50) {
        return "D";
    } else {
        return "F";
    }
    }
    public static String getStatus(int marks) {

    if (marks >= 50) {
        return "PASS";
    } else {
        return "FAIL";
    }

}
public static void saveStudents(ArrayList<student> students) {

    try {

        java.io.FileWriter writer = new java.io.FileWriter("students.txt");

        for (student s : students) {

            writer.write(
                s.id + "," +
                s.Name + "," +
                s.Department + "," +
                s.Year + "," +
                s.Email + "," +
                s.Phone + "," +
                s.Marks + "\n"
            );
        }

        writer.close();

        System.out.println("Student data saved successfully!");

    } catch (java.io.IOException e) {

        System.out.println("Error saving student data.");
    }
}
public static void loadStudents(ArrayList<student> students) {

    try {

        java.io.File file = new java.io.File("students.txt");

        if (!file.exists()) {
            return;
        }

        java.util.Scanner fileScanner = new java.util.Scanner(file);

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            String department = data[2];
            int year = Integer.parseInt(data[3]);
            String email = data[4];
            String phone = data[5];
            int marks = Integer.parseInt(data[6]);

            student s = new student(
                id,
                name,
                department,
                year,
                email,
                phone,
                marks
            );

            students.add(s);
        }

        fileScanner.close();

    } catch (Exception e) {

        System.out.println("Error loading student data.");
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       
       ArrayList<student> students = new ArrayList<>();
       loadStudents(students);
    int choice;
      

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    

   
   System.out.print("Enter Student ID: ");
   int id = sc.nextInt();
   sc.nextLine();

boolean idExists = false;

for (student s : students) {
    if (s.id == id) {
        idExists = true;
        break;
    }
}

if (idExists) {
    System.out.println("Student ID already exists!");
    break;
}

    System.out.print("\nEnter Name: ");
    String name = sc.nextLine();

    System.out.print("\nEnter Department: ");
    String department = sc.nextLine();

    System.out.print("Enter Year: ");
    int year = sc.nextInt();
    sc.nextLine();

   String email;

do {
    System.out.print("Enter Email: ");
    email = sc.nextLine();

    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        System.out.println("Invalid email! Please enter a valid email.");
    }

} while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
String phone;

do {
    System.out.print("Enter Phone (10 digits): ");
    phone = sc.nextLine();

    if (!phone.matches("\\d{10}")) {
        System.out.println("Invalid phone number! Enter exactly 10 digits.");
    }

} while (!phone.matches("\\d{10}"));

    int marks;

do {
    System.out.print("Enter Marks (0-100): ");
    marks = sc.nextInt();

    if (marks < 0 || marks > 100) {
        System.out.println("Invalid marks! Please enter between 0 and 100.");
    }

} while (marks < 0 || marks > 100);

    student student = new student(
        id, name, department, year,
        email, phone, marks
    );
    students.add(student);


    System.out.println("\nStudent added successfully!");

    System.out.println("ID         : " + student.id);
    System.out.println("Name       : " + student.Name);
    System.out.println("Department : " + student.Department);
    System.out.println("Year       : " + student.Year);
    System.out.println("Email      : " + student.Email);
    System.out.println("Phone      : " + student.Phone);
    System.out.println("Marks      : " + student.Marks);

    break;

                case 2:
    
     System.out.println("\n===== STUDENT LIST =====");
    if (students.isEmpty()) {

        System.out.println("No students found.");
    } else {

        System.out.println("\n===== STUDENT LIST =====");

        for (student s : students) {

            System.out.println("--------------------");
            System.out.println("ID         : " + s.id);
            System.out.println("Name       : " + s.Name);
            System.out.println("Department : " + s.Department);
            System.out.println("Year       : " + s.Year);
            System.out.println("Email      : " + s.Email);
            System.out.println("Phone      : " + s.Phone);
            System.out.println("Marks      : " + s.Marks);
            System.out.println("Grade      : " + calculateGrade(s.Marks));
            System.out.println("Status     : " + getStatus(s.Marks));

            int totalMarks = 0;
int highestMarks = students.get(0).Marks;
int lowestMarks = students.get(0).Marks;


for (student m: students) {

    totalMarks += m.Marks;

    if (s.Marks > highestMarks) {
        highestMarks = s.Marks;
    }

    if (s.Marks < lowestMarks) {
        lowestMarks = s.Marks;
    }
}
        
double averageMarks = (double) totalMarks / students.size();

System.out.println("\n===== STUDENT STATISTICS =====");
System.out.println("Total Students : " + students.size());
System.out.println("Average Marks  : " + averageMarks);
System.out.println("Highest Marks  : " + highestMarks);
System.out.println("Lowest Marks   : " + lowestMarks);



        }
    }

    break;

               case 3:

    System.out.print("Enter Student ID to search: ");
    int searchId = sc.nextInt();

    boolean found = false;

    for (student s : students) {

        if (s.id == searchId) {

            System.out.println("\n===== STUDENT FOUND =====");
            System.out.println("ID         : " + s.id);
            System.out.println("Name       : " + s.Name);
            System.out.println("Department : " + s.Department);
            System.out.println("Year       : " + s.Year);
            System.out.println("Email      : " + s.Email);
            System.out.println("Phone      : " + s.Phone);
            System.out.println("Marks      : " + s.Marks);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found!");
    }

    break;

                case 4:

    System.out.print("Enter Student ID to update: ");
    int updateId = sc.nextInt();
    sc.nextLine();

    boolean updated = false;

    for (student s : students) {

        if (s.id == updateId) {

            System.out.println("\nEnter new details:");

            System.out.print("Enter Name: ");
            s.Name = sc.nextLine();

            System.out.print("Enter Department: ");
            s.Department = sc.nextLine();

            System.out.print("Enter Year: ");
            s.Year = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Email: ");
            s.Email = sc.nextLine();

            System.out.print("Enter Phone: ");
            s.Phone = sc.nextLine();

            System.out.print("Enter Marks: ");
            s.Marks = sc.nextInt();

            updated = true;

            System.out.println("\nStudent updated successfully!");

            break;
        }
    }

    if (!updated) {
        System.out.println("Student not found!");
    }

    break;

                case 5:

    System.out.print("Enter Student ID to delete: ");
    int deleteId = sc.nextInt();

    boolean deleted = false;

    for (int i = 0; i < students.size(); i++) {

        if (students.get(i).id == deleteId) {

            students.remove(i);

            deleted = true;

            System.out.println("Student deleted successfully!");

            break;
        }
    }

    if (!deleted) {
        System.out.println("Student not found!");
    }

    break;
    case 6:
    saveStudents(students);
    System.out.println("Thank you for using Student Management System!");
    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 6);

        sc.close();
    }
}