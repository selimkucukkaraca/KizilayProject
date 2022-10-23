package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Admin {
    private String name;
    private String lastname;
    private int password;
}
