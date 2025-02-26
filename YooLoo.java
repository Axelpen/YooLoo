import java.util.ArrayList;
import java.util.HashMap;

public class YooLoo {
  private static ArrayList<Spieler> spielerListe = new ArrayList<>();

  public static void main(String[] args) {
    Spieler spieler1 = new Spieler("Testo");
    // Deck testDeck = new Deck();
    // testDeck.zeigeDeck();
    System.out.println("test");
    spieler1.zeigeInfo();

    spielerHinzufügen("Alex");

  }

  public static int spielerHinzufügen(String name) {
    if (spielerListe.size() >= 10) {
      System.out.println("Das Spiel ist voll!!");
      return 1;
    }
    if (name != null) {
      Spieler neuerSpieler = new Spieler(name);
      spielerListe.add(neuerSpieler);
      return 0;
    }
    return 1;
  }

  public static int spielStarten() {
    if (spielerListe.size() >= 3) {
      System.out.println("Nicht genug Spieler!!!");
      return 1;
    }
    System.out.println("Spiel startet!");
    // TODO
    // Logik vom Spiel
    return 0;
  }

  public static void spieleRunde(ArrayList<Spieler> spielendeListe){
    int hoechstePunkte = 0;
    HashMap<String,Integer> punktZahl = new HashMap<String, Integer>();

    for(Spieler spieler : spielerListe)
    {
      
    }

  }

  public static int bestimmeGewinner() {

    int maxPunkte = 0;
    int anzahlGewinner = 0;

    for (Spieler spieler : spielerListe) {
      int gesamtPunkte = spieler.getGesamtPunkte();

      if (gesamtPunkte > maxPunkte) {
        maxPunkte = gesamtPunkte;
        anzahlGewinner = 1;
      } else if (gesamtPunkte == maxPunkte) {
        anzahlGewinner++;
      }
    }

    ArrayList<Spieler> gewinnerListe = new ArrayList<>();

    for (Spieler spieler : spielerListe) {
      if (spieler.getGesamtPunkte() == maxPunkte) {
        gewinnerListe.add(spieler);
      }
    }

    if (anzahlGewinner == 1) {
      kroeneGewinner(gewinnerListe.get(0));
      return 0;
    }
    finaleRunde(gewinnerListe);
    return 0;
  }

  public static void kroeneGewinner(Spieler gewinner) {
    System.out.println("Der Gewinner ist:" + gewinner.getName() + "Mit der Punktzahl" + gewinner.getGesamtPunkte());
  }      


  




  public static void finaleRunde(ArrayList<Spieler> gewinner) {
    System.out.println(gewinner.size() + " Spieler haben die gleiche Punktzahl! Finale Runde starten...");
    // TODO
    // Falls 2 oder mehr Spieler die gleiche Punktzahl haben, kommt die
    // Finale Runde
  }
}
