package fail.stderr.sterling.datarepository.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.jetbrains.annotations.Nullable;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JsonNodeTypeHandler extends BaseTypeHandler<JsonNode> {

  protected final  ObjectMapper objectMapper;

  public JsonNodeTypeHandler(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int index, JsonNode parameter, JdbcType jdbcType) throws SQLException {
    try {
      final String json = objectMapper.writeValueAsString(parameter);
      ps.setString(index, json);
    } catch (JsonProcessingException e) {
      throw new SQLException("Failed to serialize JsonNode instance to string: " + e.getMessage(), e);
    }
  }

  @Override
  public JsonNode getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return getNullableResult(rs.getString(columnName));
  }

  @Override
  public JsonNode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return getNullableResult(rs.getString(columnIndex));
  }

  @Override
  public JsonNode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return getNullableResult(cs.getString(columnIndex));
  }

  @Nullable
  protected JsonNode getNullableResult(@Nullable String data) throws SQLException {
    if (null != data) {
      try {
        final JsonNode jsonNode = objectMapper.readValue(data, JsonNode.class);
        return jsonNode;
      } catch (JsonProcessingException e) {
        throw new SQLException("Failed to deserialize JSON string from DB into a JsonNode instance: " + e.getMessage(), e);
      }
    }
    return null;
  }

}
