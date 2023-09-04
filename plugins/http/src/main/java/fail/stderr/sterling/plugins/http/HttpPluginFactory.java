package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.contract.runner.RunnerPlugin;
import fail.stderr.sterling.plugin.contract.runner.RunnerPluginCreateContext;
import fail.stderr.sterling.plugin.contract.runner.RunnerPluginFactory;
import fail.stderr.sterling.plugin.contract.persistence.PersistencePlugin;
import fail.stderr.sterling.plugin.contract.persistence.PersistencePluginCreateContext;
import fail.stderr.sterling.plugin.contract.persistence.PersistencePluginFactory;
import org.jetbrains.annotations.NotNull;

public class HttpPluginFactory implements RunnerPluginFactory, PersistencePluginFactory {

  @Override
  public @NotNull RunnerPlugin create(@NotNull RunnerPluginCreateContext context) throws Exception {
    return new HttpRunnerPlugin();
  }

  @Override
  public @NotNull PersistencePlugin create(@NotNull PersistencePluginCreateContext context) throws Exception {
    return new HttpRunnerPlugin();
  }

}
