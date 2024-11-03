
import java.util.Arrays;
import java.util.Comparator;
class Item{
    int weight;
    int value;

    public Item(int value,int weight) {
        this.value=value;
        this.weight=weight;
    }
    
}

class Solve{
    double Solution(int w,Item[] ar,int n){
        Arrays.sort(ar,new itemComp());
        int currentWt=0;
        double finalVal=0.0;

        for(int i=0;i<n;i++)
        {
            if(currentWt+ar[i].weight<=w){
                currentWt+=ar[i].weight;
                finalVal+=ar[i].value;
            }
            else{
                int rem=w-currentWt;
                finalVal+=((double)(ar[i].value)/(double)(ar[i].weight))*(double)rem;
                break;
            }
        }
        return finalVal;

    }
}

class itemComp implements Comparator<Item>{
    @Override
    public int compare(Item a,Item b){
        double r1=(double)(a.value)/(double)(a.weight);
        double r2=(double)(b.value)/(double)(b.weight);
        if(r1<r2){
            return 1;
        }
        else if(r1>r2){
            return -1;
        }
        else{
            return 0;
        }

    }

}



public class FractKnapSack {
    public static void main(String[] args) {
        int w=90;
        int n=4;
        Item[] item=new Item[n];
        item[0]=new Item(100,20);
        item[1]=new Item(60,10);
        item[2]=new Item(100,50);
        item[3]=new Item(200,50);

        Solve ob=new Solve();
        double ans=ob.Solution(w,item,n);
        System.out.println(ans+"--------");

    }
    
}
