package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    public abstract BaseSchema<T> required();

    public abstract boolean isValid(T obj);
}
