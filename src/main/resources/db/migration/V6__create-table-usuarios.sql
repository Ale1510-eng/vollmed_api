CREATE TABLE usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(100) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,

  primary key(id)
);