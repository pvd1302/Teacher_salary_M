import Entity.MonHoc;
import Entity.GiangVien;
import Entity.QL_giangday;
import Entity.QL_kekhai;

import java.util.Scanner;

public class MainRun {
    Scanner scanner = new Scanner(System.in);
    private static final GiangVien[] GIANGVIEN = new GiangVien[100];
    private static MonHoc[] MONHOC = new MonHoc[100];
    private static QL_kekhai[] QLKK = new QL_kekhai[100];

    public static void main(String[] args) {

        showMenu();
    }

    public static void showMenu() {
        DulieuGV();
        DulieuMH();
        while (true){
            int functionChoice=functionChoice();
            switch (functionChoice){
                case 1:
                    NhapMonhoc();
                    break;
                case 2:
                    HienThiMonHoc();
                    break;
                case 3:
                    NhapGiangVien();
                    break;
                case 4:
                    HienThiGiangVien();
                    break;
                case 5:
                    CreateQLKeKhaiGiangDay();
                    showQLKeKhaiGiangDay();
                    break;
                case 6:
                    showQLKeKhaiGiangDay();
                    break;
                case 7:
                    sapXepDSTheoTen();
                    showQLKeKhaiGiangDay();
                    break;
                case 8:
                    sapXepDSTheoSoTietGiangDay();
                    showQLKeKhaiGiangDay();
                    break;
                case 9:
                    lapBangTinhLuong();
                    break;
            }
        }
    }

    private static int functionChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============QUẢN LÝ TRẢ LƯƠNG CHO NHÂN VIÊN THỈNH GIẢNG==============");
        System.out.println("1. Nhập danh sách môn học mới: ");
        System.out.println("2. Nhập danh sách giảng viên mới: ");
        System.out.println("3. Hiện danh sách bảng kê khai giảng dạy: ");
        System.out.println("4. Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên");
        System.out.println("5. Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn (giảm dần)");
        System.out.println("6. Bảng tính tiền cho giảng viên:  ");
        System.out.println("7. Thoát chương trình");
        System.out.println("======================================================================");
        System.out.println("Mời nhập lựa chọn !!");

        int choice = -1;
        do {
            choice = sc.nextInt();
            if (choice < 7 && choice >= 1) {
                break;
            }
        } while (choice > 7 || choice < 1);
        return functionChoice();
    }
    public static void DulieuGV(){}
    public static void DulieuMH(){}
    private static void NhapMonhoc(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số môn học muốn thêm");
        int slmonhoc=sc.nextInt();
        for (int i = 0; i < slmonhoc; i++) {
            System.out.println("Nhập thông tin môn học thứ "+i+" : ");
            MonHoc monHoc=new MonHoc();
            monHoc.nhapthongTinMH();

            //lưu thông tin môn học
            SaveMonHoc(monHoc);
        }
    }
    private   static void SaveMonHoc(MonHoc monHoc){
        for (int i = 0; i < MONHOC.length; i++) {
            if(MONHOC[i]==null){
                MONHOC[i]=new MonHoc();
                break;
            }
        }
    }

    private static void HienThiMonHoc(){
        for (int i = 0; i < MONHOC.length; i++) {
            if(MONHOC[i]==null){
                continue;
            }
            System.out.println(MONHOC[i]);
        }
    }
    private static void NhapGiangVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng giảng viên muốn thêm: ");
        int slGV = sc.nextInt();
        for (int i = 0; i < slGV; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i = 1));

            GiangVien gv = new GiangVien();
            gv.nhapThongTinGV();

            luuGiangvien(gv);
        }
    }

    private static void luuGiangvien(GiangVien giangVien) {
        for (int i = 0; i < GIANGVIEN.length; i++) {
            if (GIANGVIEN[i] == null) {
                GIANGVIEN[i] = giangVien;
                break;
            }
        }
    }

    private static void HienThiGiangVien() {
        for (int i = 0; i < GIANGVIEN.length; i++) {
            if (GIANGVIEN[i] == null) {
                continue;
            }
            System.out.println(GIANGVIEN[i]);
        }
    }

    private static QL_giangday[] CreateQLKeKhaiGiangDay(){
        Scanner sc=new Scanner(System.in);
        if(!CheckData()){
            System.out.println("Hiện tại chưa có danh sách, vui lòng thêm dữ liêu");
            return new QL_giangday[0];
        }
        System.out.print("Nhập số lượng kê khai giảng viên:");
        int slkekhai=sc.nextInt();
        for (int i = 0; i < slkekhai; i++) {
            QL_kekhai ql_kekhai_ =new QL_kekhai();
            GiangVien gv=nhapGVKK(i);

            ql_kekhai_.setGiangVien(gv);

            QL_giangday[] chiTietGiangDays=CreateQLKeKhaiGiangDay();
            ql_kekhai_.setQl_giangday(chiTietGiangDays);
            //lưu kê khai

            SaveQLGD(ql_kekhai_);
        }
        return new QL_giangday[0];
    }

    private  static void showQLKeKhaiGiangDay(){
        for (int i = 0; i <QLKK.length ; i++) {
            QL_kekhai KKGD=QLKK[i];
            if(KKGD!=null){
                System.out.println("Giang viên "+KKGD.getGiangVien().getHoTen()+"đã chọn môn học sau:");
                for (int j = 0; j < KKGD.getQl_giangday().length; j++) {
                    System.out.println(KKGD.getQl_giangday()[j]);

                }
                System.out.println("===================");
            }
        }
    }
    private  static void SaveQLGD(QL_kekhai ql_kekhai_){
        for (int i = 0; i < QLKK.length; i++) {
            if(QLKK[i]==null){
                QLKK[i]= ql_kekhai_;
                return;
            }
        }
    }

    private static GiangVien nhapGVKK(int index){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã giảng viên thứ "+(index+1)+"muốn kê khai:");
        int maGiangVien;
        GiangVien giangVien;
        do {
            maGiangVien=sc.nextInt();
            giangVien=searchGiangVienByID(maGiangVien);
            if(searchGiangVienByID(maGiangVien)!=null){
                break;
            }
            System.out.println("Không tồn tại mã giảng viên");
        }while (true);

        return giangVien;
    }
    private static GiangVien searchGiangVienByID(int maGV){
        for (int i = 0; i <GIANGVIEN.length ; i++) {
            GiangVien gv=GIANGVIEN[i];
            if(gv!=null&&gv.getMaGV()==maGV){
                return gv;
            }
        }
        return null;
    }

    private static MonHoc nhapMonHoc(int index){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã môn học thứ "+(index+1)+":");
        int maMonhoc;
        MonHoc monHoc;
        do {
            maMonhoc=sc.nextInt();
            monHoc=searchMonHocByID(maMonhoc);
            if(searchMonHocByID(maMonhoc)!=null){
                break;
            }
            System.out.println("Không tồn tại mã môn học");
        }while (true);
        return monHoc;
    }
    private static MonHoc searchMonHocByID(int maMonhoc){
        for (int i = 0; i < MONHOC.length; i++) {
            MonHoc monHoc=MONHOC[i];
            if(monHoc!=null&&monHoc.getMaMH()==maMonhoc){
                return monHoc;
            }
        }
        return null;
    }
   
    private static boolean CheckData(){
        boolean coDulieuGiangvien=false;

        for (int i = 0; i < GIANGVIEN.length; i++) {
            if(GIANGVIEN[i]!=null){
                coDulieuGiangvien=true;
                break;
            }
        }

        boolean coDulieuMonhoc=false;
        for (int i = 0; i <MONHOC.length ; i++) {
            if(MONHOC[i]!=null);
            coDulieuMonhoc=true;
            break;
        }
        return coDulieuMonhoc&&coDulieuGiangvien;
    }

    private static QL_giangday[] CreateQLgiangday(){
        System.out.println("Nhập số lượng môn học giảng viên muốn đăng ký:");
        int slmonhoc=new Scanner(System.in).nextInt();


        QL_giangday[] ql_giangdays=new QL_giangday[slmonhoc];
        for (int i = 0; i <slmonhoc ; i++) {
            QL_giangday ql_giangday=new QL_giangday();
            //xác định giảng viên dạy môn nào
            //yêu cầu nhập mã môn muốn dạy
            MonHoc monHoc=nhapMonHoc(i);

            //lưu đầu sách tìm được vào chi tiết giảng dạy(chi tiết giảng dạy)
            ql_giangday.setMonHoc(monHoc);

            System.out.print("Nhập số lopws muốn dạy:");
            int soLop;
            do {
                soLop=new Scanner(System.in).nextInt();
                if(soLop<10&&soLop>=1){
                    break;
                }
            }while (true);
            ql_giangday.setSoLop(soLop);




            //lưu chitiet giảng dạy vừa nhập
            for (int j = 0; j <ql_giangdays.length ; j++) {
                if(ql_giangdays[i]==null){
                    ql_giangdays[i]=ql_giangday;
                    break;
                }
            }
        }
        return ql_giangdays;
    }
    private static void sapXepDSTheoTen(){
        int n = QLKK.length;

        QL_kekhai temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QL_kekhai qlms1=QLKK[i];

                QL_kekhai qlms2=QLKK[j];
                if(qlms1 == null || qlms2 == null){
                    break;
                }
                if (qlms1.getGiangVien().getHoTen().compareTo(qlms2.getGiangVien().getHoTen())>0){
                    temp = QLKK[i];
                    QLKK[i]= QLKK[j];
                    QLKK[j]= temp;
                }

            }

        }
    }
    private static void sapXepDSTheoSoTietGiangDay(){
        int n = QLKK.length;

        QL_kekhai temp;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                QL_kekhai qlms1=QLKK[i];

                QL_giangday[] chitietGD=qlms1.getQl_giangday();
                QL_giangday chitiet = chitietGD[i];

                QL_kekhai qlms2=QLKK[j];

                QL_giangday[] chitietGD2=qlms2.getQl_giangdays();
                QL_giangday chitiet2 = chitietGD2[j];
                if(qlms1 == null || qlms2 == null){
                    break;
                }
                if (chitiet.getMonHoc().getTsTiet()<chitiet2.getMonHoc().getTsTiet()){
                    temp = QLKK[i];
                    QLKK[i]= QLKK[j];
                    QLKK[j]= temp;
                }

            }

        }
    }
    private static void lapBangTinhLuong() {
        // kiểm tra xem trong ORDER đã có dữ liệu hay chưa
        boolean coDuLieuDS = false;
        for (int i = 0; i < QLKK.length; i++) {
            if (QLKK[i] != null) {
                coDuLieuDS = true;
            }
        }
        if (!coDuLieuDS) {
            System.out.println("Chưa có hóa đơn nào trong hệ thống, vui lòng tạo hóa đơn trước khi thực hiện tính năng này.");
            return;
        }

        for (int i = 0; i < QLKK.length; i++) {
            QL_kekhai qlkkgd = QLKK[i];
            if (qlkkgd == null) {
                continue;
            }
            double TienLuong = 0;
            QL_giangday[] chitietGD = qlkkgd.getQl_giangdays();
            for (int j = 0; j < chitietGD.length; j++) {
                QL_giangday chitiet = chitietGD[j];
                TienLuong += ((chitiet.getMonHoc().getMucKP()*chitiet.getMonHoc().getStLT())
                        +((chitiet.getMonHoc().getMucKP()*0.7)*(chitiet.getMonHoc().getTsTiet()-chitiet.getMonHoc().getStLT())))*(chitiet.getSoLop());
            }
            System.out.println("Gv " + qlkkgd.getGiangVien().getHoTen() + " Có tiền lương " + TienLuong + "VND");

        }
    }

}
