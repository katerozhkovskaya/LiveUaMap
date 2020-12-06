package infrastructure.logging;

public interface AbstractLogger {
    public  static final String WELCOME_MESSAGE="Test suit started at %s";
    public  static final String FINAL_MESSAGE="Test suit finished at %s";

    void log(String msg);
    void atFinish();
    void atStart();
}
