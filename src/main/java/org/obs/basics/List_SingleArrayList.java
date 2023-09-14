package org.obs.basics;

import java.util.ArrayList;

public class List_SingleArrayList {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("JAVA");
        al.add("PHP");
        al.add("RUBY");
        al.add(".NET");
        for(int i=0;i<al.size();i++){
            String all=al.get(i);
            System.out.println(all);
        }
        System.out.println("The list is " + al);

        int size = al.size();
        System.out.println("The size is " + size);

        if (al.contains("PYTHON")) {
            System.out.println("Language present");
        } else {
            System.out.println("The element is not present ");
            al.add("PYTHON");
        }

        int index = al.indexOf("PYTHON");
        System.out.println("Index of python is " + index);

        if (al.contains("RUBY")) {
            int a = al.indexOf("RUBY");
            System.out.println("Ruby exists with index " + a);
            al.remove("RUBY");
        } else {
            al.add(2, "HTML");
            System.out.println(al);
            int b = al.indexOf("HTML");
            System.out.println("Ruby does not exists so i have added html in index " + b);
        }
    }
}
