package fail.stderr.sterling.plugins.propconverters.impl;

import fail.stderr.sterling.plugin.propconverter.PropConverter;

public class StringPropConverter implements PropConverter<String, String> {

  @Override
  public String serialize(String value) {
    return value;
  }

  @Override
  public String deserialize(String value) {
    return value;
  }

  @Override
  public Class<String> deserializedType() {
    return String.class;
  }

}
