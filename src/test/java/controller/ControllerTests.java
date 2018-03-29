package controller;

import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Cristina on 3/20/2018.
 */

public class ControllerTests {
    private Student s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19;
    Controller ctrl = new Controller("studentsTest.txt", "laboratoriesTest.txt");

    @Before
    public void setUp() throws Exception {
//        s11 = new Student("aqsw1234", "asd asd", 123);
//        s12 = new Student("zsed0987", "asd asd", 123);
//        s13 = new Student("zxfg6754", "asd asd", 123);

        //registerNumber
        s1 = new Student("asd1234", "asd asd", 200);
        s2 = new Student("asdf123", "asd asd", 200);
        s3 = new Student("asdfg1234", "asd asd", 200);
        s4 = new Student("asdf12345", "asd asd", 200);
        s5 = new Student("1234", "asd asd", 200);
        s6 = new Student("asdf", "asd asd", 200);
        s7 = new Student("as12", "asd asd", 200);
        s8 = new Student("asdfg12345", "asd asd", 200);
        s9 = new Student("", "asd asd", 200);
        s10 = new Student("asdf1234", "asd asd", 200);
        s11 = new Student("1234asdf", "asd asd", 200);
        s12 = new Student("a1s2d3f4", "asd asd", 200);

        //name
        s13 = new Student("asdf1231", "asd", 123);
        s14 = new Student("asdf1232", "asd5 asd6", 123);
        s15 = new Student("asdf1233", "", 123);

        //group
        s16 = new Student("asdf1235", "asd asd", 99);
        s17 = new Student("asdf1236", "asd asd", 901);
        s18 = new Student("asdf1245", "asd asd", 900);
        s19 = new Student("asdf1267", "asd asd", 100);
    }

    @After
    public void tearDown() {
        System.out.println("Test Completed");
    }

    @Test
    public void saveStudentTest() {
        assertFalse(ctrl.saveStudent(s1));
        assertFalse(ctrl.saveStudent(s2));
        assertFalse(ctrl.saveStudent(s3));
        assertFalse(ctrl.saveStudent(s4));
        assertTrue(ctrl.saveStudent(s10));
    }

    @Test
    public void saveStudentRegisterNumber_LessLetters_Test() {
        assertFalse(ctrl.saveStudent(s1));
    }

    @Test
    public void saveStudentRegisterNumber_LessDigits_Test() {
        assertFalse(ctrl.saveStudent(s2));
    }

    @Test
    public void saveStudentRegisterNumber_MoreLetters_Test() {
        assertFalse(ctrl.saveStudent(s3));
    }

    @Test
    public void saveStudentRegisterNumber_MoreDigits_Test() {
        assertFalse(ctrl.saveStudent(s4));
    }

    @Test
    public void saveStudentRegisterNumber_NoLetters_Test() {
        assertFalse(ctrl.saveStudent(s5));
    }

    @Test
    public void saveStudentRegisterNumber_NoDigits_Test() {
        assertFalse(ctrl.saveStudent(s6));
    }

    @Test
    public void saveStudentRegisterNumber_LessLettersAndDigits_Test() {
        assertFalse(ctrl.saveStudent(s7));
    }

    @Test
    public void saveStudentRegisterNumber_MoreLettersAndDigits_Test() {
        assertFalse(ctrl.saveStudent(s8));
    }

    @Test
    public void saveStudentRegisterNumber_NoLettersAndDigits_Test() {
        assertFalse(ctrl.saveStudent(s9));
    }

    @Test
    public void saveStudentRegisterNumber_CorrectNumberLettersAndDigits_Test() {
        assertTrue(ctrl.saveStudent(s10));
    }

    @Test
    public void saveStudentRegisterNumber_IncorrectOrderLettersAndDigits_Test() {
        assertFalse(ctrl.saveStudent(s11));
    }

    @Test
    public void saveStudentRegisterNumber_RandomOrderLettersAndDigits_Test() {
        assertFalse(ctrl.saveStudent(s12));
    }


//    @Test
//    public void saveStudentName() {
//        assertTrue(ctrl.saveStudent(s12));
//        assertFalse(ctrl.saveStudent(s4));
//        assertFalse(ctrl.saveStudent(s5));
//        assertFalse(ctrl.saveStudent(s6));
//    }

//    @Test
//    public void saveStudentRegNumber() throws IOException {
//        assertTrue(ctrl.saveStudent(s13));
//        assertFalse(ctrl.saveStudent(s7));
//        assertTrue(ctrl.saveStudent(s8));
//        assertFalse(ctrl.saveStudent(s9));
//    }
}
