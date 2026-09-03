package com.group.libraryapp.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // DB에서 책 이름을 통해 책을 가져오는 메서드
    Optional<Book> findByName(String bookName);
}
