import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.WARN
import static ch.qos.logback.classic.Level.TRACE

import static ch.qos.logback.core.spi.FilterReply.ACCEPT
import static ch.qos.logback.core.spi.FilterReply.DENY

scan("120 seconds")
/**
 * Define constants for logback
 */
def LOG_HOME = "E:/log/dolphin"
def LOG_PATTERN = "%d{yy.MM.dd HH:mm:ss} [%thread] %-5level %logger{50} - %msg%n"
def LOG_SIZE = "30M"

appender("console", ConsoleAppender) {
    filter(LevelFilter) {
        level = ERROR
        onMatch = ACCEPT
        onMismatch = DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

appender("trace", RollingFileAppender) {
    filter(LevelFilter) {
        level = TRACE
        onMatch = ACCEPT
        onMismatch = DENY
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_HOME}/trace/trace.log.%d{yyyy-MM-dd}-%i.log"
        maxHistory = 30
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSizeAsString = "${LOG_SIZE}"
        }
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

appender("debug", RollingFileAppender) {
    filter(LevelFilter) {
        level = DEBUG
        onMatch = ACCEPT
        onMismatch = DENY
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_HOME}/debug/debug.log.%d{yyyy-MM-dd}-%i.log"
        maxHistory = 30
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSizeAsString = "${LOG_SIZE}"
        }
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

appender("info", RollingFileAppender) {
    filter(LevelFilter) {
        level = INFO
        onMatch = ACCEPT
        onMismatch = DENY
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_HOME}/info/info.log.%d{yyyy-MM-dd}-%i.log"
        maxHistory = 30
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSizeAsString = "${LOG_SIZE}"
        }
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

appender("warn", RollingFileAppender) {
    filter(LevelFilter) {
        level = WARN
        onMatch = ACCEPT
        onMismatch = DENY
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_HOME}/warn/warn.log.%d{yyyy-MM-dd}-%i.log"
        maxHistory = 30
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSizeAsString = "${LOG_SIZE}"
        }
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

appender("error", RollingFileAppender) {
    filter(LevelFilter) {
        level = ERROR
        onMatch = ACCEPT
        onMismatch = DENY
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_HOME}/error/error.log.%d{yyyy-MM-dd}-%i.log"
        maxHistory = 30
        timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP) {
            maxFileSizeAsString = "${LOG_SIZE}"
        }
    }
    encoder(PatternLayoutEncoder) {
        pattern = "${LOG_PATTERN}"
    }
}

logger("com.github.dolphin", INFO)
logger("org.apache.ibatis", DEBUG)
logger("java.sql.Connection", DEBUG)
logger("java.sql.Statement", DEBUG)
logger("druid.sql", DEBUG)
logger("java.sql.PreparedStatement", DEBUG)
logger("org.springframework.beans.factory", INFO)
root(INFO, ["console", "trace", "debug", "info", "warn", "error"])
