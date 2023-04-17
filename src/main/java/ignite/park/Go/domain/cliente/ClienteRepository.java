package Ignite.Park.Go.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
}
