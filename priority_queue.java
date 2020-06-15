//implementation of priority queue using binary heap extending Comparable interface
public class MaxPQ<Key extends Comparable<Key>>
{
   private Key[] pq;
   private int N;
   
   //constructor to create a priority queue
   public MaxPQ(int capacity)
   {
      pq = (Key[]) new Comparable[capacity + 1] ; 
   }
   
   //to check priority queue is empty 
   public boolean isEmpty()
   {
      return N==0;
   }
   
   //to insert element/key at the end of the priority queue
   //At most (1 + ln N) compares
   public void insert(Key key)
   {
     pq[++N]=key;
     swim(N);
   }
   
   //to delete the maximum node,the root of the binary heap tree
   //At most ( 2lnN ) compares
   public Key delMax()
  {
    Key max = pq[1];
    //exchange 1 key(largest) with the last key(smallest)
    exch(1,N--);
    //reorder the heap tree as the root is the smallest
    sink(1);
    pq[N+1] = null;
    return max;
   }
   
   
   //if child key > parent key , exchange them untill heap is restored
   //k is the child whereas k/2 is the parent node
   private swim(int k)
  {
    while(k>1 && less(k/2,k))
    {
       exch(k,k/2);
       k=k/2;
    }
   }
   
   //if parent key < both child or one of the  child
   //for node k the children are 2k & 2k+1
   private void sink(int k)
   {
     while(2*k <= N)
     {
      int j=2*k;
      if(j<N && less(j,j+1))
      {
        j++;
      }
      if(!less(k,j))break;
      //exchange parent with the greater child
      exch(k,j);
      k=j;
      }
    }
    
    private boolean less(int i,int j)
   {
     return pq[i].comapreTo(pq[j]) < 0;
   }
   
   private void exch(int i,int j)
  {
    Key t=pq[i];
    pq[i]=pq[j];
    pq[j]=t;
  }
  
} 
   
     
      
   
    
   
   
