package org.hillel.lesson_5_multithreading_advanced.benchmark;

import java.util.List;

public class Container {

    private final List<Object> objectList;


    public Container(List<Object> objectList) {
        this.objectList = objectList;
    }

    public List<Object> getObjectList() {
        return objectList;
    }
}
