import java.nio.file.Path;
import java.util.Scanner;
import java.util.Random;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String gissning="";
        String [] ordlista = {};
        int rundor =7;

        //Colors for the indication
        final String GREEN ="\u001b[42;1m"; //If letter is correct nad on the right place
        final String YELLOW="\u001b[43;1m"; //If letter is correct but on wrong place
        final String RESET="\u001b[40m";  //If letter don't appear in the word at all

        //Background color black
        System.out.println(RESET);

        //Takes random number 1-5757 which is the amount of words in "fil.txt"
            Random random = new Random();
            int nr = (random.nextInt(5757));

            //Chooses a 5letter word to guess
            //Reads all lines from "fil.txt" and takes the random number and saves the word on that line
        String korrekt;
            try {
                 korrekt = Files.readAllLines(Paths.get("src/fil.txt")).get(nr-1).toUpperCase();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        System.out.println("WORDLE!");
        System.out.println("Du har 6 försök att gissa på det hemliga ordet (bara engelska ord).");
        System.out.println("Ordet är 5 bokstäver långt");
        System.out.println(GREEN +"Grön" + RESET + "= Bokstaven på rätt plats");
        System.out.println(YELLOW +"Gul" + RESET + "= Bokstaven finns i ordet men ligger på fel plats");
        System.out.println("Inget = Bokstaven finns inte i ordet");
        System.out.println("LYCKA TILL!");

        try {
            ordlista = Files.readAllLines(Path.of("src/fil.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //You only have 6 guesses on you to get the correct word
        for (int runda=0;runda<6;runda++) {


                    rundor--;
                    int test=0;
                    int x = 0;
                    while(test==0)
                    {
                        System.out.print("Gissa på ett ord (Du har "+rundor+" rundor kvar)->");
                        gissning = input.nextLine().toUpperCase();
                        //Checks if the user has guessed an actual word from the list
                        while (ordlista[x].toLowerCase().equals(gissning.toLowerCase())==false)
                        {
                            x++;
                            if(ordlista[x].toLowerCase().equals(gissning.toLowerCase())==true)
                            {
                                test=1;
                            }
                            if(x==5756)
                            {
                                System.out.println("Skriv endast engelska ord                       ");
                                System.out.println("Orden får bara 5 bokstäver långt                ");
                                System.out.println("Och inga tecken som: ' ! . / . etc              ");
                                x=0;
                                break;
                            }
                        }

                    }

            for (int i = 0; i < 5; i++)
            {
                if (gissning.substring(i, i + 1).equals(korrekt.substring(i, i + 1))) {
                    //If the letter matches perfectly it prints the letter with a green background
                    System.out.print(GREEN + gissning.charAt(i) + RESET);
                }
                else if (korrekt.contains(gissning.substring(i, i + 1)))
                {
                    //If the letter is in the word but on the wrong spot it prints the letter with a yellow background
                    System.out.print(YELLOW + gissning.charAt(i) + RESET);
                }
                else
                {
                    //If the letter isn't in the word at all it prints a black background
                    System.out.print(gissning.charAt(i));
                }
                }
            System.out.println();
            //When you guessed the word correct
            if(gissning.equals(korrekt))
            {
                System.out.println("Snyggt jobbat! Du vann!");
                break;
            }
        }
        //When you didn't guess the right word
    if(!gissning.equals(korrekt))
    {
        System.out.println("Tyvärr klarade du det inte! Det rätta ordet var " +korrekt+".");
    }

//slut på void main
    }
    }
