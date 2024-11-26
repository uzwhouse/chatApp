package user;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;

public class UserFileHandler extends FileHandler {
    public UserFileHandler() throws IOException, SecurityException {
        super();
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
