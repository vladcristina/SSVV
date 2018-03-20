package validator;

import model.Laboratory;
import model.Student;

import java.util.Date;

public class Validator {

    public static boolean validateStudent(Student student) {
        if(!student.getRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")){
            return false;
        }
        if (!student.getName().matches("[a-zA-Z]+[\\s]?[a-zA-Z]+")) {
            return false;
        }
        if(student.getGroup() >= 901 || student.getGroup() <= 99){
            return false;
        }
        return true;
    }

    public static boolean validateLaboratory(Laboratory laboratory) {
        if(laboratory.getLaboratoryNumber() < 1 && laboratory.getLaboratoryNumber() > 14) {
            return false;
        }
        if(laboratory.getProblemNumber() < 1) {
            return false;
        }
        Date date = new Date();
        if(date.after(laboratory.getDate())) {
            return false;
        }
        if(!laboratory.getStudentRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")) {
            return false;
        }

        return true;
    }

    public static boolean validateGrade(float grade) {
        if(grade >= 1 && grade <= 10) {
            return true;
        }
        return false;
    }
} 