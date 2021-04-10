package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Attribute {
    private String name;
    private String visibility; // Replace with enum
    private String type; // Replace with enum
    private boolean isStatic;
    
    public Attribute() {}
}
