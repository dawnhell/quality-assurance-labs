package entities;

public class Group {
    private int       _groupId;
    private Student[] _students;

    public Group(int _groupId, Student[] _students) {
        this._groupId = _groupId;
        this._students = _students;
    }

    public int get_groupId() {
        return this._groupId;
    }

    public Student[] get_students() {
        return this._students;
    }

    public void set_groupId(int _groupId) {
        this._groupId = _groupId;
    }

    public void set_student(Student[] _students) {
        this._students = _students;
    }
}
