//Угнивенко Дмитрий Б763-2
//Вариант А. 17.Создать объект класса Дерево, используя классы Лист, Ветка. Методы:
//зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.





public class Tree {
    private Branch[] branches;

    public Tree(int branchCount, int leafCountPerBranch) {
        branches = new Branch[branchCount];
        for (int i = 0; i < branchCount; i++) {
            branches[i] = new Branch(leafCountPerBranch);
        }
    }

    public void blossom() {
        System.out.println("Дерево зацвело!");
    }

    public void dropLeaves() {
        for (Branch branch : branches) {
            branch.dropLeaves();
        }
    }

    public void frostCover() {
        System.out.println("Дерево покрылось инеем");
    }

    public void yellowLeaves() {
        for (Branch branch : branches) {
            branch.yellowLeaves();
        }
    }

    private class Leaf {

        public void fall() {
            System.out.println("Лист упал на землю");
        }

        public void turnYellow() {
            System.out.println("Лист пожелтел");
        }
    }

    private class Branch {
        private Leaf[] leaves;

        public Branch(int leafCount) {
            leaves = new Leaf[leafCount];
            for (int i = 0; i < leafCount; i++) {
                leaves[i] = new Leaf();
            }
        }

        public void dropLeaves() {
            for (Leaf leaf : leaves) {
                leaf.fall();
            }
        }

        public void yellowLeaves() {
            for (Leaf leaf : leaves) {
                leaf.turnYellow();
            }
        }
    }




    public static void main(String[] args) {
        Tree tree = new Tree(1, 2);

        tree.blossom();
        tree.yellowLeaves();
        tree.frostCover();
        tree.dropLeaves();
    }
}
