package meryem.learningproject;

import meryem.learningproject.entities.Person;
import meryem.learningproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningprojectApplication  implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(LearningprojectApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        Person per1=new Person("Meryem","+659745520",40,"UK","IT",45.3,9.2,2.3);
       Person per2=new Person("Meryem1","+659745520",40,"UK","IT",45.3,9.2,2.3);

        personService.addPerson(per1);
        personService.addPerson(per2);



    }





}

