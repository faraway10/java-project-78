package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean isPositive;
    private Integer bottomRange;
    private Integer upRange;

    public NumberSchema() { }

    public void required() {
        super.required();
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(Integer from, Integer to) {
        bottomRange = from;
        upRange = to;
        return this;
    }

    public boolean isValid(Integer number) {
        if (!super.isRequired()) {
            return true;
        }

        if (number == null) {
            return false;
        }

        if (isPositive && number <= 0) {
            return false;
        }

        if (!isNumberInRange(number)) {
            return false;
        }

        return true;
    }

    private boolean isNumberInRange(Integer number) {
        if (bottomRange != null && number < bottomRange) {
            return false;
        }

        if (upRange != null && number > upRange) {
            return false;
        }

        return true;
    }
}
