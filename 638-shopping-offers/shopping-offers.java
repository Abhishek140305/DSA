class Solution {
    // Memoization map to store calculated results for specific states
    Map<String, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return f(price, special, needs, 0);
    }

    // Calculates the cost of buying all remaining items at regular retail price
    private int direct_purchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }

    // Checks if the special offer causes us to buy more than we need
    private boolean is_valid(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                return false;
            }
        }
        return true;
    }

    int f(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx) {
        // Create a unique state key for memoization
        String key = needs.toString() + idx;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Base case / Fallback: Cost without using any more special offers
        int res = direct_purchase(price, needs);

        // Try applying each special offer
        for (int i = idx; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            
            if (is_valid(offer, needs)) {
                // Create the new remaining needs list after applying the offer
                List<Integer> tempNeeds = new ArrayList<>();
                for (int j = 0; j < needs.size(); j++) {
                    tempNeeds.add(needs.get(j) - offer.get(j));
                }
                
                // The price of the special offer is the last element in the list
                int offer_price = offer.get(offer.size() - 1);
                
                // Recurse and take the minimum cost
                res = Math.min(res, offer_price + f(price, special, tempNeeds, idx));
            }
        }
        
        // Save result in DP map before returning
        dp.put(key, res);
        return res;
    }
}