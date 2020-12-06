package infrastructure.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdTestLogger implements AbstractLogger {
    public static int counter = 0;

    @Override
    public void log(String operation) {
        System.out.println(getEntry(operation));
    }

    private String getEntry(String operation) {
        counter++;
        Date currentDate = new Date();
        String formatedDate = new SimpleDateFormat("HH:mm:ss.SSS").format(currentDate.getTime());
        return (counter + ") " + formatedDate + "[" + Thread.currentThread().getName() + "]: " + operation);
    }

    public void atFinish(){

    }
    public void atStart(){

    }
}

