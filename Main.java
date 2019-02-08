import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static void main(String[] args) {

        //operations de base
        Scanner scan = new Scanner(System.in);
        //Saisie des donnees
        System.out.print("Entrer un text a crypter :");
        String str = scan.nextLine();
        //String str = "car la méthode round me donne lenvie dacheter du pq";
        System.out.print("Entrer le mot clé : ");
        String motCle = scan.nextLine();
        //String motCle = "adake";
        String data = str.replaceAll(" ", "");

        System.out.println(motCle);
        //calcule des elts de la matrice
        int tailleData = data.length();
        int tailleMot = motCle.length();

        //dictionnaire de donnéeq
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int colones = tailleMot;


        //System.out.println((tailleData*1.0/tailleMot));

        int lignes = (int)(Math.ceil(tailleData*1.0/tailleMot));
        int nbCases = lignes * colones ;
        int[] tabposition = new int[colones];
        char[][] cryptogramme = new char[lignes][colones];

        //trouver l'ordre des lettres du mot-clé
        char[] let = motCle.toCharArray();
            char[] dat = data.toCharArray();
        int tour = 0;
        for (int i = 0; i< alphabet.length; i++){
            int cas = 0;
            for (char e : let) {
                //System.out.println(e);
                if (e == alphabet[i]) {
                    //System.out.println(cas+ " " + tour);
                    tabposition[cas]= tour;
                    tour++;//sert a eviter la repetition
                }
                cas++;//passe a la case suivante
            }
        }

        //remplissage du tableau
        int y = 0;
        char carac = 'a';
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colones; j++) {
                if (y >= dat.length){
                    carac = 'x';
                }else{
                    carac = dat[y];
                }
                cryptogramme[i][j] = carac;
                y++;

            }
        }

        //Affichage du cryptogramme
        System.out.println();
        System.out.println("CRYPTOGRAMME");
        for (int car : tabposition) {
            System.out.print(car);
        }
        System.out.println();
        for (char[] e : cryptogramme) {
            for (char car : e) {
                System.out.print(car);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        //lecture du cryptogramme
        int cmpte = 1;
        String msg = "";
        for (int col : tabposition) {
            for (char[] line : cryptogramme) {
                msg += line[col];
                if (cmpte == 5){
                    msg += "--";
                    cmpte = 0;
                }
                cmpte++;
            }
        }


        System.out.println("Message crypté :");
        System.out.println(msg);
    }



}
