package com.change.le.base;

/**
 * Datatables相应结构
 * author shichangle
 * date 2019/11/11 0011 18:42
 */
public class ApiDataTableResponse extends JSONResponse {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;

    public ApiDataTableResponse(JSONResponse.Status status) {

        this(status.getCode(),status.getStandardMessage(),null);
    }

    public ApiDataTableResponse(int code, String message, Object data) {
        super(code, message, data);
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
