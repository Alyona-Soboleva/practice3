package part4.part4_1;

public class DiscountCalculator {

    public static double calculateDiscount(double price, String customerType) {
        // TODO: реализуйте скидку по типу клиента.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        double discountPercent = 0.0;

        switch (customerType.toLowerCase()) {
            case "vip":
                discountPercent = 0.20;
                break;
            case "regular":
                discountPercent = 0.05;
                break;
            case "new":
                discountPercent = 0.10;
                break;
            default:
                discountPercent = 0.0;
        }

        double discount = price * discountPercent;
        return Math.min(discount, price * 0.5); // Максимум 50% от цены
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static double calculateDiscount(double price, int purchaseCount) {
        // TODO: реализуйте скидку по количеству покупок.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        double discountPercent;

        if (purchaseCount >= 100) {
            discountPercent = 0.25;
        } else if (purchaseCount >= 50) {
            discountPercent = 0.15;
        } else if (purchaseCount >= 20) {
            discountPercent = 0.10;
        } else if (purchaseCount >= 10) {
            discountPercent = 0.05;
        } else {
            discountPercent = 0.0;
        }

        double discount = price * discountPercent;
        return Math.min(discount, price * 0.5);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static double calculateDiscount(double price, String promoCode, boolean isFirstOrder) {
        // TODO: реализуйте скидку по промокоду + бонус за первый заказ.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        double discountPercent = 0.0;

        // Скидка по промокоду
        switch (promoCode.toUpperCase()) {
            case "SAVE20":
                discountPercent = 0.20; // 20% скидка
                break;
            case "SAVE10":
                discountPercent = 0.10; // 10% скидка
                break;
            case "WELCOME":
                discountPercent = 0.15; // 15% скидка
                break;
            default:
                discountPercent = 0.0;
        }

        // Бонус за первый заказ (дополнительные 5%)
        if (isFirstOrder) {
            discountPercent += 0.05;
        }

        // Ограничиваем максимальную скидку 50%
        discountPercent = Math.min(discountPercent, 0.5);

        double discount = price * discountPercent;
        return discount;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static double calculateDiscount(double price, int age, String season) {
        // TODO: четвертая перегрузка (пример: возраст + сезон).
        // Подсказка: ограничьте максимальную скидку 50% от price.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        double discountPercent = 0.0;

        // Скидка по возрасту
        if (age >= 60) {
            discountPercent += 0.15; // Пенсионерам 15%
        } else if (age <= 18) {
            discountPercent += 0.10; // Детям и подросткам 10%
        } else if (age >= 25 && age <= 35) {
            discountPercent += 0.05; // Молодым специалистам 5%
        }

        // Скидка по сезону
        switch (season.toLowerCase()) {
            case "winter":
                discountPercent += 0.10; // Зимняя распродажа
                break;
            case "summer":
                discountPercent += 0.05; // Летняя распродажа
                break;
            case "spring":
            case "autumn":
                discountPercent += 0.03; // Весенняя/осенняя скидка
                break;
            default:
                // Нет скидки по сезону
        }

        // Специальные комбо-скидки
        if (age >= 60 && season.equalsIgnoreCase("winter")) {
            discountPercent += 0.05; // Дополнительные 5% для пенсионеров зимой
        }

        // Ограничиваем максимальную скидку 50%
        discountPercent = Math.min(discountPercent, 0.5);

        double discount = price * discountPercent;
        return discount;
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static void main(String[] args) {
        double price = 10000.0;
        System.out.println("VIP: " + calculateDiscount(price, "vip"));
        System.out.println("75 покупок: " + calculateDiscount(price, 75));
        System.out.println("SAVE20 + first: " + calculateDiscount(price, "SAVE20", true));
        System.out.println("Возраст+сезон: " + calculateDiscount(price, 65, "winter"));

        // Дополнительные тесты для проверки
        System.out.println("\n=== Дополнительные тесты ===");
        System.out.println("Regular клиент: " + calculateDiscount(price, "regular"));
        System.out.println("10 покупок: " + calculateDiscount(price, 10));
        System.out.println("Только SAVE10: " + calculateDiscount(price, "SAVE10", false));
        System.out.println("Возраст 70, лето: " + calculateDiscount(price, 70, "summer"));
        System.out.println("Возраст 16, весна: " + calculateDiscount(price, 16, "spring"));
        System.out.println("Возраст 30, осень: " + calculateDiscount(price, 30, "autumn"));
    }
}