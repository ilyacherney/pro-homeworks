package ru.otus.homework12;

import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Item, Long> {
}
