package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired;

    public BaseSchema<T> required() {
        isRequired = true;
        return this;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public abstract boolean isValid(T obj);
}
