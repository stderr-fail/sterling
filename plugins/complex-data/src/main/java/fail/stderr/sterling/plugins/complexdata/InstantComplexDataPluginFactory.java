package fail.stderr.sterling.plugins.complexdata;

import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPlugin;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginCreateContext;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginFactory;
import fail.stderr.sterling.plugins.complexdata.data.InstantComplexDataValue;
import fail.stderr.sterling.plugins.complexdata.impl.InstantComplexDataPlugin;
import org.jetbrains.annotations.NotNull;

public class InstantComplexDataPluginFactory implements ComplexDataPluginFactory {

  @Override
  public @NotNull ComplexDataPlugin<InstantComplexDataValue> create(@NotNull ComplexDataPluginCreateContext context) throws Exception {
    return new InstantComplexDataPlugin();
  }

}
