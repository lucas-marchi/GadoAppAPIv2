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

    private String id;
    private String name;
    private String status;
    private String gender;
    private String breed;
    private Double weight;
    private Date birth;
    private String description;
}
