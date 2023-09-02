package fail.stderr.sterling.plugins.propconverters.impl;

import fail.stderr.sterling.plugin.propconverter.PropConverter;

public class BooleanPropConverter implements PropConverter<Boolean, Boolean> {

  @Override
  public Boolean serialize(Boolean value) {
    return value;
  }

  @Override
  public Boolean deserialize(Boolean value) {
    return value;
  }

  @Override
  public Class<Boolean> deserializedType() {
    return Boolean.class;
  }
  
}
