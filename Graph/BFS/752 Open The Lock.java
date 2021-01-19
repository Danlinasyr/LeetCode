class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int t = 0;
        while (!queue.isEmpty()) {
            String comb = queue.poll();
            if (comb.equals(target)) {
                return t;
            }
            List<String> combs = getNewCombos(comb, dead);
            for (String nc : combs) {
                queue.offer(nc);
                visited.add(nc);
            }
            t++;
        }
        return -1;

    }

    // https://pastebin.ubuntu.com/p/Stspp5StRC/
    private List<String> getNewCombos(String sb) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = sb.charAt(i);
            String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
            String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
            res.add(s1);
            res.add(s2);
        }

        return res;
    }

}

// Bi-driection BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> fQueue = new ArrayDeque<>();
        Queue<String> bQueue = new ArrayDeque<>();
        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }
        Set<String> fset = new HashSet<>();
        Set<String> bset = new HashSet<>();
        fQueue.offer("0000");
        fset.add("0000");
        bQueue.offer(target);
        bset.add(target);
        int t = 0;
        while (!fQueue.isEmpty() && !bQueue.isEmpty()) {
            t++;
            int sz = fQueue.size();
            for (int i = 0; i < sz; i++) {
                String comb = fQueue.poll();
                if (dead.contains(comb)) {
                    continue;
                }
                if (bset.contains(comb)) {
                    return t - 1;
                }
                List<String> combs = getNewCombos(comb);
                for (String nc : combs) {
                    if (!fset.contains(nc)) {
                        fQueue.offer(nc);
                        fset.add(nc);
                    }
                }
            }
            t++;
            sz = bQueue.size();
            for (int i = 0; i < sz; i++) {
                String comb = bQueue.poll();
                if (dead.contains(comb)) {
                    continue;
                }
                if (fset.contains(comb)) {
                    return t - 1;
                }
                List<String> combs = getNewCombos(comb);
                for (String nc : combs) {
                    if (!bset.contains(nc)) {
                        bQueue.offer(nc);
                        bset.add(nc);
                    }
                }
            }

        }
        return -1;

    }

    private List<String> getNewCombos(String sb) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int d = sb.charAt(i) - '0';
            String s1 = sb.substring(0, i) + ((d + 1 + 10) % 10) + sb.substring(i + 1);
            String s2 = sb.substring(0, i) + ((d - 1 + 10) % 10) + sb.substring(i + 1);
            res.add(s1);
            res.add(s2);
        }

        return res;
    }

}