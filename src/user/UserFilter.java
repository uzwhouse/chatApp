package user;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class UserFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return Level.CONFIG.equals(record.getLevel());
    }
}
