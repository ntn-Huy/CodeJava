
public class StringBuilderDemo {
    public static void main(String[] args) {
        // Su dung StringBuilder de toi uu bo nho, tranh tao doi tuong String rac trong vong lap
        StringBuilder reportBuilder = new StringBuilder();
        
        for (int i = 0; i < 5000; i++) {
            reportBuilder.append(i).append(",");
        }
        
        String report = reportBuilder.toString();
        
        // In ra do dai hoac mot phan chuoi de kiem tra
        System.out.println("Do dai chuoi tao thanh: " + report.length());
    }
}