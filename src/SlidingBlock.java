import java.util.*;

class SlidingBlock {

    SlidingBlock(Block[] blockList) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> costMap = new HashMap<>();
        costMap.put(toStr(blockList), 0);
        Queue<Block[]> queue = new PriorityQueue<>(11,
                new Comparator<Block[]>() {
                    public int compare(Block[] a, Block[] b) {
                        String aStr = toStr(a);
                        String bStr = toStr(b);
                        return (Math.abs(a[0].location[0] - 4) + Math.abs(a[0].location[1] - 3) + costMap.get(aStr)) - (Math.abs(b[0].location[0] - 4) + Math.abs(b[0].location[1] - 3) + costMap.get(bStr));
                    }
                });

        while (true) {
            //reach goal state
            if (blockList[0].location[0] == 4 && blockList[0].location[1] == 3) {
                List<String> list = new ArrayList<>();
                String goal = toStr(blockList);
                list.add(goal);
                while (map.containsKey(goal)) {
                    goal = map.get(goal);
                    list.add(goal);
                }
                printList(list);
                break;
            }

            for (int i = 0; i < blockList.length; i++) {

                //one side
                Block newBlock = blockList[i].clone();
                newBlock.location[newBlock.direction]--;

                boolean valid = true;
                if (newBlock.location[newBlock.direction] >= 0) {
                    for (int j = 0; j < blockList.length; j++) {
                        if (i != j && blockList[j].interaction(newBlock)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        Block[] newBlockList = blockList.clone();
                        newBlockList[i] = newBlock;
                        if (!costMap.containsKey(toStr(newBlockList))) {
                            String newBlockListStr = toStr(newBlockList);
                            String blockListStr = toStr(blockList);
                            map.put(newBlockListStr, blockListStr);
                            costMap.put(newBlockListStr, costMap.get(blockListStr) + 1);
                            queue.add(newBlockList);
                        }
                    }
                }

                //another side
                newBlock = blockList[i].clone();
                newBlock.location[newBlock.direction]++;

                valid = true;
                if (newBlock.location[newBlock.direction] + newBlock.length < 6 + 1) {
                    for (int j = 0; j < blockList.length; j++) {
                        if (i != j && blockList[j].interaction(newBlock)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        Block[] newBlockList = blockList.clone();
                        newBlockList[i] = newBlock;
                        if (!costMap.containsKey(toStr(newBlockList))) {
                            String newBlockListStr = toStr(newBlockList);
                            String blockListStr = toStr(blockList);
                            map.put(newBlockListStr, blockListStr);
                            costMap.put(newBlockListStr, costMap.get(blockListStr) + 1);
                            queue.add(newBlockList);
                        }
                    }
                }
            }

            if (queue.isEmpty()) {
                System.out.println("No answer");
                break;
            } else {
                blockList = queue.poll();
            }
        }
    }

    private String toStr(Block[] blockList) {
        String s = "";
        for (Block block : blockList) {
            s += block.location[0] + "," + block.location[1] + " ";
        }
        return s;
    }

    private String[] change(String list1, String list2) {
        String[] array1 = list1.split(" ");
        String[] array2 = list2.split(" ");

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return new String[]{array1[i], array2[i], i + ""};
            }
        }
        return null;
    }

    private void printList(List<String> list) {
        String preState = list.get(list.size() - 1);
        String location1 = "";
        String location2 = "";
        String changedIndex = "";
        for (int i = list.size() - 2; i >= 0; i--) {
            String[] change = change(preState, list.get(i));
            if (changedIndex.equals("")) {
                location1 = change[0];
                location2 = change[1];
                changedIndex = change[2];
            } else if (!changedIndex.equals(change[2])) {
                System.out.println(location1 + " ---> " + location2);
                location1 = change[0];
                location2 = change[1];
                changedIndex = change[2];
            } else {
                location2 = change[1];
            }
            preState = list.get(i);
            if (i == 0) {
                System.out.println(change[0] + " ---> " + change[1]);
            }
        }
    }
}