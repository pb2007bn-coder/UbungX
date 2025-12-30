package h1;

public class H1_main {

    public static void main(String[] args) {
        int gridRows = 5;
        int gridCols = 5;

        // 1. Startzellen definieren (lebendig)
        Cell[] startCells = {
            new Cell(2, 1),
            new Cell(2, 2),
            new Cell(2, 3)
        };

        // 2. Grid erstellen
        Grid grid = new Grid(startCells, gridRows, gridCols);

        // 3. Startgeneration ausgeben
        System.out.println("Startgeneration:");
        printGrid(grid);

        // 4. Nächste 5 Generationen berechnen
        int n = 5;
        for (int i = 1; i <= n; i++) {
            grid.computeNextGen();  // eine Generation berechnen
            System.out.println("Generation " + i + ":");
            printGrid(grid);
        }
    }

    // Hilfsmethode zum Ausgeben des Grids
    private static void printGrid(Grid grid) {
        for (int row = 0; row < grid.getGridValues().length; row++) {
            for (int col = 0; col < grid.getGridValues()[0].length; col++) {
                // 1 = lebendig, 0 = tot
                System.out.print(grid.getGridValues()[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
