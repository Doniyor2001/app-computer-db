package ai.ecma.appComputerDbBot.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormDataDTO {
    private Set<String> types;
    private Set<String> models;
    private Set<String> makers;
}
