package org.borzykin.jfaker.producers.address;

import lombok.Setter;

import java.util.Random;

@Setter
public class AddressData {
    private String[] state;
    private String[] city;
    private String[] address;
    private String[] zipCode;

    private Random rnd = new Random();

    public String getRandomState() {
        return state[rnd.nextInt(state.length - 1)];
    }

    public String getRandomCity() {
        return city[rnd.nextInt(city.length - 1)];
    }

    public String getRandomAddress() {
        return address[rnd.nextInt(address.length - 1)];
    }

    public String getRandomZip() {
        return zipCode[rnd.nextInt(zipCode.length - 1)];
    }
}
