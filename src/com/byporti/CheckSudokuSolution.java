package com.byporti;


import java.util.Scanner;

/**
 *
 * @author byporti
 */
public class CheckSudokuSolution {
    
    //public static void main(String[] args) {
    //    
    //    // Girilecek sudokuyu dizi içerisinde saklamak için.
    //    int[][] grid = readASolution();
    //    
    //    //True veya false dönmesine göre yazılacak string
    //    System.out.println(isValid(grid) ? "Valid Solution:" :
    //            "Invalid Solution");
    //    
    //}
    
    // Klavyeden sudokuyu alıp alma işlemi bitince sudokunun kaydedildiği
    // diziyi geri döndürür.
    public static int[][] readASolution() {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a Sudoku puzzle solution:");
        // 9 a 9 luk dizimizi tanımladık.
        int grid[][] = new int[9][9];
        
        // değerleri alalım.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        return grid;
    }
    
    // Sudoku dizisini alıp belirli koşulları inceleyip buna göre sudoku
    // doğru ise true yanlış ise false bilgisini geri döndürür.
    public static boolean isValid(int[][] grid) {
        
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                /*1.Eğer girilen değer 1 den küçükse yada
                  2.Eğer girilen değer 9 dan büyükse yada
                  3.Eğer isValid(); false dönerse
                */
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /* Sudoku dizisini SATIR VE SUTUN bilgileriyle birlikte alıp gerekli
       koşullara bakarak true yada false döndürür.
    */
    public static boolean isValid(int i, int j, int[][] grid) {
        
        /* column!= j yani bakacağımız sutun j sutunundan farklı olucak ve
        grid[i][column] == grid[i][j] bakılan sutun j sutunu değeriyle aynı
        olucak kısaca satırlar aynı sutunlar farklı olma durumu
        */
        for(int column = 0; column < 9; column++) {
            // Aynı sutunda aynı değer olması durumunda false döndür.
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
        }
        
        for(int row = 0; row < 9; row++) {
            // Aynı satırda aynı değer olması durumunda false döndür.
            if (row!= i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }
        
        // 3 e 3 lük şekilde sudokuyu alıp gereken koşullara bakmak için.
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            
            for (int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++) {
                // Farklı satır ve sutunlar aynı değer durumunda false döndür.
                if(row != i && column != j && grid[row][column] == grid[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

