class CountSquares {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        // if (map.containsKey(point[0])) map.get(point[0]).add(point[1]);
        // else {
        //     ArrayList<Integer> l = new ArrayList<Integer>();
        //     l.add(point[1]);
        //     map.put(point[0], l);
        // }
        int x = point[0], y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        int newCount = map.get(x).getOrDefault(y, 0) + 1;
        map.get(x).put(y, newCount);
    }
    
    public int count(int[] point) {
        System.out.println("-----");
        // First, check if the x value is there
        if (!map.containsKey(point[0])) return 0;

        int count = 0;
        int x1 = point[0];
        int y1 = point[1];

        for (int y2 : map.get(x1).keySet()) {
            // Look through each y2 and see if you can make a square
            int sideLength = y2 - y1;
            if (sideLength == 0) continue;

            // Possibility 1: x1 + sideLength
            int x2 = x1 + sideLength;
            if (map.containsKey(x2)) {
                count += map.get(x1).get(y2)
                    * map.get(x2).getOrDefault(y1, 0)
                    * map.get(x2).getOrDefault(y2, 0); 
            }

            // Possibility 2: x1 - sideLength
            x2 = x1 - sideLength;
            if (map.containsKey(x2)) {
                count += map.get(x1).get(y2)
                    * map.get(x2).getOrDefault(y1, 0)
                    * map.get(x2).getOrDefault(y2, 0); 
            }
        }
        return count;

        // // Since there are points with the same x value as this one, we can now count
        // ArrayList<Integer> set = map.get(point[0]);
        // int count = 0;
        // for (int value : set) {
        //     System.out.println("Value Checked: " + value);
        //     System.out.println("Cur Point: (" + point[0] + ", " + point[1] + ")");
        //     // Check if each y value is covered
        //     int distance = Math.abs(value - point[1]);

        //     // First, check if there is something with the same y value
        //     if (map.containsKey(point[0] - distance)) {
        //         // Potential value here
        //         int new_x = point[0] - distance;
        //         int new_y = value;
        //         System.out.println("New Point to check for: (" + new_x + ", " + new_y + ")");
        //         for (int val : map.get(new_x)) {
        //             if (val == new_y) count++;
        //         }
        //     }

        //     if (map.containsKey(point[0] + distance)) {
        //         // Potential value here - Don't want to double count so make them separate if statements
        //         int new_x = point[0] + distance;
        //         int new_y = value;
        //         System.out.println("New Point to check for: (" + new_x + ", " + new_y + ")");
        //         for (int val : map.get(new_x)) {
        //             if (val == new_y) count++;
        //         }
        //     }
        // }

        // return count;
    }
}
