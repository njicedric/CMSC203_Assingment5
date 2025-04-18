
import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {
    
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<double[]> rows = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(" ");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            rows.add(row);
        }
        scanner.close();
        
        return rows.toArray(new double[0][]);
    }
    
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i]);
                if (i < row.length - 1) writer.print(" ");
            }
            writer.println();
        }
        writer.close();
    }
    
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }
    
    public static double getAverage(double[][] data) {
        int count = 0;
        double sum = 0;
        for (double[] row : data) {
            count += row.length;
            for (double value : row) {
                sum += value;
            }
        }
        return sum / count;
    }
    
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                total += value;
            }
        }
        return total;
    }
    
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                total += row[col];
            }
        }
        return total;
    }
    
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double highest = data[row][0];
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }
    
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1;
        }
        int index = 0;
        double highest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }
    
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double lowest = data[row][0];
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }
    
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1;
        }
        int index = 0;
        double lowest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }
    
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean found = false;
        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                found = true;
                if (row[col] > highest) {
                    highest = row[col];
                }
            }
        }
        return found ? highest : 0;
    }
    
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (data[i][col] > highest) {
                    highest = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }
    
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean found = false;
        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                found = true;
                if (row[col] < lowest) {
                    lowest = row[col];
                }
            }
        }
        return found ? lowest : 0;
    }
    
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col >= 0 && col < data[i].length) {
                if (data[i][col] < lowest) {
                    lowest = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }
    
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }
    
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}