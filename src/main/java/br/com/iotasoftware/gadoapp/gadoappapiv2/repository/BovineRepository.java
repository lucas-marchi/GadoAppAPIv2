package br.com.iotasoftware.gadoapp.gadoappapiv2.repository;

import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BovineRepository extends JpaRepository<Bovine, Long> {
    List<Bovine> findByHerdId(Long herdId);
}
