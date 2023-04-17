package Ignite.Park.Go.domain.estacionamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

    Page<Estacionamento> findAllByAtivoTrue(Pageable paginacao);
}
