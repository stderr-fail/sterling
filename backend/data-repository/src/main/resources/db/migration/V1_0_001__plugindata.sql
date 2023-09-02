CREATE TABLE `plugindata`
(
  id       INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  pluginId TEXT      NOT NULL,
  created  TIMESTAMP NOT NULL,
  modified TIMESTAMP NOT NULL,
  version  INTEGER   NOT NULL,
  json     TEXT      NOT NULL
);
