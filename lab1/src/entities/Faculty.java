package entities;

public class Faculty {
    private int     _facultyId;
    private Group[] _groups;

    public Faculty(int _facultyId, Group[] _groups) {
        this._facultyId = _facultyId;
        this._groups = _groups;
    }

    public int get_facultyId() {
        return this._facultyId;
    }

    public Group[] get_groups() {
        return this._groups;
    }

    public void set_facultyId(int _facultyId) {
        this._facultyId = _facultyId;
    }

    public void set_groups(Group[] _groups) {
        this._groups = _groups;
    }
}
