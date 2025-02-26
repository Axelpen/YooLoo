import java.util.Scanner;

public class Spieler {
  private String name;
  private int gesamtPunkte;
  private Deck myDeck;

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

  private Deck sortiereKarten(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Bitte gib deine Reihenfolge an!");

  }

  public void zeigeInfo() {
    System.out.println("Spieler: " + name);
    System.out.println("Gesamtpunkte: " + gesamtPunkte);
    System.out.println("Deck:");
    myDeck.zeigeDeck(); // Zeigt die Karten im Deck des Spielers an
  }
}
