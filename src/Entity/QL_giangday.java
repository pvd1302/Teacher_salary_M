package Entity;

public class QL_giangday {
    private MonHoc monHoc;
    private int soLop;
    private double tienLuong;

    public MonHoc getMonHoc(){
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    @Override
    public String toString(){
        return "QL_giangday{" +
                "monHoc=" + monHoc +
                ", soLopGiangDay=" + soLop +
                '}';

    }
}
