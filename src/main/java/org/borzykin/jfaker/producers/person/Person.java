package org.borzykin.jfaker.producers.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.borzykin.jfaker.producers.address.Address;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Address address;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
