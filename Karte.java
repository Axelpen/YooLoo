public class Karte {

    private int wert;
    private String farbe;
    private String art;
    
    public Karte(int wert, String farbe, String art){
        this.wert = wert;
        this.farbe = farbe;
        this.art = art;
    }

    public int getWert(){
      return wert;
    }

    @Override
    public String toString() {
        return "Karte{" +
                "wert=" + wert +
                ", farbe='" + farbe + '\'' +'}';
    }
}
