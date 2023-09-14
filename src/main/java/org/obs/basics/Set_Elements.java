package org.obs.basics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
public class Set_Elements {
    public static void main(String args[]) {
        Set<String> s = new LinkedHashSet<String>();
        s.add("My");
        s.add("Name");
        s.add("is");
        s.add("Aswathy");
        System.out.println("Set: " + s);
        Iterator newSet = s.iterator();
        System.out.println("The New Set values are: ");
        while (newSet.hasNext()) {
            System.out.println(newSet.next());
        }
    }
}
