package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    private boolean isRequired;
    private int minLength;
    private String requiredSubStr;

    public StringSchema() { }

    @Override
    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String str) {
        requiredSubStr = str;
        return this;
    }

    @Override
    public boolean isValid(String str) {
        if (!isRequired) {
            return true;
        }

        if (str == null || str.isEmpty()) {
            return false;
        }

        if (str.length() < minLength) {
            return false;
        }

        if (requiredSubStr != null && !requiredSubStr.isEmpty() && !str.contains(requiredSubStr)) {
            return false;
        }

        return true;
    }
}
