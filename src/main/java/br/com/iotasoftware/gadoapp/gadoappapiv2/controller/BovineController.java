package br.com.iotasoftware.gadoapp.gadoappapiv2.controller;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.BovineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bovines")
public class BovineController {

    @Autowired
    private BovineService bovineService; // Business logic layer

    @PostMapping
    public BovineDTO addBovine(@RequestBody BovineDTO bovineDTO) {
        return bovineService.addBovine(bovineDTO);
    }

    @PatchMapping("/{id}")
    public BovineDTO updateBovineFields(@PathVariable String id, @RequestBody BovineDTO bovineDTO) {
        return bovineService.updateBovineFields(id, bovineDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBovine(@PathVariable String id) {
        bovineService.deleteBovine(id);
    }

    @GetMapping
    public List<BovineDTO> getAllBovines() {
        return bovineService.getAllBovines();
    }

    @GetMapping("/{id}")
    public BovineDTO getBovineById(@PathVariable String id) {
        return bovineService.getBovineById(id);
    }
}
