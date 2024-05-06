package com.study.member.pojo.data;

import java.util.Arrays;
import java.util.List;

public record Author(
        String id,
        String firstName,
        String lastName
) {

    private static final List<Author> authors = Arrays.asList(
            new Author("author1", "Kate", "P"),
            new Author("author2", "Bill", "A"),
            new Author("author3", "Joshua", "B")
    );

    public static Author getById(String id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
