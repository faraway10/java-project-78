package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired;

    public void required() {
        isRequired = true;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public abstract boolean isValid(T obj);
}
