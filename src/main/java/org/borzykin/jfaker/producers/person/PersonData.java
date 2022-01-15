package org.borzykin.jfaker.producers.person;

import lombok.Setter;

import java.util.Random;

@Setter
public class PersonData {
    private String[] firstNamesMale;
    private String[] firstNamesFemale;
    private String[] lastNames;

    private Random rnd = new Random();

    public String getRandomFirstname(final Gender gender) {
        if (gender.equals(Gender.MALE)) {
            return firstNamesMale[rnd.nextInt(firstNamesMale.length - 1)];
        } else {
            return firstNamesFemale[rnd.nextInt(firstNamesFemale.length - 1)];
        }
    }

    public String getRandomLastname() {
        return lastNames[rnd.nextInt(lastNames.length - 1)];
    }
}
