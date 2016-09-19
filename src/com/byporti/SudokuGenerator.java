package com.byporti;

import java.util.Random;

public class SudokuGenerator {
    
    private static int[][] sudoku = new int[9][9];
    private static int[] rakamlar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    private static void SudokuAyarla() {
        
        // Satır için döngü
        for (int i = 1; i < rakamlar.length; i++) {
            // Satırlara uygun değer bulunamadığında uygun değerlerin birdaha aranabilmesini sağlamak için.
            boolean deger = true;
            // 0. cı satırdaki değer için.
            for (int j = 0; j < rakamlar.length; j++) {
                if (Uygunluk(i, 0, rakamlar[j])) {
                    sudoku[i][0] = rakamlar[j];
                    // 1.ci satırdaki değer için.
                    for (int j1 = 0; j1 < rakamlar.length; j1++) {
                        if (Uygunluk(i, 1, rakamlar[j1])) {
                            sudoku[i][1] = rakamlar[j1];
                            // 2.ci satırdaki değer için.
                            for (int j2 = 0; j2 < rakamlar.length; j2++) {
                                if (Uygunluk(i, 2, rakamlar[j2])) {
                                    sudoku[i][2] = rakamlar[j2];
                                    // 3.cü satırdaki değer için.
                                    for (int j3 = 0; j3 < rakamlar.length; j3++) {
                                        if (Uygunluk(i, 3, rakamlar[j3])) {
                                            sudoku[i][3] = rakamlar[j3];
                                            // 4.cü satırdaki değer için.
                                            for (int j4 = 0; j4 < rakamlar.length; j4++) {
                                                if (Uygunluk(i, 4, rakamlar[j4])) {
                                                    sudoku[i][4] = rakamlar[j4];
                                                    // 5.ci satırdaki değer için.
                                                    for (int j5 = 0; j5 < rakamlar.length; j5++) {
                                                        if (Uygunluk(i, 5, rakamlar[j5])) {
                                                            sudoku[i][5] = rakamlar[j5];
                                                            // 6.cı satırdaki değer için.
                                                            for (int j6 = 0; j6 < rakamlar.length; j6++) {
                                                                if (Uygunluk(i, 6, rakamlar[j6])) {
                                                                    sudoku[i][6] = rakamlar[j6];
                                                                    // 7.ci satırdaki değer için.
                                                                    for (int j7 = 0; j7 < rakamlar.length; j7++) {
                                                                        if (Uygunluk(i, 7, rakamlar[j7])) {
                                                                            sudoku[i][7] = rakamlar[j7];
                                                                            // 8.ci satırdaki değer için.
                                                                            for (int j8 = 0; j8 < rakamlar.length; j8++) {
                                                                                if (Uygunluk(i, 8, rakamlar[j8])) {
                                                                                    sudoku[i][8] = rakamlar[j8];
                                                                                    
                                                                                    deger = false;
                                                                                    // Döngüyü bitirdik.Eğer bitirmezsek döngüleri tamamiyle kontrol edip uygun olanını atardı.
                                                                                    // Örneğin 2. ci döngüde 5 sayısı geldi uygun.4.cü döngüde 3 sayısı feldi uygun.Sayı 3 oldu.
                                                                                    break;
                                                                                }
                                                                                // Değer = true ve son döngüdeki değerde olmadı.Bu yüzden bir önceki değeri
                                                                                // 0 yapıp tekrardan sayı denemesini istedim.
                                                                                // Bu kısımlarda diğer değerleri 0 yapmadığımız için sıkıntı olabileceğini düşünebiliriz.Yani 0 lağığımız
                                                                                // satır sonrasındaki değerleride koşula katıp işlem yapıcak ve yine ikilemde kalıcak gibi.Fakat açığa
                                                                                // kavuşturmak gerekirse o sayılar zaten kurallara uygun şekilde yerleştirilmiş, kurallara uygun olmayan
                                                                                // değerler için 0 değeri koyuyor biz 0 değeri yerine yeni bir sayı üretmesi için zaten bunu kullanıyoruz.
                                                                                // Yeni bir sayı üretilirken silmediğimiz yerler zaten uygun olduğu için hata vermeden yeni uygun bir sayı
                                                                                // üreticek ve sonrasında sonraki satırda SAYI OLSA BİLE tekrar kontrol yapıp daha uygun bir sayı koyucaktır.
                                                                                else if (deger && j8 == 8) {
                                                                                    sudoku[i][7] = 0;
                                                                                }
                                                                            }
                                                                        }
                                                                        else if (deger && j7 == 8) {
                                                                            sudoku[i][6] = 0;
                                                                            
                                                                        }
                                                                    }
                                                                }
                                                                else if (deger && j6 == 8) {
                                                                    sudoku[i][5] = 0;
                                                                }
                                                            }
                                                        }
                                                        else if (deger && j5 == 8) {
                                                            sudoku[i][4] = 0;
                                                        }
                                                    }
                                                }
                                                else if (deger && j4 == 8) {
                                                    sudoku[i][3] = 0;  
                                                }
                                            }
                                        }
                                        else if (deger && j3 == 8) {
                                            sudoku[i][2] = 0;
                                        }
                                    }
                                }
                                else if (deger && j2 == 8) {
                                    sudoku[i][1] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private static boolean SatirKosulKontrol(int i, int sayi) {
        
        for (int sutun = 0; sutun < 9; sutun++) {
            if (sudoku[i][sutun] == sayi)  {
                return false;
            }
        }
        return true;
    }
    private static boolean SutunKosulKontrol(int j, int sayi) {
        
        for (int satir = 0; satir < 9; satir++) {
            if (sudoku[satir][j] == sayi)  {
                return false;
            }
        }
        return true;
    }
    private static boolean KutuKosulKontrol(int i, int j, int sayi) {
        
        for (int satir = (i / 3) * 3; satir < (i / 3) * 3 + 3; satir++) {
            
            for (int sutun = (j / 3) * 3; sutun < (j / 3) * 3 + 3; sutun++) {
                
                if (sudoku[satir][sutun] == sayi) {
                    return false;
                }
            }
        }    
        return true;
    }
    
    private static boolean Uygunluk(int i, int j, int sayi) {
        
        if (SatirKosulKontrol(i, sayi)) {
            if (SutunKosulKontrol(j, sayi)) {
                if (KutuKosulKontrol(i, j, sayi)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static void SudokuIlkSatirAyarla(int[] dizi) {
        
        Random rand = new Random();
        
        int randomSayi;
        int temp;
        
        for (int i = 0; i < dizi.length; i++) {
        
            randomSayi = rand.nextInt(9);
            
            temp = dizi[i];
            dizi[i] = dizi[randomSayi];
            dizi[randomSayi] = temp;
        }
        // 1. Satırı ayarlama işlemi
        for(int i = 0; i < dizi.length; i++) {
            sudoku[0][i] = dizi[i];
        }
    }
    
    public static void main(String[] args) {
        
        SudokuIlkSatirAyarla(rakamlar);
        SudokuAyarla();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(" " + sudoku[i][j] + " ");
                if (j == 8)
                    System.out.println();
            }
        }
        
        System.out.println(CheckSudokuSolution.isValid(sudoku) ? "Sudoku Generate Doğru Çalıştı." : "Sudoku Generate Hata Yaptı.Sudoku YANLIŞ!!!!");
        
    }
    
    
}
