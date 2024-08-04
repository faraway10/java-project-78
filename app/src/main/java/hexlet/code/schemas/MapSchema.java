package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private Integer requiredSize;
    @Override
    public void required() {
        super.required();
    }

    public MapSchema sizeof(int size) {
        requiredSize = size;
        return this;
    }

    @Override
    public boolean isValid(Map map) {
        if (!super.isRequired()) {
            return true;
        }

        if (map == null) {
            return false;
        }

        if (requiredSize != null && map.size() != requiredSize) {
            return false;
        }

        return true;
    }
}
