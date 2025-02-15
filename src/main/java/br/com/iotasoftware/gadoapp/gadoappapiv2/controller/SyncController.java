package br.com.iotasoftware.gadoapp.gadoappapiv2.controller;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.HerdRequestDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.HerdResponseDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.SyncRequest;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.BovineRepository;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import br.com.iotasoftware.gadoapp.gadoappapiv2.service.BovineService;
import br.com.iotasoftware.gadoapp.gadoappapiv2.service.HerdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sync")
public class SyncController {

    private final HerdService herdService;
    private final BovineService bovineService;
    private final HerdRepository herdRepository;

    public SyncController(HerdService herdService, BovineService bovineService, HerdRepository herdRepository) {
        this.herdService = herdService;
        this.bovineService = bovineService;
        this.herdRepository = herdRepository;
    }

    @PostMapping("/herds")
    public ResponseEntity<?> syncHerds(@RequestBody SyncRequest<HerdRequestDTO> request) {
        List<HerdRequestDTO> herds = request.getData();
        try {
            herdService.syncHerdsOverwriteSafely(herds);
            return ResponseEntity.ok(Map.of("message", "Herds sincronizados com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    Map.of("error", "Erro na sincronização: " + e.getMessage())
            );
        }
    }

    @PostMapping("/bovines")
    public ResponseEntity<?> syncBovines(@RequestBody SyncRequest<Bovine> request) {
        try {
            List<Bovine> savedBovines = bovineService.syncBovines(request.getData());
            return ResponseEntity.ok(savedBovines);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Erro na sincronização de bovinos"));
        }
    }
}
