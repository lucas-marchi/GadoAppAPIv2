package br.com.iotasoftware.gadoapp.gadoappapiv2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HerdDTO {

    private String id;
    private String name;
    private List<BovineDTO> bovines;
}
