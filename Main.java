import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Course: ");
                    String course = scanner.nextLine();

                    Student s = new Student(roll, name, age, course);
                    manager.addStudent(s);
                    System.out.println("Student added!");
                }

                case 2 -> {
                    for (Student s : manager.getAllStudents()) {
                        System.out.println(s);
                    }
                }

                case 3 -> {
                    System.out.print("Enter Roll Number to search: ");
                    int roll = scanner.nextInt();
                    Student s = manager.findByRollNumber(roll);
                    if (s != null) {
                        System.out.println("Found: " + s);
                    } else {
                        System.out.println("Student not found.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter Roll Number to update: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Course: ");
                    String course = scanner.nextLine();

                    manager.updateStudent(roll, name, age, course);
                    System.out.println("Student updated!");
                }

                case 5 -> {
                    System.out.print("Enter Roll Number to delete: ");
                    int roll = scanner.nextInt();
                    if (manager.deleteStudent(roll)) {
                        System.out.println("Student deleted!");
                    } else {
                        System.out.println("Student not found.");
                    }
                }

                case 6 -> {
                    System.out.println("Exiting... Bye!");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
