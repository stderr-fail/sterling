package fail.stderr.sterling.plugins.propconverters;

import fail.stderr.sterling.plugin.contracts.PropConverterPlugin;
import fail.stderr.sterling.plugin.propconverter.PropConverter;
import fail.stderr.sterling.plugins.propconverters.impl.BooleanPropConverter;
import fail.stderr.sterling.plugins.propconverters.impl.IntegerPropConverter;
import fail.stderr.sterling.plugins.propconverters.impl.StringPropConverter;

import java.util.ArrayList;
import java.util.List;

public class DefaultPropConvertersPlugin implements PropConverterPlugin {

  @Override
  public List<PropConverter<?, ?>> getPropConverters() {
    final ArrayList<PropConverter<?, ?>> converters = new ArrayList<>();
    converters.add(new StringPropConverter());
    converters.add(new IntegerPropConverter());
    converters.add(new BooleanPropConverter());
    return converters;
  }

}
