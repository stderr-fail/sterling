package fail.stderr.sterling.plugin.contract.runner;

import org.jetbrains.annotations.NotNull;

public interface RunnerPlugin {

  void execute(@NotNull RunnerPluginExecutionContext context) throws Exception;

}
