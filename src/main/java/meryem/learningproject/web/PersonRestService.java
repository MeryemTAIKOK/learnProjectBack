package meryem.learningproject.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import meryem.learningproject.entities.Person;
import meryem.learningproject.entities.PersonForm;
import meryem.learningproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonRestService {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons")
    public List<Person> getPersons(){
        return personService.showPersonsList();
    }


    @GetMapping(value = "/persons/{personId}")
    public Person getPersonByID(@PathVariable Long personId) {
        return personService.getPerParId(personId);
    }

    @DeleteMapping(value = "/persons/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(value = "/persons/{personId}")
    public Person update(@RequestParam("person")String person, @PathVariable("personId") Long personId ) throws JsonMappingException, JsonProcessingException, IOException, Exception {
  Person person1=new ObjectMapper().readValue(person,Person.class);
  Person person2=personService.getPerParId(personId);

        person2.setPhoneNumber(person1.getPhoneNumber());
        person2.setLog(person1.getLog());
        person2.setLen(person1.getLen());
        person2.setFirstName(person1.getFirstName());
        person2.setAge(person1.getAge());
        person2.setJobTitle(person1.getJobTitle());
        person2.setCountry(person1.getCountry());
        person2.setMonthlyIncome(person1.getMonthlyIncome());

        return personService.updatePers(personId,person2);
    }

//,consumes = MediaType.APPLICATION_JSON_VALUE
  //  @PostMapping(value ="/persons",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //public Person addPerson(@ModelAttribute  Person person) {
//@PostMapping(value ="/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
//public Person addPerson(@RequestBody  Person person) {

      /*  System.out.println(person.getFirstName());
        System.out.println(person.getFamilyName());
        System.out.println(person.getAge());
        System.out.println(person.getCountry());
        System.out.println(person.getJobTitle());
        System.out.println(person.getPhoneNumber());
        System.out.println(person.getLen());
        System.out.println(person.getFirstName());
        return personService.addPerson(person);
    }*/

    @PostMapping(value ="/persons")
    public Person addPerson(@RequestParam("person")String person) throws JsonMappingException, JsonProcessingException, IOException {
        PersonForm per = new ObjectMapper().readValue(person, PersonForm.class);
        System.out.println("person : "+person);
        System.out.println(per);
        Person person1 = new Person();
        person1.setPhoneNumber(per.getPhoneNumber());
        person1.setLog(per.getLog());
        person1.setLen(per.getLen());
        person1.setFirstName(per.getFirstName());
        person1.setAge(per.getAge());
        person1.setJobTitle(per.getJobTitle());
        person1.setCountry(per.getCountry());
        person1.setMonthlyIncome(per.getMonthlyIncome());

        return personService.addPerson(person1);
    }







}
