package fail.stderr.sterling.plugins.complexdata;

import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPlugin;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginCreateContext;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginFactory;
import fail.stderr.sterling.plugins.complexdata.data.BigDecimalComplexDataValue;
import fail.stderr.sterling.plugins.complexdata.impl.BigDecimalComplexDataPlugin;
import org.jetbrains.annotations.NotNull;

public class BigDecimalComplexDataPluginFactory implements ComplexDataPluginFactory {

  @Override
  public @NotNull ComplexDataPlugin<BigDecimalComplexDataValue> create(@NotNull ComplexDataPluginCreateContext context) throws Exception {
    return new BigDecimalComplexDataPlugin();
  }

}
