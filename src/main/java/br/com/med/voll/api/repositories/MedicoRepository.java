package br.com.med.voll.api.repositories;

import br.com.med.voll.api.domain.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findTop10ByOrderByName(Pageable paginacao);

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}