package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean isRequired;

    public void required() {
        isRequired = true;
    }

    public boolean isRequired() {
        return isRequired;
    }
}
