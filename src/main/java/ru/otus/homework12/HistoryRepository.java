package ru.otus.homework12;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History, Long> {
    public List<History> findByCustomerId(Long customerId);
    public List<History> findByItemId(Long itemId);
}
