package org.hillel.lesson_6.reflaction;

@Service(name = "AnnotationLazyService", lazyLoad = true)
public class LazyService {

    @Init(isSuppressException = true)
    public void lazyInit() throws Exception {
        System.out.println("I'm lazy service");
        throw new Exception("Lazy service exception was thrown!!!");
    }

    @Override
    public String toString() {
        return "LazyService{}";
    }
}
