package org.borzykin.jfaker.producers.words;

import lombok.Setter;

import java.util.Random;

@Setter
public class WordData {
    private String[] words;

    private Random rnd = new Random();

    public String getRandomWord() {
        return words[rnd.nextInt(words.length - 1)];
    }
}
