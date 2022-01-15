package org.borzykin.jfaker;

import org.borzykin.jfaker.producers.address.Address;
import org.borzykin.jfaker.producers.company.Company;
import org.borzykin.jfaker.producers.person.Person;

public class Main {
    public static void main(String[] args) {
        Jfaker jfaker = Jfaker.create();

        Person person = jfaker.person();
        System.out.println(person);
        System.out.println(person.getFullName());

        Address address = jfaker.address();
        System.out.println(address);

        Company company = jfaker.company();
        System.out.println(company);

        String text = jfaker.text().alphabetic(5);
        System.out.println(text);

        String textWithNums = jfaker.text().alphaNumeric(12);
        System.out.println(textWithNums);

        String words = jfaker.text().words(3);
        System.out.println(words);
    }
}
