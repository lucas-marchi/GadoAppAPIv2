package br.com.iotasoftware.gadoapp.gadoappapiv2.controller;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.BovineDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.BovineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BovineController {

    private final BovineRepository bovineRepository;

    public BovineController(BovineRepository bovineRepository) {
        this.bovineRepository = bovineRepository;
    }

    @GetMapping("/bovines")
    public ResponseEntity<List<BovineDTO>> getAllBovines() {
        List<Bovine> bovines = bovineRepository.findAll();
        return ResponseEntity.ok(
                bovines.stream()
                        .map(BovineDTO::new)
                        .collect(Collectors.toList())
        );
    }
}
