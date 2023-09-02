package fail.stderr.sterling.plugin.contractold;

import fail.stderr.sterling.plugin.Plugin;
import fail.stderr.sterling.plugin.propconverter.PropConverter;

import java.util.List;

public interface PropConverterPlugin extends Plugin {

  List<PropConverter<?, ?>> getPropConverters();

}
