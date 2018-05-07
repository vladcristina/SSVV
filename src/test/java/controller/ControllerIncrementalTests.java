package controller;

import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Cristina on 5/7/2018.
 */

public class ControllerIncrementalTests {
    private Student s1;
    private Laboratory l1;
    private float grade,grade2;
    Controller ctrl = new Controller("students.txt", "laboratories.txt");

    @Before
    public void setUp() throws Exception {
        s1 = new Student("asdf1234", "asd asd", 200);
        l1 = new Laboratory(1, "30/04/2018", 11, grade, "asdf1234");
        grade = 9;
        grade2 = 10;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void saveStudent_Correct() throws IOException {
        assertTrue(ctrl.saveStudent(s1));
    }

    @Test
    public void saveStudent_assignLabGrade_Correct() throws IOException, ParseException {
        assertTrue(ctrl.saveStudent(s1));
        assertTrue(ctrl.addGrade(s1.getRegNumber(), l1.getLaboratoryNumber(), grade));
    }

    @Test
    public void saveStudent_assignGrade_getPassedStudents_Correct() throws IOException, ParseException {
        assertTrue(ctrl.saveStudent(s1));
        assertTrue(ctrl.addGrade(s1.getRegNumber(), l1.getLaboratoryNumber(), grade));
        assertEquals(1, ctrl.passedStudents().size());
    }
}
