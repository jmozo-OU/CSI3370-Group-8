package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Argument {
    private String name;
    private String type; // Replace with enum

    public Argument() {}
}
