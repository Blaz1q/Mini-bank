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
        ArrayList<String> finalLogs = logs;
        for (String finalLog : finalLogs) {
            System.out.println(finalLog);
        }
    }
}
