package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.HerdDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerdService {

    private final HerdRepository herdRepository;

    public HerdService(HerdRepository herdRepository) {
        this.herdRepository = herdRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void syncHerdsOverwriteSafely(List<HerdDTO> dtos) {
        herdRepository.deleteAll();
        entityManager.flush();
        entityManager.clear();

        for (HerdDTO dto : dtos) {
            Herd newHerd = Herd.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .build();
            herdRepository.save(newHerd);
        }
    }
}