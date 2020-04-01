package springboot.component.ioc.xml;

import org.springframework.stereotype.Component;

@Component
public class App {

    private Student student;

//    @Autowired
//    @Qualifier("monkey")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String hello() {
        return animal.getName();
    }

}
