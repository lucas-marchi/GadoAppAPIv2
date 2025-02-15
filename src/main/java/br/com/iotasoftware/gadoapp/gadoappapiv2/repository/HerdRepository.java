package br.com.iotasoftware.gadoapp.gadoappapiv2.repository;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerdRepository extends JpaRepository<Herd, Integer> {

}

