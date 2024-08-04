package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired;
    private int minLength;
    private String requiredSubStr;

    public StringSchema() { }

    public void required() {
        isRequired = true;
    }

    public StringSchema minLength(int length) {
        isRequired = true;
        minLength = length;
        return this;
    }

    public StringSchema contains(String str) {
        isRequired = true;
        requiredSubStr = str;
        return this;
    }

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
