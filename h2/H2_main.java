package h2;

public class H2_main {
    public static void main(String[] args) {
        // 1. Spielbrett erstellen (z. B. 3x3)
        Spielbrett brett = new Spielbrett(3);

        // 2. Felder auf dem Brett initialisieren
        brett.getBrett()[0][0] = new Feld(false, 'D');
        brett.getBrett()[0][1] = new Feld(false, 'R');
        brett.getBrett()[0][2] = new Feld(true, 'L');
        brett.getBrett()[1][0] = new Feld(false, 'R');
        brett.getBrett()[1][1] = new Feld(false, 'D');
        brett.getBrett()[1][2] = new Feld(false, 'L');
        brett.getBrett()[2][0] = new Feld(true, 'U');
        brett.getBrett()[2][1] = new Feld(false, 'R');
        brett.getBrett()[2][2] = new Feld(false, 'U');

        // 3. Spielstein erstellen mit Startposition (0,0)
        Spielstein spielstein = new Spielstein(brett, 0, 0);

        // 4. Startposition ausgeben
        System.out.println("Startposition: (" + spielstein.getCurrentRow() + ", " + spielstein.getCurrentCol() + ")");
        brett.printBrett(spielstein);
        // 5. Spielstein 5 Züge ausführen
        spielstein.go(5);

        // 6. Endposition ausgeben
        System.out.println("Endposition nach 5 Zügen: (" + spielstein.getCurrentRow() + ", " + spielstein.getCurrentCol() + ")");
        brett.printBrett(spielstein);
    }
    
    
}
