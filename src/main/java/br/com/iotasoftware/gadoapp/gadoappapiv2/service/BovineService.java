package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.BovineDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.BovineRepository;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BovineService {

    private final BovineRepository bovineRepository;
    private final HerdRepository herdRepository;

    public BovineService(BovineRepository bovineRepository, HerdRepository herdRepository) {
        this.bovineRepository = bovineRepository;
        this.herdRepository = herdRepository;
    }

    public List<Bovine> syncBovines(List<Bovine> bovines) {
        return bovines.stream()
                .map(bovine -> {
                    if (bovine.getId() != null) {
                        return bovineRepository.findById(bovine.getId())
                                .map(existing -> updateBovine(existing, bovine))
                                .orElseGet(() -> createBovine(bovine));
                    }
                    return createBovine(bovine);
                })
                .collect(Collectors.toList());
    }

    private Bovine createBovine(Bovine bovine) {
        resolveRelations(bovine);
        return bovineRepository.save(bovine);
    }

    private Bovine updateBovine(Bovine existing, Bovine newData) {
        existing.setName(newData.getName());
        existing.setStatus(newData.getStatus());
        existing.setGender(newData.getGender());
        existing.setBreed(newData.getBreed());
        existing.setWeight(newData.getWeight());
        existing.setBirth(newData.getBirth());
        existing.setHerd(newData.getHerd());
        existing.setMom(newData.getMom());
        existing.setDad(newData.getDad());
        existing.setDescription(newData.getDescription());
        resolveRelations(existing);
        return bovineRepository.save(existing);
    }

    private void resolveRelations(Bovine bovine) {
        if (bovine.getHerd() != null && bovine.getHerd().getId() != null) {
            herdRepository.findById(bovine.getHerd().getId())
                    .ifPresent(bovine::setHerd);
        }
        if (bovine.getMom() != null && bovine.getMom().getId() != null) {
            bovineRepository.findById(bovine.getMom().getId())
                    .ifPresent(bovine::setMom);
        }
        if (bovine.getDad() != null && bovine.getDad().getId() != null) {
            bovineRepository.findById(bovine.getDad().getId())
                    .ifPresent(bovine::setDad);
        }
    }
}
