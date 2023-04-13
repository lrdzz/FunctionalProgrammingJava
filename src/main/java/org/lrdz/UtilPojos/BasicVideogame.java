package org.lrdz.UtilPojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicVideogame {

    private String name;
    private Double price;
    private Console console;
}
