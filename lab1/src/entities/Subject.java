package entities;

public class Subject {
    private long   _id;
    private String _name;

    public Subject(long _id, String _name) {
        this._id = _id;
        this._name = _name;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
