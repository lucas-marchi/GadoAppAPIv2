package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.HerdRequestDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HerdService {

    private final HerdRepository herdRepository;

    public HerdService(HerdRepository herdRepository) {
        this.herdRepository = herdRepository;
    }

    @Transactional
    public List<Herd> syncHerds(List<HerdRequestDTO> dtos) {
        return dtos.stream()
                .map(dto -> {
                    if (dto.getId() != null) {
                        return herdRepository.findById(dto.getId())
                                .map(existingHerd -> {
                                    existingHerd.setName(dto.getName());
                                    return herdRepository.save(existingHerd);
                                })
                                .orElseThrow(() -> new RuntimeException("Herd não encontrado para ID: " + dto.getId()));
                    } else {
                        Herd newHerd = Herd.builder()
                                .name(dto.getName())
                                .build();
                        return herdRepository.save(newHerd);
                    }
                })
                .collect(Collectors.toList());
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void syncHerdsOverwriteSafely(List<HerdRequestDTO> dtos) {
        herdRepository.deleteAll();
        entityManager.flush();
        entityManager.clear();

        for (HerdRequestDTO dto : dtos) {
            Herd newHerd = Herd.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .build();
            herdRepository.save(newHerd);
        }
    }
}