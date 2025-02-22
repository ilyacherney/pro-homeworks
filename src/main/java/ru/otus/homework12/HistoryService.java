package ru.otus.homework12;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private HistoryRepository historyRepository;
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History saveHistory(Customer customer, Item item) {
        History history = new History(customer, item);
        historyRepository.save(history);
        return history;
    }

    public List<History> findCustomerHistory(long customerId) {
        return historyRepository.findByCustomerId(customerId);
    }

    public List<History> findItemHistory(long itemId) {
        return historyRepository.findByItemId(itemId);
    }
}
