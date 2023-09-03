package fail.stderr.sterling.datarepository.mapper;

import fail.stderr.sterling.datarepository.model.PluginData;
import org.apache.ibatis.annotations.Mapper;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Mapper
public interface PluginDataMapper {

  void insert(@NotNull PluginData pluginData);

  List<PluginData> selectAll();

}
