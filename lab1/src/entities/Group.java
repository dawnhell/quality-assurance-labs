package entities;

public class Group {
    private long      _groupId;
    private Student[] _students;

    public Group(long _groupId, Student[] _students) {
        this._groupId = _groupId;
        this._students = _students;
    }

    public long get_groupId() {
        return this._groupId;
    }

    public Student[] get_students() {
        return this._students;
    }

    public void set_groupId(long _groupId) {
        this._groupId = _groupId;
    }

    public void set_student(Student[] _students) {
        this._students = _students;
    }
}
