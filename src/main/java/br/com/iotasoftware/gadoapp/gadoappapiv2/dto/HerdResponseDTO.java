package br.com.iotasoftware.gadoapp.gadoappapiv2.dto;

import br.com.iotasoftware.gadoapp.gadoappapiv2.model.Herd;

public class HerdResponseDTO {
    private Integer id;
    private String name;

    public HerdResponseDTO(Herd herd) {
        this.id = herd.getId();
        this.name = herd.getName();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
