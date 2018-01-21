package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants
    {
        public static final String Ex1 = "Server is not accessible for now.";
        public static final String Ex3 = "User is not authorized.";
        public static final String Ex5 = "User is banned.";
        public static final String Ex7 = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.Ex1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.Ex1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.Ex3);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.Ex3, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.Ex5);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.Ex5, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.Ex7);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.Ex7, cause);
        }
    }
}
