package fail.stderr.sterling.plugin.contract.persistence;

import org.jetbrains.annotations.NotNull;

public interface PersistencePluginFactory {

  @NotNull
  PersistencePlugin create(@NotNull PersistencePluginCreateContext context) throws Exception;

}
