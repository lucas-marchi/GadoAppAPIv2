package br.com.iotasoftware.gadoapp.gadoappapiv2.repository;

import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface HerdRepository extends JpaRepository<Herd, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Herd h WHERE h.id NOT IN :ids")
    void deleteByIdNotIn(@Param("ids") List<Integer> ids);
}

