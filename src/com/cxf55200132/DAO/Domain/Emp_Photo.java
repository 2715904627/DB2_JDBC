package com.cxf55200132.DAO.Domain;

import com.cxf55200132.ui.Blob;

public class Emp_Photo {
    private String EMPNO;
    private String PHOTO_FORMAT;
    private Blob PICTURE;

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

    public Blob getPICTURE() {
        return PICTURE;
    }

    public void setPICTURE(Blob PICTURE) {
        this.PICTURE = PICTURE;
    }




    public Emp_Photo(String EMPNO, String PHOTO_FORMAT, Blob PICTURE) {
        this.EMPNO = EMPNO;
        this.PHOTO_FORMAT = PHOTO_FORMAT;
        this.PICTURE = PICTURE;
    }




    public Emp_Photo() {
    }

    @Override
    public String toString() {
        return "Emp_Photo{" +
                "EMPNO='" + EMPNO + '\'' +
                ", PHOTO_FORMAT='" + PHOTO_FORMAT + '\'' +
                ", PICTURE=" + PICTURE +
                '}';
    }
}
