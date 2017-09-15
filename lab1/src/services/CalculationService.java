package services;

import entities.*;

public class CalculationService {
    public double getAverageMarksOfStudent(Student student) {
        double result = 0;
        Mark[] marks  = student.get_marks();

        for (int i = 0; i < marks.length; ++i) {
            result += marks[i].get_mark();
        }

        if (marks.length > 0) {
            result = result / marks.length;
        }

        return result;
    }

    public double getAverageMarksOfStudentBySubject(Student student, int subjectId) {
        double result = 0;
        Mark[] marks  = student.get_marks();

        for (int i = 0; i < marks.length; ++i) {
            if (marks[i].get_subjectId() == subjectId) {
                result += marks[i].get_mark();
            }
        }

        if (marks.length > 0) {
            result = result / marks.length;
        }

        return result;
    }

    public double getAverageMarksOfGroup(Group group) {
        double result      = 0;
        Student[] students = group.get_students();

        for (int i = 0; i < students.length; ++i) {
            result += this.getAverageMarksOfStudent(students[i]);
        }

        if (students.length > 0) {
            result = result / students.length;
        }

        return result;
    }

    public double getAverageMarksOfFaculty(Faculty faculty) {
        double result  = 0;
        Group[] groups = faculty.get_groups();

        for (int i = 0; i < groups.length; ++i) {
            result += this.getAverageMarksOfGroup(groups[i]);
        }

        if (groups.length > 0) {
            result = result / groups.length;
        }

        return result;
    }

    public double getAverageMarksOfUniversity(University university) {
        double result = 0;
        Faculty[] faculties = university.get_faculties();

        for (int i = 0; i < faculties.length; ++i) {
            result += this.getAverageMarksOfFaculty(faculties[i]);
        }

        if (faculties.length > 0) {
            result = result / faculties.length;
        }

        return result;
    }
}
