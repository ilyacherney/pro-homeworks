package ru.otus.homework13;

import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void save(Phone phone) {
        phoneRepository.save(phone);
    }
}
