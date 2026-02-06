package org.example.testseverstal.dto;

import lombok.Data;
import org.example.testseverstal.entities.Illness;

@Data
public class IllnessDTO {
    private Long id;
    private String name;


    public static IllnessDTO fromEntity(Illness illness) {
        if (illness == null) {
            return null;
        }
        IllnessDTO dto = new IllnessDTO();
        dto.setId(illness.getId());
        dto.setName(illness.getName());
        return dto;
    }

    public static Illness toEntity(IllnessDTO dto) {
        if (dto == null) {
            return null;
        }
        Illness illness = new Illness();
        illness.setId(dto.getId());
        illness.setName(dto.getName());
        return illness;
    }
}

