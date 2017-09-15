package entities;

public class Mark {
    private int _subjectId;
    private int _mark;

    public Mark(int _subjectId, int _mark) {
        this._subjectId = _subjectId;
        this._mark      = _mark;
    }

    public int get_subjectId() {
        return this._subjectId;
    }

    public int get_mark() {
        return this._mark;
    }

    public void set_subjectId(int _subjectId) {
        this._subjectId = _subjectId;
    }

    public void set_mark(int _mark) {
        this._mark = _mark;
    }
}
