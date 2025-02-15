package br.com.iotasoftware.gadoapp.gadoappapiv2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BovineDTO {

    String id;
    String name;
    String status;
    String gender;
    String breed;
    Double weight;
    Date birth;
    String description;
    Integer herdId;
}
