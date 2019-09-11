package org.dragonpulse.rnd.progress.constants;


import java.util.HashMap;
import java.util.Map;

public enum Progress {

    METHOD1("method1", "25"),
    METHOD2("method2", "50"),
    METHOD3("method3", "75"),
    METHOD4("method4", "100"),
    INITIAL_METHOD("initiateCreation","0");

    private final String methodName;
    private final String progressPercent;

    private static final Map<String, String> PROGRESS_MAP = new HashMap<String, String>();
    static {
        for (Progress p : Progress.values()) {
            PROGRESS_MAP.put(p.methodName, p.progressPercent);
        }
    }

    private Progress(String methodName, String progressPercent) {
        this.methodName = methodName;
        this.progressPercent = progressPercent;
    }



    public static String getProgressPercentByMethodName(String methodName) {
        return PROGRESS_MAP.get(methodName);
    }

    public static boolean isMethodNameExists(String methodName){
        return PROGRESS_MAP.containsKey(methodName);
    }
}
