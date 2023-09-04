package fail.stderr.sterling.plugin.contract.persistence;

import org.jetbrains.annotations.NotNull;

public interface PersistencePlugin {

  void execute(@NotNull PersistencePluginExecutionContext context) throws Exception;

}
