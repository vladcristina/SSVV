package controller;

import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Cristina on 4/3/2018.
 */

public class ControllerGradeTests {
    private Student s1;
    private Laboratory l1;
    private float grade1, grade2;

    Controller ctrl = new Controller("students.txt", "laboratories.txt");

    @Before
    public void setUp() throws Exception {
        s1 = new Student("asdf1234", "asd asd", 200);
        l1 = new Laboratory(1, "5/06/2018", 1, s1.getRegNumber());
        grade1 = 9;
        grade2 = 11;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void assignLabGrade_Correct() throws IOException, ParseException {
        assertTrue(ctrl.addGrade(s1.getRegNumber(), l1.getLaboratoryNumber(), grade1));
    }

    @Test
    public void assignLabGrade_StudentRegNumberNotInFile() throws IOException, ParseException {
        try {
            assertFalse(ctrl.addGrade("asd123", 1, grade1));
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    @Test
    public void assignLabGrade_LabNumberNotInFile() throws IOException, ParseException {
        try {
            assertFalse(ctrl.addGrade(s1.getRegNumber(), 3, grade1));
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    @Test
    public void assignLabGrade_WrongGrade() throws IOException, ParseException {
        try {
            assertFalse(ctrl.addGrade(s1.getRegNumber(), 3, grade2));
        }
        catch(IOException e){
            e.getMessage();
        }
    }
}