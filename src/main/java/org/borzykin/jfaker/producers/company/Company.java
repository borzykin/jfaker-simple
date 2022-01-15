package org.borzykin.jfaker.producers.company;

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
public class Company {
    private String name;
    private String domain;
    private String website;
}
