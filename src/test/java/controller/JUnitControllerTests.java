package controller;

import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by Cristina on 3/20/2018.
 */

public class JUnitControllerTests {
    private Student s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
    LaboratoriesController ctrl = new LaboratoriesController("students.txt","laboratories.txt");
    @Before
    public void setUp() throws Exception {
        s1=new Student("aqsw1234","asd asd", 123);
        s12=new Student("zsed0987","asd asd", 123);
        s13=new Student("zxfg6754","asd asd", 123);

        //group
        s2=new Student("asdf1235","asd asd", 99);
        s3=new Student("asdf1236","asd asd", 901);
        s10=new Student("asdf1245","asd asd", 900);
        s11=new Student("asdf1267","asd asd", 100);

        //registerNumber
        s4=new Student("asd1239","asd asd", 123);
        s5=new Student("asdf123","asd asd", 123);
        s6=new Student("asdfg12367","asd asd", 123);

        //name
        s7=new Student("asdf1231","asd", 123);
        s8=new Student("asdf1232","asd5 asd6", 123);
        s9=new Student("asdf1233","", 123);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void saveStudentTest() {
        assertTrue(ctrl.saveStudent(s1));
        assertFalse(ctrl.saveStudent(s2));
        assertFalse(ctrl.saveStudent(s3));
        assertTrue(ctrl.saveStudent(s10));
        assertTrue(ctrl.saveStudent(s11));
    }

    @Test
    public void saveStudentName() throws IOException {
        assertTrue(ctrl.saveStudent(s12));
        assertFalse(ctrl.saveStudent(s4));
        assertFalse(ctrl.saveStudent(s5));
        assertFalse(ctrl.saveStudent(s6));
    }

//    @Test
//    public void saveStudentRegNumber() throws IOException {
//        assertTrue(ctrl.saveStudent(s13));
//        assertFalse(ctrl.saveStudent(s7));
//        assertTrue(ctrl.saveStudent(s8));
//        assertFalse(ctrl.saveStudent(s9));
//    }
}
