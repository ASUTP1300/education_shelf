package edu.spring_wf.transaction;

import edu.spring_wf.data.entity.Person;
import edu.spring_wf.data.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.bee.arcollection.bankstatement.BankStatementInfoClient;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Дурилка о @Transactional
 *
 */
@Component
public class A_Service {
    private final PersonRepository personRepository;
    private final B_Service b_Service;

    @Autowired
    private  BankStatementInfoClient client;


    private final Logger log = LoggerFactory.getLogger(A_Service.class);

    @Autowired
    public A_Service(PersonRepository personRepository, B_Service b_service) {
        this.personRepository = personRepository;
        this.b_Service = b_service;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional(dontRollbackOn = Exception.class)
    public void createPerson() {
        client.getBankStatementsByPeriod(11L, LocalDate.of(2002,1, 1), LocalDate.now());





        try {

            throw new Exception("Failed to create");
        } catch (Throwable e) {
//            e.addSuppressed(e);
//            log.error(e.getMessage());

        }

    }
}

@Component
class B_Service {
    private final PersonRepository personRepository;

    @Autowired
    public B_Service(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void fakeCreatePerson(String name) {
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        if (name != null) {
            throw new IllegalStateException("Фейк-ошибка создания пользователя");
        }
    }


}

