package codefile;

public class Solution1011 {
	public static boolean isPossible(int[]weights,int maxCapacity,int deadline){
        int currentWeight=0,cntDays=0;
        for(int x:weights){
            if(currentWeight+x<=maxCapacity) currentWeight+=x;
            else{
                cntDays++;
                if(cntDays>=deadline) return false;
                currentWeight=x;
            }
        }
        cntDays++;
        if(cntDays<=deadline) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,maxi=Integer.MIN_VALUE;
        for(int x:weights){
            sum+=x;
            maxi=Math.max(maxi,x);
        }
        int start=maxi,end=sum,ans=0,mid=0;
        while(start<=end){
            mid = (start+end)/2;
            if(isPossible(weights,mid,days)) end=mid-1;
            else start=mid+1;
        }
        return start;
    }

}
