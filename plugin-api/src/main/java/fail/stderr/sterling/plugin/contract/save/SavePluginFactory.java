package fail.stderr.sterling.plugin.contract.save;

import org.jetbrains.annotations.NotNull;

public interface SavePluginFactory {

  @NotNull
  SavePlugin create(@NotNull SavePluginCreateContext context) throws Exception;

}
