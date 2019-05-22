		//One pass solution by leetcodes young_stone
		//Very elegant, runs in 0ms o(n)
		//Memory better than 100% o(1)
		//Basically when you find 0 make this element whatever is in p1
		//and whatever is in p1 make it 0
		//and if you find 2 make this position have the value of p2, decrease p2 and index 
		//so you verify the number you put in index is not smaller
public void sortColors(int[] nums) {
    // 1-pass
    int p1 = 0, p2 = nums.length - 1, index = 0;
    while (index <= p2) {
        if (nums[index] == 0) {
            nums[index] = nums[p1];
            nums[p1] = 0;
            p1++;
        }
        if (nums[index] == 2) {
            nums[index] = nums[p2];
            nums[p2] = 2;
            p2--;
            index--;
        }
        index++;
    }
}

		//Two pass solution  leetcodes young_stone
		//with counting sort (suggested in problem description as being too easy)
		//It actually runs in 0ms o(n), same as 1 pass, but obviously for big enough test cases will lag
		//Same memory as one pass solution o(1)
public void sortColors(int[] nums) {
    // 2-pass
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {count0++;}
        if (nums[i] == 1) {count1++;}
        if (nums[i] == 2) {count2++;}
    }
    for(int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}