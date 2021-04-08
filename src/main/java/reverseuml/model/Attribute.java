package reverseuml.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attribute {
    private String name;
    private String visibility; // Replace with enum
    private String type; // Replace with enum
    private boolean isStatic;
    
    public Attribute() {}
}
