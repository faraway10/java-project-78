package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String requiredSubStr;

    public StringSchema() { }

    @Override
    public void required() {
        super.required();
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
        if (!super.isRequired()) {
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
