package com.kbu.exam.gsonparsing;

public class util {
    public String getLogInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 4) {
            StackTraceElement traceElement = stackTrace[4];
            String className = traceElement.getClassName();
            int lastDotIndex = className.lastIndexOf(".");
            if (lastDotIndex > 0 && lastDotIndex < className.length() - 1) {
                className = className.substring(lastDotIndex + 1);
            }
            return "[" + className + ":" + traceElement.getLineNumber() + "]";
        }
        return "";
    }
}
