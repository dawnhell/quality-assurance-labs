package services;

import entities.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class FileReaderService {
    private String FILE_PATH = System.getProperty("user.dir") + "/src/data/data.json";

    public University getUniversityFromFile() {
        return this.parseUniversity(this.readDataFromFile());
    }

    private JSONObject readDataFromFile() {
        JSONObject jsonObject = new JSONObject();

        try {
            JSONParser parser = new JSONParser();
            File       file   = new File(this.FILE_PATH);
            Object     object = parser.parse(new FileReader(file));

            jsonObject = (JSONObject) object;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private University parseUniversity(JSONObject jsonObject) {
        JSONObject universityObject = (JSONObject) jsonObject.get("university");

        return new CreatorService().createUniversity(
            (long) universityObject.get("id"),
            this.parseFaculties((JSONArray) universityObject.get("faculties"))
        );
    }

    private Faculty[] parseFaculties(JSONArray facultiesObject) {
        Faculty[] faculties = new Faculty[facultiesObject.size()];

        for (int i = 0; i < facultiesObject.size(); ++i) {
            faculties[i] = this.parseFaculty((JSONObject) facultiesObject.get(i));
        }

        return faculties;
    }

    private Faculty parseFaculty(JSONObject facultyObject) {
        return new CreatorService().createFaculty(
            (long) facultyObject.get("id"),
            this.parseGroups((JSONArray) facultyObject.get("groups"))
        );
    }

    private Group[] parseGroups(JSONArray groupsObject) {
        Group[] groups = new Group[groupsObject.size()];

        for (int i = 0; i < groupsObject.size(); ++i) {
            groups[i] = this.parseGroup((JSONObject) groupsObject.get(i));
        }

        return groups;
    }

    private Group parseGroup(JSONObject groupObject) {
        return new CreatorService().createGroup(
            (long) groupObject.get("id"),
            this.parseStudents((JSONArray) groupObject.get("students"))
        );
    }

    private Student[] parseStudents(JSONArray studentsObject) {
        Student[] students = new Student[studentsObject.size()];

        for (int i = 0; i < studentsObject.size(); ++i) {
            students[i] = this.parseStudent((JSONObject) studentsObject.get(i));
        }

        return students;
    }

    private Student parseStudent(JSONObject studentObject) {
        return new CreatorService().createStudent(
            (long) studentObject.get("id"),
            this.parseSubjects((JSONArray) studentObject.get("subjects")),
            this.parseMarks((JSONArray) studentObject.get("marks"))
        );
    }

    private Mark[] parseMarks(JSONArray marksObject) {
        Mark[] marks = new Mark[marksObject.size()];

        for (int i = 0; i < marksObject.size(); ++i) {
            marks[i] = this.parseMark((JSONObject) marksObject.get(i));
        }

        return marks;
    }

    private Mark parseMark(JSONObject markObject) {
        return new CreatorService().createMark(
            (long) markObject.get("subjectId"),
            (long) markObject.get("mark")
        );
    }

    private Subject[] parseSubjects(JSONArray subjectObject) {
        Subject[] subjects = new Subject[subjectObject.size()];

        for (int i = 0; i < subjectObject.size(); ++i) {
            subjects[i] = this.parseSubject((JSONObject) subjectObject.get(i));
        }

        return subjects;
    }

    private Subject parseSubject(JSONObject subjectObject) {
        return new CreatorService().createSubject(
            (long) subjectObject.get("id"),
            (String) subjectObject.get("name")
        );
    }
}
