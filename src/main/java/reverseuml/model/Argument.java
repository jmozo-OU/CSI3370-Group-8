package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Argument {
    private String name;
    private String type; // Replace with enum

    public Argument() {}
}
