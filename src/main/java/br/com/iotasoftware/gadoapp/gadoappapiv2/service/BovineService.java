package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.BovineDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.BovineRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BovineService {

    private final BovineRepository bovineRepository;

    public BovineService(BovineRepository bovineRepository) {
        this.bovineRepository = bovineRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void syncBovinesOverwriteSafely(List<BovineDTO> dtos) {
        bovineRepository.deleteAll();
        entityManager.flush();
        entityManager.clear();

        for (BovineDTO dto : dtos) {
            Bovine newBovine = Bovine.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .status(dto.getStatus())
                    .gender(dto.getGender())
                    .breed(dto.getBreed())
                    .weight(dto.getWeight())
                    .birth(dto.getBirth())
                    .description(dto.getDescription())
                    .herdId(dto.getHerdId())
                    .dadId(dto.getDadId())
                    .momId(dto.getMomId())
                    .build();
            bovineRepository.save(newBovine);
        }
    }
}
