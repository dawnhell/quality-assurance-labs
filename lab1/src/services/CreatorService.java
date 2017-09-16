package services;

import entities.*;

public class CreatorService {
    public Subject createSubject(long id, String name) {
        return new Subject(id, name);
    }

    public Mark createMark(long subjectId, long mark) {
        return new Mark(subjectId, mark);
    }

    public Student createStudent(long id, Subject[] subjects, Mark[] marks) {
        return new Student(id, subjects, marks);
    }

    public Group createGroup(long id, Student[] students) {
        return new Group(id, students);
    }

    public Faculty createFaculty(long id, Group[] groups) {
        return new Faculty(id, groups);
    }

    public University createUniversity(long id, Faculty[] faculties) {
        return new University(id, faculties);
    }
}
