package br.com.iotasoftware.gadoapp.gadoappapiv2.service;

import br.com.iotasoftware.gadoapp.gadoappapiv2.dto.BovineDTO;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Bovine;
import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.BovineRepository;
import br.com.iotasoftware.gadoapp.gadoappapiv2.repository.HerdRepository;
import org.hibernate.query.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class BovineService {

    @Autowired
    private BovineRepository bovineRepository;

}
