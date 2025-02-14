package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.HerdDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HerdService {

    @Autowired
    private HerdRepository herdRepository;

    public Herd createHerd(HerdDTO dto) {
        var herd = new Herd();
        BeanUtils.copyProperties(dto, herd);

        return herdRepository.save(herd);
    }


}
