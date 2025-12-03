package kz.narxoz.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProgramDto {
    private Long id;
    private String nameDto;
    private String descriptionDto;
}
