 public int maxCount(int m, int n, List<List<Integer>> ops) {
        Map<Integer, Integer> xs = new HashMap<>();
        Map<Integer, Integer> ys = new HashMap<>();

        for (List<Integer> op : ops) {
            for (int i = 1; i <= op.get(0); i++) {
                xs.put(i, xs.getOrDefault(i, 0) + 1);
            }
            for (int j = 1; j <= op.get(1); j++) {
                ys.put(j, ys.getOrDefault(j, 0) + 1);
            }
        }

        int maxX = m;
        int maxY = n;
        int maxXval = 0;
        int maxYval = 0;

        for (Map.Entry<Integer, Integer> entry : xs.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v >= maxXval) {
                maxX = k;
                maxXval = v;
            }
        }

        for (Map.Entry<Integer, Integer> entry : ys.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v >= maxYval) {
                maxY = k;
                maxYval = v;
            }
        }

        return maxX * maxY;
    }