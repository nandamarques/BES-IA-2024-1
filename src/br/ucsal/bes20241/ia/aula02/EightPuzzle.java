package br.ucsal.bes20241.ia.aula02;

import java.util.*;
public class EightPuzzle {

    public static final List<Integer> originalList = createPieces();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        List <Integer> sortedTray = createPieces();

        do {
            Collections.shuffle(sortedTray);
        } while (!isSolvable(sortedTray));

        do {
            System.out.println("---------8-PUZZLE----------\n");
            printTable(sortedTray);
            System.out.println("\nEnter the direction or get help from the robot: "
                    + "\n 1 - right "
                    + "\n 2 - left "
                    + "\n 3 - down "
                    + "\n 4 - up "
                    + "\n 5 - need help"
                    + "\n 6 - complete solution"
                    + "\n 7 - exit ");
            int choice = keyboard.nextInt();

            switch (choice){
                case 1:
                    moveRight(sortedTray);
                    break;
                case 2:
                    moveLeft(sortedTray);
                    break;
                case 3:
                    moveDown(sortedTray);
                    break;
                case 4:
                    moveUp(sortedTray);
                    break;
                case 5:
                    System.out.println("aqui vem uma ajuda da BFS :)");
                    break;
                case 6:
                    System.out.println("aqui vem uma soluÃ§Ã£o completa da inteligÃªncia BFS com dados legais");
                    break;
                case 7:
                    System.exit(200);
                    break;
                default:
                    System.out.println("Put a valid number!");
            }
        } while (!sortedTray.equals(originalList));
        System.out.println("Congratulations! You made it!!!!");
        printTable(sortedTray);
    }

    public static List<Integer> createPieces(){
        List<Integer> myList = new ArrayList<Integer>();

        for (int i = 1; i <= 8; i++){
            myList.add(i);

        }
        myList.add(0);

        return myList;
    }

    public static void printTable(List<Integer> list) {
        for (int i = 0; i < list.size(); i++){
            if (i % 3 == 0 && i > 0){
                System.out.println();
            }
            if (list.get(i) == 0) {
                System.out.print("_ "); // Imprime o sublinhado para o espaÃ§o vazio

            } else {
                System.out.print(list.get(i) + " "); // Imprime o nÃºmero seguido de espaÃ§o
            }
        }
        System.out.println();
    }
    public static List<Integer> moveRight(List<Integer> list){
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(0)) {
                Collections.swap(list, (i -1), i);
            }
        }
        return list;
    }

    public static List<Integer> moveLeft(List<Integer> list){
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(0)) {
                Collections.swap(list, i, i + 1);
                break;
            }
        }
        return list;
    }

    public static List<Integer> moveDown(List<Integer> list) {
        int index = list.indexOf(0);
        if (index >= 3) {
            Collections.swap(list, index, index - 3);
        }
        return list;
    }

    public static List<Integer> moveUp(List<Integer> list){
        int index = list.indexOf(0);
        if(index <= 5){
            Collections.swap(list, index, index + 3);
        }
        return list;
    }
    public static boolean isSolvable(List<Integer> pieces) {
        int inversions = 0;
        for (int i = 0; i < pieces.size(); i++) {
            for (int j = i + 1; j < pieces.size(); j++) {
                if (pieces.get(i) > pieces.get(j) && pieces.get(i) != 0 && pieces.get(j) != 0) {
                    inversions++;
                }
            }
        }
        return inversions % 2 == 0;
    }
}



