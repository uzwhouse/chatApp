package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class WarningFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        String stackTrace = "\n";
        Throwable thrown = record.getThrown();
        if (thrown != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            thrown.printStackTrace(printWriter);
            stackTrace += stringWriter.toString();
        }

        return "%s :: [%d] :: %s :: [%s] %s"
                .formatted(record.getLevel(),
                        record.getLongThreadID(),
                        record.getLoggerName(),
                        record.getMessage(),
                        stackTrace);
    }
}
