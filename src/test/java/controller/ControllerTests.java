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
    private Student s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21;
    Controller ctrl = new Controller("studentsTest.txt", "laboratoriesTest.txt");

    @Before
    public void setUp() throws Exception {
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
        s13 = new Student("asdf1234", "asdf asdf asdf", 123);
        s14 = new Student("asdf1234", "asd5 asd6", 123);
        s15 = new Student("asdf1234", "", 123);
        s16 = new Student("asdf1234", "asdf asdf", 123);
        s17 = new Student("asdf1234", "asdf", 123);

        //group
        s18 = new Student("asdf1234", "asd asd", 99);
        s19 = new Student("asdf1234", "asd asd", 901);
        s20 = new Student("asdf1234", "asd asd", 900);
        s21 = new Student("asdf1234", "asd asd", 100);
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

    //register number
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


    //name
    @Test
    public void saveStudentName_MoreThanTwoNames_Test() {
        assertFalse(ctrl.saveStudent(s13));
    }

    @Test
    public void saveStudentName_NamesWithNumbers_Test() {
        assertFalse(ctrl.saveStudent(s14));
    }

    @Test
    public void saveStudentName_NoName_Test() {
        assertFalse(ctrl.saveStudent(s15));
    }

    @Test
    public void saveStudentName_CorrectNameTwoWords_Test() {
        assertTrue(ctrl.saveStudent(s16));
    }

    @Test
    public void saveStudentName_LowerValue_Test() {
        assertTrue(ctrl.saveStudent(s17));
    }



    //group
    @Test
    public void saveStudentGroup_LowerThanMinValue_Test() {
        assertFalse(ctrl.saveStudent(s18));
    }

    @Test
    public void saveStudentGroup_HigherThanMaxValue_Test() {
        assertFalse(ctrl.saveStudent(s19));
    }

    @Test
    public void saveStudentGroup_CorrectGroupMaxValue_Test() {
        assertTrue(ctrl.saveStudent(s20));
    }

    @Test
    public void saveStudentGroup_CorrectGroupMinValue_Test() {
        assertTrue(ctrl.saveStudent(s21));
    }
}
