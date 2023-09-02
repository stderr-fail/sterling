package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.contract.runner.RunnerPlugin;
import fail.stderr.sterling.plugin.contract.runner.RunnerPluginCreateContext;
import fail.stderr.sterling.plugin.contract.runner.RunnerPluginFactory;
import fail.stderr.sterling.plugin.contract.save.SavePlugin;
import fail.stderr.sterling.plugin.contract.save.SavePluginCreateContext;
import fail.stderr.sterling.plugin.contract.save.SavePluginFactory;
import org.jetbrains.annotations.NotNull;

public class HttpPluginFactory implements RunnerPluginFactory, SavePluginFactory {

  @Override
  public @NotNull RunnerPlugin create(@NotNull RunnerPluginCreateContext context) throws Exception {
    return null;
  }

  @Override
  public @NotNull SavePlugin create(@NotNull SavePluginCreateContext context) throws Exception {
    return null;
  }

}
