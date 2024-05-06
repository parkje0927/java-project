package com.study.member.pojo.data;

import java.util.Arrays;
import java.util.List;

public record Book(
        String id,
        String name,
        int pageCount,
        String authorId
) {

    private static final List<Book> books = Arrays.asList(
            new Book("book1", "java", 100, "author1"),
            new Book("book2", "kotlin", 150, "author2"),
            new Book("book3", "javascript", 200, "author3")
    );

    public static Book getById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
