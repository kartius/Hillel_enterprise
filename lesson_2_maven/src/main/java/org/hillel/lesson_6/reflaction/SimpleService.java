package org.hillel.lesson_6.reflaction;

@Service(name = "AnnotationSimpleService")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("I'm simple service");
    }
}
