package org.borzykin.jfaker.producers;

import lombok.SneakyThrows;
import org.borzykin.jfaker.producers.address.Address;
import org.borzykin.jfaker.producers.address.AddressData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.Locale;

public class AddressFactory {
    private final AddressData data;
    private final Locale locale;

    public AddressFactory(final Locale locale) {
        this.locale = locale;
        Yaml yaml = new Yaml(new Constructor(AddressData.class));
        this.data = yaml.load(readYml());
    }

    public Address create() {
        return new Address()
                .setState(data.getRandomState())
                .setCity(data.getRandomCity())
                .setAddress(data.getRandomAddress())
                .setZipCode(data.getRandomZip());
    }

    @SneakyThrows
    private FileInputStream readYml() {
        return new FileInputStream(String.format("src/main/resources/address_%s.yml", locale.toLanguageTag()));
    }
}
