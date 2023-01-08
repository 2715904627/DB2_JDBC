package com.cxf55200132.DAO.Domain;

import java.sql.Date;

public class TEMPL {
    String EMPNO;
    String FIRSTNME;
    String MIDINIT;
    String LASTNAME;
    String WORKDEPT;
    String PHONENO;
    Date HIREDATE ;
    String JOB;
    int EDLEVEL;
    String SEX;
    Date BIRTHDATE;
    String SALARY;
    String BONUS;
    String COMM;

    public TEMPL() {

    }

    public String getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(String EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getFIRSTNME() {
        return FIRSTNME;
    }

    public void setFIRSTNME(String FIRSTNME) {
        this.FIRSTNME = FIRSTNME;
    }

    public String getMIDINIT() {
        return MIDINIT;
    }

    public void setMIDINIT(String MIDINIT) {
        this.MIDINIT = MIDINIT;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getWORKDEPT() {
        return WORKDEPT;
    }

    public void setWORKDEPT(String WORKDEPT) {
        this.WORKDEPT = WORKDEPT;
    }

    public String getPHONENO() {
        return PHONENO;
    }

    public void setPHONENO(String PHONENO) {
        this.PHONENO = PHONENO;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public int getEDLEVEL() {
        return EDLEVEL;
    }

    public void setEDLEVEL(int EDLEVEL) {
        this.EDLEVEL = EDLEVEL;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public Date getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(Date BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    public String getSALARY() {
        return SALARY;
    }

    public void setSALARY(String SALARY) {
        this.SALARY = SALARY;
    }

    public String getBONUS() {
        return BONUS;
    }

    public void setBONUS(String BONUS) {
        this.BONUS = BONUS;
    }

    public String getCOMM() {
        return COMM;
    }

    public void setCOMM(String COMM) {
        this.COMM = COMM;
    }

    public TEMPL(String EMPNO, String FIRSTNME, String MIDINIT, String LASTNAME, String WORKDEPT, String PHONENO, Date HIREDATE, String JOB, int EDLEVEL, String SEX, Date BIRTHDATE, String SALARY, String BONUS, String COMM) {
        this.EMPNO = EMPNO;
        this.FIRSTNME = FIRSTNME;
        this.MIDINIT = MIDINIT;
        this.LASTNAME = LASTNAME;
        this.WORKDEPT = WORKDEPT;
        this.PHONENO = PHONENO;
        this.HIREDATE = HIREDATE;
        this.JOB = JOB;
        this.EDLEVEL = EDLEVEL;
        this.SEX = SEX;
        this.BIRTHDATE = BIRTHDATE;
        this.SALARY = SALARY;
        this.BONUS = BONUS;
        this.COMM = COMM;
    }

    @Override
    public String toString() {
        return "TEMPL{" +
                "EMPNO='" + EMPNO + '\'' +
                ", FIRSTNME='" + FIRSTNME + '\'' +
                ", MIDINIT='" + MIDINIT + '\'' +
                ", LASTNAME='" + LASTNAME + '\'' +
                ", WORKDEPT='" + WORKDEPT + '\'' +
                ", PHONENO='" + PHONENO + '\'' +
                ", HIREDATE=" + HIREDATE +
                ", JOB='" + JOB + '\'' +
                ", EDLEVEL=" + EDLEVEL +
                ", SEX='" + SEX + '\'' +
                ", BIRTHDATE=" + BIRTHDATE +
                ", SALARY='" + SALARY + '\'' +
                ", BONUS='" + BONUS + '\'' +
                ", COMM='" + COMM + '\'' +
                '}';
    }
}
