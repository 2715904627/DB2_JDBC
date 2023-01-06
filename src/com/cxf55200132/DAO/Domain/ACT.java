package com.cxf55200132.DAO.Domain;

public class ACT {
    private Integer ACTNO;
    private String ACTKWD;
    private String ACTDESC;

    public Integer getACTNO() {
        return ACTNO;
    }

    public void setACTNO(Integer ACTNO) {
        this.ACTNO = ACTNO;
    }

    public String getACTKWD() {
        return ACTKWD;
    }

    public void setACTKWD(String ACTKWD) {
        this.ACTKWD = ACTKWD;
    }

    public String getACTDESC() {
        return ACTDESC;
    }

    public void setACTDESC(String ACTDESC) {
        this.ACTDESC = ACTDESC;
    }

    public ACT(Integer ACTNO, String ACTKWD, String ACTDESC) {
        this.ACTNO = ACTNO;
        this.ACTKWD = ACTKWD;
        this.ACTDESC = ACTDESC;
    }

    public ACT() {
    }

    @Override
    public String toString() {
        return "ACT{" +
                "ACTNO=" + ACTNO +
                ", ACTKWD='" + ACTKWD + '\'' +
                ", ACTDESC='" + ACTDESC + '\'' +
                '}';
    }
}
