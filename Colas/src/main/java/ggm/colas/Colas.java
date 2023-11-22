package ggm.colas;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Colas {

    public static void main(String[] args) {

        // cola estática
//        Queue<Integer> q1 = new ArrayDeque<>();
//        Queue<Integer> q1 = new PriorityQueue<>();
//        q1.offer(8);
//        q1.offer(3);
//        q1.offer(9);
//        q1.offer(1);
//
//        while (!q1.isEmpty()) {
//            Integer e = q1.poll(); // desencolar
//            System.out.println(e);
//        }
//
//        // cola dinámica
//        Queue<String> q2 = new PriorityQueue<>();
//        q2.offer("Juanes");
//        q2.offer("Rosalia");
//        q2.offer("Daddy Yankee");
//        q2.offer("Luis Fonsi");
//        q2.offer("Shakira");
//        q2.offer("Maluma");
//        q2.offer("Ariana Grande");
//        
//        System.out.println(q2.toString());
//
//        System.out.println("\nCon iterador:");
//
//        Iterator<String> iterator = q2.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }
//
//        System.out.println("\nDesencolando:");
//
//        while (!q2.isEmpty()) {
//            System.out.println(q2.poll());
//        }
        
        

        Comparator<Student> c1 = (s1, s2) -> {
            return s1.getAge() - s2.getAge();
        };
        
        Comparator<Student> c2 = (s1, s2) -> {
            return s1.getName().compareTo(s2.getName());
        };
        
//        Comparator<Student> c3 = (s1, s2) -> {
//            
//        };

        
        Queue<Student> q3 = new PriorityQueue<>(c1);
        
        
        
//        Queue<Student> q3 = new LinkedList<>();
        
        q3.offer(new Student("Manuel", 38));
        q3.offer(new Student("Alice", 19));
        q3.offer(new Student("Andrew", 25));
        q3.offer(new Student("Bob", 20));
        q3.offer(new Student("Alice", 29));
        q3.offer(new Student("Charlie", 23));
        q3.offer(new Student("Alice", 28));
        q3.offer(new Student("Alice", 18));
        q3.offer(new Student("Alice", 17));
        
        System.out.println("\nDesencolando");
        while (!q3.isEmpty()) {
            System.out.println(q3.poll());
        }

        System.out.println("Todo felicidad");

    }
}
