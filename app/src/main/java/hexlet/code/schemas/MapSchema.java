package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T> extends BaseSchema<Map> {
//    private Map<String, BaseSchema<T>> shapeSchemas;
//    private boolean isShaped;

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                value -> value.size() == size
        );
        return this;
    }

//    public MapSchema shape(Map<String, BaseSchema<T>> schemas) {
//        shapeSchemas = schemas;
//        isShaped = true;
//        return this;
//    }
//
//    public boolean isShapeValid(Map<String, T> map) {
//        for (var key : shapeSchemas.keySet()) {
//            var schema = shapeSchemas.get(key);
//            T value = map.get(key);
//
//            if (!schema.isValid(value)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
