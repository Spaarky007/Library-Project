package com.newLibraryProjectt.LibraryProject.external;

public enum ErrorCodes {
    USER_NOT_FOUND{
        @Override
        public String getErrorMessage(){
            return "USER NOT FOUND";
        }
        @Override
        public  String getUserErrorMessage(){
            return "USER NOT FOUND IN REPOSITORY";
        }

        @Override
        public int getErrorCode(){
            return 1000;
        }

    },
    BOOK_NOT_FOUND {
        @Override
        public String getErrorMessage() {
            return "BOOK NOT FOUND";
        }

        @Override
        public String getUserErrorMessage() {
            return "BOOK NOT FOUND IN REPOSITORY";
        }

        @Override
        public int getErrorCode() {
            return 1001;
        }
    },
    ISSUE_NOT_FOUND {
        @Override
        public String getErrorMessage() {
            return "ISSUE NOT FOUND";
        }

        @Override
        public String getUserErrorMessage() {
            return "ISSUE NOT FOUND IN REPOSITORY";
        }

        @Override
        public int getErrorCode() {
            return 1002;
        }
    },
    INVALID_PAGE_REQUEST {
        @Override
        public String getErrorMessage() {
            return "INVALID PAGE REQUEST";
        }

        @Override
        public String getUserErrorMessage() {
            return "SORRY YOU DON'T HAVE ACCESS TO THIS PAGE";
        }

        @Override
        public int getErrorCode() {
            return 1003;
        }
    },
    MISSING_FIELD_EXCEPTION{
        @Override
        public String getErrorMessage(){
            return "FIELD NOT FOUND";
        }
        @Override
        public  String getUserErrorMessage(){
            return "SOME FIELDS ARE MISSING, PLEASE CHECK AGAIN";
        }

        @Override
        public int getErrorCode(){
            return 1005;
        }
    },
    AUTHOR_NOT_FOUND {
        @Override
        public String getErrorMessage() {
            return "AUTHOR NOT FOUND";
        }

        @Override
        public String getUserErrorMessage() {
            return "AUTHOR NOT FOUND IN REPOSITORY";
        }
        @Override
        public int getErrorCode(){
            return 1006;
        }

    },
    ;
    private static final String ERROR_MESSAGE = "Unknown error occurred";
    private static final String USER_ERROR_MESSAGE = "Sorry cant process now, please try again later";
    private static final int ERROR_CODE = 1111;

    public String getErrorMessage(){
        return  ERROR_MESSAGE;
    }

    public String getUserErrorMessage(){
        return USER_ERROR_MESSAGE;
    }

    public int getErrorCode(){
        return ERROR_CODE;
    }
}
