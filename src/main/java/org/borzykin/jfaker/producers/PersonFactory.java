package org.borzykin.jfaker.producers;

import lombok.SneakyThrows;
import org.borzykin.jfaker.producers.person.Gender;
import org.borzykin.jfaker.producers.person.Person;
import org.borzykin.jfaker.producers.person.PersonData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Random;

public class PersonFactory {
    private final Locale locale;
    private final PersonData data;
    private final Random rnd;

    public PersonFactory(final Locale locale) {
        this.locale = locale;
        Yaml yaml = new Yaml(new Constructor(PersonData.class));
        this.data = yaml.load(readYml());
        this.rnd = new Random();
    }

    public Person create() {
        final Gender gender = rnd.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        return new Person()
                .setFirstName(data.getRandomFirstname(gender))
                .setLastName(data.getRandomLastname())
                .setGender(gender)
                .setAge(rnd.nextInt(100))
                .setAddress(new AddressFactory(locale).create());
    }

    public Person create(final Gender gender) {
        return new Person()
                .setFirstName(data.getRandomFirstname(gender))
                .setLastName(data.getRandomLastname())
                .setGender(gender)
                .setAge(rnd.nextInt(100));
    }

    @SneakyThrows
    private FileInputStream readYml() {
        return new FileInputStream(String.format("src/main/resources/person_%s.yml", locale.toLanguageTag()));
    }
}
