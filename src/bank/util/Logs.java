package bank.util;

import bank.domain.Exportable;

import java.util.ArrayList;

public final class Logs implements Exportable {


    private static ArrayList<String> logs = new ArrayList<>();
    public static void Log(String message){
        System.out.println(message);
        logs.add(message);
    }

    @Override
    public void export() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.File("historia_banku.csv"))) {
            writer.println("Typ;Wiadomość");
            for (String log : logs) {
                writer.println(log.replaceFirst(": ", ";"));
            }
            System.out.println("Pomyślnie wygenerowano plik: historia_banku.csv");
        } catch (java.io.IOException e) {
            System.out.println("Błąd zapisu pliku: " + e.getMessage());
        }
    }
}
