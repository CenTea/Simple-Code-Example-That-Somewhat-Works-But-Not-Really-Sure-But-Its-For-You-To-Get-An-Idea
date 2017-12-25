/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.combat;

/**
 *
 * @author Cen
 */
public class Character {
    private String name;
    private int level;
    
    private int exp;
    private int expThresh;
    
    private double hp;
    private double atk;
    private double def;
    private double mod;
    
    public Character(String name)
    {
        this.name = name;
        this.level = 1;
        this.hp = 20;
        this.atk = Math.abs(Math.random())*5+1;
        this.def = Math.abs(Math.random())*5+1;
        this.mod = .75;
        
        this.exp = 0;
        this.expThresh = 100;
        
        if ((this.atk + this.def) < 10)
        {
            if(this.atk>=this.def)
            {
                this.def += 10-(this.atk+this.def);
            }
            else
            {
                this.atk += 10-(this.atk+this.def);
            }
        }
    }
    
    public void levelUp(Enemy enemy)
    {
        this.exp+=enemy.getExp();
        if (this.exp>=this.expThresh)
        {
        this.level++;
        this.hp+=2;
        this.atk++;
        this.def++;
        this.exp = this.exp-this.expThresh;
        this.expThresh *= 1.25;
        }
    }
    
    public void applyDamage(double value)
    {
        this.hp-=value;
    }
    
    public double retHp()
    {
        return this.hp;
    }
    
    public double retAtk()
    {
        return this.atk;
    }
    
    public double retDef()
    {
        return this.def;
    }
    public int retLevel()
    {
        return this.level;
    }
    public double retMod()
    {
        return this.mod;
    }
    
    public void printStatus()
    {
        System.out.println("Character Status:\n" + "Name: " + this.name +"\nHP: " + this.hp +"\nLEV: " + this.level+"\nATK: " + this.atk+"\nDEF: " + this.def + "\nEXP: " + this.exp + "/"+ this.expThresh);
    }
}
