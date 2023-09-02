package fail.stderr.sterling.plugin.contract.runner;

import org.jetbrains.annotations.NotNull;

public interface RunnerPluginFactory {

  @NotNull
  RunnerPlugin create(@NotNull RunnerPluginCreateContext context) throws Exception;

}
