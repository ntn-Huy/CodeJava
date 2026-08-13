# CHƯƠNG 1: TỔNG HỢP LÝ THUYẾT TRỌNG TÂM

## 📌 PHẦN 0: NGÔN NGỮ LẬP TRÌNH JAVA CƠ BẢN

### 0.1. Giới Thiệu Java & Cơ Chế Hoạt Động Của JVM
> 💡 **Triết lý:** *"Write Once, Run Anywhere"* nhờ vào máy ảo Java (**JVM**).

**⚙️ Quy trình biên dịch & thực thi:**
- **Biên dịch:** Dùng `javac` dịch code nguồn (`.java`) thành dạng Bytecode (`.class`).
- **Thực thi:** **JVM** đọc Bytecode và dịch sang lệnh máy theo từng hệ điều hành cụ thể.

---

### 0.2. Cấu Trúc Chương Trình & Từ Khóa Trong `main()`
📝 **Giải thích các từ khóa trong `public static void main(String[] args)`:**
- `public`: Modifier công khai để JVM có thể nhìn thấy và gọi từ bên ngoài.
- `static`: Phương thức tĩnh, JVM gọi trực tiếp từ Class mà không cần tạo Object trước.
- `void`: Phương thức không trả về giá trị.
- `main`: Tên phương thức quy ước cứng làm "cửa vào" của chương trình.
- `String[] args`: Mảng tham số truyền từ dòng lệnh terminal.

---

### 0.3. Kiểu Dữ Liệu & Bộ Nhớ (Stack vs Heap)
📝 Java phân chia 2 nhóm kiểu dữ liệu rõ rệt:

📊 **Bảng so sánh kiểu dữ liệu:**

| Tiêu chí | Primitive Types (Nguyên thủy) | Reference Types (Tham chiếu) |
| :--- | :--- | :--- |
| **Gồm có** | 8 kiểu: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`. | Class (như `String`), Array (mảng), Interface. |
| **Vị trí lưu** | Lưu giá trị trực tiếp tại **Stack**. | Lưu địa chỉ ô nhớ (reference) trỏ tới Object trên **Heap**. |
| **Giá trị mặc định** | `0`, `0.0`, `false`, `\u0000` | `null` |

---

### 0.4. Biến, Hằng Số & Quy Ước Đặt Tên (Naming Conventions)
- **Hằng số:** Khai báo bằng từ khóa `final`. Giá trị sau khi gán lần đầu sẽ không thể thay đổi.

---

### 0.5. Toán Tử & "Bẫy" Cần Tránh
> ⚠️ **Short-circuit Evaluation (Đánh giá ngắn mạch):**
> - Với `&&`: Nếu vế trái `false`, Java bỏ qua vế phải.
> - Với `||`: Nếu vế trái `true`, Java bỏ qua vế phải.

**💡 Ứng dụng chống crash:** 
```java
if (obj != null && obj.getValue() > 0)
```

---

### 0.6. Cấu Trúc Điều Khiển & Vòng Lặp
- **Switch Expression** (Java 14+): Cú pháp mũi tên `case 1 -> "Monday";` giúp tự động loại bỏ lỗi Fall-through (không cần từ khóa `break`).
- **For-each:** Dùng khi chỉ cần đọc giá trị mảng/danh sách: `for (int num : numbers)`.
- **Break vs Continue:**
  - `break`: Thoát hoàn toàn khỏi vòng lặp.
  - `continue`: Bỏ qua lượt lặp hiện tại để chuyển sang lượt kế tiếp.

---

### 0.7 - 0.10. Mảng, Method, Input/Output & String
- **StringBuilder:** Do `String` là **Immutable** (bất biến - mỗi lần nối chuỗi `+` tạo ra 1 Object mới gây tốn RAM), ta dùng `StringBuilder` cho các thao tác nối chuỗi nhiều lần trong vòng lặp.

---

### 0.12 - 0.13. Ép Kiểu & Wrapper Classes
- **Implicit Casting (Tự động):** Chuyển từ kiểu nhỏ sang lớn (VD: `int` → `double`).
- **Explicit Casting (Thủ công):** Chuyển từ lớn sang nhỏ (VD: `int i = (int) 9.99;` → `i` nhận giá trị `9`, bị cắt thập phân).
- **Wrapper Classes:** Bản gói đối tượng của kiểu nguyên thủy (`int` → `Integer`, `double` → `Double`).
- **Autoboxing:** Tự động chuyển Primitive → Wrapper.
- **Unboxing:** Tự động chuyển Wrapper → Primitive.

---

## 📌 PHẦN 1: TƯ DUY HƯỚNG ĐỐI TƯỢNG (OOP)

### 1.1. Từ Thủ Tục (Procedural) Sang OOP
- **Procedural (Thủ tục):** Tập trung vào *"Làm thế nào?"*, tách rời Dữ liệu (*struct*) và Hàm xử lý (*function*) → Khó quản lý khi hệ thống lớn.
- **OOP (Hướng đối tượng):** Gom nhóm Dữ liệu (*Thuộc tính*) và Hành vi (*Phương thức*) vào chung một đơn vị gọi là **Class/Object**.

---

### 1.1.5. 4 Trụ Cột Cốt Lõi Của OOP (Đặc Biệt Quan Trọng)
- **Encapsulation (Đóng gói):** Gói dữ liệu và phương thức vào Class, che giấu chi tiết bên trong bằng `private`, chỉ cung cấp truy cập qua `getter/setter`.
- **Inheritance (Kế thừa):** Lớp con thừa hưởng thuộc tính/phương thức từ lớp cha (`extends`), tránh lặp lại code.
- **Polymorphism (Đa hình):** Cùng một tên phương thức nhưng các đối tượng khác nhau sẽ thực thi theo cách riêng.
- **Abstraction (Trừu tượng hóa):** Ẩn đi sự phức tạp bên trong, chỉ cung cấp các giao diện chức năng cần thiết ra bên ngoài.

> 📝 **Khái niệm Class vs Object:**
> - **Class:** Bản vẽ / Khuôn mẫu (*Blueprint*).
> - **Object:** Thực thể cụ thể (*Instance*) tạo ra từ Class bằng từ khóa `new`.

---

## 📌 PHẦN 2: MÔI TRƯỜNG, BUILD TOOL & CLEAN CODE

### 1.2. Công Cụ Lập Trình
🛠️ **Công cụ:**
- Cursor IDE
- JDK 21 LTS

⚙️ **Git 3 Trạng Thái File:**
`Working Directory` → `git add` → `Staging Area` → `git commit` → `Repository`.

⚙️ **Maven & `pom.xml`:** Build tool tự động quản lý dependencies (thư viện) và đóng gói dự án (`mvn compile`, `mvn test`, `mvn package`).

---

### 1.3. Clean Code & Code Smells
- **Quy tắc đọc code:** 80% thời gian là đọc code, chỉ 20% là viết mới.
- **Self-Documenting Code:** Đặt tên biến/hàm rõ ràng để tự giải thích mục đích, hạn chế dùng comment giải thích "code làm gì".

---

### 1.4. Java Modules (JPMS - Java 9+)
📝 File khai báo `module-info.java` giúp giải quyết hiện tượng *"Classpath Hell"*.

**Các từ khóa chính:**
- `requires`: Khai báo phụ thuộc vào module khác.
- `exports`: Cho phép module khác dùng package được chỉ định.
- `opens`: Mở package cho cơ chế Reflection.

---

## 💻 BÀI TẬP

### 📝 BÀI TẬP 1: Cấu trúc cơ bản & Xử lý Bẫy Input (Java Basic)
**Yêu cầu:** Viết chương trình `EmployeeManagement` thực hiện:
- Nhập từ bàn phím thông qua `Scanner`:
  - Mã nhân viên (`String`)
  - Họ và tên (`String`)
  - Tuổi (`int`)
  - Hệ số lương (`double`)
- **Yêu cầu kỹ thuật:**
  - Xử lý triệt để hiện tượng trôi lệnh khi nhập chuỗi sau số.
  - Sử dụng `Locale.US` để bắt buộc dùng dấu chấm thập phân.
  - Sử dụng `printf` để in ra bảng thông tin nhân viên được định dạng đẹp mắt.

---

### 📝 BÀI TẬP 2: Thao tác Chuỗi & StringBuilder (Clean Code)
**Yêu cầu:** Viết lớp `TextProcessor` chứa phương thức `public static String formatName(String rawName)` thực hiện:
- Nhận vào một chuỗi họ tên bị lỗi định dạng (VD: `" ngUYeN tHaNh nHAT hUY "`).
- Xóa khoảng trắng thừa ở đầu/cuối và giữa các từ.
- Chuyển đổi họ tên về dạng chuẩn Capitalize (Chữ cái đầu viết hoa, còn lại viết thường → `"Nguyễn Thành Nhật Huy"`).
- **Yêu cầu kỹ thuật:** Sử dụng `StringBuilder` để xử lý nối chuỗi tối ưu bộ nhớ.

---

### 📝 BÀI TẬP 3: Thiết kế Lớp hướng đối tượng chuẩn Encapsulation (OOP Core)
**Yêu cầu:** Thiết kế lớp `BankAccount` thỏa mãn chuẩn Clean Code và Đóng gói:
- **Fields (`private`):**
  - `accountNumber` (`String`)
  - `ownerName` (`String`)
  - `balance` (`double`)
- **Constructors:**
  - Constructor không tham số gán mặc định.
  - Constructor đầy đủ tham số sử dụng từ khóa `this`.
- **Methods:**
  - Getters/Setters có ràng buộc điều kiện (Số dư `balance` phải ≥ 0).
  - `deposit(double amount)`: Nạp tiền (Số tiền nạp phải > 0).
  - `withdraw(double amount)`: Rút tiền (Số tiền rút phải > 0 và ≤ `balance`).
  - `displayInfo()`: In thông tin tài khoản dạng Clean Code.

---

### 📝 BÀI TẬP 4: Bài tập tổng hợp - Quản lý Danh sách Sản phẩm (Ứng dụng)
**Yêu cầu:**
- Tạo lớp `Product` gồm các thuộc tính `id`, `name`, `price`, `quantity`.
- Trong hàm `main` của lớp `ProductManager`:
  - Tạo một mảng hoặc danh sách gồm 3 sản phẩm.
  - Tính tổng giá trị kho hàng ($\sum \text{price} \times \text{quantity}$).
  - Tìm sản phẩm có giá đắt nhất.
  - Lọc và in ra màn hình danh sách các sản phẩm có số lượng `quantity < 5`.
