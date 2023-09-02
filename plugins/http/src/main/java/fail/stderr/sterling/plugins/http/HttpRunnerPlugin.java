package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.contract.runner.RunnerPlugin;
import fail.stderr.sterling.plugin.contract.runner.RunnerPluginExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRunnerPlugin implements RunnerPlugin {

  private final Logger log = LoggerFactory.getLogger(HttpRunnerPlugin.class);

  @Override
  public void execute(@NotNull RunnerPluginExecutionContext context) throws Exception {

  }
}
