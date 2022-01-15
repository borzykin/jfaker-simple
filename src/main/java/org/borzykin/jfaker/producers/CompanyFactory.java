package org.borzykin.jfaker.producers;

import lombok.SneakyThrows;
import org.borzykin.jfaker.producers.company.Company;
import org.borzykin.jfaker.producers.company.CompanyData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.Locale;

public class CompanyFactory {
    private final CompanyData data;
    private final Locale locale;

    public CompanyFactory(final Locale locale) {
        this.locale = locale;
        Yaml yaml = new Yaml(new Constructor(CompanyData.class));
        this.data = yaml.load(readYml());
    }

    public Company create() {
        return new Company()
                .setName(data.getRandomName())
                .setDomain(data.getRandomDomain())
                .setWebsite(data.getRandomWebsite());
    }

    @SneakyThrows
    private FileInputStream readYml() {
        return new FileInputStream(String.format("src/main/resources/company_%s.yml", locale.toLanguageTag()));
    }
}
