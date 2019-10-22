package com.change.le.base;

/**
 * author shichangle
 * date 2019/10/22 0022 19:46
 */
public class JSONResponse {
    private int code;
    private String message;
    private Object data;
    private boolean flag;

    public JSONResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public JSONResponse() {
        this.code=Status.SUCCESS.getCode();
        this.message=Status.SUCCESS.getStandardMessage();
    }

    public static JSONResponse ofMessage(int code,String message){
        return new JSONResponse(code,message,null);
    }

    public static JSONResponse ofSuccess(Object data){
        return new JSONResponse(Status.SUCCESS.getCode(),Status.SUCCESS.getStandardMessage(),data);
    }

    public static JSONResponse ofStatus(Status status) {
        return new JSONResponse(status.getCode(),status.getStandardMessage(),null);
    }

    public enum Status{
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        NOT_FOUND(404,"NOT FOUND"),
        INTERNAL_SERVER_ERROR(500,"Unknown Internal Error"),
        NOT_VALID_PARAM(40005,"Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006,"Operation not supported"),
        NOT_LOGIN(50000,"Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }








    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
