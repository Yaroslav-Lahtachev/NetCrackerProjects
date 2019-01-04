package com.lahtachev.objects;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection {
    List objectsList;
    Set objectsSet;
    Map objectsMap;

    public Collection() {
        System.out.println("Collection.Collection");
    }

    public Collection(List objectsList, Set objectsSet, Map objectsMap) {
        this.objectsList = objectsList;
        this.objectsSet = objectsSet;
        this.objectsMap = objectsMap;
        System.out.println("objectsList = " + objectsList);
        System.out.println("objectsSet = " + objectsSet);
        System.out.println("objectsMap = " + objectsMap);
    }

    public List getObjectsList() {
        return objectsList;
    }

    public void setObjectsList(List objectsList) {
        System.out.println("Collection.setObjectsList");
        this.objectsList = objectsList;
        System.out.println("objectsList = " + objectsList);
    }

    public Set getObjectsSet() {
        return objectsSet;
    }

    public void setObjectsSet(Set objectsSet) {
        System.out.println("Collection.setObjectsSet");
        this.objectsSet = objectsSet;
        System.out.println("objectsSet = " + objectsSet);
    }

    public Map getObjectsMap() {
        return objectsMap;
    }

    public void setObjectsMap(Map objectsMap) {
        System.out.println("Collection.setObjectsMap");
        this.objectsMap = objectsMap;
        System.out.println("objectsMap = " + objectsMap);
    }
}
