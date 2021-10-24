package com.bobocode;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NameProvider {

    public String getName(){
        return "Pasha";
    }
}
