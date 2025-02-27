import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* TODO: Spieler Deck-Reihenfolge ist nicht selber wählbar!
 * Es werden Random Nummern benutzt... -> Funktion in Spieler.
 * finaleRunde und spezialRunde erstellen
 * Klassen aufräumen 
 */

public class YooLoo {
  private static ArrayList<Spieler> spielerListe = new ArrayList<>();

  public static void main(String[] args) {
    // Deck testDeck = new Deck();
    // testDeck.zeigeDeck();
    System.out.println("test");

    spielerHinzufügen("Alex");
    spielerHinzufügen("Jake");

    spielerHinzufügen("ZazaCrew");
    spielerHinzufügen("Penny");
    spielStarten();
  }

  public static Spieler bestimmeRundenGewinner(Map<Spieler, Karte> gefilterteKarten) {
    Spieler gewinner = null;
    int maxWert = -1;

    for (Map.Entry<Spieler, Karte> entry : gefilterteKarten.entrySet()) {
      if (entry.getValue().getWert() > maxWert) {
        maxWert = entry.getValue().getWert();
        gewinner = entry.getKey();
      }
    }
    return gewinner;
  }


  public static void spieleRunde(ArrayList<Spieler> spielendeListe) {
    Map<Spieler, Karte> gelegteKarten = new HashMap<>();

    for (int runde = 1; runde <= 10; runde++) {
      System.out.println("Runde " + runde);

      for (Spieler spieler : spielerListe) {
          Karte karte = spieler.myDeck.getErsteKarte();
          gelegteKarten.put(spieler, karte);
          System.out.println(
              spieler.getName() + " legt " + karte.getWert());
      }

      entferneDoppelteWerte(gelegteKarten);
      System.out.println("Werte aus...");
      Spieler rundenGewinner = bestimmeRundenGewinner(gelegteKarten);

      if (rundenGewinner != null) {
          int gewinnerPunkte = rundenGewinner.myDeck.getErsteKarte().getWert();
          rundenGewinner.addPunkte(gewinnerPunkte);
          System.out.println(
              rundenGewinner.getName() + " gewinnt die Runde und erhält " + gewinnerPunkte + " Punkte." + "\n###############################################\n");
          for(Spieler spieler : spielerListe){
            spieler.myDeck.entferneErsteKarte();
          }
            }


      } 
        // System.out.println("Kein Gewinner in dieser Runde!");
        // Laut Regelwerk soll bei keinem Gewinner in der Runde
        // eine Doppelte Runde gespielt werden. D.h. in der nächsten
        // Runde werden 2 Karten aufgedeckt!
        // TODO
      
    gelegteKarten.clear();
    bestimmeGewinner();
  }

  public static void entferneDoppelteWerte(Map<Spieler, Karte> map) {
    Set<Integer> doppelteWerte = new HashSet<>();
    Set<Integer> alleWerte = new HashSet<>();

    for (Map.Entry<Spieler, Karte> entry : map.entrySet()) {
      int wert = entry.getValue().getWert();
      if (!alleWerte.add(wert)) {
        doppelteWerte.add(wert);
      }
    }

    Iterator<Map.Entry<Spieler, Karte>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Spieler, Karte> entry = iterator.next();
      if (doppelteWerte.contains(entry.getValue().getWert())) {
        iterator.remove();
      }
    }
  }
  

    public static int spielerHinzufügen(String name) {
    if (spielerListe.size() >= 10) {
      System.out.println("Das Spiel ist voll!!!");
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
    if (spielerListe.size() <= 3) {
      System.out.println("Nicht genug Spieler!!!");
      return 1;
    }
    System.out.println("Spiel startet!");
    spieleRunde(spielerListe);
    return 0;
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
    System.out.println("Der Gewinner ist:" + gewinner.getName() + " Mit der Punktzahl " + gewinner.getGesamtPunkte());
  }

  public static void finaleRunde(ArrayList<Spieler> gewinner) {
    System.out.println(gewinner.size() + " Spieler haben die gleiche Punktzahl! Finale Runde starten...");
    // ### TODO
    // spieleRunde sollte nur 1 Runde sein anstatt alle 10! sonst müssen die Gewinner 10 Runde spielen anstatt
    // nur eine Stichrunde...
    // Falls 2 oder mehr Spieler die gleiche Punktzahl haben, kommt die
    // Finale Runde
    spieleRunde(gewinner);
    
}
}
