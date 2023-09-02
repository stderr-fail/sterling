package fail.stderr.sterling.plugin.propconverter;

public interface PropConverter<DESERIALIZED, SERIALIZED> {

  SERIALIZED serialize(DESERIALIZED value);

  DESERIALIZED deserialize(SERIALIZED value);

  Class<DESERIALIZED> deserializedType();

  default int priority() {
    return 500;
  }

}
