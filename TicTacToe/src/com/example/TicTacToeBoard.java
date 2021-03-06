package com.example;
import java.util.*;

public class TicTacToeBoard {
		String input;
		int count_x,count_o;
		int pos[]=new int[9];
		
  public TicTacToeBoard(String board) {
	   input=board.toLowerCase();
	    count_x=0;
	    count_o=0;
  }
  
  
  public Evaluation evaluate() {
	  if(input.length()>9&&input.length()<9)
	  {
		  return Evaluation.InvalidInput;
	  }
	  for(int i=0;i<input.length();i++)
	  {
	      if(input.charAt(i)!='x' || input.charAt(i)!='o')
	      {
	    	  return Evaluation.InvalidInput;  
	      }
		  else if(input.charAt(i)=='x')
		  {
			  count_x++;//counting no of x's
			  pos[i]=1;//setting array position for x as 1
		  }
		  else
		  {
			  count_o++;// counting no of o's
			  pos[i]=0;//setting array position for o as 0
		  }
	  }
	  if(Math.abs(count_x-count_o) >=2)//comparing inputs
	  {
		  System.out.println("Someone has cheated");
		  return Evaluation.UnreachableState;
	  }
	  else
	  {
			  if((pos[0]==1&&pos[1]==1&&pos[2]==1) || (pos[3]==1&&pos[4]==1&&pos[5]==1) ||(pos[6]==1&&pos[7]==1&&pos[8]==1) ||(pos[0]==1&&pos[3]==1&&pos[6]==1) || (pos[1]==1&&pos[4]==1&&pos[7]==1) || (pos[2]==1&&pos[5]==1&&pos[8]==1) || (pos[0]==1&&pos[4]==1&&pos[8]==1) || (pos[2]==1&&pos[4]==1&&pos[6]==1)) {
				  return Evaluation.Xwins;//In this condition, comparing whether the win positions are set for x's
			  }
			  else if((pos[0]==0&&pos[1]==0&&pos[2]==0) || (pos[3]==0&&pos[4]==0&&pos[5]==0) ||(pos[6]==0&&pos[7]==0&&pos[8]==0) ||(pos[0]==0&&pos[3]==0&&pos[6]==0) || (pos[1]==0&&pos[4]==0&&pos[7]==0) || (pos[2]==0&&pos[5]==0&&pos[8]==0) || (pos[0]==0&&pos[4]==0&&pos[8]==0) || (pos[2]==0&&pos[4]==0&&pos[6]==0)) {
				  return Evaluation.Owins;//In this condition, comparing whether the win positions are set for o's
			  }
			  else
			  {
				  System.out.println("Match has drawn");
				  return Evaluation.NoWinner;
			  }
			  
		  
	  }
	  
  }
}
 class Main{
	public static void main(String args[])
	  {
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter your input combinations...");
		  String str=sc.next();
		  TicTacToeBoard t=new TicTacToeBoard(str);//passing input to constructor
		  System.out.print(t.evaluate());
	  }
}

