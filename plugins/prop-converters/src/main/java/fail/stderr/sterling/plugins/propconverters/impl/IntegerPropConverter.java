package fail.stderr.sterling.plugins.propconverters.impl;

import fail.stderr.sterling.plugin.propconverter.PropConverter;

public class IntegerPropConverter implements PropConverter<Integer, Integer> {

  @Override
  public Integer serialize(Integer value) {
    return value;
  }

  @Override
  public Integer deserialize(Integer value) {
    return value;
  }

  @Override
  public Class<Integer> deserializedType() {
    return Integer.class;
  }
  
}
