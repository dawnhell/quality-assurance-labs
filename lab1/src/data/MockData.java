package data;

import entities.*;

public class MockData {
    public University initialize() {
        Subject[] subjects = {
            new Subject(1, "Numerical methods"),
            new Subject(2, "Math analysis"),
            new Subject(3, "PE")
        };

        Mark[] marks = {
            new Mark(1, 9),
            new Mark(2, 6),
            new Mark(3, 7)
        };

        Student[] students = {
            new Student(1, subjects, marks)
        };

        Group[] groups = {
            new Group(1, students)
        };

        Faculty[] faculties = {
            new Faculty(1, groups)
        };

        University university = new University(1, faculties);

        return university;
    }
}
