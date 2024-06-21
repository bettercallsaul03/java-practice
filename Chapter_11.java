//Угнивенко Дмитрий Б763-2
//Вариант A. 6. Определить множество на основе множества целых чисел. Создать методы
//для определения пересечения и объединения множеств.

import java.util.HashSet;
import java.util.Set;

public class IntegerSet {
        private Set<Integer> set;
        
        public IntegerSet(Set<Integer> elements) {
                this.set = new HashSet<>(elements);
        }

        public void add(int element) {
                this.set.add(element);
        }

        public IntegerSet intersection(IntegerSet otherSet) {
                Set<Integer> intersection = new HashSet<>(this.set);
                intersection.retainAll(otherSet.set);
                return new IntegerSet(intersection);
        }

        public IntegerSet union(IntegerSet otherSet) {
                Set<Integer> union = new HashSet<>(this.set);
                union.addAll(otherSet.set);
                return new IntegerSet(union);
        }

        public String toString() {
                return "IntegerSet" + set.toString();
        }

        public static void main(String[] args) {
                IntegerSet set1 = new IntegerSet(Set.of(1, 2, 3, 4, 22, 99));
                IntegerSet set2 = new IntegerSet(Set.of(3, 4, 5, 6, 22, 99));

                System.out.println("Множество 1: " + set1);
                System.out.println("Множество 2: " + set2);

                IntegerSet intersectionSet = set1.intersection(set2);
                System.out.println("Пересечение: " + intersectionSet);

                IntegerSet unionSet = set1.union(set2);
                System.out.println("Объединение: " + unionSet);
        }
}
