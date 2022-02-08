package meryem.learningproject.servicesImpl;

import meryem.learningproject.dao.personJpaRepository;
import meryem.learningproject.entities.Person;
import meryem.learningproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired private personJpaRepository perJpaRepository;

    @Override
    public List<Person> showPersonsList() {
        return perJpaRepository.findAll();
    }

    @Override
    public Person getPerParId(Long idPers) {

        Optional<Person> person=perJpaRepository.findById(idPers);

        if(!person.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "The person with  id("+idPers+") doesn't exist");
        }
        return perJpaRepository.findById(idPers).get();
    }

    @Override
    public Person addPerson(Person pers) {
        return perJpaRepository.save(pers);
    }

    @Override
    public Person updatePers(Long idPers, Person pers) {
        if(!idPers.equals(pers.getPersonId())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "The specified 'id' in the IRI doesn't equal the ID related to the article that you want to update ");
        }

        Optional<Person> ad=perJpaRepository.findById(idPers);

        if(!ad.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "the person with the ID ' "+idPers+" ' doesn't exist");
        }
        Person p=this.getPerParId(idPers);

        p.setFirstName(pers.getFirstName());
        p.setPhoneNumber(pers.getPhoneNumber());
        p.setAge(pers.getAge());
        p.setCountry(pers.getCountry());
        p.setJobTitle(pers.getJobTitle());
        p.setMonthlyIncome(pers.getMonthlyIncome());
        p.setLen(pers.getLen());
        p.setLog(pers.getLog());



        return perJpaRepository.save(p);
    }

    @Override
    public boolean deletePerson(Long idPers) {
        if(perJpaRepository.findById(idPers).isPresent()) {
            perJpaRepository.deleteById(idPers);
            return true;
        }
        return false;
    }
}
