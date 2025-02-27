import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Spieler {
  private String name;
  private int gesamtPunkte;
  public Deck myDeck;

  public Spieler(String name) {
    this.name = name;
    this.gesamtPunkte = 0;
    this.myDeck = new Deck();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGesamtPunkte() {
    return gesamtPunkte;
  }

  public void addPunkte(int punkte) {
    this.gesamtPunkte += punkte;
  }

  public Deck getmyDeck() {
    return myDeck;
  }

  

  private void sortiereKarten() { 
      /* Work in Progress, Scanner throwed Exception.
       * Wenig Priorität erstmal
       */
    Scanner scan = new Scanner(System.in);
    List<Karte> karten = new ArrayList<>(myDeck.getKarten());
    List<Karte> sortierteKarten = new ArrayList<>();
    Integer[] reihenFolge = new Integer[10];

    System.out.println("Bitte gib deine Reihenfolge an!");
    for (int i = 0; i < 10; i++) {
      reihenFolge[i] = scan.nextInt();
      if (reihenFolge[i] > 10) {
        System.out.println("Zahl zu hoch!");
        i--;
        continue;
      }
    }
    scan.close();

    for (int i = 0; i < 10; i++) {
      int wert = reihenFolge[i];
      Karte placeholder = null;
      for (Karte karte : karten) {
        if (karte.getWert() == wert) {
          placeholder = karte;
          break;
        }
      }
    }
    myDeck.setKarten(sortierteKarten);

  }

  public void zeigeInfo() {
    System.out.println("Spieler: " + name);
    System.out.println("Gesamtpunkte: " + gesamtPunkte);
    System.out.println("Deck:");
    myDeck.zeigeDeck(); // Zeigt die Karten im Deck des Spielers an
  }
}
