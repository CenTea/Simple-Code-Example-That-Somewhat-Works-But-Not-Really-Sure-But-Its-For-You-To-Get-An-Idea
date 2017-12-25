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
public class Combat {
    boolean kill=false;
    public Combat(Character player, Enemy creep)
    {
        Scanner input = new Scanner(System.in);
        
        double defBuff;
        boolean defended = false;
        
        String choice;
        do 
        {
            defBuff = Math.abs(Math.random())*4;
            System.out.println("Current HP: " + player.retHp());
            System.out.println("1. Attack\n2.Defend\n3.Run");
            choice = input.next();
            if (choice.equals("1"))
            {
                System.out.println("You attack!");
                creep.applyDamage(doDamage(creep, player, (Math.random()*2)));
                if (creep.retHp() <= 0)
                {
                    System.out.println(creep.retName() + " has died!\nExp gained!");
                    player.levelUp(creep);
                    kill = true;
                    break;
                }
                if (defended == false)
                {
                System.out.println("You take " + takeDamage(player, creep) + " Damage");
                player.applyDamage(takeDamage(player, creep));
                }
                else
                {
                System.out.println("The enemy is recovering from its attack!");
                defended = false;
                }
            }
            else if (choice.equals("2"))
            {
                System.out.println("You defend!");
                defended = true;
                System.out.println("You take " + (takeDamage(player, creep)-defBuff) + " Damage");
                player.applyDamage(takeDamage(player, creep)-defBuff);
            }
            else if (choice.equals("3"))
            {
                System.out.println("You run!");
                break;
            }

        }while(player.retHp() > 0 && creep.retHp() > 0);
    }
    
    public boolean retKill()
    {
        return kill;
    }
    
    public double takeDamage(Character defender, Enemy attacker)
    {
        return (((attacker.retAtk() - defender.retDef())<0) ? 0 : (attacker.retAtk() - defender.retDef()) )*defender.retMod();
    }
    
    public double doDamage(Enemy defender, Character attacker, double dmg)
    {
        return (dmg + attacker.retAtk());
    }
    
}
