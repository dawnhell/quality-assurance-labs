package services;

import entities.*;

public class CreatorService {
    public Subject createSubject(int id, String name) {
        return new Subject(id, name);
    }

    public Mark createMark(int subjectId, int mark) {
        return new Mark(subjectId, mark);
    }

    public Student createStudent(int id, Subject[] subjects, Mark[] marks) {
        return new Student(id, subjects, marks);
    }

    public Group createGroup(int id, Student[] students) {
        return new Group(id, students);
    }

    public Faculty createFaculty(int id, Group[] groups) {
        return new Faculty(id, groups);
    }

    public University createUniversity(int id, Faculty[] faculties) {
        return new University(id, faculties);
    }
}
