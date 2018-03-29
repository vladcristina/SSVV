package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import controller.Controller;
import model.Laboratory;
import model.Student;

public class LaboratoriesUI {
	private Controller controller;

    public LaboratoriesUI(){
    }

    public void run(){
        System.out.println("Starting");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new Controller("students.txt", "laboratories.txt");

        while(true){
            System.out.println(" 1) Add student \n 2) Add laboratory \n 3) Add grade \n 4) Get passing students \n 0) Exit");

            try {
                String line = br.readLine().trim();
                if (line.equals("1")) {
                    String registrationNumber, name;
                    int group;
                    System.out.print("Student registration number(4 letters and 4 digits): ");
                    registrationNumber = br.readLine();
                    System.out.print("Name(first name, surname): ");
                    name = br.readLine();
                    try {
                        System.out.print("Group number(between 100 and 900): ");
                        String groupString = br.readLine();
                        group = Integer.parseInt(groupString);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid group - not a number");
                        continue;
                    }

                    Student student = new Student(registrationNumber, name, group);
                    Boolean success = controller.saveStudent(student);
                    if (!success) {
                        System.out.println("Invalid student");
                    }
                    else{
                        System.out.println("Student successfully added\n");
                    }
                } else if (line.equals("2")) {
                    int number, problemNumber;
                    String date, studentRegNumber;

                    try {
                        System.out.println("Lab number: ");
                        String labNumberString = br.readLine();
                        System.out.println("Problem number: ");
                        String labProblemNumberString = br.readLine();
                        number = Integer.parseInt(labNumberString);
                        problemNumber = Integer.parseInt(labProblemNumberString);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                        continue;
                    }

                    System.out.println("Date (dd/mm/yyy)");
                    date = br.readLine();
                    System.out.println("Student registration number");
                    studentRegNumber = br.readLine();
                    Laboratory lab;
                    try {
                        lab = new Laboratory(number, date, problemNumber, studentRegNumber);
                        Boolean success = controller.saveLaboratory(lab);
                        if (!success) {
                            System.out.println("Cannot save laboratory");
                        } else {
                            System.out.println("Lab successfully assigned to the student\n");
                        }
                    }   catch (IOException e) {
                            System.out.println(e.getMessage());
                    } catch (ParseException e) {
                        System.out.println("Invalid input");
                    }

                } else if (line.equals("3")) {
                    String registrationNumber, labNumber;
                    float grade;
                    System.out.println("Student registration number(4 letters and 4 digits): ");
                    registrationNumber = br.readLine();
                    System.out.println("Lab number: ");
                    labNumber = br.readLine();
                    try {
                        System.out.println("Grade: ");
                        String gradeString = br.readLine();
                        grade = Float.parseFloat(gradeString);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid grade");
                        continue;
                    }
                    try {
                        Boolean success = controller.addGrade(registrationNumber, labNumber, grade);
                        if (!success) {
                            System.out.println("Cannot save grade");
                        }
                        else{
                            System.out.println("Grade successfully assigned to the student\n");
                        }
                    } catch (NumberFormatException | IOException | ParseException e) {
                        System.out.println("Cannot save grade");
                    }

                } else if (line.equals("4")) {
                    try {
                        List<Student> passingStudents = controller.passedStudents();
                        System.out.println("Passing students: ");
                        for (Student student : passingStudents) {
                            System.out.println("\t - " + student.toString());
                        }
                    } catch (ParseException e) {
                        System.out.println("Could not get passing students");
                    }
                } else if (line.equals("0")) {
                    break;
                } else {
                    System.out.println("Invalid option");
                }
            } catch (IOException exception) {
                System.out.println("An error occured while reading from command line: " + exception.getMessage());
            }
        }
    }
} 