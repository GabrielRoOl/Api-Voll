package br.com.med.voll.api.repositories;

import br.com.med.voll.api.domain.model.consulta.Consulta;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetween(@NotNull Long aLong, @NotNull @Future LocalDateTime data, LocalDateTime ultimoHorario);
}
