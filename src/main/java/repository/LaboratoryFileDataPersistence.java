package repository;

import model.Laboratory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristina on 3/19/2018.
 */
public class LaboratoryFileDataPersistence extends FileDataPersistence {
    public LaboratoryFileDataPersistence(String file) {
        super(file);
    }

    public void saveLaboratory(Laboratory laboratory) throws IOException, ParseException {
        Map<String, List<Laboratory>> assignedLaboratories = this.getLaboratoryMap();
        if (assignedLaboratories.get(laboratory.getStudentRegNumber()) != null) {
            for (Laboratory laboratoryInList : assignedLaboratories.get(laboratory.getStudentRegNumber())) {
//            if (laboratory.getProblemNumber() == laboratoryInList.getProblemNumber() && laboratory.getLaboratoryNumber() == laboratoryInList.getLaboratoryNumber()) {
                if (laboratory.getLaboratoryNumber() == laboratoryInList.getLaboratoryNumber()) {
//                    return;
                    throw new IOException("The lab number is not unique");
                }
            }
        } else {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(laboratory.toString() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addGrade(String studentRegNumber, int labNumber, float grade)
            throws IOException, NumberFormatException, ParseException {
        File fileA = new File(file);
        File fileB = new File("temp");

        BufferedReader reader = new BufferedReader(new FileReader(fileA));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileB));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] lineData = line.split(" ");
            String fileLabNumber = lineData[0];
            String fileStudentNumber = lineData[4];
            if (Integer.parseInt(fileLabNumber) == labNumber && fileStudentNumber.equals(studentRegNumber)) {
                Laboratory laboratory = new Laboratory(
                        Integer.valueOf(lineData[0]), lineData[1],
                        Integer.valueOf(lineData[2]), lineData[4]);
                laboratory.setGrade(grade);
                writer.write(laboratory.toString() + "\n");
            } else {
//                writer.write(line + "\n");
                throw new IOException("The lab number or the the student registration number does not exist in the file");
            }
        }
        writer.close();
        reader.close();

        fileA.delete();
        fileB.renameTo(fileA);
    }

    public Map<String, List<Laboratory>> getLaboratoryMap() throws NumberFormatException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Map<String, List<Laboratory>> laboratoryMap = new HashMap<String, List<Laboratory>>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] lineData = line.split(" ");
            Laboratory laboratory = new Laboratory(Integer.valueOf(lineData[0]),
                    lineData[1], Integer.valueOf(lineData[2]), Float.valueOf(lineData[3]),
                    lineData[4]);
            if (laboratoryMap.get(laboratory.getStudentRegNumber()) == null) {
                List<Laboratory> laboratoryList = new ArrayList<Laboratory>();
                laboratoryList.add(laboratory);
                laboratoryMap.put(laboratory.getStudentRegNumber(),
                        laboratoryList);
            } else {
                laboratoryMap.get(laboratory.getStudentRegNumber()).add(laboratory);
            }
        }
        return laboratoryMap;
    }
}
