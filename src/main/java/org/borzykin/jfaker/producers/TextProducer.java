package org.borzykin.jfaker.producers;

import lombok.SneakyThrows;
import org.borzykin.jfaker.producers.person.PersonData;
import org.borzykin.jfaker.producers.words.WordData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TextProducer {
    private final Random random;
    private final Locale locale;
    private final WordData data;

    public TextProducer(final Locale locale) {
        this.locale = locale;
        this.random = new Random();
        Yaml yaml = new Yaml(new Constructor(WordData.class));
        this.data = yaml.load(readYml());
    }

    public String alphabetic(final int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String alphaNumeric(final int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, (stringBuilder1, codePoint) -> stringBuilder1.appendCodePoint(codePoint), (stringBuilder, s) -> stringBuilder.append(s))
                .toString();
    }

    public String words(final int amount) {
        final StringBuilder builder = new StringBuilder();

        IntStream.range(0, amount)
                .forEach(x -> builder.append(data.getRandomWord()).append(" "));

        return builder.toString().trim();
    }

    @SneakyThrows
    private FileInputStream readYml() {
        return new FileInputStream(String.format("src/main/resources/vocab_%s.yml", locale.toLanguageTag()));
    }
}
