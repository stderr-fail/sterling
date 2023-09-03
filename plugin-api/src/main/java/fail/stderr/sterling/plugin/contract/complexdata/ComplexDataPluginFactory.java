package fail.stderr.sterling.plugin.contract.complexdata;

import org.jetbrains.annotations.NotNull;

public interface ComplexDataPluginFactory {

  @NotNull
  ComplexDataPlugin create(@NotNull ComplexDataPluginCreateContext context) throws Exception;

}
