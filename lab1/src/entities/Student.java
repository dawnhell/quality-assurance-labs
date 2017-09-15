package entities;

public class Student {
    private int       _id;
    private Subject[] _attendingSubjects;
    private Mark[]    _marks;

    public Student(int _id, Subject[] _attendingSubjects, Mark[] _marks) {
        this._id                = _id;
        this._attendingSubjects = _attendingSubjects;
        this._marks             = _marks;
    }

    public int get_id() {
        return this._id;
    }

    public Subject[] get_attendingSubjects() {
        return this._attendingSubjects;
    }

    public Mark[] get_marks() {
        return this._marks;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_attendingSubjects(Subject[] _attendingSubjects) {
        this._attendingSubjects = _attendingSubjects;
    }

    public void set_marks(Mark[] _marks) {
        this._marks = _marks;
    }
}
