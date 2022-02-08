package meryem.learningproject.services;

import meryem.learningproject.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    public List<Person> showPersonsList();
    public Person getPerParId(Long idPers);
    public Person addPerson(Person pers);
    public Person updatePers(Long idPers, Person pers);
    public boolean deletePerson(Long idPers);


}
