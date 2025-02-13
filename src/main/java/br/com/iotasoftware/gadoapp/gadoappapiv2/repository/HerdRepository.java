package br.com.iotasoftware.gadoapp.gadoappapiv2.repository;

import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HerdRepository extends JpaRepository<Herd, Long> {
    Optional<Herd> findByName(String name);
}