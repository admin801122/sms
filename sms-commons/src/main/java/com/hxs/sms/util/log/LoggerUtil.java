package com.hxs.sms.util.log;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

public class LoggerUtil {

  private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
      .getRootLogger();

  public static LoggerUtil getRootLogger() {
    return new LoggerUtil();
  }

  @SuppressWarnings("rawtypes")
  public static void trace(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isTraceEnabled()) {
      forcedLog(logger, Level.TRACE, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void trace(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isTraceEnabled()) {
      forcedLog(logger, Level.TRACE, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void debug(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isDebugEnabled()) {
      forcedLog(logger, Level.DEBUG, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void debug(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isDebugEnabled()) {
      forcedLog(logger, Level.DEBUG, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void info(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isInfoEnabled()) {
      forcedLog(logger, Level.INFO, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void info(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isInfoEnabled()) {
      forcedLog(logger, Level.INFO, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void warn(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.WARN)) {
      forcedLog(logger, Level.WARN, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void warn(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.WARN)) {
      forcedLog(logger, Level.WARN, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void error(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.ERROR)) {
      forcedLog(logger, Level.ERROR, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void error(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.ERROR)) {
      forcedLog(logger, Level.ERROR, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void fatal(Class classz, Object message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.FATAL)) {
      forcedLog(logger, Level.FATAL, message);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void fatal(Class classz, Object message, Throwable t) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (logger.isEnabledFor(Level.FATAL)) {
      forcedLog(logger, Level.FATAL, message, t);
    }
  }

  @SuppressWarnings("rawtypes")
  public static void assertLog(Class classz, boolean assertion, String message) {
    logger = org.apache.log4j.Logger.getLogger(classz);
    if (!assertion) {
      forcedLog(logger, Level.ERROR, message);
    }
  }

  private static void forcedLog(org.apache.log4j.Logger logger, Level level,
      Object message) {
    logger.callAppenders(new LoggingEvent(FQCN, logger, level, message, null));
  }

  private static void forcedLog(org.apache.log4j.Logger logger, Level level,
      Object message, Throwable t) {
    logger.callAppenders(new LoggingEvent(FQCN, logger, level, message, t));
  }

  private static final String FQCN;

  static {
    FQCN = LoggerUtil.class.getName();
  }
}