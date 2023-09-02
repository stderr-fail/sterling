package fail.stderr.sterling.plugin.contract.save;

import org.jetbrains.annotations.NotNull;

public interface SavePlugin {

  void execute(@NotNull SavePluginExecutionContext context) throws Exception;

}
