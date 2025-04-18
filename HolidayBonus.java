
public class HolidayBonus {
    public static final double HIGHEST_BONUS = 5000.0;
    public static final double LOWEST_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;
    
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        
        // Find max column count to know how many columns to process
        int maxCols = 0;
        for (double[] row : data) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        
        for (int col = 0; col < maxCols; col++) {
            // Find highest and lowest in this column
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            
            // Count how many stores are eligible for bonus in this category
            int eligibleStores = 0;
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    eligibleStores++;
                }
            }
            
            // Assign bonuses
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    if (eligibleStores == 1) {
                        // Only one store gets $5000
                        if (row == highIndex) {
                            bonuses[row] += HIGHEST_BONUS;
                        }
                    } else {
                        // Normal bonus assignment
                        if (row == highIndex) {
                            bonuses[row] += HIGHEST_BONUS;
                        } else if (row == lowIndex) {
                            bonuses[row] += LOWEST_BONUS;
                        } else {
                            bonuses[row] += OTHER_BONUS;
                        }
                    }
                }
            }
        }
        
        return bonuses;
    }
    
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}