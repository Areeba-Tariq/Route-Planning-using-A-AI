/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package optimumpathfinder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Areeba Tariq
 */
public class DemoPanel extends JPanel {
    //setting screen
    final int maxCols=20;
    final int maxRows=15;
    final int nodeSize=60;
    final int screenWidth=nodeSize*maxCols;
    final int screenHeight=nodeSize*maxRows;
    
    Node[][]node=new Node[maxCols][maxRows];
    
    Node startNode;
    Node goalNode;
    Node currentNode;
    ArrayList<Node>openList=new ArrayList<>();
    ArrayList<Node>checkedList=new ArrayList<>();
    
    boolean goalReached=false;
    int step=0;
    public DemoPanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRows,maxCols));
        this.addKeyListener(new keyHandler(this));
        this.setFocusable(true);
        
        //placing nodes on panel
        
        int col=0;
        int row=0;
        while(col<maxCols && row<maxRows)
        {
            node[col][row]=new Node(col,row);
            this.add(node[col][row]);
            
            col++;
            if(col==maxCols)
            {
             col=0;
             row++;
            }
        }
        setStartNode(3,6);
        setGoalNode(11,3);
        //set solid/obstacts 
        setSolidNode(10,2);
        setSolidNode(10,3);
        setSolidNode(10,4);
        setSolidNode(10,5);
        setSolidNode(10,6);
        setSolidNode(10,7);
        setSolidNode(6,2);
        setSolidNode(7,2);
        setSolidNode(8,2);
        setSolidNode(9,2);
        setSolidNode(11,7);
        setSolidNode(12,7);
        setSolidNode(6,1);
        
        //setting the costs
        setCostOnNodes();
    }
    private void setStartNode(int col,int row)
    {
        node[col][row].setAsStart();
        startNode=node[col][row];
        currentNode=startNode;//as program begin current node==startnode
    }
      private void setGoalNode(int col,int row)
    {
        node[col][row].setAsGoal();
        goalNode=node[col][row]; 
    }
       private void setSolidNode(int col,int row)
    {
        node[col][row].setAsSolid();
        
    }
       
       private void setCostOnNodes()
       {
           int col=0;
           int row=0;
           while(col<maxCols && row<maxRows)
           {
               getCost(node[col][row]);
               col++;
               if(col==maxCols)
               {
                   col=0;
                   row++;
               }
           }
       }
       private void getCost(Node node)
       {
           //get g cost i.e distance from start node
           int xDistance=Math.abs(node.col-startNode.col);
           int yDistance=Math.abs(node.row-startNode.row);
           node.gCost=xDistance+yDistance;
           
           //get h cost i.e distance from goal node
           xDistance=Math.abs(node.col-goalNode.col);
           yDistance=Math.abs(node.row-goalNode.row);
           node.hCost=xDistance+yDistance;
           
           node.fCost=node.gCost+node.hCost;
           
           //displaying costs on node
           
           if(node!=startNode&& node!=goalNode){
               node.setText("<html>F:"+node.fCost +"<br>G:"+node.gCost+"</html>");
           }
       }
       public void search()
       {
           if(goalReached==false)
           {
            int col=currentNode.col;
            int row=currentNode.row;
            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);
            
            //open up node
            if(row-1>=0){
            openNode(node[col][row-1]);
            }
            if(col-1>=0){
            //open left node
            openNode(node[col-1][row]);
            }
            if(row+1<maxRows){
            //open below node
            openNode(node[col][row+1]);
            }
            if(col+1<maxCols){
            //open right node
            openNode(node[col+1][row]);
           }
            //finding the best node
            int bestNodeIndex=0;
            int bestNodefCost=999;
            
            for(int i=0;i<openList.size();i++)
            {
                //checking if this node fcost is better
                if(openList.get(i).fCost<bestNodefCost)
                {
                    bestNodeIndex=i;
                    bestNodefCost=openList.get(i).fCost;
                }else if(openList.get(i).fCost==bestNodefCost)
                {
                    if(openList.get(i).gCost<openList.get(bestNodeIndex).gCost)
                    {
                        bestNodeIndex=i;
                    }
                }
            }
            //after this loop we get the best node -> our next step
            
            currentNode=openList.get(bestNodeIndex);
            if(currentNode==goalNode)
            {
                goalReached=true;
            }
           }
           
       }
        public void autoSearch()
       {
           while(goalReached==false && step<300)
           {
            int col=currentNode.col;
            int row=currentNode.row;
            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);
            
            //open up node
            if(row-1>=0){
            openNode(node[col][row-1]);
            }
            if(col-1>=0){
            //open left node
            openNode(node[col-1][row]);
            }
            if(row+1<maxRows){
            //open below node
            openNode(node[col][row+1]);
            }
            if(col+1<maxCols){
            //open right node
            openNode(node[col+1][row]);
           }
            //finding the best node
            int bestNodeIndex=0;
            int bestNodefCost=999;
            
            for(int i=0;i<openList.size();i++)
            {
                //checking if this node fcost is better
                if(openList.get(i).fCost<bestNodefCost)
                {
                    bestNodeIndex=i;
                    bestNodefCost=openList.get(i).fCost;
                }else if(openList.get(i).fCost==bestNodefCost)
                {
                    if(openList.get(i).gCost<openList.get(bestNodeIndex).gCost)
                    {
                        bestNodeIndex=i;
                    }
                }
            }
            //after this loop we get the best node -> our next step
            
            currentNode=openList.get(bestNodeIndex);
            if(currentNode==goalNode)
            {
                goalReached=true;
                trackThePath();
            }
            step++;
           }
           
       }
       
       private void openNode(Node node)
       {
           if(node.open==false && node.checked==false && node.solid==false)
           {
               node.setAsOpen();
               node.parent=currentNode;
               openList.add(node);
           }
       }
       private void trackThePath()
       {
           //backtract and draw the best path
           Node curr=goalNode;
           while(curr!=startNode)
           {
               curr=curr.parent;
               if(curr!=startNode)
               {
                   curr.setAsPath();
               }
           }
       }
}
