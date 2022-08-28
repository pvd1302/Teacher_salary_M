package Entity;

import sun.security.krb5.internal.APRep;

import java.util.Scanner;

public class MonHoc {
    public static int AUTO_ID = -1;
    private int maMH;
    private  String tenMH;
    private int tsTiet;
    private int stLT;
    private int mucKP;

    public MonHoc(){
        if (AUTO_ID==-1){
            AUTO_ID = 100;
            this.maMH=AUTO_ID;
            return;
        }
        this.maMH=++AUTO_ID;
    }

    public int getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getTsTiet() {
        return tsTiet;
    }

    public void setTsTiet(int tsTiet) {
        this.tsTiet = tsTiet;
    }

    public int getStLT() {
        return stLT;
    }

    public void setStLT(int stLT) {
        this.stLT = stLT;
    }

    public int getMucKP() {
        return mucKP;
    }

    public void setMucKP(int mucKP) {
        this.mucKP = mucKP;
    }

    @Override
    public String toString(){
        return "entity.MonHoc{"+
                "maMH"+maMH+
                ", tenMH='"+ tenMH + '\''+
                ", tsTiet='"+ tsTiet + '\''+
                ", stLT='"+ stLT + '\''+
                ", mucKP='"+ mucKP + '\''+
                '}';
    }

    public void nhapthongTinMH(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên môn học");
        this.tenMH=scanner.nextLine();
        System.out.println("Nhập tổng số tiết");
        this.tsTiet=scanner.nextInt();
        System.out.println("Nhập số tiết lý thuyết");
        this.stLT=scanner.nextInt();
        System.out.println("Mức kinh phí");
        this.mucKP=scanner.nextInt();

    }
}
