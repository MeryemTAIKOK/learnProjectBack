package meryem.learningproject.dao;

import meryem.learningproject.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface personJpaRepository extends JpaRepository<Person,Long> {


}
