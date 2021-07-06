import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Pokemon> pokeList = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to your PokeDex");

        while (true) {
            System.out.println("\n\n[A] Add Pokemon\n[B] Search Pokemon\n[C] Battle Pokemon\n[D] Print PokeDex\n[E] Exit");
            String option = input.nextLine();

            if (option.equalsIgnoreCase("A")) {
                AddPokemon();
            } else if (option.equalsIgnoreCase("B")) {
                SearchPokemon();
            } else if (option.equalsIgnoreCase("C")) {
                BattlePokemon();
            } else if (option.equalsIgnoreCase("D")) {
                System.out.println(option);
            } else if (option.equalsIgnoreCase("E")) {
                System.exit(0);
            }

        }
    }

    static void AddPokemon() {

        System.out.println("Adding Pokemon\n");

        System.out.println("Enter Pokemon Name: ");
        String pokeName = input.nextLine();

        System.out.println("Enter Pokemon Type: ");
        String pokeType = input.nextLine();

        System.out.println("Enter Pokemon Attack: ");
        int pokeAtk = input.nextInt();
        input.nextLine();

        System.out.println("Enter Pokemon HP: ");
        int pokeHp = input.nextInt();
        input.nextLine();

        pokeList.add(new Pokemon(pokeName, pokeType, pokeAtk, pokeHp));
    }

    static void SearchPokemon() {

        System.out.println("Search the PokeDex\nWhat pokemon are you looking for?");
        String search = input.nextLine();
        boolean match;

        for (Pokemon instance : pokeList) {

            match = search.equalsIgnoreCase(instance.getPokeName());

            if (match) {
                System.out.println("You found " + instance.getPokeName() + " listed in your PokeDex.");
                System.out.println("Name: " + instance.getPokeName());
                System.out.println("Type: " + instance.getPokeType());
                System.out.println("Attack Points: " + instance.getPokeAtk());
                System.out.println("Health Points: " + instance.getPokeHp() + "\n");
            }

        }
    }

    static void BattlePokemon() {


        System.out.println("Here are your Pokemons:");

        for (int i = 0; i < pokeList.size(); i++) {
            System.out.println("[" + i + "] " + pokeList.get(i).getPokeName());
        }

        System.out.println("Select first pokemon for battle:");
        int red = input.nextInt();
        input.nextLine();

        System.out.println("Select second pokemon for battle:");
        int blue = input.nextInt();
        input.nextLine();

        System.out.println("Who should attack first?\n");
        System.out.println("[1]" + pokeList.get(red).getPokeName());
        System.out.println("[2]" + pokeList.get(blue).getPokeName());
        int initiate = input.nextInt();
        input.nextLine();

        int redMaxHp = pokeList.get(red).getPokeHp();
        int blueMaxHp = pokeList.get(blue).getPokeHp();

        int redDamage = pokeList.get(red).getPokeAtk();
        int blueDamage = pokeList.get(blue).getPokeAtk();

        if (Integer.toString(initiate).equals("1")) {
            while (blueMaxHp > 0 && redMaxHp > 0) {
                System.out.println(pokeList.get(red).getPokeName() + " attacks " + pokeList.get(blue).getPokeName());
                System.out.println(pokeList.get(blue).getPokeName() + " received " + pokeList.get(red).getPokeAtk() + " damage");
                int blueCurHp = blueMaxHp - redDamage;
                System.out.println(pokeList.get(blue).getPokeName() + " has " + blueCurHp + " hp left\n");
                blueMaxHp = blueCurHp;

                //checker if a pokemon fainted on first instance
                if (redMaxHp == 0) {
                    System.out.println(pokeList.get(red).getPokeName() + " has fainted");
                } else if (blueMaxHp == 0) {
                    System.out.println(pokeList.get(blue).getPokeName() + " has fainted");
                }

                System.out.println(pokeList.get(blue).getPokeName() + " attacks " + pokeList.get(red).getPokeName());
                System.out.println(pokeList.get(red).getPokeName() + " received " + pokeList.get(blue).getPokeAtk() + " damage");
                int redCurHp = redMaxHp - blueDamage;
                System.out.println(pokeList.get(red).getPokeName() + " has " + redCurHp + " hp left\n");
                redMaxHp = redCurHp;
            }
        } else if (Integer.toString(initiate).equals("2")) {
            while (blueMaxHp > 0 && redMaxHp > 0) {
                System.out.println(pokeList.get(blue).getPokeName() + " attacks " + pokeList.get(red).getPokeName());
                System.out.println(pokeList.get(red).getPokeName() + " received " + pokeList.get(blue).getPokeAtk() + " damage");
                int redCurHp = redMaxHp - blueDamage;
                System.out.println(pokeList.get(red).getPokeName() + " has " + redCurHp + " hp left\n");
                redMaxHp = redCurHp;

                //checker if a pokemon fainted on first instance
                if (redMaxHp == 0) {
                    System.out.println(pokeList.get(red).getPokeName() + " has fainted");
                } else if (blueMaxHp == 0) {
                    System.out.println(pokeList.get(blue).getPokeName() + " has fainted");
                }

                System.out.println(pokeList.get(red).getPokeName() + " attacks " + pokeList.get(blue).getPokeName());
                System.out.println(pokeList.get(blue).getPokeName() + " received " + pokeList.get(red).getPokeAtk() + " damage");
                int blueCurHp = blueMaxHp - redDamage;
                System.out.println(pokeList.get(blue).getPokeName() + " has " + blueCurHp + " hp left\n");
                blueMaxHp = blueCurHp;

            }
        }
    }

}
