📌 PHẦN C: BÀI TẬP TƯ DUY PHÂN TÍCH (MỨC ĐỘ KHÓ)
Mục tiêu: Rèn khả năng đọc – truy vết – lập luận – thiết kế, không chỉ “viết cho chạy được”.

Phạm vi kiến thức (bắt buộc): chỉ dùng Chương 1 — Java cơ bản (0.1–0.20), tư duy Procedural vs OOP (1.1), môi trường Git/Maven (1.2), Clean Code (1.3), Modules (1.4).

Không yêu cầu: kế thừa/ghi đè/đa hình (Chương 3), Collections/Stream (Chương 6), exception nâng cao (Chương 5). Có thể gọi tên Class/Object/Encapsulation như khái niệm đã học ở 1.1.5.

Cách nộp mỗi bài:

Kết luận (1–3 câu)
Lập luận (bảng vết / sơ đồ Stack–Heap / danh sách thực thể)
Hậu quả nếu sai (bug, hiệu năng, khó bảo trì)
Chỉ viết code khi đề bài yêu cầu minh họa
C1. Truy vết bộ nhớ — Primitive, mảng và aliasing (Khó)
Kiến thức: 0.3 (primitive vs reference, Stack/Heap), 0.7 (mảng), 0.8 (new)

Cho đoạn chương trình:

public class MemoryTrace {
    public static void main(String[] args) {
        int score = 8;
        int copy = score;

        int[] a = {8, 5, 9};
        int[] b = a;
        int[] c = {8, 5, 9};

        copy = 10;
        b[1] = 99;
        c[0] = 1;

        System.out.println(score);
        System.out.println(copy);
        System.out.println(a[1]);
        System.out.println(b[1]);
        System.out.println(c[0]);
        System.out.println(a == b);
        System.out.println(a == c);
    }
}

Yêu cầu phân tích:

Vẽ Stack và Heap sau khi chạy hết các dòng gán (trước println). Ghi rõ: biến nào lưu giá trị, biến nào lưu địa chỉ.
Dự đoán toàn bộ output, từng dòng. Giải thích vì sao a[1] đổi khi sửa b[1], còn score không đổi khi sửa copy.
a và c cùng chứa {8, 5, 9} lúc khởi tạo — vì sao a == c lại khác a == b?
Nếu đổi thành int[] b = a.clone(); (hoặc copy từng phần tử sang mảng mới), kết luận ở câu 2 thay đổi thế nào? Vì sao cách copy này khác phép gán b = a?
Tiêu chí đạt:

Phân biệt đúng “copy giá trị primitive” và “hai biến trỏ cùng một mảng trên Heap”
Không nhầm == trên mảng với “so sánh nội dung”
C2. Bẫy kiểu dữ liệu — ép kiểu, overflow, Wrapper, null (Khó)
Kiến thức: 0.3, 0.12 (casting), 0.13 (Wrapper, autoboxing), 0.15 (null / NPE), 0.17 (Integer.MAX_VALUE)

Với từng đoạn dưới đây, trả lời: compile được không? Nếu chạy được thì output / exception là gì? Nguyên nhân gốc nằm ở đâu?

Đoạn 1 — mất dữ liệu khi ép kiểu

double d = 300.7;
byte b = (byte) d;
System.out.println(b);

Đoạn 2 — tràn số nguyên

int x = Integer.MAX_VALUE;
System.out.println(x);
System.out.println(x + 1);

Đoạn 3 — unboxing null

Integer n = null;
int v = n;
System.out.println(v);

Đoạn 4 — int không thể null

int age = null;

Đoạn 5 — so sánh nội dung String vs số

String s = "10";
int n = 10;
// Câu hỏi: s + n in ra gì? n + 5 in ra gì?
// Có được viết `if (s == n)` không? Muốn so sánh số thì phải làm gì (parse)?
System.out.println(s + n);
System.out.println(n + 5);

Yêu cầu thêm: 6. Giải thích một tình huống thực tế nên dùng int và một tình huống bắt buộc dùng Integer (gợi ý: giá trị có thể “chưa có”, hoặc sau này đưa vào Collection — Chương 6). 7. Vì sao ép double → byte vẫn compile, trong khi gán int age = null thì lỗi ngay lúc biên dịch?

Tiêu chí đạt:

Chỉ ra được: mất dữ liệu (câu 1), wrap-around (câu 2), NPE khi unboxing (câu 3), lỗi kiểu (câu 4)
Không nói mơ hồ “bị lỗi” mà phải nêu đúng loại lỗi (compile-time vs runtime)
C3. String bất biến, equals, và cái giá của vòng lặp nối chuỗi (Khó)
Kiến thức: 0.10 (String, equals), 0.16 (immutable, StringBuilder)

Phần 1 — bất biến

String name = "An";
String upper = name.toUpperCase();
name.concat(" Van");
System.out.println(name);
System.out.println(upper);

Output là gì? concat có đổi name không? Vì sao String được gọi là immutable?
Dòng name.concat(" Van"); có vô nghĩa không? Muốn đổi nội dung hiển thị, phải viết thế nào?
Phần 2 — == và equals

String a = "Hello";
String b = "Hello";
String c = new String("Hello");
System.out.println(a.equals(b));
System.out.println(a.equals(c));
System.out.println(a == b);
System.out.println(a == c);

Dự đoán 4 dòng in. Giải thích sự khác nhau giữa so sánh nội dung (equals) và so sánh tham chiếu (==). Chương 1 dạy tạo String bằng literal và bằng new — hãy dùng đúng hai cách đó để lập luận.
Quy tắc kỹ sư: khi nào bắt buộc dùng equals cho String? Hậu quả nếu dùng == trong điều kiện if?
Phần 3 — hiệu năng

String report = "";
for (int i = 0; i < 5000; i++) {
    report = report + i + ",";
}

Ước lượng: vòng lặp này tạo bao nhiêu đối tượng String (cấp độ: ít / nhiều / rất nhiều)? Liên hệ tính immutable.
Viết lại bằng StringBuilder và giải thích vì sao tiết kiệm bộ nhớ hơn. Trường hợp nào dùng + vẫn chấp nhận được (gợi ý: nối 2–3 chuỗi, không nằm trong vòng lặp lớn)?
Tiêu chí đạt:

Hiểu immutable: method String trả về object mới, object cũ không bị sửa
Tách được equals (nội dung) và == (tham chiếu)
Nêu được lý do dùng StringBuilder trong vòng lặp
C4. Bảng vết điều khiển — vòng lặp lồng, break / continue, off-by-one (Khó)
Kiến thức: 0.6 (if, for, while, break/continue), 0.7 (mảng), 0.8 (method)

public class TraceControl {
    public static int process(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                continue;
            }
            if (a[i] == 0) {
                break;
            }
            if (a[i] % 2 == 0) {
                sum += a[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] data = {3, 4, -1, 8, 0, 10, 2};
        System.out.println(process(data));
    }
}

Yêu cầu:

Lập bảng vết: mỗi vòng, ghi i, a[i], nhánh đi vào (continue / break / cộng vào sum / bỏ qua vì lẻ), giá trị sum sau vòng đó.
Output cuối cùng là gì? Số 10 và 2 có được cộng không? Vì sao?
Nếu đổi break thành return sum; thì kết quả có khác không? Còn nếu xóa hẳn nhánh == 0 thì sao?
Tìm lỗi tư duy (không nhất thiết là lỗi compile): điều kiện a[i] == 0 dùng break có phù hợp nếu 0 nghĩa là “dữ liệu thiếu ở giữa danh sách, vẫn phải xét các phần tử sau”? Đề xuất sửa một dòng và giải thích lựa chọn continue vs break.
Viết lại đề bài bằng lời: “Method này thực sự đang tính gì?” Nếu tên process là code smell (1.3), hãy đặt tên method mô tả đúng hành vi sau khi bạn đã truy vết.
Tiêu chí đạt:

Bảng vết khớp output
Phân biệt continue (bỏ 1 phần tử) và break (dừng cả vòng)
Chỉ ra được rủi ro nghiệp vụ khi dùng break sai ý nghĩa dữ liệu
C5. Phạm vi biến & static vs instance — tìm bug tư duy (Khó)
Kiến thức: 0.2 (main), 0.8 (static vs instance), 0.14 (scope)

Có ba phiên bản class. Với mỗi phiên bản: lỗi ở đâu (compile hay runtime hay logic)? Sửa tối thiểu và giải thích vì sao phải sửa như vậy.

Phiên bản A

public class CounterA {
    int count = 0;

    public static void main(String[] args) {
        count++;
        System.out.println(count);
    }
}

Phiên bản B

public class CounterB {
    static int count = 0;

    public void bump() {
        count++;
    }

    public static void main(String[] args) {
        CounterB a = new CounterB();
        CounterB b = new CounterB();
        a.bump();
        a.bump();
        b.bump();
        System.out.println(a.count);
        System.out.println(b.count);
        System.out.println(CounterB.count);
    }
}

Phiên bản C

public class CounterC {
    int count = 0;

    public void bump() {
        int count = 0;
        count++;
    }

    public static void main(String[] args) {
        CounterC x = new CounterC();
        x.bump();
        x.bump();
        System.out.println(x.count);
    }
}

Yêu cầu thêm: 4. Dùng ẩn dụ “bản vẽ / ngôi nhà” ở mục 0.8: static thuộc về đâu, biến instance thuộc về đâu? 5. Tình huống nào nên dùng static (đếm tổng số object, hằng số, tiện ích Math)? Tình huống nào cấm dùng static cho dữ liệu của từng đối tượng (ví dụ số dư tài khoản)? 6. Ở phiên bản C, hiện tượng biến cục bộ che biến instance gọi là gì (shadowing)? Muốn tăng đúng field thì phải viết thế nào (this.count — khái niệm this sẽ sâu ở Chương 2, ở đây chỉ cần phân biệt hai count)?

Tiêu chí đạt:

A: không gọi instance từ static main nếu chưa có object
B: hiểu static count dùng chung, nên a.count và b.count cùng một giá trị
C: hiểu local count làm bump() không đổi field
C6. Phân rã bài toán — từ thủ tục sang đối tượng (Khó)
Kiến thức: 1.1 (Procedural vs OOP, 6 khái niệm cốt lõi), 1.3 (tách method, đặt tên)

Một nhóm viết prototype quản lý thư viện theo kiểu thủ tục (mọi thứ nhét trong main + hàm rời):

Dữ liệu (mảng song song):
  titles[], authors[], copies[], isBorrowed[]

Hàm:
  addBook(...)
  borrowBook(int index)
  returnBook(int index)
  printAllBooks()
  findByTitle(String title)
  saveToFile()          // giả lập
  printBorrowReceipt()  // in biên lai

Yêu cầu nghiệp vụ sắp tới (chưa code):

Thêm tạp chí (có số kỳ, không có tác giả giống sách)
Một cuốn có thể được mượn bởi đúng một sinh viên; cần biết ai đang giữ
Cấm mượn khi copies == 0
Sau này có thể thêm phạt trễ hạn
Yêu cầu phân tích (không bắt buộc viết kế thừa):

Lập bảng: mỗi hàm đang đụng mảng nào? Khi thêm trường dueDate[], phải sửa những hàm nào? Đó là nhược điểm nào của procedural (1.1.2)?
Liệt kê ứng viên class (thực thể): tên class, thuộc tính, hành vi. Phân biệt “dữ liệu” và “hành vi nên gắn vào đúng object”.
Chỉ ra ít nhất 2 lỗi thiết kế của mảng song song (titles[i] phải khớp authors[i]). Encapsulation (1.1.5) giúp gì?
saveToFile() và printBorrowReceipt() có nên nhét vào class Book không? Phân tích theo nguyên tắc “một class một trách nhiệm” ở mức đọc code (Clean Code — method/class làm quá nhiều việc). Gợi ý tách Book / Loan / Library (chỉ ở mức sơ đồ, chưa cần code đầy đủ).
Chọn một yêu cầu “sắp tới” và mô tả: với procedural phải sửa những gì; với OOP sửa/thêm ở đâu. Không viết extends — chỉ lập luận.
Câu hỏi tư duy: bài toán thư viện nhỏ 3 cuốn sách thì procedural có chấp nhận được không? Mốc nào thì OOP bắt đầu đáng giá hơn (độ phức tạp, thay đổi, nhiều thực thể)?
Tiêu chí đạt:

Tách được thực thể, không nhét mọi hàm vào một class “God class”
Nêu được chi phí thay đổi của dữ liệu tách rời logic
Không nhầm “in biên lai / ghi file” thành hành vi cốt lõi của cuốn sách
C7. Đọc yêu cầu — tìm class, thuộc tính, hành vi, và những thứ không phải class (Khó)
Kiến thức: 1.1.4–1.1.5, 1.3.1 (đặt tên class/method)

Đọc đoạn mô tả:

Căng tin trường mở app đặt món. Sinh viên chọn món, chọn số lượng, có thể thêm ghi chú (ít đá, không cay). Mỗi món có tên, giá, còn bán hay hết. Đơn hàng có mã, thời điểm đặt, danh sách món, trạng thái (chờ nấu / đã xong / đã hủy). Khi đơn đã xong, sinh viên đến quầy nhận. Cuối ngày quản lý xem doanh thu và món bán chạy. Thanh toán chỉ nhận tiền mặt tại quầy (chưa có ví điện tử).

Yêu cầu:

Gạch chân danh từ (ứng viên class/thuộc tính) và động từ (ứng viên method). Loại bỏ danh từ không nên thành class (ví dụ: “tiền mặt”, “cuối ngày”, “ghi chú” — lập luận từng cái).
Đề xuất 4–6 class tối thiểu cho bản MVP. Với mỗi class: 3 thuộc tính + 2 hành vi. Đặt tên theo Java (PascalCase / camelCase — 1.3.1).
Vẽ (bằng markdown) quan hệ dùng (không cần UML đầy đủ): class nào giữ danh sách class nào? Đây là tư duy “object cộng tác”, chưa cần composition lý thuyết Chương 3.
Chỉ ra 2 quyết định dễ sai:
Nhồi toàn bộ vào Main
Tạo class cho mọi danh từ (TienMat, CuoiNgay, ItDa) Giải thích hậu quả bảo trì.
Câu hỏi ranh giới Chương 1: vì sao TrangThaiDon có thể chỉ là String/int ở bản MVP, dù sau này (Chương sau) có thể đổi enum? Không cần code enum — chỉ phân tích đánh đổi.
Tiêu chí đạt:

Có tiêu chí loại danh từ không phải class
Tên class là danh từ, method là động từ
MVP đủ dùng, không phình mô hình
C8. Thẩm định Clean Code — comment rác, magic number, method thần thánh (Khó)
Kiến thức: 1.3 (naming, readability, comment, JavaDoc, code smells)

public class X {
    public static void m(String[] n, int[] p, int[] q) {
        // khai bao
        int t = 0;
        int c = 0;
        // duyet
        for (int i = 0; i < n.length; i++) {
            // neu gia > 0
            if (p[i] > 0) {
                t = t + p[i] * q[i];
                if (p[i] > 100000) {
                    // giam 10%
                    t = t - (p[i] * q[i] * 10 / 100);
                }
                c++;
            }
        }
        // in
        System.out.println(t);
        System.out.println(c);
    }
}

Giả sử ý định thật: n = tên sản phẩm, p = đơn giá, q = số lượng; bỏ qua sản phẩm giá <= 0; đơn giá > 100_000 được giảm 10% trên thành tiền dòng đó; in tổng tiền sau giảm và số dòng hợp lệ.

Yêu cầu:

Liệt kê tối thiểu 6 vấn đề, gắn đúng loại: magic number, tên vô nghĩa, comment rác, method quá nhiều việc, mảng song song, mất dữ liệu (chia nguyên 10/100), không JavaDoc.
Comment // giam 10% có phải comment tốt không? Đối chiếu nguyên tắc “comment giải thích TẠI SAO, không lặp LÀM GÌ”.
Chỉ ra bug ẩn: t = t - (p[i] * q[i] * 10 / 100) kết hợp int — kết quả có luôn đúng 10% không? (chia nguyên)
Viết lại bản thiết kế (chưa cần OOP đầy đủ): tên class/method/hằng số, chữ ký method gợi ý, JavaDoc mô tả quy tắc giảm giá (business rule). Có thể vẫn dùng mảng, nhưng phải đọc được.
So sánh: chỉ đổi tên biến đã đủ sạch chưa? Chỗ nào bắt buộc tách method (isValidLine, lineAmount, discount)?
Tiêu chí đạt:

Phát hiện bug chia nguyên, không chỉ “code xấu”
Phân biệt refactor đặt tên với refactor tách trách nhiệm
Đề xuất hằng số DISCOUNT_RATE, DISCOUNT_THRESHOLD thay cho 100000 và 10
C9. Truyền tham số — primitive và mảng (bẫy rất hay gặp) (Khó)
Kiến thức: 0.3, 0.7, 0.8 (tham số method)

public class PassDemo {
    public static void resetScore(int score) {
        score = 0;
    }

    public static void resetFirst(int[] scores) {
        scores[0] = 0;
    }

    public static void replaceArray(int[] scores) {
        scores = new int[] {0, 0, 0};
    }

    public static void main(String[] args) {
        int s = 9;
        resetScore(s);
        System.out.println(s);

        int[] arr = {9, 8, 7};
        resetFirst(arr);
        System.out.println(arr[0]);

        replaceArray(arr);
        System.out.println(arr[0] + "," + arr[1] + "," + arr[2]);
    }
}

Yêu cầu:

Dự đoán 3 dòng output.
Giải thích thống nhất bằng một nguyên tắc: Java truyền bản sao giá trị của tham số. Với int, bản sao là số. Với mảng, bản sao là tham chiếu (địa chỉ) — nên sửa scores[0] ảnh hưởng mảng gốc, còn gán scores = new int[]{...} chỉ đổi bản sao local.
Vẽ Stack/Heap cho resetFirst và replaceArray tại thời điểm trước khi method return.
Muốn method “thay cả mảng mới” cho caller thì không thể chỉ gán lại tham số. Đề xuất hướng giải pháp trong phạm vi Chương 1 (ví dụ: return mảng mới, hoặc copy phần tử vào mảng caller đưa vào). Không cần nói “pass by reference” như C++.
Tiêu chí đạt:

Ba output đúng
Không nói sai “Java truyền object by reference”; lập luận phải dựa trên copy reference
C10. Tình huống kỹ sư — Git, Maven, classpath, module (Khó)
Kiến thức: 1.2.3 (Git), 1.2.4 (Maven), 1.4 (JPMS), 0.1 (bytecode / JVM)

Đọc nhật ký nhóm (rút gọn):

Tuần 1: gửi nhau file Main.java qua Zalo, kèm Main.class.
Tuần 2: mỗi người một thư mục project_final, project_ok, project_ok2. Máy A JDK 8, máy B JDK 21.
Tuần 3: thêm thư viện JSON tải tay, copy .jar lung tung; chạy được trên máy A, máy B báo thiếu class lúc runtime.
Tuần 4: commit cả thư mục target/, file .class, rồi ghi đè code của nhau. Một người xóa nhầm hàm, không biết lấy lại.

Yêu cầu:

Với từng tuần, chỉ ra nguyên nhân gốc (không phải “tại bạn ấy bất cẩn”) và công cụ Chương 1 nào xử lý (Git, .gitignore, Maven/pom.xml, JDK thống nhất, module/module-info.java).
Vì sao gửi .class cho bạn không thay được gửi source + cách build? Liên hệ bytecode và JVM (0.1).
“Classpath Hell” (1.4.1) xuất hiện ở tuần nào? Maven khác copy .jar thủ công ở điểm nào (khai báo phụ thuộc, chu trình compile/package)?
Module giải quyết được gì mà Maven không thay thế hết (ranh giới: Maven = build/dependency; JPMS = ranh giới package được exports / requires)? Dự án bài tập nhỏ có bắt buộc dùng module không? Lập luận.
Viết quy ước nhóm 8–10 dòng (checklist) cho đồ án Chương 1: JDK, Git, ignore, Maven, không commit gì.
Tiêu chí đạt:

Tách đúng vai trò Git / Maven / JDK / module
Không nhầm .class với source of truth
Checklist thực dụng, không sao chép giáo trình
C11. Case tổng hợp — prototype điểm danh (Rất khó)
Kiến thức: toàn Chương 1 (logic, mảng, String, static, procedural vs OOP, clean code)

public class App {
    static String[] names = new String[100];
    static int[] present = new int[100]; // 1 = có mặt
    static int n = 0;
    static String log = "";

    public static void add(String name) {
        names[n] = name;
        present[n] = 1;
        n++;
        log = log + name + ",";
    }

    public static void kick(String name) {
        for (int i = 0; i < n; i++) {
            if (names[i] == name) {
                present[i] = 0;
            }
        }
    }

    public static int total() {
        int t = 0;
        for (int i = 0; i <= n; i++) {
            t = t + present[i];
        }
        return t;
    }
}

Giảng viên mô tả ý định: thêm sinh viên (mặc định có mặt), đánh dấu vắng theo tên, đếm số có mặt; log dùng in báo cáo cuối buổi.

Yêu cầu — trả lời theo mục, có bằng chứng:

Bug logic / cú pháp tư duy: total() — vòng lặp i <= n gây rủi ro gì? (off-by-one, ArrayIndexOutOfBounds khi n == 100)
Bug so sánh String: names[i] == name trong kick — liên hệ C3. Hệ quả: gọi kick(new String("An")) có thể không đánh vắng. Sửa bằng gì?
Bug hiệu năng / bộ nhớ: log = log + name + "," mỗi lần add — liên hệ C3 phần 3. Khi add 10.000 lần thì sao?
Bug thiết kế dữ liệu: mảng song song names / present; static toàn cục. Hai object “lớp học khác nhau” có tồn tại được không? Liên hệ C5 và 1.1.
Thiếu ràng buộc: add khi n == 100 thì sao? Tên null hoặc rỗng? kick tên không có trong danh sách?
Viết bản phân tích chuyển đổi OOP (1–1.5 trang ý): class Student, AttendanceSession (hoặc tên bạn đặt); field nào instance, method nào; log để ở đâu; có dùng StringBuilder không. Không yêu cầu inheritance.
Liệt kê code smell theo 1.3.3 (tên App, kick, int[] present thay vì ý nghĩa boolean).
Nếu đây là đồ án nhóm: file này nên được Git quản lý thế nào để không lặp lại nhật ký C10?
Deliverable: bản phân tích có tiêu đề từng mục 1–8. Được phép viết khung class (chữ ký method, field) nhưng trọng số điểm nằm ở lập luận.

Tiêu chí đạt (rất khó):

Tìm được cả bug kỹ thuật (vòng lặp, ==, String concat) lẫn bug tư duy (static global, mảng song song)
Đề xuất mô hình object vừa đủ, không biến thành Chương 3
Hướng dẫn tự chấm Phần C
Mức	Mô tả
Chưa đạt	Chỉ đoán output / liệt kê class, không giải thích cơ chế
Đạt	Output hoặc sơ đồ đúng, có viện dẫn mục trong chương
Khá	Chỉ ra hậu quả bảo trì / bug nghiệp vụ, không chỉ bug compile
Giỏi	So sánh được 2 hướng giải, nêu giới hạn kiến thức Chương 1 (cái gì để dành Chương 2–3)
Gợi ý làm bài: C1 → C5 (cơ chế Java) rồi C6 → C8 (tư duy thiết kế) rồi C9 → C11 (bẫy tổng hợp). Nên viết tay bảng vết trước khi mở IDE.