/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input

*/

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {
    
    int[][] parentChildPairs = new int[][] {
      {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
      {4, 5}, {4, 8}, {4, 9}, {9, 11}
    };
    Solution s = new Solution();
    s.findNodesWithZeroAndOneParents(parentChildPairs);
  }
  
  public List findNodesWithZeroAndOneParents(int[][] parentChildPairs){
    List<List> chiildrenElement = new ArrayList<List>();
    Map<Integer,Integer> childMap = new HashMap<Integer,Integer>();
    List<Integer> parentMap = new ArrayList<Integer>();
    int count=0;
    
    for(int i=0;i<parentChildPairs.length;i++){
        parentMap.add(parentChildPairs[i][0]);
        
      if(childMap.get(parentChildPairs[i][1])!=null){
        childMap.put(parentChildPairs[i][1], childMap.get(parentChildPairs[i][1])+1);
      }else{
        childMap.put(parentChildPairs[i][1], 1);
      }
    }
    List oneParent = new ArrayList();
    List childElement = new ArrayList();
    for(Map.Entry<Integer,Integer> m : childMap.entrySet()){
      childElement.add(m.getKey());
      
      if(m.getValue()==1){
        oneParent.add(m.getKey());
      }
    }
    int count1=0;
    parentMap.removeAll(childElement);
    //System.out.println(parentMap);
    Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
    for(int i=0;i<parentMap.size();i++){
      tempMap.put(parentMap.get(i),parentMap.get(i));
    }
    List l = new ArrayList();
    for(Map.Entry<Integer,Integer> m2 : tempMap.entrySet()){
      l.add(m2.getKey());
    }
    chiildrenElement.add(l);
    chiildrenElement.add(oneParent);
    System.out.println(chiildrenElement.get(0));
    System.out.println(chiildrenElement.get(1));
    return chiildrenElement;
  }
}
