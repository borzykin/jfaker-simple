package org.borzykin.jfaker;

import org.borzykin.jfaker.producers.AddressFactory;
import org.borzykin.jfaker.producers.CompanyFactory;
import org.borzykin.jfaker.producers.TextProducer;
import org.borzykin.jfaker.producers.address.Address;
import org.borzykin.jfaker.producers.company.Company;
import org.borzykin.jfaker.producers.person.Gender;
import org.borzykin.jfaker.producers.person.Person;
import org.borzykin.jfaker.producers.PersonFactory;

import java.util.Locale;

public class Jfaker {
    private final Locale locale;
    private final PersonFactory personFactory;
    private final AddressFactory addressFactory;
    private final CompanyFactory companyFactory;
    private final TextProducer textProducer;

    private Jfaker(final Locale locale) {
        this.locale = locale;
        this.personFactory = new PersonFactory(locale);
        this.addressFactory = new AddressFactory(locale);
        this.companyFactory = new CompanyFactory(locale);
        this.textProducer = new TextProducer(locale);
    }

    public static Jfaker create() {
        return new Jfaker(Locale.ENGLISH);
    }

    public static Jfaker create(final Locale locale) {
        return new Jfaker(locale);
    }

    public Person person() {
        return personFactory.create();
    }

    public Person person(final Gender gender) {
        return personFactory.create(gender);
    }

    public Address address() {
        return addressFactory.create();
    }

    public Company company() {
        return companyFactory.create();
    }

    public TextProducer text() {
        return textProducer;
    }
}
