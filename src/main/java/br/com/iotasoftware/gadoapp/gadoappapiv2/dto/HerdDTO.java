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

    String id;
    String name;
    List<BovineDTO> bovines;
}
