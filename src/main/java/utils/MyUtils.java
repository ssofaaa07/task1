package utils;

import ru.vsu.cs.vvp2021.g12.butovetskaya_s_i.task10.n28.Apartment;
import ru.vsu.cs.vvp2021.g12.butovetskaya_s_i.task10.n28.Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyUtils {
    // работа с классами
    public static String[][] toMatrixFromList(List<String> list) {
        String[][] matrix = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            String[] mean = list.get(i).split(" ");
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = mean[j];
            }
        }
        return matrix;
    }

    public static List<Apartment> toApartmentFromMatrix(String[][] matrix) {
        List<Apartment> apartments = new ArrayList<>();

        for (String[] strings : matrix) {
            Apartment apart = new Apartment();
            apart.setRegion(strings[0]);
            apart.setRooms(Integer.parseInt(strings[1]));
            apart.setTotalarea(Double.parseDouble(strings[2]));
            apart.setKitchenarea(Double.parseDouble(strings[3]));
            apart.setPrice(Double.parseDouble(strings[4]));
            apartments.add(apart);
        }
        return apartments;
    }

    public static String[][] toMatrixFromApartment(List<Apartment> apartments) {
        String[][] matrix = new String[apartments.size()][5];
        for (int i = 0; i < apartments.size(); i++) {
            matrix[i][0] = apartments.get(i).getRegion();
            matrix[i][1] = String.valueOf(apartments.get(i).getRooms());
            matrix[i][2] = String.valueOf(apartments.get(i).getTotalarea());
            matrix[i][3] = String.valueOf(apartments.get(i).getKitchenarea());
            matrix[i][4] = String.valueOf(apartments.get(i).getPrice());
        }
        return matrix;
    }

    public static Filter toFilterFromList(String list) {
        String[] mean = list.split(" ");
        return new Filter(mean[0], mean[1],
                mean[2], mean[3],
                mean[4], mean[5],
                mean[6], mean[7]);
    }

    public static List<Apartment> toApartmentFromString(List<String> listFromFile) {
        List<Apartment> apartments = new ArrayList<>();

        for (int i = 0; i < listFromFile.size(); i++) {
            String[] mean = listFromFile.get(i).split(" ");
            Apartment apart = new Apartment();
            apart.setRegion(mean[0]);
            apart.setRooms(Integer.parseInt(mean[1]));
            apart.setTotalarea(Double.parseDouble(mean[2]));
            apart.setKitchenarea(Double.parseDouble(mean[3]));
            apart.setPrice(Integer.parseInt(mean[4]));
            apartments.add(apart);
        }
        return apartments;
    }

    //работа с файлом
    public static void writeMatrixToFile(String fileName, String[][] arr)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (String[] strings : arr) {
                for (int j = 0; j < arr[0].length; j++) {
                    out.print(strings[j] + " ");
                }
                out.println();
            }
        }
    }

    public static List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }
}

//    public static List<String> toListFromProperty(List<Property> property) {
//        List<String> list = new ArrayList<>();
//        for (Property value : property) {
//            list.add(value.parametersProperty());
//        }
//        return list;
//    }

