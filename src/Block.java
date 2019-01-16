public class Block {

    int[] location;
    int direction; // 0: vertical, 1: horizontal
    int length;

    public Block(int[] location, int direction, int length) {
        this.location = location;
        this.direction = direction;
        this.length = length;
    }

    boolean interaction(Block block) {
        int[] newLocation = {block.location[0], block.location[1]};

        for (int i = 0; i < block.length; i++) {
            if (location[1 - direction] == newLocation[1 - direction]) {
                if (location[direction] <= newLocation[direction] && location[direction] + length - 1 >= newLocation[direction]) {
                    return true;
                }
            }
            newLocation[block.direction]++;
        }
        return false;
    }

    public Block clone() {
        return new Block(location.clone(), direction, length);
    }
}
