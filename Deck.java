import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private ArrayList<Karte> karten;
  private int Position; // nicht gebraucht?

  public Deck() {
    karten = new ArrayList<Karte>();
    erstelleDeck();
  }

  private void erstelleDeck() {
    Random rand = new Random();
    String[] farben = { "Schwarz", "Lila", "Blau", "Grün" }; // etc...
    for (int i = 0; i < 10; i++) {
      String farbe = farben[rand.nextInt(farben.length)];
      karten.add(new Karte(rand.nextInt(20), farbe, "Spielkarte"));
      //karten.add(new Karte(i + 1, farbe, "Spielkarte"));
      // Die Art von Karte overengineered? Deswegen erstmal nur placeholder
    }
  }

  public List<Karte> getKarten() {
    return Collections.unmodifiableList(karten);
  }

  public void setKarten(List<Karte> karten) {
    this.karten = new ArrayList<>(karten);
  }

  public Karte getErsteKarte() {
    return karten.getFirst();
  }

  public void entferneKarte(int zahlDerKarte) {
    karten.removeIf(n -> (n.getWert() == zahlDerKarte));
    // Löscht Karte mit gespielter Nummer, evtl elegantere Lösung?
    // deprecated, da man immer ersteKarte entfernen will... erstmal aufheben
  }

  public void entferneErsteKarte()
  {
    karten.removeFirst();
  }

  public void zeigeDeck() {
    for (Karte karte : karten) {
      System.out.println(karte);
    }
  }
}
