package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private Integer requiredSize;
    private Map<String, BaseSchema<String>> shapeSchemas;
    private boolean isShaped;

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        requiredSize = size;
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        shapeSchemas = schemas;
        isShaped = true;
    }

    @Override
    public boolean isValid(Map map) {
        if (!super.isRequired() && !isShaped) {
            return true;
        }

        if (map == null) {
            return false;
        }

        if (requiredSize != null && map.size() != requiredSize) {
            return false;
        }

        if (isShaped) {
            return isShapeValid(map);
        }

        return true;
    }

    public boolean isShapeValid(Map map) {
        for (var key : shapeSchemas.keySet()) {
            var schema = shapeSchemas.get(key);
            var value = map.get(key);
            if (!schema.isValid((String) value)) {
                return false;
            }
        }

        return true;
    }
}
