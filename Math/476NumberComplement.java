class Solution {
    public int findComplement(int num) {
   int x=1,i=1;
    while(x<=num && i<32)
    {
        num=num^x;
        x=x<<1;
        i++;
    }

    return num;
}
}