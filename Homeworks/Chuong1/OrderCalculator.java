/**
 * Lớp hỗ trợ tính toán và xử lý đơn hàng.
 * Áp dụng các quy tắc Clean Code: đặt tên tự mô tả, tách nhỏ method và loại bỏ magic numbers.
 */
public class OrderCalculator {

    // Khai báo các hằng số thay thế cho Magic Numbers
    public static final double DISCOUNT_THRESHOLD = 100_000.0;
    public static final double DISCOUNT_RATE = 0.10;

    /**
     * Tính tổng thành tiền của danh sách sản phẩm sau khi đã áp dụng chiết khấu.
     * Quy tắc nghiệp vụ: Những mặt hàng có đơn giá lớn hơn 100.000 VNĐ sẽ được giảm giá 10%.
     *
     * @param productNames Mảng tên các sản phẩm
     * @param unitPrices Mảng đơn giá tương ứng của các sản phẩm
     * @param quantities Mảng số lượng mua của các sản phẩm
     * @return Tổng số tiền phải thanh toán sau khi giảm giá
     */
    public static double calculateTotalAmount(String[] productNames, double[] unitPrices, int[] quantities) {
        double totalAmount = 0.0;
        int validItemCount = 0;

        for (int i = 0; i < unitPrices.length; i++) {
            if (isValidItem(unitPrices[i])) {
                totalAmount += calculateLineAmount(unitPrices[i], quantities[i]);
                validItemCount++;
            }
        }

        printReport(totalAmount, validItemCount);
        return totalAmount;
    }

    /**
     * Kiểm tra xem một mặt hàng có đơn giá hợp lệ để tính tiền hay không.
     *
     * @param price Đơn giá cần kiểm tra
     * @return true nếu đơn giá hợp lệ (> 0), ngược lại trả về false
     */
    private static boolean isValidItem(double price) {
        return price > 0;
    }

    /**
     * Tính thành tiền cho một dòng sản phẩm (đã bao gồm chiết khấu nếu vượt ngưỡng).
     * Sử dụng kiểu double để tránh bug mất phần thập phân khi chia số nguyên.
     *
     * @param unitPrice Đơn giá sản phẩm
     * @param quantity Số lượng sản phẩm
     * @return Thành tiền của dòng sản phẩm
     */
    private static double calculateLineAmount(double unitPrice, int quantity) {
        double lineTotal = unitPrice * quantity;
        if (unitPrice > DISCOUNT_THRESHOLD) {
            lineTotal -= lineTotal * DISCOUNT_RATE;
        }
        return lineTotal;
    }

    /**
     * In báo cáo tổng tiền và số lượng dòng hợp lệ ra màn hình.
     *
     * @param totalAmount Tổng tiền sau khi giảm giá
     * @param validCount Số lượng mặt hàng hợp lệ
     */
    private static void printReport(double totalAmount, int validCount) {
        System.out.printf("Tong tien: %.2f\n", totalAmount);
        System.out.println("So san pham hop le: " + validCount);
    }

    public static void main(String[] args) {
        // Dữ liệu mẫu để kiểm thử hàm tính toán
        String[] productNames = {"But bi", "Sach Java", "Vo ghi", "San pham loi"};
        double[] unitPrices = {5_000.0, 150_000.0, 20_000.0, -10_000.0};
        int[] quantities = {2, 1, 3, 5};

        calculateTotalAmount(productNames, unitPrices, quantities);
    }
}