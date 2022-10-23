package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Donor {

    private String name;
    private String lastname;
    private int age;
    private int identityNumber;
    private String bloodGroup;
}
