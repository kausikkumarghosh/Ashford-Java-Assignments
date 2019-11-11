import java.util.Arrays;
import java.util.Comparator;


public class SortArray {
    public static void main(String args[]){
        //Array with address to sort
        String[][] userArray = new String[][]{
                {"0","Admin", "Password1"},
                {"1","Vale.Vicky", "Password1"},
                {"2","Lane.Lois", "Password1"},
                {"3","Kent.Clark", "Password1"},
                {"4","Wayne.Bruce", "Password1"},
                {"5","Parker.Peter", "Password1"},
                {"6","Rogers.Steve", "Password1"},
                {"7","Luther.Lex", "Password1"},
                {"8","Osborn.Harry", "Password1"},
                {"9","Prince.Diana", "Password1"},
                {"10","Linda.Zoel", "Password1"}};

        //Sort the array by name or column 2
        Arrays.sort(userArray, new ColumnComparator(1));

        //Print the sorted array
        for(int i=0; i<userArray.length; i++){
            String[] row = userArray[i];
            for(int j=0; j<row.length; j++) {
                System.out.print(row[j] + " , ");
            }
            System.out.print("\n");
        }

        //Search for Steve Rogers and print his information
        String user = "Rogers.Steve";
        for(int i=0; i<userArray.length; i++){
            String[] row = userArray[i];
            String name = row[1];
            if (user.compareTo(name)==0) {
                for (int j = 0; j < row.length; j++) {
                    System.out.print(row[j] + " , ");
                }
                System.out.print("\n");
            }
        }
    }
}

//Class that extends Comparator
class ColumnComparator implements Comparator {
    int columnToSort;
    ColumnComparator(int columnToSort) {
        this.columnToSort = columnToSort;
    }
    //overriding compare method
    public int compare(Object o1, Object o2) {
        String[] row1 = (String[]) o1;
        String[] row2 = (String[]) o2;
        //compare the columns to sort
        return row1[columnToSort].compareTo(row2[columnToSort]);
    }
}