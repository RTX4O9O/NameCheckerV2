package me.rtx4090;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("$$\\      $$\\ $$\\                                                   $$$$$$\\    $$\\           $$\\   $$\\                                          $$$$$$\\  $$\\                           $$\\                           ");
        System.out.println("$$$\\    $$$ |\\__|                                                 $$  __$$\\   $$ |          $$$\\  $$ |                                        $$  __$$\\ $$ |                          $$ |                          ");
        System.out.println("$$$$\\  $$$$ |$$\\ $$$$$$$\\   $$$$$$\\   $$$$$$$\\  $$$$$$\\  $$$$$$\\  $$ /  \\__|$$$$$$\\         $$$$\\ $$ | $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$ /  \\__|$$$$$$$\\   $$$$$$\\   $$$$$$$\\ $$ |  $$\\  $$$$$$\\   $$$$$$\\  ");
        System.out.println("$$\\$$\\$$ $$ |$$ |$$  __$$\\ $$  __$$\\ $$  _____|$$  __$$\\ \\____$$\\ $$$$\\     \\_$$  _|        $$ $$\\$$ | \\____$$\\ $$  _$$  _$$\\ $$  __$$\\       $$ |      $$  __$$\\ $$  __$$\\ $$  _____|$$ | $$  |$$  __$$\\ $$  __$$\\ ");
        System.out.println("$$ \\$$$  $$ |$$ |$$ |  $$ |$$$$$$$$ |$$ /      $$ |  \\__|$$$$$$$ |$$  _|      $$ |          $$ \\$$$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |      $$ |      $$ |  $$ |$$$$$$$$ |$$ /      $$$$$$  / $$$$$$$$ |$$ |  \\__|");
        System.out.println("$$ |\\$  /$$ |$$ |$$ |  $$ |$$   ____|$$ |      $$ |     $$  __$$ |$$ |        $$ |$$\\       $$ |\\$$$ |$$  __$$ |$$ | $$ | $$ |$$   ____|      $$ |  $$\\ $$ |  $$ |$$   ____|$$ |      $$  _$$<  $$   ____|$$ |      ");
        System.out.println("$$ | \\_/ $$ |$$ |$$ |  $$ |\\$$$$$$$\\ \\$$$$$$$\\ $$ |     \\$$$$$$$ |$$ |        \\$$$$  |      $$ | \\$$ |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\       \\$$$$$$  |$$ |  $$ |\\$$$$$$$\\ \\$$$$$$$\\ $$ | \\$$\\ \\$$$$$$$\\ $$ |      ");
        System.out.println("\\__|     \\__|\\__|\\__|  \\__| \\_______| \\_______|\\__|      \\_______|\\__|         \\____/       \\__|  \\__| \\_______|\\__| \\__| \\__| \\_______|       \\______/ \\__|  \\__| \\_______| \\_______|\\__|  \\__| \\_______|\\__|");
        System.out.println("  _           ___ _______  __");
        System.out.println(" | |__ _  _  | _ \\_   _\\ \\/ /");
        System.out.println(" | '_ \\ || | |   / | |  >  < ");
        System.out.println(" |_.__/\\_, | |_|_\\ |_| /_/\\_\\");
        System.out.println("       |__/");



        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入單字列表檔案的路徑：");
        String filePath = scanner.nextLine();
        ArrayList<String> availableIGN = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String string = line.trim();
                if (string.length() >= 3 && string.length() <= 16 && isValidString(string)) {
                    boolean isNameAvailable = checkNameAvailability(string);
                    if (isNameAvailable) {
                        System.out.println("[CHECK]  " + string);
                        availableIGN.add(string);
                    } else {
                        System.out.println("[CROSS]  "+ string);
                    }
                } else {
                    System.out.println("[CROSS]  "+ string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String ign :availableIGN) {
            System.out.println("可用ign: ");
            System.out.println(ign);
        }
    }

    private static boolean checkNameAvailability(String name) {
        try {
            String url = "https://api.mojang.com/users/profiles/minecraft/" + name;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_NOT_FOUND;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean isValidString(String input) {
        // Use a regular expression to match the input against the pattern
        // The pattern "[a-zA-Z0-9_]*" matches strings containing only alphabets, numbers, and underscores
        return input.matches("[a-zA-Z0-9_]*");
    }

}