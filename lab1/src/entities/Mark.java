package entities;

public class Mark {
    private long _subjectId;
    private long _mark;

    public Mark(long _subjectId, long _mark) {
        this._subjectId = _subjectId;
        this._mark      = _mark;
    }

    public long get_subjectId() {
        return this._subjectId;
    }

    public long get_mark() {
        return this._mark;
    }

    public void set_subjectId(long _subjectId) {
        this._subjectId = _subjectId;
    }

    public void set_mark(long _mark) {
        this._mark = _mark;
    }
}
