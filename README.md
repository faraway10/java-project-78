## Data Validator
[![Actions Status](https://github.com/faraway10/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/faraway10/java-project-78/actions) [![Actions Status](https://github.com/faraway10/java-project-78/actions/workflows/custom-check.yml/badge.svg)](https://github.com/faraway10/java-project-78/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/a04b84e8837a70249161/maintainability)](https://codeclimate.com/github/faraway10/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/a04b84e8837a70249161/test_coverage)](https://codeclimate.com/github/faraway10/java-project-78/test_coverage)

Data validator is a library that can be used to check the correctness of any data. Such libraries are numerous in every language, since almost all programs work with external data that must be checked for correctness. First of all, we are talking about the forms to be filled by users. The project is based on the yup library.

Example of use:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// Strings
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with structure check support
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).required().shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human2); // false
```
