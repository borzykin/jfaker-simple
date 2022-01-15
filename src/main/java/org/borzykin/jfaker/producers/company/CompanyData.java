package org.borzykin.jfaker.producers.company;

import lombok.Setter;

import java.util.Random;

@Setter
public class CompanyData {
    private String[] name;
    private String[] domain;
    private String[] website;

    private Random rnd = new Random();

    public String getRandomName() {
        return name[rnd.nextInt(name.length - 1)];
    }

    public String getRandomDomain() {
        return domain[rnd.nextInt(domain.length - 1)];
    }

    public String getRandomWebsite() {
        return website[rnd.nextInt(website.length - 1)];
    }
}
