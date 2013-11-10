package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r==0 || c==0 || c==r) 1 
    else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    if (newbalance(chars, 0) < 0) false else true
  }
  
  def newbalance(chars: List[Char], count: Int): Int = {
    if (chars.isEmpty || count < 0) {
      count
    } else if (chars.head=='(') {
      newbalance(chars.tail, count+1)
    } else if (chars.head==')') {
      newbalance(chars.tail, count-1)
    } else {
      newbalance(chars.tail, count)
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money <= 0 || coins.isEmpty) 0
    else {
      val c = coins.sortWith(_<_)
      countChangeAux(money, c, 0, c(0))
    }
  }
  def countChangeAux(money: Int, coins: List[Int], acc: Int, lastCoin: Int): Int = {
    if (money < 0) {
    	acc
    } else if (money == 0) {
    	acc+1
    } else {
    	for (k <- coins) {
    		if (k >= lastCoin) {
    			countChangeAux(money-k, coins, acc, k)
    		}
      }
          
    }
  }

}
