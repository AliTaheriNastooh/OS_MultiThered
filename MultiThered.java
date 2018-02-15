import java.util.Scanner;

/**
 * Created by ASUS on 12/24/2017.
 */
public class main2 {
    public static class mytread extends Thread{
        int[][] a,b;
        int n,m;
        int size;
        int result;
        mytread(int[][] arr1,int[][]arr2,int n1,int m1,int size1){
            a=arr1;
            b=arr2;
            n=n1;
            m=m1;
            size=size1;
        }
        public void run(){
            result=0;
            for(int i=0;i<size;i++){
                result=result+(a[n][i]*b[i][m]);
            }

        }
        public int getRes(){
            return result;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int[][] arr,arr2;
        Scanner scanner=new Scanner(System.in);
        System.out.print("enter size of your matrix:");
        int n=scanner.nextInt();

        arr=new int[n][n];
        arr2=new int[n][n];
        int[][]res;
        res=new int[n][n];
        mytread[] mylist = new mytread[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int s=scanner.nextInt();
                arr[i][j]=s;
                arr2[i][j]=s;
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                mylist[cnt] = new mytread(arr, arr2, i, j,n);
                mylist[cnt].start();
                cnt++;
            }
        }
        for(int i=0;i<cnt;i++){
            mylist[i].join();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[i][j]=mylist[(i*n)+j].getRes();
                System.out.print(res[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
}

