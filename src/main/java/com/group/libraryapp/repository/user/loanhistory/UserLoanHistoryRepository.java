package com.group.libraryapp.repository.user.loanhistory;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// UserLoanHistoryRepository는 JpaRepository를 상속하며, UserLoanHistory 타입의 엔티티를, Long타입의 PK로 다룸.
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    // existsBy는 boolean 리턴. 파라미터로 받은 bookName, isReturn값과 일치하는 BookName, IsReturn 값이 DB에 있는지 확인
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
    Optional<UserLoanHistory> findByUserIdAndBookName(Long userId, String bookName);
}
