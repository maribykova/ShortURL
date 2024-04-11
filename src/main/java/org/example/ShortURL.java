package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.net.URL;
public class ShortURL {
    private final  HashMap<String, String> shortToLong;
    private final HashMap<String, String> longToShort;
    private final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public ShortURL() {
        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();
    }
    public String shortenURL(String longURL) {
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }
        String shortUrl = generateShortURL();
        shortToLong.put(shortUrl, longURL);
        longToShort.put(longURL, shortUrl);
        return shortUrl;
    }
    public String expandURL(String shortURL) {
        String str = shortToLong.getOrDefault(shortURL, "");
        if (str.length()<1){
            return "There is no such short URL!";
        }
        return shortToLong.getOrDefault(shortURL, "");

    }
    private String generateShortURL() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(alpha.length());
            char randomChar = alpha.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    public Boolean isURL(String s){
        try {
            new URL(s).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        ShortURL tt = new ShortURL();
        String start = "Hi!\n" +
                "Here's what I can do:\n" +
                "1 - shorten the link\n" +
                "2 - restore the long link\n" +
                "3 - log out\n" +
                "What do you choose? Enter the  number: ";
        printLine(start);
        String str = "-111000";
        str = readLine();
        while(!(str.equals("1") || str.equals("2") || str.equals("3"))){
            printLine("I can't understand what you want. Please, write the correct number!");
            str = readLine();
        }
        //System.out.println(str);
        while (!(str.equals("3"))){
            if (str.equals("1")) {
                printLine("Write long URL: ");
                String long_url = readLine();
                if (tt.isURL(long_url)) {
                    String short_url = "n.ru/" + tt.shortenURL(long_url);
                    printLine(short_url);
                }
                else{
                    printLine("It's not URL. Choose 1, 2 or 3.");
                }
                printLine("Choose 1, 2 or 3.");
                str = readLine();
                while(!(str.equals("1") || str.equals("2") || str.equals("3"))) {
                    printLine("I can't understand what you want. Please, write the correct number!");
                    str = readLine();
                }
            }
            if (str.equals("2")){
                printLine("Write short URL: ");

                String short_url = readLine();

                    short_url = short_url.substring(5);
                    String long_url = tt.expandURL(short_url);
                    if (!long_url.equals("")){
                        printLine(long_url);
                }

                else{
                    printLine("It's not URL. Choose 1, 2 or 3.");
                }
                printLine("Choose 1, 2 or 3.");
                str = readLine();
                while(!(str.equals("1") || str.equals("2") || str.equals("3"))){
                    printLine("I can't understand what you want. Please, write the correct number!");
                    str = readLine();
                }
            }
        }
        printLine("Goodbye!");
    }
    private static String readLine(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str= br.readLine();
            return str;
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
    private static void printLine(String s){
        System.out.println(s);
        return;
    }
}