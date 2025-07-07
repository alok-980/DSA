import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(2);
        // pq.add(5);
        // pq.add(1);
        // pq.add(3);
        // pq.add(4);

        pq.add(new Student("Alok", 2));
        pq.add(new Student("Hariom", 4));
        pq.add(new Student("Amit", 3));
        pq.add(new Student("Ankur", 5));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }
    }
}