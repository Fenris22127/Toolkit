package de.toolkit.logging.colorlogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static de.fenris.logger.FormatColor.*;

public class LogFormatter extends Formatter {
    private static String severeColor = RED_BOLD_BRIGHT.getColor();
    private static String warningColor = YELLOW_BRIGHT.getColor();
    private static String infoColor = GREEN_BACKGROUND.getColor();
    private static String configColor = CYAN.getColor();
    private static String fineColor = BLUE.getColor();
    private static String finerColor = PURPLE.getColor();
    private static String finestColor = BLACK_BRIGHT.getColor();

    public LogFormatter() {
        //Empty constructor
    }

    public String format(LogRecord logRecord) {
        StringBuilder builder = new StringBuilder();
        builder.append(LogFormatter.getLevelColor(logRecord.getLevel()));
        builder.append("[");
        builder.append(calcDate(logRecord.getMillis()));
        builder.append("]");
        builder.append(" [");
        builder.append(logRecord.getSourceClassName());

        builder.append("]");
        builder.append(" [");
        builder.append(logRecord.getLevel().getName());
        builder.append("]");
        builder.append(WHITE.getColor());
        if (logRecord.getLevel() == Level.INFO || logRecord.getLevel() == Level.FINE) {
            builder.append("\t\t - ");
        }
        else {
            builder.append("\t - ");
        }
        builder.append(logRecord.getMessage());
        Object[] params = logRecord.getParameters();
        if (params != null) {
            builder.append("\t");

            for(int i = 0; i < params.length; ++i) {
                builder.append(params[i]);
                if (i < params.length - 1) {
                    builder.append(", ");
                }
            }
        }

        builder.append(RESET.getColor());
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    private static String calcDate(long milliSecs) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(milliSecs);
        return dateFormat.format(resultDate);
    }

    private static String getLevelColor(Level level) {
        return switch (level.toString()) {
            case "SEVERE" -> severeColor;
            case "WARNING" -> warningColor;
            case "INFO" -> infoColor;
            case "CONFIG" -> configColor;
            case "FINE" -> fineColor;
            case "FINER" -> finerColor;
            case "FINEST" -> finestColor;
            default -> WHITE.getColor();
        };
    }

    private static void setLevelColor(Level level, FormatColor color) {
        switch (level.toString()) {
            case "SEVERE" -> severeColor = color.getColor();
            case "WARNING" -> warningColor = color.getColor();
            case "INFO" -> infoColor = color.getColor();
            case "CONFIG" -> configColor = color.getColor();
            case "FINE" -> fineColor = color.getColor();
            case "FINER" -> finerColor = color.getColor();
            case "FINEST" -> finestColor = color.getColor();
            default -> color.getColor();
        }
    }
}

