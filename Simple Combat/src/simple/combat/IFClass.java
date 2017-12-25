/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.combat;

import java.util.Scanner;

/**
 *
 * @author Cen
 */
public class IFClass {
    String input;
    int points = 0;
    boolean exit = false;
    Character chara = new Character("USER");
        
    public IFClass()
    {
        Scanner s = new Scanner(System.in);
        navi(s);
    }
    private void navi(Scanner s)
    {
        do
        {
            System.out.println("1.Travel\n2.Rest\n3.Status Check\n4.Exit");
            if ((input = s.next()).equals("1"))
            {
                travel(chara);
                points+=10;
            }
            else if (input.equals("2"))
            {
                System.out.println("You Rest and Heal 5 HP!");
                chara.applyDamage(-5);
                points-=5;
                System.out.println("Current HP: " + chara.retHp());
            }
            else if (input.equals("3"))
            {
                chara.printStatus();
            }
            else
            {
               exit = true;    
            }
            

            System.out.println("Current Points: " + points);
        }while(exit!=true && chara.retHp()>0);
        
        System.out.println("Total Points = " + points);
    }
    private void travel(Character x)
    {
        if (Math.abs(Math.random())>.75)
        {
            System.out.println("An Enemy has appeared!");
            Combat instance = new Combat(x, new Enemy("Slime", x.retLevel()+1));
            if (instance.retKill())
            {
                points+=10;
            }
        }
        else
        {
            System.out.println("You Travel!");
        }
    }
}
