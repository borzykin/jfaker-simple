package org.borzykin.jfaker.producers.address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
public class Address {
    private String state;
    private String city;
    private String address;
    private String zipCode;
}
