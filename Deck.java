import java.util.Random;
import java.util.ArrayList;

public class Deck {
  private ArrayList<Karte> karten;
  private int Position; // wofür gebraucht?

  public Deck() {
    karten = new ArrayList<Karte>();
    erstelleDeck();
  }

  private void erstelleDeck() {
    Random rand = new Random();
    String[] farben = { "Schwarz", "Lila", "Blau", "Grün" }; // etc...
    for (int i = 0; i < 10; i++) {
      String farbe = farben[rand.nextInt(farben.length)];
      karten.add(new Karte(i+1, farbe, "Spielkarte"));
      // Die Art von Karte overengineered? Deswegen erstmal nur placeholder
    }
  }

  public void entferneKarte(int zahlDerKarte){
      karten.removeIf(n -> (n.getWert() == zahlDerKarte));
  }

  public void zeigeDeck() {
    for (Karte karte : karten) 
    {
      System.out.println(karte);
    }
  }

}
