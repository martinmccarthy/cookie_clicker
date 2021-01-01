public class Shop {
    public int subtractCookies(int currentCookies, int cost) {
        return currentCookies - cost;
    }

    boolean validityCheck(int currentCookies, int cost) {
        if(cost > currentCookies)
            return false;
        else
            return true;
    }

    int newPrice(int multiplierPrice) {
        return multiplierPrice * 4;
    }
}
