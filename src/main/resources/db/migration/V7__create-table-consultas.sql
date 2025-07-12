CREATE TABLE consultas(
    id INT NOT NULL auto_increment,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    fecha DATETIME NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY(medico_id) REFERENCES medicos(id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY(paciente_id) REFERENCES pacientes(id)
);