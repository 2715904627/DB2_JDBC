package com.cxf55200132.DAO.Domain;

import com.cxf55200132.ui.Blob;

public class Emp_Photo {
    public Emp_Photo() {
    }

    public Emp_Photo(String EMPNO, String PHOTO_FORMAT) {
        this.EMPNO = EMPNO;
        this.PHOTO_FORMAT = PHOTO_FORMAT;
    }

    public String getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(String EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getPHOTO_FORMAT() {
        return PHOTO_FORMAT;
    }

    public void setPHOTO_FORMAT(String PHOTO_FORMAT) {
        this.PHOTO_FORMAT = PHOTO_FORMAT;
    }

    @Override
    public String toString() {
        return "Emp_Photo{" +
                "EMPNO='" + EMPNO + '\'' +
                ", PHOTO_FORMAT='" + PHOTO_FORMAT + '\'' +
                '}';
    }

    private String EMPNO;
    private String PHOTO_FORMAT;


}
