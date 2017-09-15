package entities;

public class University {
    private int       _universityId;
    private Faculty[] _faculties;

    public University(int _universityId, Faculty[] _faculties) {
        this._universityId = _universityId;
        this._faculties = _faculties;
    }

    public int get_universityId() {
        return this._universityId;
    }

    public Faculty[] get_faculties() {
        return this._faculties;
    }

    public void set_universityId(int _universityId) {
        this._universityId = _universityId;
    }

    public void set_faculties(Faculty[] _faculties) {
        this._faculties = _faculties;
    }
}
