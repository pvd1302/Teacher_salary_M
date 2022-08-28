package Entity;

public class QL_kekhai {
    private GiangVien giangVien;
    private  MonHoc monHoc;
    private QL_giangday[] ql_giangday;

    public QL_giangday[] getQl_giangday(){
        return ql_giangday;
    }

    private QL_giangday[] ql_giangdays;
    private QL_LuongGV[] ql_luongGVS;

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public QL_giangday[] getQl_giangdays() {
        return ql_giangdays;
    }

    public void setQl_giangday(QL_giangday[] ql_giangday) {
        this.ql_giangday = ql_giangday;
    }

    public QL_LuongGV[] getQl_luongGVS() {
        return ql_luongGVS;
    }

    public void setQl_luongGVS(QL_LuongGV[] ql_luongGVS) {
        this.ql_luongGVS = ql_luongGVS;
    }
}
