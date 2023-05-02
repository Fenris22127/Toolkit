package de.toolkit.logging.colorlogger;

import java.util.logging.*;

public class ColorLogger extends Logger {


    protected ColorLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public static Logger newLogger(String name) {
        Logger logger = Logger.getLogger(name);
        Handler handlerObj = new ConsoleHandler();
        handlerObj.setLevel(Level.ALL);
        Formatter formatter = new LogFormatter();
        handlerObj.setFormatter(formatter);
        logger.addHandler(handlerObj);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        return logger;
    }
}