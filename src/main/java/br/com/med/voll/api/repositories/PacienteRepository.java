package br.com.med.voll.api.repositories;

import br.com.med.voll.api.domain.model.paciente.Paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean findAtivoById(@NotNull Long aLong);
}